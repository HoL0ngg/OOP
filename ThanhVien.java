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

    public void nhapThongTin(int tong){
        System.out.println("Nhap ngay thang nam sinh");
        NgayThang tmp = new NgayThang();
        tmp.nhapThongTin();
        this.setNgaysinh(tmp);
        this.setDiemtichluy(tong);
    }
}
