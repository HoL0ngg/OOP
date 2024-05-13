import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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

    public static void docDSTVTuFile(String filepath){
        try(Scanner scan = new Scanner(new File(filepath))) {
            while(scan.hasNext()){
                ThanhVien tv = new ThanhVien();
                String line = scan.nextLine();
                String[] parts = line.split(line);
                tv.setId(parts[0]);
                tv.setTen(parts[1]);
                NgayThang tmp = new NgayThang(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                tv.setNgaysinh(tmp);
                tv.setDiemtichluy(Integer.parseInt(parts[5]));
                DSTV.add(tv);
            }
        } catch (Exception e) {
            System.out.println("Khong the doc file " + filepath);
        }
    }

    public static void ghiDSTVVaoFile(String filepath){
        try(FileWriter fw = new FileWriter(new File(filepath), false)) {
            for(ThanhVien tv : DSThanhVien.DSTV){
                StringBuilder sb = new StringBuilder();
                sb.append(tv.getId() + "#");
                sb.append(tv.getTen() + "#");
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

    public static void ghiDSTVVaoFile(String filepath,ThanhVien tv){
        try(FileWriter fw = new FileWriter(new File(filepath), true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(tv.getId() + "#");
            sb.append(tv.getTen() + "#");
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

    public static void xuatDSTV(){
        System.out.println("\n------------------------------------------------------ NHAN VIEN DAT HANG ------------------------------------------------------");
        System.out.format("%-8s %-18s %-12s %-5",
		"ID",
		"|  Ten",
		"|  Ngay sinh",
		"|  ",
		"|  SDT",
		"|  Email");
        for(ThanhVien tv : DSTV){
            
        }
    }
    public static ThanhVien themThanhVien(){
        ThanhVien tv = new ThanhVien();
        System.out.println("Xin moi nhap thong tin");
        System.out.print("Nhap ten cua ban: ");
        String ten = ChucNang.chuanHoaChuoi();
        
        //tim kiem trong danh sach coi co ten chua
        for (ThanhVien Thanhvien : DSThanhVien.DSTV){
            if (Thanhvien.getTen().equalsIgnoreCase(ten)){
                System.out.println("Ban do co tai khoan");
                return Thanhvien;
            }
        }

        tv.nhapThongTin();
        return tv;
    }
}