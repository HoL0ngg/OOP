package CHUCNANG;

import java.util.Calendar;
import java.util.Scanner;

public class ChucNang {
    public static int chuanHoa(int low, int high) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                int luachon = Integer.parseInt(scan.nextLine());
                while (luachon < low || luachon > high) {
                    System.out.println("Gia tri khong hop le!");
                    System.out.print("Vui long nhap lai: ");
                    luachon = Integer.parseInt(scan.nextLine());
                }
                return luachon;

            } catch (Exception e) {
                System.out.println("Gia tri khong hop le!");
            }
        }
    }

    public static String chuanHoaChuoi() {
        Scanner scan = new Scanner(System.in);
        // System.out.print("Moi nhap lua chon: ");
        String luachon = scan.nextLine();
        while (luachon.trim().equals("")) {
            System.out.println("Gia tri khong hop le!");
            System.out.print("Vui long nhap lai: ");
            luachon = scan.nextLine();
        }
        return luachon;
    }

    public static int xacNhanThaoTac() {
        System.out.println("\nXac nhan thuc hien thao tac?");
        System.out.println("0. Khong xac nhan");
        System.out.println("1. Xac nhan");
        int xacnhan = ChucNang.chuanHoa(0, 1);
        return xacnhan;
    }

    public static String chuanHoaGia(int gia) {
        String tmp = Integer.toString(gia);
        String hehe = "";
        while (tmp.length() % 3 != 0)
            tmp = " " + tmp;
        for (int i = 0; i < tmp.length(); ++i) {
            if (tmp.charAt(i) == ' ')
                continue;
            hehe = hehe + tmp.charAt(i);
            if (((i + 1) % 3 == 0) & (i + 1 != tmp.length()))
                hehe = hehe + ".";
        }

        return hehe;
    }

    // public static int chuanHoa(int high) {
    // Scanner scan = new Scanner(System.in);
    // while (true) {
    // try {
    // int hehe = Integer.parseInt(scan.nextLine());
    // while (hehe < 0 || hehe > high) {
    // System.out.println("Gia tri khong hop le!");
    // System.out.print("Vui long nhap lai: ");
    // hehe = Integer.parseInt(scan.nextLine());
    // }
    // return hehe;

    // } catch (Exception e) {
    // System.out.println("Gia tri khong hop le!");
    // }
    // }
    // }

    public static boolean SoSanhNgay(NgayThang ngay, Calendar today) {
        if (ngay.getNam() < today.get(Calendar.YEAR))
            if (ngay.getThang() == (today.get(Calendar.MONTH) + 1) && ngay.getNgay() < today.get(Calendar.DAY_OF_MONTH))
                return false;
        if (ngay.getThang() < (today.get(Calendar.MONTH) + 1))
            return false;
        return true;
    }

    public static String chuaHoaSDT() {
        Scanner scan = new Scanner(System.in);
        String sdt = scan.nextLine();
        while (sdt.charAt(0) != '0' || sdt.length() < 10) {
            System.out.println("Gia tri khong hop le !");
            System.out.print("Moi nhap lai SDT: ");
            sdt = scan.nextLine();
        }
        return sdt;
    }
}
