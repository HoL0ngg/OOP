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
        int tongdon = 0;
        int tongDoanhthu = 0;
        System.out.print("Nhap nam muon thong ke: ");
        int nam = ChucNang.chuanHoa(2024);
        for (Hoadon hd : DSHoaDon.getDSHD()) {
            if (hd.getNgayHoadon().getNam() == nam) {
                soluongdon[hd.getNgayHoadon().getThang() / 4]++;
                doanhthu[hd.getNgayHoadon().getThang() / 4] += hd.getTienHoadon();
            }
        }
        System.out.println(
                "+===============================================================================================+");
        System.out.println(
                "|                                       THONG KE QUY NAM " + nam
                        + "                                   |");
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
        System.out.println(
                "|     LOAI      |     QUY I     |     QUY II    |    QUY  III   |    QUY  IV    |      TONG     |");
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
        System.out.print("| So luong don\t");
        for (int i = 0; i < 4; ++i) {
            tongdon += soluongdon[i];
            System.out.printf("|       %-8s", soluongdon[i]);
        }
        System.out.printf("|      %-9d", tongdon);
        System.out.println("|");
        System.out.print("| Tong tien\t");
        for (int i = 0; i < 4; ++i) {
            tongDoanhthu += doanhthu[i];
            if (doanhthu[i] == 0) {
                System.out.printf("|       %-8d", 0);
            } else {
                System.out.printf("|    %-11s", ChucNang.chuanHoaGia(doanhthu[i]));
            }

        }
        int length = ChucNang.chuanHoaGia(tongDoanhthu).length() - 4;
        System.out.print("|");
        for (int j = 1; j < 8 - length; ++j) {
            System.out.print(" ");
        }
        int tab = 7 - 3;
        System.out.print(ChucNang.chuanHoaGia(tongDoanhthu));
        for (int j = 0; j < tab; ++j) {
            System.out.print(" ");
        }
        System.out.println("|");
        System.out.println(
                "+===============================================================================================+");
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
        System.out.print("Nhap nam muon thong ke: ");
        int nam = ChucNang.chuanHoa(2024);
        for (Hoadon hd : DSHoaDon.getDSHD()) {
            if (hd.getNgayHoadon().getNam() == nam) {
                soluongdon[hd.getNgayHoadon().getThang()]++;
                doanhthu[hd.getNgayHoadon().getThang()] += hd.getTienHoadon();
            }
        }
        // System.out.println(
        // "+===========================================================================================================================================================================+");
        // System.out.println(
        // "| THONG KE THANG TRONG NAM "
        // + nam + " |");
        // System.out.println(
        // "+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        // System.out.println(
        // "| LOAI | THANG 1 | THANG 2 | THANG 3 | THANG 4 | THANG 5 | THANG 6 | THANG 7
        // | THANG 8 | THANG 9 | THANG 10 | THANG 11 | THANG 12 |");
        // System.out.println(
        // "+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

        // System.out.print("| So luong don\t");
        // for (int i = 0; i < 12; ++i) {
        // System.out.printf("| %-6s", soluongdon[i]);
        // }
        // System.out.println("|");
        // System.out.print("| Tong tien\t");
        // for (int i = 0; i < 12; ++i) {
        // if (doanhthu[i] == 0) {
        // System.out.printf("| %-6d", 0);
        // } else
        // System.out.printf("| %-9s", ChucNang.chuanHoaGia(doanhthu[i]));
        // }
        // System.out.println("|");
        // System.out.println(
        // "+===========================================================================================================================================================================+");
        int tongdon = 0;
        int tongDoanhthu = 0;
        System.out.println("+==============================================+");
        System.out.println("|            THONG KE THANG NAM " + nam + "           |");
        System.out.println("+----------------------------------------------+");
        System.out.println("|   THANG   |   SO LUONG DON   |   TONG TIEN   |");
        System.out.println("+----------------------------------------------+");
        for (int i = 0; i < 12; ++i) {
            tongDoanhthu += doanhthu[i];
            tongdon += soluongdon[i];
            System.out.printf("|     %-6d", i + 1);
            System.out.printf("|        %-10d", soluongdon[i]);
            if (doanhthu[i] == 0)
                System.out.printf("|       %-8d", 0);
            else {
                int length = ChucNang.chuanHoaGia(doanhthu[i]).length() - 4;
                System.out.print("|");
                for (int j = 1; j < 8 - length; ++j) {
                    System.out.print(" ");
                }
                int tab = 7 - 3;
                System.out.print(ChucNang.chuanHoaGia(doanhthu[i]));
                for (int j = 0; j < tab; ++j) {
                    System.out.print(" ");
                }
                // System.out.printf("%-11s", ChucNang.chuanHoaGia(doanhthu[i]));
            }
            System.out.println("|");
        }
        System.out.println("+----------------------------------------------+");
        System.out.printf("|   TONG    |        %-8d  |    %-8s   |\n", tongdon, ChucNang.chuanHoaGia(tongDoanhthu));
        System.out.println("+==============================================+");
    }
}
