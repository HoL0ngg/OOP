public class CTHD {
    private String maChitetHoadon;
    private String ten;
    private int size;
    private int soluongSanpham;
    private int donGia;
    private boolean hoanthanh;
    private int duong;
    private int da;

    public CTHD() {
    }

    public CTHD(String maHoadon, String ten, int soluongSanpham, int size, int tienSanpham, boolean hoanthanh) {
        this.maChitetHoadon = maHoadon;
        this.soluongSanpham = soluongSanpham;
        this.ten = ten;
        this.size = size;
        this.donGia = tienSanpham;
        this.hoanthanh = hoanthanh;
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

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public boolean isHoanthanh() {
        return hoanthanh;
    }

    public void setHoanthanh(boolean hoanthanh) {
        this.hoanthanh = hoanthanh;
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

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getDuong() {
        return duong;
    }

    public void setDuong(int duong) {
        this.duong = duong;
    }

    public int getDa() {
        return da;
    }

    public void setDa(int da) {
        this.da = da;
    }

    public void xuatHoadon() {

    }

    public void xuatThongTin() {
        String stringsize = null;
        switch (this.getSize()) {
            case 0:
                stringsize = "S";
                break;
            case 1:
                stringsize = "M";
                break;
            case 2:
                stringsize = "L";
                break;
        }
        System.out.format("%-1s %5s %-30s %-7s %-5s %-10s %-15s %-1s",
                "|",
                this.getMaChitetHoadon(),
                "|  " + this.getTen(),
                "|   " + stringsize,
                "|  " + this.getSoluongSanpham(),
                "|  " + ChucNang.chuanHoaGia(this.getDonGia()) + "d",
                "|  " + (this.isHoanthanh() ? "Hoan thanh" : "Dang xu ly"),
                "|");
        System.out.println();

        if (this.getDuong() != SanPham.duong.length - 1) {
            System.out.format("%-1s %5s %-24s %-7s %-5s %-10s %-15s %-1s",
                    "|",
                    "",
                    "|\t+ " + SanPham.duong[this.duong] + " duong",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|");
            System.out.println();
        }
        if (this.getDa() != SanPham.da.length - 1) {
            System.out.format("%-1s %5s %-24s %-7s %-5s %-10s %-15s %-1s",
                    "|",
                    "",
                    "|\t+ " + SanPham.da[this.da] + " da",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|");
            System.out.println();
        }
    }
}
