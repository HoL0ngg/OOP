import java.util.ArrayList;
import java.util.Scanner;

public class nvDatHang extends NhanVien{
	// private ArrayList<SanPham> DSSanPham;

	// 1 mang luu vi tri voi moi vi tri la 3 size
	private	int[] DSSanPham;

	public nvDatHang(){
		// this.DSSanPham = new ArrayList<SanPham>();
	}

	public void xuatDonHang(){
		int tongtien = 0;
		int cntTab = (SanPham.maxLength / 8) + 1;
		String navList[] = {"Ten mon hang", "Size", "So luong"};
		//						   size soluong
		int lenOfHoaDon = cntTab + 1 + 1 + 1;

		System.out.println("\tDon hang hien tai: ");
		for (int i = 0 ; i <= lenOfHoaDon * 8; ++i){
			System.out.print('-');
		}
		System.out.println();
		for (int i = 0 ; i < navList.length; ++i){
			//Truong hop dau
			if (i == 0){
				System.out.print("|\t" + navList[i]);
				int lenOfItem = (navList[i].length() + 1 + 8) / 8;
				for (int j = lenOfItem ; j <= cntTab; ++j){
					System.out.print("\t");
				}
			} else

			//Truong hop cuoi
			if (i == navList.length - 1){
				System.out.println(navList[i]+"|");
			} else{
				System.out.print(navList[i] + "\t");
			}
		}
		
		for (int i = 0 ; i <= lenOfHoaDon * 8; ++i){
			System.out.print('-');
		}
		System.out.println();
		int index = 1;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize; ++i){
			if (this.DSSanPham[i] != 0){
				int ten = i / SanPham.validSize;
				int size = i % SanPham.validSize;

				int tmplength = (ThucDon.thucdon.get(ten).getTen().length() + 3 +  (String.valueOf(index).length())) / 8;
				// System.out.println(tmplength);

				System.out.print("|" + index++ + ". " + ThucDon.thucdon.get(ten).getTen());
				for (int j = tmplength ; j <= cntTab; ++j){
					System.out.print("\t");
				}

				System.out.println(SanPham.size[size] + "\t" + this.DSSanPham[i] + "\t|");

				tongtien += this.DSSanPham[i] * ThucDon.thucdon.get(ten).getGiaTienAtIndex(size);
			}
		}
		for (int i = 0 ; i <= lenOfHoaDon * 8; ++i){
			System.out.print('-');
		}
		System.out.println();
		System.out.print("|");
		for (int i = cntTab; i <= lenOfHoaDon; ++i){
			System.out.print("\t");
		}
		System.out.print("Thanh tien: " + tongtien + "d\t|");
		System.out.println();
		for (int i = 0 ; i <= lenOfHoaDon * 8; ++i){
			System.out.print('-');
		}
		System.out.println();
		System.out.println();
	}

	public void thaydoiSanPham(int index, int anoIndex){
	}

	public void thaydoiKichThuoc(int index){

	}

	public void xoaSanPham(int index){

	}

	public void nhanDonHang(){
		this.DSSanPham = new int[ThucDon.thucdon.size() * SanPham.validSize];
		//Hoi nguoi ta muon uong gi
		ThucDon.xuatMenu();

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Chon '0' de thoat");
		while (true) {
			System.out.println("Ban muon dung mon gi ?");
			System.out.println("1. Tra sua");
			System.out.println("2. Ca phe");
			System.out.print("Moi nhap lua chon: ");
			int loai = Integer.parseInt(scan.nextLine());

			//chuan hoa du lieu
			while (loai < 1 || loai > 2) {
				System.out.println("Vui long nhap lai!");
				System.out.println("Ban muon dung mon gi ?");
				System.out.println("1. Tra sua");
				System.out.println("2. Ca phe");
				System.out.print("Moi nhap lua chon: ");
				loai = Integer.parseInt(scan.nextLine());
			}

			System.out.print("Moi chon mon: ");
			int vitriMon = Integer.parseInt(scan.nextLine());
			
			//chuan hoa du lieu
			while (vitriMon < 1 || vitriMon > ((loai == 1) ? ThucDon.indexOfCaPhe : ThucDon.thucdon.size() - ThucDon.indexOfCaPhe)){
				System.out.println("Vui long nhap lai!");
				System.out.print("Moi chon mon: ");
			 	vitriMon = Integer.parseInt(scan.nextLine());
			}

			System.out.println("Moi chon size: ");
			for (int i = 0 ; i < SanPham.validSize; ++i){
				System.out.println((i + 1) + ". " + SanPham.size[i]);
			}
			System.out.print("Moi chon size: ");
			int kichThuoc = Integer.parseInt(scan.nextLine());

			//Chuan hoa du lieu
			while (kichThuoc < 1 || kichThuoc > SanPham.validSize) {
				System.out.println("Vui long nhap lai!");
				System.out.print("Moi chon size: ");
				kichThuoc = Integer.parseInt(scan.nextLine());
			}

			this.DSSanPham[(vitriMon - 1)*SanPham.validSize + (kichThuoc - 1) + (loai == 2 ? 1 : 0)*ThucDon.indexOfCaPhe*SanPham.validSize]++;
			System.out.println("Ban co muon chon nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Moi nhap lua chon: ");
			int chonTiep = Integer.parseInt(scan.nextLine());

			//Chuan hoa du lieu
			while (chonTiep < 1 || chonTiep > 2){
				System.out.println("Vui long nhap lai!");
				System.out.println("Ban co muon chon nua khong ?");
				System.out.println("1. Co");
				System.out.println("2. Khong");
				chonTiep = Integer.parseInt(scan.nextLine());
			}
			if (chonTiep == 2) break;
		}

		
		//xuat ra don hang hien tai de kiem tra
		this.xuatDonHang();

		//Phan nay chua lam xong !!!
		System.out.println("Ban co muon thay doi gi khong ?");
		System.out.println("1. Co");
		System.out.println("2. Khong");
		int chonlai = Integer.parseInt(scan.nextLine());
		while (chonlai == 1){
			System.out.println("Ban muon thay doi gi? ");
			System.out.println("1. Thay doi san pham");
			System.out.println("2. Thay doi kich thuoc");
			System.out.println("3. Xoa san pham");
			System.out.print("Moi nhap lua chon: ");
			int hehe = Integer.parseInt(scan.nextLine());
			while (hehe < 1 || hehe > 3) {
				System.out.println("Lua chon khong hop le, vui long nhap lai");
				System.out.print("Moi nhap lua chon: ");
				hehe = Integer.parseInt(scan.nextLine());
			}
			switch (hehe) {
				case 1:
					System.out.print("Nhap stt san pham can thay doi: ");
					int spBiThayDoi = Integer.parseInt(scan.nextLine());
					System.out.print("Nhap stt san pham thay doi thanh: ");
					int spThayDoi = Integer.parseInt(scan.nextLine());
					this.thaydoiSanPham(spBiThayDoi, spThayDoi);
					break;
				case 2:
					System.out.print("Nhap stt san pham can thay doi kich thuoc: ");
					int spThayDoiSize = Integer.parseInt(scan.nextLine());
					this.thaydoiKichThuoc(Integer.parseInt(scan.nextLine()));
					break;
				case 3:
					System.out.print("Nhap stt san pham can xoa: ");
					this.xoaSanPham(Integer.parseInt(scan.nextLine()));
					break;
			}

			System.out.println("Ban co muon thay doi gi nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Moi nhap lua chon: ");
			chonlai = Integer.parseInt(scan.nextLine());
		}
		scan.close();
	}

}
