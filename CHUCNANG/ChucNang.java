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
                System.out.print("Moi nhap lua chon: ");
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
        System.out.print("Moi nhap lua chon: ");
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
        boolean isSDT = true;
        String sdt = scan.nextLine().trim();
        for (int i = 0; i < sdt.length(); ++i) {
            if (sdt.charAt(i) < '0' || sdt.charAt(i) > '9')
                isSDT = false;
        }

        if (sdt.length() < 10 || sdt.length() > 11)
            isSDT = false;
        else if (sdt.charAt(0) != '0' || sdt.charAt(1) == '0')
            isSDT = false;
        while (!isSDT) {
            isSDT = true;
            System.out.print("Gia tri khong hop le, moi nhap lai SDT: ");
            sdt = scan.nextLine().trim();
            for (int i = 0; i < sdt.length(); ++i) {
                if (sdt.charAt(i) < '0' || sdt.charAt(i) > '9')
                    isSDT = false;
            }
            if (sdt.length() < 10 || sdt.length() > 11)
                isSDT = false;
            else if (sdt.charAt(0) != '0' || sdt.charAt(1) == '0')
                isSDT = false;
        }
        // do {
        // isSDT = true;
        // sdt = scan.nextLine().trim();
        // for (int i = 0; i < sdt.length(); ++i) {
        // if (sdt.charAt(i) <= '0' || sdt.charAt(i) >= '9')
        // isSDT = false;
        // }
        // if (sdt.charAt(0) != '0' && sdt.charAt(1) == '0' && sdt.length() < 10 &&
        // sdt.length() > 11)
        // isSDT = false;
        // } while (!isSDT);
        return sdt;
    }

    public static String chuanHoaSoNha() {
        Scanner scan = new Scanner(System.in);
        String soNha = scan.nextLine();
        boolean check = false;
        soNha = soNha.trim();
        for (int i = 0; i < soNha.length(); ++i) {
            if ((soNha.charAt(i) >= '0' && soNha.charAt(i) <= '9') || soNha.charAt(i) == '/') {
                check = true;
                break;
            }
        }
        if (soNha.charAt(soNha.length() - 1) == '/')
            check = false;
        while (soNha.length() < 1 || !check) {
            check = false;
            System.out.print("Gia tri khong hop le, moi nhap lai so nha: ");
            soNha = scan.nextLine();
            soNha = soNha.trim();
            for (int i = 0; i < soNha.length(); ++i) {
                if ((soNha.charAt(i) >= '0' && soNha.charAt(i) <= '9') || soNha.charAt(i) == '/') {
                    check = true;
                    break;
                }
            }
            if (soNha.charAt(soNha.length() - 1) == '/')
                check = false;
        }
        return soNha;
    }

    public static String chuanHoaTen() {
        Scanner scan = new Scanner(System.in);
        boolean isTen = true;
        String ten = scan.nextLine().trim();
        for (int i = 0; i < ten.length(); ++i) {
            if (ten.charAt(i) >= '0' && ten.charAt(i) <= '9') {
                isTen = false;
                break;
            }
        }
        while (ten.length() < 2 || !isTen) {
            System.out.print("Gia tri khong hop le, vui long nhap lai ten: ");
            isTen = true;
            ten = scan.nextLine().trim();
            for (int i = 0; i < ten.length(); ++i) {
                if (ten.charAt(i) >= '0' && ten.charAt(i) <= '9') {
                    isTen = false;
                    break;
                }
            }
        }
        return ten;
    }

    public static String chuanHoaEmail() {
        Scanner scan = new Scanner(System.in);
        char[] check = { '@', '.' };
        boolean isEmail = false;
        String mail = scan.nextLine().trim();
        int i = 1;
        int j = 0;
        while (i < mail.length() && j < check.length) {
            if (mail.charAt(i) == check[j]) {
                i = i + 2;
                j++;
            }
            ++i;
        }
        if (j == check.length - 1 && mail.length() - i > 2)
            isEmail = true;

        while (!isEmail) {
            System.out.print("Gia tri khong hop le, moi nhap lai email: ");
            mail = scan.nextLine().trim();
            i = 1;
            j = 0;
            while (i < mail.length() && j < check.length) {
                if (mail.charAt(i) == check[j]) {
                    i = i + 2;
                    j++;
                } else
                    ++i;
            }
            if (j == check.length && mail.length() - i > 0)
                isEmail = true;
        }
        // do {
        // mail = scan.nextLine().trim();
        // int i = 1;
        // int j = 0;
        // while (i < mail.length() && j < check.length) {
        // if (mail.charAt(i) == check[j]) {
        // i = i + 2;
        // j++;
        // }
        // }
        // if (j == check.length - 1 && mail.length() - i > 2)
        // isEmail = true;

        // } while (!isEmail);

        return mail;
    }
}
