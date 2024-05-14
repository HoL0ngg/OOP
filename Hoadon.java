import java.util.Scanner;

public class Hoadon {
    public String maHoadon;
    public String maNhanvien;
    public NgayThang ngayHoadon;
    public int tienHoadon;

    public static Scanner inp = new Scanner(System.in);
    public Hoadon() {

    }
    public Hoadon(String maHoadon, String maNhanvien, NgayThang ngayHoadon, int tienHoadon) {
        this.maHoadon = maHoadon;
        this.maNhanvien = maNhanvien;
        this.ngayHoadon = ngayHoadon;
        this.tienHoadon = tienHoadon;
    }

    public void setMaNhanvien(String maNhanvien) {
        this.maNhanvien = maNhanvien;
    }

    public String getMaNhanvien() {
        return maNhanvien;
    }

    public void setMaHoadon(String maHoadon) {
        this.maHoadon = maHoadon;
    }

    public String getMaHoadon() {
        return maHoadon;
    }


    public int getTienHoadon() {
        return tienHoadon;
    }

    public void setTienHoadon(int tienHoadon) {
        this.tienHoadon = tienHoadon;
    }

    public NgayThang getNgayHoadon() {
        return ngayHoadon;
    }

    public void setNgayHoadon(NgayThang ngayHoadon) {
        this.ngayHoadon = ngayHoadon;
    }

    public void xuatHoadon () {
        System.out.println("+=========================================+");
        System.out.println("|                  HOA DON                |");
        System.out.println("+-----------------------------------------+");
        System.out.println("| Ma hoa don: " + getMaHoadon() + "                       |");
        System.out.println("| Ma nhan vien: " + getMaNhanvien() + "                     |");
        System.out.println("| Ngay: " + getNgayHoadon() + "                          |");
        System.out.println("| Tong tien: " + getTienHoadon() + "                       |");
        System.out.println("+-----------------------------------------+");
    }
}
