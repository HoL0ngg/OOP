import java.util.Calendar;
import java.util.Date;

public class nvDatHang extends NhanVien {
	private int[] DSSanPham;
	private int demSanPham;

	public nvDatHang() {
		super();
	}

	private int xuatDonHang() {
		int tongtien = 0;
		int cntTab = (SanPham.maxLength / 8) + 1;
		String navList[] = { "Ten mon hang", "Size", "So luong", "Don gia" };
		// size soluong
		int lenOfHoaDon = cntTab + 1 + 1 + 1;
		System.out.println("+=======================================================================+");
		System.out.println("|                            DON HANG HIEN TAI                          |");
		System.out.println("+=======================================================================+");

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
				System.out.println(navList[i] + "\t|");
			} else {
				System.out.print(navList[i] + "\t");
			}
		}

		System.out.println("+-----------------------------------------------------------------------+");

		int index = 1;
		int lengthThucDon = ThucDon.thucdon.size() * SanPham.validSize * SanPham.duong.length * SanPham.da.length;
		for (int i = 0; i < lengthThucDon; ++i) {
			if (this.DSSanPham[i] != 0) {
				int ten = i / (SanPham.validSize * SanPham.duong.length * SanPham.da.length);
				int size = (i / (SanPham.duong.length * SanPham.da.length)) % SanPham.validSize;
				int duong = (i / SanPham.da.length) % SanPham.duong.length;
				int da = i % SanPham.da.length;

				int tmplength = (ThucDon.thucdon.get(ten).getTen().length() + 4 + (String.valueOf(index).length())) / 8;
				// System.out.println(tmplength);

				System.out.print("| " + index++ + ". " + ThucDon.thucdon.get(ten).getTen());
				for (int j = tmplength; j <= cntTab; ++j) {
					System.out.print("\t");
				}

				// so luong
				System.out.println(" " + SanPham.size[size] + "\t   " + this.DSSanPham[i] + " \t\t"
						+ ChucNang.chuanHoaGia(ThucDon.thucdon.get(ten).getGiaTienAtIndex(size)) + "d\t|");
				if (duong != SanPham.duong.length - 1
						&& i < ThucDon.indexOfCaPhe * SanPham.validSize * SanPham.duong.length * SanPham.da.length)
					System.out.println("|\t + " + SanPham.duong[duong] + " duong\t\t\t\t\t\t\t|");
				if (da != SanPham.da.length - 1)
					System.out.println("|\t + " + SanPham.da[da] + " da\t\t\t\t\t\t\t|");
				System.out.println("+-----------------------------------------------------------------------+");
				tongtien += this.DSSanPham[i] * ThucDon.thucdon.get(ten).getGiaTienAtIndex(size);
			}
		}
		// System.out.println("+-------------------------------------------------------+");
		System.out.print("|");
		for (int i = cntTab; i <= lenOfHoaDon; ++i) {
			System.out.print("\t");
		}
		System.out.print("\tThanh tien: " + ChucNang.chuanHoaGia(tongtien) + "d\t\t|");
		System.out.println();
		System.out.println("+=======================================================================+");
		System.out.println();

		return tongtien;
	}

	private void themSanPham() {
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
				((loai == 1) ? ThucDon.indexOfCaPhe : ThucDon.thucdon.size() - ThucDon.indexOfCaPhe)) - 1;

		vitriMon = vitriMon + (loai == 2 ? 1 : 0) * ThucDon.indexOfCaPhe;

		System.out.println("Moi chon size: ");
		for (int i = 0; i < SanPham.validSize; ++i) {
			System.out.println((i + 1) + ". " + SanPham.size[i]);
		}

		int kichThuoc = ChucNang.chuanHoa(1, SanPham.validSize) - 1;

		int chonDuong = SanPham.duong.length - 1;
		int chonDa = SanPham.da.length - 1;

		if (loai == 1) {
			System.out.println("Moi chon luong duong");
			for (int i = 0; i < SanPham.duong.length; ++i) {
				System.out.println((i + 1) + ". " + SanPham.duong[i]);
			}
			int luachon = ChucNang.chuanHoa(1, SanPham.duong.length);
			chonDuong = luachon - 1;

			System.out.println("Moi chon luong da");
			for (int i = 0; i < SanPham.da.length; ++i) {
				System.out.println((i + 1) + ". " + SanPham.da[i]);
			}
			luachon = ChucNang.chuanHoa(1, SanPham.da.length);
			chonDa = luachon - 1;
		}
		if (loai == 2) {
			System.out.println("Moi chon luong da");
			System.out.println("1. Khong da");
			System.out.println("2. Co da");
			int luachon = ChucNang.chuanHoa(1, 2);
			if (luachon == 2)
				luachon = 5;
			chonDa = luachon - 1;
		}

		int vitri = vitriMon * SanPham.validSize * SanPham.duong.length * SanPham.da.length
				+ kichThuoc * SanPham.duong.length * SanPham.da.length + chonDuong * SanPham.da.length
				+ chonDa;

		if (this.DSSanPham[vitri] == 0)
			this.demSanPham++;

		this.DSSanPham[vitri]++;
	}

	private void xoaSanPham(int index) {
		int cnt = 0;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize * SanPham.duong.length
				* SanPham.da.length; ++i) {
			if (this.DSSanPham[i] != 0) {
				++cnt;
			}
			if (cnt == index) {
				this.DSSanPham[i] = 0;
				this.demSanPham--;
				return;
			}
		}
	}

	private void thaydoiSanPham(int index) {
		this.xoaSanPham(index);

		this.themSanPham();
	}

	private void thaydoiChiTiet(int index) {
		System.out.println("Ban muon thay doi gi ?");
		System.out.println("1. Thay doi kich thuoc");
		System.out.println("2. Thay doi luong duong");
		System.out.println("3. Thay doi luong da");
		System.out.println("4. Thay doi so luong");
		int luachon = ChucNang.chuanHoa(1, 4);
		int hehe = 0;
		switch (luachon) {
			case 1:
				System.out.println("Moi chon size: ");
				for (int i = 0; i < SanPham.validSize; ++i) {
					System.out.println((i + 1) + ". " + SanPham.size[i]);
				}

				hehe = ChucNang.chuanHoa(1, SanPham.validSize) - 1;
				break;

			case 2:
				System.out.println("Moi chon luong duong");
				for (int i = 0; i < SanPham.duong.length; ++i) {
					System.out.println((i + 1) + ". " + SanPham.duong[i]);
				}
				hehe = ChucNang.chuanHoa(1, SanPham.duong.length) - 1;

				break;

			case 3:
				System.out.println("Moi chon luong da");
				for (int i = 0; i < SanPham.da.length; ++i) {
					System.out.println((i + 1) + ". " + SanPham.da[i]);
				}
				hehe = ChucNang.chuanHoa(1, SanPham.da.length) - 1;
				break;

			case 4:
				System.out.println("Moi nhap so luong");
				hehe = ChucNang.chuanHoa(0, 1000);
				break;
		}
		int cnt = 0;
		for (int i = 0; i < ThucDon.thucdon.size() * SanPham.validSize * SanPham.duong.length
				* SanPham.da.length; ++i) {
			if (this.DSSanPham[i] != 0) {
				++cnt;
			}
			if (cnt == index) {
				if (luachon == 4) {
					this.DSSanPham[i] = hehe;
					return;
				}
				this.DSSanPham[i] = 0;
				if (this.DSSanPham[i + (hehe - (i % (luachon == 3 ? SanPham.da.length
						: luachon == 2 ? SanPham.duong.length : SanPham.validSize)))
						* (luachon == 1 ? SanPham.duong.length * SanPham.da.length
								: luachon == 2 ? SanPham.da.length : 1)] != 0)
					this.demSanPham--;
				this.DSSanPham[i + (hehe - (i % (luachon == 3 ? SanPham.da.length
						: luachon == 2 ? SanPham.duong.length : SanPham.validSize)))
						* (luachon == 1 ? SanPham.duong.length * SanPham.da.length
								: luachon == 2 ? SanPham.da.length : 1)]++;
				return;
			}
		}
	}

	private void xuliDonHang() {
		while (true) {
			this.themSanPham();

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
			System.out.println("+==================================+");
			System.out.println("|         THAY DOI LUA CHON        |");
			System.out.println("+----------------------------------+");
			System.out.println("| 1. Them san pham                 |");
			System.out.println("| 2. Thay doi san pham             |");
			System.out.println("| 3. Thay doi chi tiet             |");
			System.out.println("| 4. Xoa san pham                  |");
			System.out.println("+==================================+");
			System.out.println("Ban muon thay doi gi ? ");
			System.out.println("1. Them san pham");
			System.out.println("2. Thay doi san pham");
			System.out.println("3. Thay doi chi tiet");
			System.out.println("4. Xoa san pham");
			int hehe = ChucNang.chuanHoa(1, 4);

			this.xuatDonHang();

			switch (hehe) {
				case 1:
					this.themSanPham();
					break;

				case 2:
					System.out.println("Nhap stt san pham can thay doi: ");
					int spBiThayDoi = ChucNang.chuanHoa(1, this.demSanPham);
					this.thaydoiSanPham(spBiThayDoi);
					break;

				case 3:
					System.out.println("Nhap stt san pham can thay doi chi tiet: ");
					int spthaydoi = ChucNang.chuanHoa(1, this.demSanPham);

					this.thaydoiChiTiet(spthaydoi);
					break;

				case 4:
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

		this.DSSanPham = new int[ThucDon.thucdon.size() * SanPham.validSize * SanPham.duong.length * SanPham.da.length];
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

		DSHoaDon.them(this.DSSanPham, this);

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
