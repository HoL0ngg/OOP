import java.util.Calendar;
import java.util.Date;

public class nvDatHang extends NhanVien {
	// 1 mang luu vi tri voi moi vi tri la 3 size
	private int[] DSSanPham;
	private int demSanPham;
	private int[] chonDuong;
	private int[] chonDa;

	public nvDatHang() {
		super();
	}

	private int xuatDonHang() {
		int tongtien = 0;
		int cntTab = (SanPham.maxLength / 8) + 1;
		String navList[] = { "Ten mon hang", "Size", "So luong" };
		// size soluong
		int lenOfHoaDon = cntTab + 1 + 1 + 1;

		System.out.println("\tDon hang hien tai: ");

		System.out.println("+=======================================================+");

		for (int i = 0; i < navList.length; ++i) {
			// Truong hop dau
			if (i == 0) {
				System.out.print("|\t" + navList[i]);
				int lenOfItem = (navList[i].length() + 1 + 8) / 8;
				for (int j = lenOfItem; j <= cntTab; ++j) {
					System.out.print("\t");
				}
			} else

			// Truong hop cuoi
			if (i == navList.length - 1) {
				System.out.println(navList[i] + "|");
			} else {
				System.out.print(navList[i] + "\t");
			}
		}

		System.out.println("+-------------------------------------------------------+");

		int index = 1;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize; ++i) {
			if (this.DSSanPham[i] != 0) {
				int ten = i / SanPham.validSize;
				int size = i % SanPham.validSize;

				int tmplength = (ThucDon.thucdon.get(ten).getTen().length() + 4 + (String.valueOf(index).length())) / 8;
				// System.out.println(tmplength);

				System.out.print("| " + index++ + ". " + ThucDon.thucdon.get(ten).getTen());
				for (int j = tmplength; j <= cntTab; ++j) {
					System.out.print("\t");
				}

				// so luong
				System.out.println(" " + SanPham.size[size] + "\t   " + this.DSSanPham[i] + "\t|");
				if (chonDuong[i] != 4 && i < ThucDon.indexOfCaPhe * SanPham.validSize)
					System.out.println("|\t + " + SanPham.duong[chonDuong[i]] + " duong\t\t\t\t\t|");
				if (chonDa[i] != 4)
					System.out.println("|\t + " + SanPham.da[chonDa[i]] + " da\t\t\t\t\t|");
				System.out.println("+-------------------------------------------------------+");

				tongtien += this.DSSanPham[i] * ThucDon.thucdon.get(ten).getGiaTienAtIndex(size);
			}
		}
		// System.out.println("+-------------------------------------------------------+");
		System.out.print("|");
		for (int i = cntTab; i <= lenOfHoaDon; ++i) {
			System.out.print("\t");
		}
		System.out.print("Thanh tien: " + ChucNang.chuanHoaGia(tongtien) + "d\t|");
		System.out.println();
		System.out.println("+=======================================================+");
		System.out.println();

		return tongtien;
	}

	private void xoaSanPham(int index) {
		int cnt = 0;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize; ++i) {
			if (this.DSSanPham[i] != 0) {
				++cnt;
			}
			if (cnt == index) {
				this.DSSanPham[i] = 0;
				return;
			}
		}
	}

	private void thaydoiSanPham(int index) {
		this.xoaSanPham(index);

		System.out.println("Ban muon dung mon gi ?");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca phe");
		int loai = ChucNang.chuanHoa(1, 2);

		ThucDon.xuatMenu(loai);

		// chuan hoa du lieu
		int vitriMon = ChucNang.chuanHoa(1,
				((loai == 1) ? ThucDon.indexOfCaPhe : ThucDon.thucdon.size() - ThucDon.indexOfCaPhe));

		System.out.println("Moi chon size: ");
		for (int i = 0; i < SanPham.validSize; ++i) {
			System.out.println((i + 1) + ". " + SanPham.size[i]);
		}

		int kichThuoc = ChucNang.chuanHoa(1, SanPham.validSize);

		if (this.DSSanPham[(vitriMon - 1) * SanPham.validSize + (kichThuoc - 1)
				+ (loai == 2 ? 1 : 0) * ThucDon.indexOfCaPhe * SanPham.validSize] != 0)
			this.demSanPham--;

		this.DSSanPham[(vitriMon - 1) * SanPham.validSize + (kichThuoc - 1)
				+ (loai == 2 ? 1 : 0) * ThucDon.indexOfCaPhe * SanPham.validSize]++;
	}

	private void thaydoiKichThuoc(int index, int size) {
		int cnt = 0;
		size--;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize; ++i) {
			if (this.DSSanPham[i] != 0) {
				++cnt;
			}
			if (cnt == index) {
				this.DSSanPham[i] = 0;
				this.DSSanPham[i + (size - (i % SanPham.validSize))]++;
				return;
			}
		}
	}

	private void xuliDonHang() {
		while (true) {
			System.out.println("+=============================+");
			System.out.println("|           DAT HANG          |");
			System.out.println("+-----------------------------+");
			System.out.println("| 1. Tra sua                  |");
			System.out.println("| 2. Ca phe                   |");
			System.out.println("+-----------------------------+");
			System.out.println("|       VUI LONG LUA CHON     |");
			System.out.println("+=============================+");
			int loai = ChucNang.chuanHoa(1, 2);

			ThucDon.xuatMenu(loai);

			int vitriMon = ChucNang.chuanHoa(1,
					((loai == 1) ? ThucDon.indexOfCaPhe : ThucDon.thucdon.size() - ThucDon.indexOfCaPhe));

			System.out.println("Moi chon size: ");
			for (int i = 0; i < SanPham.validSize; ++i) {
				System.out.println((i + 1) + ". " + SanPham.size[i]);
			}

			int kichThuoc = ChucNang.chuanHoa(1, SanPham.validSize);

			int vitri = (vitriMon - 1) * SanPham.validSize + (kichThuoc - 1)
					+ (loai == 2 ? 1 : 0) * ThucDon.indexOfCaPhe * SanPham.validSize;

			if (this.DSSanPham[vitri] == 0)
				this.demSanPham++;

			this.DSSanPham[vitri]++;

			if (loai == 1) {
				System.out.println("Moi chon luong duong");
				for (int i = 0; i < SanPham.duong.length; ++i) {
					System.out.println((i + 1) + ". " + SanPham.duong[i]);
				}
				int luachon = ChucNang.chuanHoa(1, SanPham.duong.length);
				this.chonDuong[vitri] = luachon - 1;

				System.out.println("Moi chon luong da");
				for (int i = 0; i < SanPham.da.length; ++i) {
					System.out.println((i + 1) + ". " + SanPham.da[i]);
				}
				luachon = ChucNang.chuanHoa(1, SanPham.da.length);
				this.chonDa[vitri] = luachon - 1;
			}
			if (loai == 2) {
				System.out.println("Moi chon luong da");
				System.out.println("1. Khong da");
				System.out.println("2. Co da");
				int luachon = ChucNang.chuanHoa(1, 2);
				if (luachon == 2)
					luachon = 5;
				luachon = this.chonDa[vitri] = luachon - 1;
			}
			this.xuatDonHang();

			System.out.println("Ban co muon chon nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");

			int chonTiep = ChucNang.chuanHoa(1, 2);

			if (chonTiep == 2)
				break;
		}
	}

	private void kiemTralai() {
		System.out.println("Ban co muon thay doi gi khong ?");
		System.out.println("1. Co");
		System.out.println("2. Khong");
		int chonlai = ChucNang.chuanHoa(1, 2);
		while (chonlai == 1) {
			System.out.println("Ban muon thay doi gi ? ");
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
					System.out.println("Nhap stt san pham can thay doi kich thuoc: ");
					int spThayDoiSize = ChucNang.chuanHoa(1, this.demSanPham);

					System.out.println("Nhap size muon thay doi: ");
					for (int i = 0; i < SanPham.validSize; ++i) {
						System.out.println((i + 1) + ". " + SanPham.size[i]);
					}
					int size = ChucNang.chuanHoa(1, SanPham.validSize);

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
			chonlai = ChucNang.chuanHoa(1, 2);
		}
		// scan.close();
	}

	private void thanhtoan(int tongtien, ThanhVien tv) {
		// DTL == diem tich luy
		int sudungDTL = 0;
		if (tv != null) {
			System.out.println("Ban co " + tv.getDiemtichluy() + " diem tich luy");
			System.out.println("Ban co muon su dung ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			sudungDTL = ChucNang.chuanHoa(1, 2);
		}
		if (tv != null) {
			NgayThang ngayHoaDon = new NgayThang();
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			ngayHoaDon.setThang(calendar.get(Calendar.MONTH) + 1);
			if (tv.getNgaysinh().getThang() == ngayHoaDon.getThang()) {
				tongtien = (tongtien * 90) / 100;
			}
			if (sudungDTL == 1) {
				if (tongtien <= tv.getDiemtichluy() * 1000) {
					tv.setDiemtichluy(tv.getDiemtichluy() - tongtien);
					tongtien = 0;
				} else {
					tongtien = tongtien - (tv.getDiemtichluy() * 1000);
					tv.setDiemtichluy(0);
				}
			}
		}
		System.out.println("Tong tien ban can thanh toan la: " + ChucNang.chuanHoaGia(tongtien) + 'd');
		if (tv != null) {
			if (sudungDTL == 1) {
				System.out.println("Diem tich luy con lai cua ban: " + tv.getDiemtichluy());
				DSThanhVien.ghiDSTVVaoFile("THANH_VIEN.txt");
			}
			if (sudungDTL == 2) {
				tv.setDiemtichluy(tv.getDiemtichluy() + (tongtien / 1000));
			}
		}
	}

	private void nhanDonHang() {
		// ThucDon.setDonGiatuFile("trasua.txt");
		// ThucDon.setDonGiatuFile("caphe.txt");

		this.DSSanPham = new int[ThucDon.thucdon.size() * SanPham.validSize];
		this.chonDuong = new int[ThucDon.thucdon.size() * SanPham.validSize];
		this.chonDa = new int[ThucDon.thucdon.size() * SanPham.validSize];
		this.demSanPham = 0;

		// xu li thao tac nguoi dung
		this.xuliDonHang();

		// nguoi dung chinh sua don hang neu co
		this.kiemTralai();

		// tong tien cua hoa don
		int tong = this.xuatDonHang();
		System.out.println("Ban co tai khoan tich diem hay khong?");
		System.out.println("1. Co");
		System.out.println("2. Khong");
		int luachon = ChucNang.chuanHoa(1, 2);

		ThanhVien tv = null;
		if (luachon == 1) {
			System.out.print("Nhap so dien thoai thanh vien: ");
			String sdt = ChucNang.chuanHoaChuoi();
			tv = DSThanhVien.timkiemTVTheoSDT(sdt);
		}

		if (tv == null) {
			System.out.println("Ban co muon tao tai khoan ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			luachon = ChucNang.chuanHoa(1, 2);
			if (luachon == 1) {
				tv = DSThanhVien.themThanhVien();
			}
		}

		this.thanhtoan(tong, tv);

		DSHoaDon.them(this.DSSanPham, this.chonDuong, this.chonDa, this);

	}

	// Menu cho nhan vien dat hang
	public void menu() {
		while (true) {
			System.out.println("+===================================+");
			System.out.println("|         NHAN VIEN DAT HANG        |");
			System.out.println("+-----------------------------------+");
			System.out.println("| 0. Dang xuat                      |");
			System.out.println("| 1. Nhan don hang                  |");
			System.out.println("| 2. Thong tin ca nhan              |");
			System.out.println("+===================================+");
			int luachon = ChucNang.chuanHoa(0, 2);

			switch (luachon) {
				case 1:
					this.nhanDonHang();
					break;
				case 2:
					this.xuatThongTinCaNhan();
					break;
				case 0:
					return;
			}
		}
	}
}
