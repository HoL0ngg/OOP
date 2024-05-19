package NHANVIEN;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import CHUCNANG.DiaChi;
import CHUCNANG.NgayThang;
import SANPHAM.nvPhaChe;

public class DSNhanVien {
    private static ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();

    public DSNhanVien() {
    }

    public DSNhanVien(ArrayList<NhanVien> dsnv) {
        DSNhanVien.dsnv = dsnv;
    }

    public ArrayList<NhanVien> getDSNV() {
        return DSNhanVien.dsnv;
    }

    public void nhapNVtuFile(String path) {
        try (Scanner scan = new Scanner(new File(path))) {
            NhanVien nv = null;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("#");
                switch (Integer.parseInt(parts[0])) {
                    case 1:
                        nv = new nvQuanLi();
                        break;
                    case 2:
                        nv = new nvPhaChe();
                        break;
                    case 3:
                        nv = new nvDatHang();
                        break;
                }
                nv.setId(parts[1]);
                nv.setTen(parts[2]);
                DiaChi dc = new DiaChi(parts[3], parts[4], parts[5], parts[6], parts[7]);
                nv.setDc(dc);
                nv.setSdt(parts[8]);
                nv.setEmail(parts[9]);
                NgayThang ngaysinh = new NgayThang(Integer.parseInt(parts[10]), Integer.parseInt(parts[11]),
                        Integer.parseInt(parts[12]));
                nv.setNgaysinh(ngaysinh);
                DSNhanVien.dsnv.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // System.out.println("Khong the mo file");
        }
    }

    public boolean kiemTraIDNV(String id) {
        for (NhanVien nv : this.getDSNV()) {
            if (nv.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public void ghiVaoFile(String filepath) {
        File file = new File(filepath);
        try (FileWriter fw = new FileWriter(file, false)) {
            for (NhanVien nv : this.getDSNV()) {
                StringBuilder sb = new StringBuilder();
                if (nv instanceof nvQuanLi) {
                    sb.append(1 + "#");
                } else {
                    if (nv instanceof nvPhaChe) {
                        sb.append(2 + "#");
                    } else {
                        sb.append(3 + "#");
                    }
                }
                sb.append(nv.getId() + "#");
                sb.append(nv.getTen() + "#");
                sb.append(nv.getDc().getTinhThanh() + "#")
                        .append(nv.getDc().getQuanHuyen() + "#")
                        .append(nv.getDc().getPhuongXa() + "#")
                        .append(nv.getDc().getSoNha() + "#")
                        .append(nv.getDc().getTenDuong() + "#");
                sb.append(nv.getSdt() + "#");
                sb.append(nv.getEmail() + "#");
                sb.append(nv.getNgaysinh().getNgay() + "#")
                        .append(nv.getNgaysinh().getThang() + "#")
                        .append(nv.getNgaysinh().getNam());
                sb.append(System.lineSeparator());
                fw.write(sb.toString());
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the mo file de ghi danh sach nhan vien");
        }
    }

    public void ghiVaoFile(String filepath, NhanVien nvmoi) {
        File file = new File(filepath);
        try (FileWriter fw = new FileWriter(file, true)) {
            StringBuilder sb = new StringBuilder();
            if (nvmoi instanceof nvQuanLi) {
                sb.append(1 + "#");
            } else {
                if (nvmoi instanceof nvPhaChe) {
                    sb.append(2 + "#");
                } else {
                    sb.append(3 + "#");
                }
            }
            sb.append(nvmoi.getId() + "#");
            sb.append(nvmoi.getTen() + "#");
            sb.append(nvmoi.getDc().getTinhThanh() + "#")
                    .append(nvmoi.getDc().getQuanHuyen() + "#")
                    .append(nvmoi.getDc().getPhuongXa() + "#")
                    .append(nvmoi.getDc().getSoNha() + "#")
                    .append(nvmoi.getDc().getTenDuong() + "#");
            sb.append(nvmoi.getSdt() + "#");
            sb.append(nvmoi.getEmail() + "#");
            sb.append(nvmoi.getNgaysinh().getNgay() + "#")
                    .append(nvmoi.getNgaysinh().getThang() + "#")
                    .append(nvmoi.getNgaysinh().getNam());
            sb.append(System.lineSeparator());
            fw.write(sb.toString());
            DSNhanVien.dsnv.add(nvmoi);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the mo file de ghi nhan vien");
        }
    }
}
