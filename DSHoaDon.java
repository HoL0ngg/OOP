import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DSHoaDon {
    private static List<Hoadon> DSHD = new ArrayList<>();
    private static List<CTHD> CTHDList = new ArrayList<>();

    // so luong hoa don
    public static int SLHD = 1;

    public DSHoaDon() {
    }

    public static List<Hoadon> getDSHD() {
        return DSHD;
    }

    public static void setDSHD(List<Hoadon> dSHD) {
        DSHD = dSHD;
    }

    public static List<CTHD> getCTHDList() {
        return CTHDList;
    }

    public static void setCTHDList(List<CTHD> cTHDList) {
        CTHDList = cTHDList;
    }

    public static int getSLHD() {
        return SLHD;
    }

    public static void setSLHD(int sLHD) {
        SLHD = sLHD;
    }

    public static void docHDtuFile(String path) {
        // File file = new File(path);
        try (Scanner scan = new Scanner(new File(path))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("#");

                String id = parts[0].trim();
                String maNV = parts[1].trim();

                Hoadon hd = new Hoadon();

                hd.setMaHoadon(id);
                hd.setMaNhanvien(maNV);

                NgayThang date = new NgayThang(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]));

                hd.setNgayHoadon(date);

                hd.setTienHoadon(Integer.parseInt(parts[5]));

                DSHoaDon.DSHD.add(hd);
            }

        } catch (Exception e) {
            System.out.println("Khong the mo file de doc san pham");
        }
    }

    public static void docCTHDtuFile(String path) {
        // File file = new File(path);
        try (Scanner scan = new Scanner(new File(path))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("#");

                String idHD = parts[0].trim();
                String tenSP = parts[1].trim();

                CTHD cthd = new CTHD();

                cthd.setMaChitetHoadon(idHD);
                cthd.setTen(tenSP);
                String size = parts[2];
                int intsize = 0;
                switch (size) {
                    case "S":
                        intsize = 0;
                        break;
                    case "M":
                        intsize = 1;
                        break;
                    case "L":
                        intsize = 2;
                        break;
                }
                cthd.setSize(intsize);
                cthd.setSoluongSanpham(Integer.parseInt(parts[3]));
                cthd.setDonGia(Integer.parseInt(parts[4]));

                DSHoaDon.CTHDList.add(cthd);
            }

        } catch (Exception e) {
            System.out.println("Khong the mo file de doc san pham");
        }
    }

    public static void them(int[] dssp, NhanVien nv) {
        Hoadon hoadon = new Hoadon();
        String maHoaDon = "HD" + DSHoaDon.SLHD++;
        hoadon.setMaNhanvien(nv.getId());
        hoadon.setMaHoadon(maHoaDon);

        NgayThang ngayHoaDon = new NgayThang();
        // ngayHoaDon.nhapThongTin();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        ngayHoaDon.setNgay(calendar.get(Calendar.DAY_OF_MONTH));
        ngayHoaDon.setThang(calendar.get(Calendar.MONTH) + 1);
        ngayHoaDon.setNam(calendar.get(Calendar.YEAR));
        hoadon.setNgayHoadon(ngayHoaDon);

        // chi tiet hoa don
        List<CTHD> temp = new ArrayList<>();

        int tongTien = 0;

        
        CTHD cthd = new CTHD();
        cthd.setMaChitetHoadon(maHoaDon);
        for (int i = 0; i < dssp.length; ++i) {
            int ten = i / SanPham.validSize;
            int size = i % SanPham.validSize;
            
            if (dssp[i] != 0) {
                cthd.setTen(ThucDon.thucdon.get(ten).getTen());
                cthd.setSize(size);
                cthd.setSoluongSanpham(dssp[i]);
                cthd.setDonGia(ThucDon.thucdon.get(ten).getGiaTienAtIndex(size));
                temp.add(cthd);
                double tien = cthd.getDonGia() * cthd.getSoluongSanpham();
                tongTien += tien;
                CTHDList.add(cthd);
                DSHoaDon.ghiCTHDVaoFile("cthd.txt", cthd);
            }
        }
        hoadon.setTienHoadon(tongTien);
        DSHD.add(hoadon);
        DSHoaDon.ghiHDVaoFile("hoadon.txt", hoadon);
    }

    public static void xuatToanboHoadon() {
        for (Hoadon hd : DSHD) {
            System.out.println("+===============================================================================+");
            System.out.println("|                                 HOA DON                                       |");
            System.out.println("+-------------------------------------------------------------------------------+");
            // System.out.printf("| Ma hoa don: %-65s |\n", hd.getMaHoadon());
            // System.out.printf("| Ma nhan vien: %-65s |\n", hd.getMaNhanvien());
            // System.out.printf("| Ngay: %-71s |\n", hd.getNgayHoadon());
            System.out.format("%-79s %1s", 
                            "|  Ma hoa don: " + hd.getMaHoadon(),
                            "|");
            System.out.println();
            System.out.format("%-79s %1s", 
                            "|  Ma nhan vien: " + hd.getMaNhanvien(),
                            "|");
            System.out.println();
            System.out.format("%-79s %1s", 
                            "|  Ngay: " + hd.getNgayHoadon(),
                            "|");
            System.out.println();
            System.out.println("+_______________________________________________________________________________+");
            System.out.println("| STT     Ten                       Size     SL      Don gia        Tien        |");
            System.out.println("+-------------------------------------------------------------------------------+");
            String mahoadon = hd.getMaHoadon();
            int stt = 1;
            for (CTHD cthd : CTHDList) {
                if (cthd.getMaChitetHoadon().equals(mahoadon)){
                    String size = SanPham.size[cthd.getSize()];
                    System.out.printf("| %-5s%-30s%-8s%-9d%-12d%-12d |\n",
                            stt++, cthd.getTen(),
                            size, cthd.getSoluongSanpham(),
                            cthd.getDonGia(), cthd.getDonGia() * cthd.getSoluongSanpham());
                }
            }
            System.out.println("+-------------------------------------------------------------------------------+");
            System.out.format("%-55s %-23s %-1s",
                            "|",
                            "Tong tien: " + ChucNang.chuanHoaGia(hd.getTienHoadon()),
                            "|");
            System.out.println();
            System.out.println("+===============================================================================+");
        }
        System.out.println();
    }

    public static void ghiHDVaoFile(String path, Hoadon hd) {
        try (FileWriter fw = new FileWriter(path, true)){
            StringBuilder sb = new StringBuilder();
            sb.append(hd.getMaHoadon()).append("#");
            sb.append(hd.getMaNhanvien()).append("#");
            sb.append(hd.getNgayHoadon().getNgay()).append("#");
            sb.append(hd.getNgayHoadon().getThang()).append("#");
            sb.append(hd.getNgayHoadon().getNam()).append("#");
            sb.append(hd.getTienHoadon());
            sb.append(System.lineSeparator());
            fw.write(sb.toString());
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void ghiDSCTHDVaoFile(String path) {
        try (FileWriter fw = new FileWriter(path, false)){
            for(CTHD cthd : DSHoaDon.getCTHDList()){
                StringBuilder sb = new StringBuilder();
                sb.append(cthd.getMaChitetHoadon()).append("#");
                sb.append(cthd.getTen()).append("#");
                sb.append(SanPham.size[cthd.getSize()]).append("#");
                sb.append(cthd.getSoluongSanpham()).append("#");
                sb.append(cthd.getDonGia());
                sb.append(System.lineSeparator());
                fw.write(sb.toString());
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void ghiCTHDVaoFile(String path, CTHD cthd) {
        try (FileWriter fw = new FileWriter(path, true)){
            StringBuilder sb = new StringBuilder();
            sb.append(cthd.getMaChitetHoadon()).append("#");
            sb.append(cthd.getTen()).append("#");
            sb.append(SanPham.size[cthd.getSize()]).append("#");
            sb.append(cthd.getSoluongSanpham()).append("#");
            sb.append(cthd.getDonGia());
            sb.append(System.lineSeparator());
            fw.write(sb.toString());
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}