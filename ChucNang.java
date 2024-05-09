import java.util.Scanner;

public class ChucNang {
    public static int chuanHoa(int low, int high){
        Scanner scan = new Scanner(System.in); 
        System.out.print("Moi nhap lua chon: ");
		int luachon = Integer.parseInt(scan.nextLine()); 
        while (luachon < low || luachon > high){
            System.out.println("Gia tri khong hop le!");
            System.out.print("Vui long nhap lai: ");
            luachon = Integer.parseInt(scan.nextLine());
        }
        return luachon;
    }

    public static String chuanHoaChuoi(){
        Scanner scan = new Scanner(System.in);
        // System.out.print("Moi nhap lua chon: ");
		String luachon = scan.nextLine(); 
        while (luachon.trim().equals("")){
            System.out.println("Gia tri khong hop le!");
            System.out.print("Vui long nhap lai: ");
            luachon = scan.nextLine();
        }
        return luachon;
    }
}
