package HOADON;

import java.util.ArrayList;
import CHUCNANG.NgayThang;

public class PhieuThongKe {
    private NgayThang NgayThongke;
    private int doanhthu;

    private int 

    public NgayThang getNgay(){
        return NgayThongke;
    }

    public ArrayList<Hoadon> getDSHD() {
        return DSHD;
    }

    public PhieuThongKe(NgayThang NgayThongke) {
        this.NgayThongke = NgayThongke;
        this.DSHD = new ArrayList<>();
    }

    public void themHoadon(Hoadon hoadon) {
        if (hoadon.getNgayHoadon().equals(this.NgayThongke)) {
            DSHD.add(hoadon);
        } else {
            System.out.println("Ngay hoa don khong hop le");
        }
    }

    public double ThongkeNgay() {
        double tongDoanhthu = 0.0;
        for (Hoadon hoadon : DSHD) {
            tongDoanhthu += hoadon.getTienHoadon();
        }
        return tongDoanhthu;
    }

    public static void main(String[] args) {
        // Tạo phiếu thống kê doanh thu cho ngày 17-05-2024;
        NgayThang ngay = new NgayThang(17, 5, 2024);
        PhieuThongKe phieu = new PhieuThongKe(ngay);
        // Thêm hóa đơn vào phiếu thống kê
        phieu.themHoadon(new Hoadon("1", "1", ngay, 100));
        phieu.themHoadon(new Hoadon("2", "1", ngay, 150));

        // In tổng doanh thu cho ngay thống kê
        System.out.print("Doanh thu bán hàng trong ngày " + ngay + ": " + phieu.ThongkeNgay());

    }
}
