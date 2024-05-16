import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DSThanhVien {
    public static ArrayList<ThanhVien> DSTV = new ArrayList<>();

    public DSThanhVien() {
    }

    public ArrayList<ThanhVien> getDSTV() {
        return DSTV;
    }

    public void setDSTV(ArrayList<ThanhVien> dSTV) {
        DSTV = dSTV;
    }

    public static void docDSTVTuFile(String filepath) {
        try (Scanner scan = new Scanner(new File(filepath))) {
            while (scan.hasNextLine()) {
                ThanhVien tv = new ThanhVien();
                String line = scan.nextLine();
                String[] parts = line.split("#");
                tv.setId(parts[0]);
                tv.setTen(parts[1]);
                tv.setSđt(parts[2]);
                NgayThang tmp = new NgayThang(Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5]));
                tv.setNgaysinh(tmp);
                tv.setDiemtichluy(Integer.parseInt(parts[6]));
                DSThanhVien.DSTV.add(tv);
            }
        } catch (Exception e) {
            System.out.println("Khong the doc file " + filepath);
        }
    }

    public static void ghiDSTVVaoFile(String filepath) {
        try (FileWriter fw = new FileWriter(new File(filepath), false)) {
            for (ThanhVien tv : DSThanhVien.DSTV) {
                StringBuilder sb = new StringBuilder();
                sb.append(tv.getId() + "#");
                sb.append(tv.getTen() + "#");
                sb.append(tv.getSđt() + "#");
                sb.append(tv.getNgaysinh().getNgay() + "#")
                        .append(tv.getNgaysinh().getThang() + "#")
                        .append(tv.getNgaysinh().getNam() + "#");
                sb.append(tv.getDiemtichluy());
                sb.append(System.lineSeparator());
                fw.write(sb.toString());
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the ghi file " + filepath);
        }
    }

    public static void ghiDSTVVaoFile(String filepath, ThanhVien tv) {
        try (FileWriter fw = new FileWriter(new File(filepath), true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(tv.getId() + "#");
            sb.append(tv.getTen() + "#");
            sb.append(tv.getSđt() + "#");
            sb.append(tv.getNgaysinh().getNgay() + "#")
                    .append(tv.getNgaysinh().getThang() + "#")
                    .append(tv.getNgaysinh().getNam() + "#");
            sb.append(tv.getDiemtichluy());
            sb.append(System.lineSeparator());
            fw.write(sb.toString());
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the ghi file " + filepath);
        }
    }

    public static void xuatDSTV() {
        ArrayList<ThanhVien> dstvmoi = (ArrayList<ThanhVien>) DSTV.clone();
        Collections.sort(dstvmoi, new SoSanhNgaySinh());
        System.out.println("\n------------------------- THANH VIEN -------------------------");
        System.out.format("%-8s %-18s %-15s %-5s",
                "ID",
                "|  Ten",
                "|  Ngay sinh",
                "|  Diem tich luy");
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        for (ThanhVien tv : dstvmoi) {
            tv.xuatThongTin();
        }
        System.out.println();
        dstvmoi = null;
    }

    private static String sinhMaTuDong() {
        int temp = DSTV.size() + 1;
        String stt = Integer.toString(temp);
        int count = 5 - stt.length();
        StringBuilder result = new StringBuilder();
        result.append("TV");
        while (count > 0) {
            result.append("0");
            --count;
        }
        result.append(stt);
        return result.toString();
    }

    public static ThanhVien themThanhVien() {
        ThanhVien tv = new ThanhVien();
        tv.setId(DSThanhVien.sinhMaTuDong());
        tv.nhapThongTin();
        // tim kiem trong danh sach coi co ten chua
        for (ThanhVien Thanhvien : DSThanhVien.DSTV) {
            if (Thanhvien.getSđt().equalsIgnoreCase(tv.getSđt())) {
                System.out.println("Ban da co tai khoan");
                tv = null;
                return Thanhvien;
            }
        }
        DSThanhVien.DSTV.add(tv);
        DSThanhVien.ghiDSTVVaoFile("THANH_VIEN.txt", tv);
        return tv;
    }

    public static ThanhVien timkiemTVTheoSDT(String sdt) {
        for (ThanhVien tv : DSThanhVien.DSTV) {
            if (tv.getSđt().equalsIgnoreCase(sdt)) {
                return tv;
            }
        }
        System.out.println("Ban chua co tai khoan");
        return null;
    }
}