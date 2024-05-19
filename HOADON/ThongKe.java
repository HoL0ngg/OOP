package HOADON;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import CHUCNANG.ChucNang;
import SANPHAM.ThucDon;

public class ThongKe {
    private static int[] soluongdon;
    private static int[] doanhthu;
    private static int[] soluonghang;

    public ThongKe() {
    }

    public static void thongKeThang() {
        ThongKe.soluongdon = new int[4];
        ThongKe.doanhthu = new int[4];
        ThongKe.soluonghang = new int[ThucDon.thucdon.size()];
        Calendar calendar = Calendar.getInstance();
        for (Hoadon hd : DSHoaDon.getDSHD()) {
            soluongdon[hd.getNgayHoadon().getNam() / 4]++;
        }
        for (CTHD cthd : DSHoaDon.getCTHDList()) {

        }
        System.out.println("+=======================================================+");
        System.out.println("|                     THONG KE QUY                      |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|    QUY I    |    QUY II   |   QUY  III  |   QUY  IV   |");
        System.out.println("+-------------------------------------------------------+");
        for (int i = 0; i < 4; ++i) {
            System.out.printf("|%-13d don", soluongdon[i]);
        }
        System.out.println("|");
        for (int i = 0; i < 4; ++i) {
            System.out.printf("|%-13sd", ChucNang.chuanHoaGia(doanhthu[i]));
        }
        System.out.println("|");
        System.out.println("+=======================================================+");
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
