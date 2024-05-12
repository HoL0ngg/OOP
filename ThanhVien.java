import java.io.File;
import java.util.Scanner;

public class ThanhVien {
    private String id;
    private String ten;
    private NgayThang ngaysinh;
    private int diemtichluy;

    public ThanhVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public NgayThang getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(NgayThang ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getDiemtichluy() {
        return diemtichluy;
    }
    
    public void setDiemtichluy(int diemtichluy) {
        this.diemtichluy = diemtichluy;
    }

    public void nhapThongTin(){
        System.out.println("Nhap ngay thang nam sinh");
        NgayThang tmp = new NgayThang();
        tmp.nhapThongTin();
        this.setNgaysinh(tmp);
        this.setDiemtichluy(0);
    }

    public static void docDSThanhVienTuFile(String path){
        // File file = new File(path);
        try (Scanner scan = new Scanner(new File(path))){
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void ghiDSThanhVienTuFile(String path){
        
    }
}
