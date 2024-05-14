
public class ThanhVien {
    private String id;
    private String ten;
    private String sđt;
    private NgayThang ngaysinh;
    private int diemtichluy;

    public ThanhVien() {
    }

    public ThanhVien(String id, String ten, String sđt, NgayThang ngaysinh, int diemtichluy) {
        this.id = id;
        this.ten = ten;
        this.sđt = sđt;
        this.ngaysinh = ngaysinh;
        this.diemtichluy = diemtichluy;
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

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    public void xuatThongTin(){
        System.out.format("%-8s %-18s %-15s %-5s",
        this.getId(),
        "|  " + this.getTen(),
        "|  " + this.getNgaysinh(),
        "|  " + this.getDiemtichluy());
        System.out.println();
    }

    public void nhapThongTin(){
        System.out.print("Nhap ten: ");
        setTen(ChucNang.chuanHoaChuoi());
        System.out.print("Nhap so dien thoai: ");
        setSđt(ChucNang.chuanHoaChuoi());
        System.out.println("Nhap ngay thang nam sinh");
        NgayThang tmp = new NgayThang();
        tmp.nhapThongTin();
        this.setNgaysinh(tmp);
        this.setDiemtichluy(0);
    }

}
