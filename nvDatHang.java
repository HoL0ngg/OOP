import java.util.ArrayList;
import java.util.Scanner;

public class nvDatHang extends NhanVien{
	// private ArrayList<SanPham> DSSanPham;

	// 1 mang luu vi tri voi moi vi tri la 3 size
	private	int[] DSSanPham = new int[ThucDon.thucdon.size() * SanPham.validSize];

	public nvDatHang(){
		// this.DSSanPham = new ArrayList<SanPham>();
	}

	public void xuatDonHang(){
		System.out.println("Don hang hien tai: ");
		for (int i = 0 ; i <= 6 * 8; ++i){
			System.out.print('-');
		}
		System.out.println();
		System.out.println("|Ten mon hang\t\t\tSize\tSo luong|");
		for (int i = 0 ; i <= 6 * 8; ++i){
			System.out.print('-');
		}
		System.out.println();
		int index = 1;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize; ++i){
			if (this.DSSanPham[i] != 0){
				int ten = i / SanPham.validSize;
				int size = i % SanPham.validSize;

				int tmplength = (ThucDon.thucdon.get(ten).getTen().length() + 2 +  (String.valueOf(index).length()))/ 8;
				// System.out.println(tmplength);
				System.out.print("|" + index++ + ". " + ThucDon.thucdon.get(ten).getTen());
				for (int j = tmplength ; j <= SanPham.maxLength/8; ++j){
					System.out.print("\t");
				}

				System.out.println(SanPham.size[size] + "\t" + this.DSSanPham[i] + "\t|");
			}
		}
		for (int i = 0 ; i <= 6 * 8; ++i){
			System.out.print('-');
		}
		System.out.println();
	}

	public void nhanDonHang(){
		//Hoi nguoi ta muon uong gi
		ThucDon.xuatMenu(3);

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Chon '0' de thoat");
		while (true) {
			System.out.println("Ban muon dung mon gi ?");
			System.out.println("1. Tra sua");
			System.out.println("2. Ca phe");
			System.out.print("Moi nhap lua chon: ");
			int loai = Integer.parseInt(scan.nextLine());
			while (loai < 1 || loai > 2) {
				System.out.println("Vui long nhap lai!!");
				System.out.println("Ban muon dung mon gi ?");
				System.out.println("1. Tra sua");
				System.out.println("2. Ca phe");
				System.out.print("Moi nhap lua chon: ");
				loai = Integer.parseInt(scan.nextLine());
			}
	
			System.out.print("Moi chon mon: ");
			int vitriMon = Integer.parseInt(scan.nextLine());
			System.out.println("Moi chon size: ");
			for (int i = 0 ; i < SanPham.validSize; ++i){
				System.out.println((i + 1) + ". " + SanPham.size[i]);
			}
			System.out.print("Moi chon kich thuoc: ");
			int kichThuoc = Integer.parseInt(scan.nextLine());
			this.DSSanPham[(vitriMon - 1)*SanPham.validSize + kichThuoc - 1 + (loai == 2 ? 1 : 0)*ThucDon.indexOfCaPhe*SanPham.validSize]++;
			System.out.println("Ban co muon chon nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			if (Integer.parseInt(scan.nextLine()) == 2) break;
		}

		
		//xuat ra don hang hien tai de kiem tra
		this.xuatDonHang();


		System.out.println("Ban co muon thay doi gi khong ?");
		System.out.println("1. Co");
		System.out.println("2. Khong");
		int chonlai = Integer.parseInt(scan.nextLine());
		while (chonlai == 1){
			System.out.println("Ban muon thay doi gi? ");
			System.out.println("1. Thay doi san pham");
			System.out.println("2. Thay doi kich thuoc");


			System.out.println("Ban co muon thay doi gi khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
		}
		scan.close();
	}
}
