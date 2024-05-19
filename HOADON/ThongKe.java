package HOADON;

import java.util.ArrayList;
import java.util.List;

import CHUCNANG.ChucNang;
import SANPHAM.ThucDon;

public class ThongKe {
    private static int[] soluongdon;
    private static int[] doanhthu;
    private static int[] soluonghang;

    public ThongKe() {
    }

    public static void thongKeQuy() {
        ThongKe.soluongdon = new int[4];
        ThongKe.doanhthu = new int[4];
        ThongKe.soluonghang = new int[ThucDon.thucdon.size()];
        System.out.println("Nhap nam muon thong ke ");
        int nam = ChucNang.chuanHoa(2024);
        for (Hoadon hd : DSHoaDon.getDSHD()) {
            if (hd.getNgayHoadon().getNam() == nam) {
                soluongdon[hd.getNgayHoadon().getNam() % 4]++;
                doanhthu[hd.getNgayHoadon().getNam() % 4] += hd.getTienHoadon();
            }
        }
        System.out.println("+===============================================================================+");
        System.out.println("|                                 THONG KE QUY                                  |");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|     LOAI      |     QUY I     |     QUY II    |    QUY  III   |    QUY  IV    |");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.print("| So luong don\t");
        for (int i = 0; i < 4; ++i) {
            System.out.printf("|       %-8s", soluongdon[i]);
        }
        System.out.println("|");
        System.out.print("| Tong tien\t");
        for (int i = 0; i < 4; ++i) {
            if (doanhthu[i] == 0) {
                System.out.printf("|       %-8d", 0);
            } else
                System.out.printf("|     %-10s", ChucNang.chuanHoaGia(doanhthu[i]));
        }
        System.out.println("|");
        System.out.println("+===============================================================================+");
    }

    public static void thongKeNgay() {
        ThongKe.soluongdon = new int[31];
        ThongKe.doanhthu = new int[31];
        ThongKe.soluonghang = new int[ThucDon.thucdon.size()];
    }

    public static void thongKeThang() {
        ThongKe.soluongdon = new int[12];
        ThongKe.doanhthu = new int[12];
        ThongKe.soluonghang = new int[ThucDon.thucdon.size()];
        System.out.println("Nhap nam muon thong ke ");
        int nam = ChucNang.chuanHoa(2024);
        for (Hoadon hd : DSHoaDon.getDSHD()) {
            if (hd.getNgayHoadon().getNam() == nam) {
                soluongdon[hd.getNgayHoadon().getThang() % 12]++;
                doanhthu[hd.getNgayHoadon().getThang() % 12] += hd.getTienHoadon();
            }
        }
        System.out.println("+===============================================================================+");
        System.out.println("|                                 THONG KE QUY                                  |");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|     LOAI      |     QUY I     |     QUY II    |    QUY  III   |    QUY  IV    |");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.print("| So luong don\t");
        for (int i = 0; i < 4; ++i) {
            System.out.printf("|       %-8s", soluongdon[i]);
        }
        System.out.println("|");
        System.out.print("| Tong tien\t");
        for (int i = 0; i < 4; ++i) {
            if (doanhthu[i] == 0) {
                System.out.printf("|       %-8d", 0);
            } else
                System.out.printf("|     %-10s", ChucNang.chuanHoaGia(doanhthu[i]));
        }
        System.out.println("|");
        System.out.println("+===============================================================================+");
    }
}
