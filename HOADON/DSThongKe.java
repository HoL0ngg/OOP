package HOADON;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import CHUCNANG.NgayThang;

public class DSThongKe {
    public static ArrayList<ThongKe> dstk = new ArrayList<>();

    public static void docDSTKTuFile(String filepath) {
        try (Scanner scan = new Scanner(new File(filepath))) {
            while (scan.hasNextLine()) {
                ThongKe tk = new ThongKe();
                String line = scan.nextLine();
                String[] parts = line.split("#");
                tk.setLoai(Integer.parseInt(parts[0]));
                tk.setId(parts[1]);
                NgayThang ngaytk = new NgayThang(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]));
                tk.setNgayTk(ngaytk);
                tk.setTongDoanhthu(Integer.parseInt(parts[5]));
                tk.setTongSoLuongDon(Integer.parseInt(parts[6]));
                DSThongKe.dstk.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Khong the doc file " + filepath);
        }
    }

    public static void ghiDSTKVaoFile(String filepath) {
        try (FileWriter fw = new FileWriter(new File(filepath), false)) {
            for (ThongKe tk : DSThongKe.dstk) {
                StringBuilder sb = new StringBuilder();
                sb.append(tk.getLoai() + "#");
                sb.append(tk.getId() + "#");
                sb.append(tk.getNgayTk().getNgay() + "#")
                        .append(tk.getNgayTk().getThang() + "#")
                        .append(tk.getNgayTk().getNam() + "#");
                sb.append(tk.getTongDoanhthu() + "#");
                sb.append(tk.getTongSoLuongDon());
                sb.append(System.lineSeparator());
                fw.write(sb.toString());
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the ghi file " + filepath);
        }
    }

    public static void ghiDSTVVaoFile(String filepath, ThongKe tk) {
        try (FileWriter fw = new FileWriter(new File(filepath), true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(tk.getLoai() + "#");
            sb.append(tk.getId() + "#");
            sb.append(tk.getNgayTk().getNgay() + "#")
                    .append(tk.getNgayTk().getThang() + "#")
                    .append(tk.getNgayTk().getNam() + "#");
            sb.append(tk.getTongDoanhthu() + "#");
            sb.append(tk.getTongSoLuongDon());
            sb.append(System.lineSeparator());
            DSThongKe.dstk.add(tk);
            fw.write(sb.toString());
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the ghi file " + filepath);
        }
    }
}
