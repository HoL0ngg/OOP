package HOADON;

import java.util.ArrayList;
import java.util.List;

import SANPHAM.ThucDon;

public class ThongKe {
    private DSHoaDon dshd;
    private static int[] soluongdon;
    private static int[] doanhthu;
    private static int[] soluonghang;

    public ThongKe() {
    }

    public void thongKeThang() {
        ThongKe.soluongdon = new int[12];
        ThongKe.doanhthu = new int[12];
        ThongKe.soluonghang = new int[ThucDon.thucdon.size()];
        List<Hoadon> = DSHoaDon.getDSHD();
        List<CTHD> = dshd.ge

    }

    public static void thongKeNgay() {
        ThongKe.soluongdon = new int[31];
        ThongKe.doanhthu = new int[31];
        ThongKe.soluonghang = new int[ThucDon.thucdon.size()];
    }

    public static void thongKeNam() {
        ThongKe.soluongdon = new int[4];
        ThongKe.doanhthu = new int[4];
        ThongKe.soluonghang = new int[ThucDon.thucdon.size()];
    }
}
