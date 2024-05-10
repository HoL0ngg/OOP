import java.util.ArrayList;
import java.util.Scanner;

public class nvDatHang extends NhanVien{
	// private ArrayList<SanPham> DSSanPham;

	// 1 mang luu vi tri voi moi vi tri la 3 size
	private	int[] DSSanPham;
	private int demSanPham;

	public nvDatHang(){
	}

	private void xuatDonHang(){
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

				int tmplength = (ThucDon.thucdon.get(ten).getTen().length() + 4 +  (String.valueOf(index).length())) / 8;
				// System.out.println(tmplength);

				System.out.print("| " + index++ + ". " + ThucDon.thucdon.get(ten).getTen());
				for (int j = tmplength ; j <= cntTab; ++j){
					System.out.print("\t");
				}

				//so luong
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
	
	private void xoaSanPham(int index){
		int cnt = 0;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize; ++i){
			if (this.DSSanPham[i] != 0){
				++cnt;
			}
			if (cnt == index){
				this.DSSanPham[i] = 0;
			}
		}
	}

	private void thaydoiSanPham(int index){
		this.xoaSanPham(index);

		System.out.println("Ban muon dung mon gi ?");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca phe");
		int loai = ChucNang.chuanHoa(1, 2);
	
		ThucDon.xuatMenu(loai);

		//chuan hoa du lieu
		int vitriMon = ChucNang.chuanHoa(1, ((loai == 1) ? ThucDon.indexOfCaPhe : ThucDon.thucdon.size() - ThucDon.indexOfCaPhe));


		System.out.println("Moi chon size: ");
		for (int i = 0 ; i < SanPham.validSize; ++i){
			System.out.println((i + 1) + ". " + SanPham.size[i]);
		}
		//chuan hoa du lieu
		int kichThuoc = ChucNang.chuanHoa(1, SanPham.validSize);


		this.DSSanPham[(vitriMon - 1)*SanPham.validSize + (kichThuoc - 1) + (loai == 2 ? 1 : 0)*ThucDon.indexOfCaPhe*SanPham.validSize]++;
	}

	private void thaydoiKichThuoc(int index, int size){

	}

	private void xuliDonHang(){
		while (true) {
			System.out.println("Ban muon dung mon gi ?");
			System.out.println("1. Tra sua");
			System.out.println("2. Ca phe");
			int loai = ChucNang.chuanHoa(1, 2);
		
			ThucDon.xuatMenu(loai);

			//chuan hoa du lieu
			int vitriMon = ChucNang.chuanHoa(1, ((loai == 1) ? ThucDon.indexOfCaPhe : ThucDon.thucdon.size() - ThucDon.indexOfCaPhe));


			System.out.println("Moi chon size: ");
			for (int i = 0 ; i < SanPham.validSize; ++i){
				System.out.println((i + 1) + ". " + SanPham.size[i]);
			}
			//chuan hoa du lieu
			int kichThuoc = ChucNang.chuanHoa(1, SanPham.validSize);


			this.DSSanPham[(vitriMon - 1)*SanPham.validSize + (kichThuoc - 1) + (loai == 2 ? 1 : 0)*ThucDon.indexOfCaPhe*SanPham.validSize]++;
			this.demSanPham++;
			
			this.xuatDonHang();

			System.out.println("Ban co muon chon nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");

			//chuan hoa du lieu
			int chonTiep = ChucNang.chuanHoa(1, 2);

			if (chonTiep == 2) break;
		}
	}
	
	private void kiemTralai(){
		//Phan nay chua lam xong !!!
		Scanner scan = new Scanner(System.in);
		System.out.println("Ban co muon thay doi gi khong ?");
		System.out.println("1. Co");
		System.out.println("2. Khong");
		int chonlai = ChucNang.chuanHoa(1, 2);
		while (chonlai == 1){
			System.out.println("Ban muon thay doi gi? ");
			System.out.println("1. Thay doi san pham");
			System.out.println("2. Thay doi kich thuoc");
			System.out.println("3. Xoa san pham");
			int hehe = ChucNang.chuanHoa(1, 3);

			this.xuatDonHang();
			
			switch (hehe) {
				case 1:
					System.out.println("Nhap stt san pham can thay doi: ");
					int spBiThayDoi = ChucNang.chuanHoa(1, this.demSanPham);
					this.thaydoiSanPham(spBiThayDoi);
					break;

				case 2:
					System.out.print("Nhap stt san pham can thay doi kich thuoc: ");
					int spThayDoiSize = Integer.parseInt(scan.nextLine());
					while (this.DSSanPham[spThayDoiSize] == 0){
						System.out.println("STT khong hop le!");
						System.out.print("Nhap stt san pham can thay doi kich thuoc: ");
						spThayDoiSize = Integer.parseInt(scan.nextLine());
					}
					System.out.print("Nhap size muon thay doi: ");
					for (int i = 0 ; i < SanPham.validSize; ++i){
						System.out.println((i + 1) + ". " + SanPham.size[i]);
					}
					System.out.print("Moi nhap lua chon: ");
					int size = Integer.parseInt(scan.nextLine());
					this.thaydoiKichThuoc(spThayDoiSize, size);
					break;

				case 3:
					System.out.println("Nhap stt san pham can xoa: ");
					int spBiXoa = ChucNang.chuanHoa(1, this.demSanPham);
					this.xoaSanPham(spBiXoa);
					break;
			}

			this.xuatDonHang();

			System.out.println("Ban co muon thay doi gi nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Moi nhap lua chon: ");
			chonlai = ChucNang.chuanHoa(1, 2);
		}
		// scan.close();
	}

	private void thanhtoan(){
		System.out.println("Ban co muon dang ky thanh vien: ");
		System.out.println("1. Co");
		System.out.println("2. Khong");
		int luachon = ChucNang.chuanHoa(1, 2);
		if (luachon == 2) return;
		ThanhVien.dkThanhVien();
	}

	public void nhanDonHang(){
		this.DSSanPham = new int[ThucDon.thucdon.size() * SanPham.validSize];
		this.demSanPham = 0;
	
		//xu li thao tac nguoi dung
		this.xuliDonHang();

		//xuat ra don hang hien tai de kiem tra
		this.xuatDonHang();

		//nguoi dung chinh sua don hang neu co
		this.kiemTralai();

		//Thanh toan don hang
		this.thanhtoan();

		//Se co 1 static function cua HoaDon de xuatHoaDon
		//HoaDon.xuatHoaDon(this.DSSanPham);

	}
	
	//Menu cho nhan vien dat hang
	public void menu( ) {
		int luachon;
		while(true){
			System.out.println("---------------------NHAN VIEN DAT HANG---------------------");
			System.out.println();
		}
	}

}
