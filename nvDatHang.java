import java.util.ArrayList;
import java.util.Scanner;

public class nvDatHang extends NhanVien{
	private ArrayList<SanPham> DSSanPham;

	public void nhanDonHang(){
		//Goi roi khoi tao luon do phai reset lai.
		this.DSSanPham = new ArrayList<SanPham>();
		
		//Hoi nguoi ta muon uong gi
		Scanner scan = new Scanner(System.in);
		System.out.println("Ban muon dung mon gi ?");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca phe");
		System.out.println("3. Chua biet");
		System.out.print("Moi nhap lua chon: ");

		int LuaChon = Integer.parseInt(scan.nextLine());
		while (LuaChon < 1 || LuaChon > 3) {
			System.out.println("Vui long nhap lai!");
			System.out.print("Moi nhap lua chon: ");
			LuaChon = Integer.parseInt(scan.nextLine());;
		}
		ThucDon.xuatMenu(LuaChon);

		//Bat dau cho goi mon
		if (LuaChon == 3){	//luc nay chua biet goi mon gi
			System.out.println("Ban muon dung mon gi ?");
			System.out.println("1. Tra sua");
			System.out.println("2. Ca phe");
			System.out.print("Moi nhap lua chon: ");
			LuaChon = Integer.parseInt(scan.nextLine());
		}
		
		System.out.println();

		System.out.println("Chon '0' de thoat");

		int index = 0;
		System.out.print("Moi chon mon: ");
		int vitriMon = Integer.parseInt(scan.nextLine());
		do {
			


			System.out.print("Moi chon mon tiep theo: ");
			vitriMon = Integer.parseInt(scan.nextLine());
		} while (vitriMon != 0);
		
		//chua lam xong
		for (SanPham sp : ThucDon.thucdon){
			if (index == vitriMon){
				this.DSSanPham.add(sp);
				break;
			}
			if ((sp instanceof TraSua && LuaChon == 1) 
			|| (sp instanceof CaPhe && LuaChon == 2)){
				++index;
			}
		}
		
	}
}
