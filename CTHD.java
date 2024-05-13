import java.util.Scanner;

public class CTHD {
    public String maChitetHoadon;
    public String id;
    public int size;
    public int soluongSanpham;
    public double donGia;
    public CTHD() {
    }
    public CTHD (String  maHoadon, String id, int soluongSanpham, int size, double tienSanpham)  {
        this.maChitetHoadon = maHoadon;
        this.soluongSanpham = soluongSanpham;
        this.id = id;
        this.size = size;
        this.donGia = tienSanpham;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaChitetHoadon() {
        return maChitetHoadon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMaChitetHoadon(String maChitetHoadon) {
        this.maChitetHoadon = maChitetHoadon;
    }

    public int getSoluongSanpham() {
        return soluongSanpham;
    }

    public void setSoluongSanpham(int soluongSanpham) {
        this.soluongSanpham = soluongSanpham;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void xuatHoadon() {

    }

}
