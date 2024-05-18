import java.util.ArrayList;
import java.util.Collections;

public class nvQuanLi extends NhanVien {
	private DSNhanVien dsNhanVien;
	// private DSHoaDon dsHoaDon;

	// getter/setters

	public nvQuanLi() {
		super();
		this.dsNhanVien = new DSNhanVien();
	}

	private void xuatDSNV() {
		sapXepTheoChucVu();
		System.out.println(
				"-------------------------------------------------------------- NHAN VIEN QUAN LY --------------------------------------------------------------");
		System.out.format("%-10s %-18s %-15s %-55s %-13s %-33s",
				"ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		while (this.dsNhanVien.getDSNV().get(i) instanceof nvQuanLi) {
			this.dsNhanVien.getDSNV().get(i).xuatThongTin();
			++i;
			if (i == this.dsNhanVien.getDSNV().size())
				break;
		}
		System.out.println();

		System.out.println(
				"-------------------------------------------------------------- NHAN VIEN PHA CHE --------------------------------------------------------------");
		System.out.format("%-10s %-18s %-15s %-55s %-13s %-33s",
				"ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		while (this.dsNhanVien.getDSNV().get(i) instanceof nvPhaChe) {
			this.dsNhanVien.getDSNV().get(i).xuatThongTin();
			++i;
			if (i == this.dsNhanVien.getDSNV().size())
				break;
		}
		System.out.println();

		System.out.println(
				"-------------------------------------------------------------- NHAN VIEN DAT HANG --------------------------------------------------------------");
		System.out.format("%-10s %-18s %-15s %-55s %-13s %-33s",
				"ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		while (this.dsNhanVien.getDSNV().get(i) instanceof nvDatHang) {
			this.dsNhanVien.getDSNV().get(i).xuatThongTin();
			++i;
			if (i == this.dsNhanVien.getDSNV().size())
				break;
		}
		System.out.println();
	}

	private void sapXepTheoChucVu() {
		Collections.sort(this.dsNhanVien.getDSNV(), new SoSanhTheoChucVu());
	}

	private String sinhMaTuDong(int loai) {
        String stt = Integer.toString(this.dsNhanVien.getDSNV().size() + 1);
        int count = 5 - stt.length();
        StringBuilder result = new StringBuilder();
        switch (loai) {
			case 1:
				result.append("QL");
				break;
			case 2:
				result.append("PC");
				break;
			case 3:
				result.append("DH");
				break;
		}
        while (count > 0) {
            result.append("0");
            --count;
        }
        result.append(stt);
        return result.toString();
    }

	private boolean daTonTaiThongTin(String dulieu){
		for(NhanVien nv : this.dsNhanVien.getDSNV()){
			if(nv.getEmail().equalsIgnoreCase(dulieu) || nv.getSdt().equalsIgnoreCase(dulieu)){
				return true;
			}
		}
		return false;
	}

	private void themNhanVien() {
		NhanVien nv = null;
		int luachon;
		System.out.println("\nNhap kieu nhan vien can them: ");
		System.out.println("1. Nhan vien quan li");
		System.out.println("2. Nhan vien pha che");
		System.out.println("3. Nhan vien dat hang");
		luachon = ChucNang.chuanHoa(1, 3);
		switch (luachon) {
			case 1:
				nv = new nvQuanLi();
				break;
			case 2:
				nv = new nvPhaChe();
				break;
			case 3:
				nv = new nvPhaChe();
				break;
		}
		nv.setId(this.sinhMaTuDong(luachon));
		System.out.print("Nhap ten: ");
		nv.setTen(ChucNang.chuanHoaChuoi());
		System.out.println("Nhap dia chi: ");
		DiaChi dc = new DiaChi();
		dc.nhapThongTin();
		nv.setDc(dc);
		
		do{
			System.out.print("Nhap so dien thoai: ");
			nv.setSdt(ChucNang.chuanHoaChuoi());
			if (this.daTonTaiThongTin(nv.getSdt())) {
				System.out.println("So dien thoai da ton tai. Vui long nhap lai");
			}
		} while (this.daTonTaiThongTin(nv.getSdt()));

		do{
			System.out.print("Nhap dia chi email: ");
			nv.setEmail(ChucNang.chuanHoaChuoi());
			if (this.daTonTaiThongTin(nv.getEmail())) {
				System.out.println("Email da ton tai. Vui long nhap lai");
			}
		} while (this.daTonTaiThongTin(nv.getEmail()));

		System.out.println("Nhap ngay sinh: ");
		NgayThang ngaysinh = new NgayThang();
		ngaysinh.nhapThongTin();
		nv.setNgaysinh(ngaysinh);
		int xacnhan = ChucNang.xacNhanThaoTac();
		switch (xacnhan) {
			case 0:
				nv = null;
				break;
			case 1:
				this.dsNhanVien.ghiVaoFile("NHAN_VIEN.txt", nv);
				System.out.println("Them nhan vien thanh cong!");
				break;
		}
	}

	private int timkiemTenSP(String ten) {
		for (int i = 0; i < ThucDon.thucdon.size(); ++i) {
			if (ThucDon.thucdon.get(i).getTen().equalsIgnoreCase(ten)) {
				return i;
			}
		}
		return -1;
	}

	private void chinhsuaThongTinNV() {
		ArrayList<NhanVien> temp = this.timkiemNV();
		int i = 1;
		System.out.println();
		System.out.format("%-3s %-10s %-18s %-15s %-55s %-13s %-33s",
				"STT",
				"|  ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (NhanVien nv : temp) {
			System.out.format("%-3s %-10s %-18s %-15s %-55s %-13s %-33s",
					i,
					"|  " + nv.getId(),
					"|  " + nv.getTen(),
					"|  " + nv.getNgaysinh(),
					"|  " + nv.getDc().xuatThongTin(),
					"|  " + nv.getSdt(),
					"|  " + nv.getEmail());
			System.out.println();
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------");
			++i;
		}
		int index = ChucNang.chuanHoa(1, (i - 1));
		--index;
		NhanVien nvThayDoiTT = temp.get(index);
		// Hoi chon can chinh sua gi
		while (true) {
			System.out.println();
			System.out.format("%-10s %-18s %-15s %-55s %-13s %-33s",
					"ID",
					"|  Ten",
					"|  Ngay sinh",
					"|  Dia chi",
					"|  SDT",
					"|  Email");
			System.out.println();
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------");
			nvThayDoiTT.xuatThongTin();
			System.out.println("\nChon thong tin can chinh sua");
			System.out.println("0. Thoat");
			System.out.println("1. Chinh sua ten");
			System.out.println("2. Chinh sua dia chi");
			System.out.println("3. Chinh sua so dien thoai");
			System.out.println("4. Chinh sua email");
			System.out.println("5. Chinh sua ngay sinh");
			int luachon = ChucNang.chuanHoa(0, 5);
			System.out.print("Nhap thong tin chinh sua: ");
			switch (luachon) {
				case 0:
					return;
				case 1:
					nvThayDoiTT.setTen(ChucNang.chuanHoaChuoi());
					break;
				case 2:
					DiaChi diachimoi = new DiaChi();
					diachimoi.nhapThongTin();
					nvThayDoiTT.setDc(diachimoi);
					break;
				case 3:
					nvThayDoiTT.setSdt(ChucNang.chuanHoaChuoi());
					break;
				case 4:
					nvThayDoiTT.setEmail(ChucNang.chuanHoaChuoi());
					break;
				case 5:
					NgayThang ngaysinhmoi = new NgayThang();
					ngaysinhmoi.nhapThongTin();
					nvThayDoiTT.setNgaysinh(ngaysinhmoi);
					break;
			}
		}
	}

	private void themSanPham() {
		SanPham sp = null;
		System.out.println("\nNhap loai do uong can them: ");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca phe");
		int LuaChon = ChucNang.chuanHoa(1, 2);
		switch (LuaChon) {
			case 1:
				sp = new TraSua();
				break;
			case 2:
				sp = new CaPhe();
				break;
		}
		sp.nhapThongTin();

		int xacnhan = ChucNang.xacNhanThaoTac();
		switch (xacnhan) {
			case 0:
				sp = null;
				return;
			case 1:
				if (sp instanceof TraSua)
					ThucDon.setSanPhamVaoFile("trasua.txt", sp);
				if (sp instanceof CaPhe)
					ThucDon.setSanPhamVaoFile("caphe.txt", sp);
				if (sp instanceof TraSua) {
					ThucDon.thucdon.add(ThucDon.indexOfCaPhe, sp);
					ThucDon.indexOfCaPhe++;
				} else {
					ThucDon.thucdon.add(sp);
				}
				System.out.println("Da them san pham\n");
				break;
		}
	}

	private void xoaSanPham() {
		SanPham spxoa = null;
		do {
			System.out.print("\nNhap ma san pham muon xoa: ");
			String idxoa = ChucNang.chuanHoaChuoi();
			spxoa = ThucDon.timKiemSPTheoID(idxoa);
			if (spxoa == null) {
				System.out.println("Khong ton tai san pham. Vui long nhap lai");
			}
		} while (spxoa == null);
		ThucDon.xuatThongTinSP(spxoa);
		int xacnhan = ChucNang.xacNhanThaoTac();
		switch (xacnhan) {
			case 0:
				spxoa = null;
				return;
			case 1:
				ThucDon.thucdon.remove(spxoa);
				ThucDon.ghiDSVaoFile();
				System.out.println("Da xoa san pham");
				break;
		}
	}

	private ArrayList<NhanVien> timkiemNV() {
		System.out.print("Tim kiem: ");
		String timkiem = ChucNang.chuanHoaChuoi();
		ArrayList<NhanVien> result = new ArrayList<>();
		for (NhanVien nv : this.dsNhanVien.getDSNV()) {
			if (nv.getTen().toLowerCase().contains(timkiem.toLowerCase())) {
				result.add(nv);
			}
		}
		return result;
	}

	private void chinhsuaTen(int indexSpThayDoi) {
		System.out.println("Nhap vao ten san pham muon chinh sua: ");
		String ten = ChucNang.chuanHoaChuoi();
		ThucDon.thucdon.get(indexSpThayDoi).setTen(ten);
		ThucDon.ghiDSVaoFile();
	}

	private void chinhsuaDonGia(int indexSpThayDoi) {
		int tmp[] = new int[SanPham.validSize];
		for (int i = 0; i < SanPham.validSize; ++i) {
			System.out.print("Nhap gia size " + SanPham.size[i] + ": ");
			tmp[i] = Integer.parseInt(ChucNang.chuanHoaChuoi());
		}
		ThucDon.thucdon.get(indexSpThayDoi).setGiaTien(tmp);
	}

	private void chinhsuaSanPham() {
		ThucDon.xuatMenu(3);
		System.out.print("Nhap ten san pham can chinh sua: ");
		String tenSP = ChucNang.chuanHoaChuoi();
		int indexSpThayDoi = timkiemTenSP(tenSP);
		while (indexSpThayDoi == -1) {
			System.out.println("Ten nhap khong hop le, vui long nhap lai");
			System.out.print("Nhap ten san pham can chinh sua: ");
			tenSP = ChucNang.chuanHoaChuoi();
			indexSpThayDoi = timkiemTenSP(tenSP);
		}
		while (true) {
			int luachon;
			System.out.println("Chon thong tin can chinh sua");
			System.out.println("1. Ten");
			System.out.println("2. Don gia");
			// System.out.println("3. So luong hang");
			luachon = ChucNang.chuanHoa(1, 2);

			// Phan nay chua lam !!!

			switch (luachon) {
				case 1:
					this.chinhsuaTen(indexSpThayDoi);
					break;
				case 2:
					this.chinhsuaDonGia(indexSpThayDoi);
					break;
				// case 3:
				// this.chinhsuaSoLuongHang(indexSpThayDoi);
				// break;
			}

			System.out.println("Ban co muon chinh sua nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Nhap lua chon: ");
			int chonTiep = ChucNang.chuanHoa(1, 2);
			if (chonTiep == 2)
				break;

		}
	}

	private void xuatDSHD() {
		DSHoaDon.xuatToanboHoadon();
	}

	private void xoaSP() {
		System.out.println("Nhap loai muon ngung kinh doanh");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca phe");
		int luachon = ChucNang.chuanHoa(1, 2);
		ThucDon.xuatMenu(luachon);
		System.out.println("Nhap stt cua san pham muon ngung kinh doanh");
		int vitriMon = ChucNang.chuanHoa(1,
				((luachon == 1) ? ThucDon.indexOfCaPhe : ThucDon.thucdon.size() - ThucDon.indexOfCaPhe));
		ThucDon.thucdon.get((vitriMon - 1) + ((luachon == 1) ? 0 : ThucDon.indexOfCaPhe)).setTrangthai(false);
		ThucDon.ghiDSVaoFile();
	}

	@Override
	public void menu() {
		while (true) {
			System.out.println("+=======================================================+");
			System.out.println("|			NHAN VIEN QUAN LI		|");
			System.out.println("+-------------------------------------------------------+");
			System.out.println("| 0. Dang xuat						|");
			System.out.println("| 1. Them san pham moi					|");
			System.out.println("| 2. Cap nhat va chinh sua thong tin san pham		|");
			System.out.println("| 3. Xoa san pham					|");
			System.out.println("| 4. Them nhan vien moi					|");
			System.out.println("| 5. Chinh sua thong tin nhan vien			|");
			System.out.println("| 6. Xuat danh sach nhan vien				|");
			System.out.println("| 7. Xuat danh sach hoa don				|");
			System.out.println("| 8. Xuat danh sach thanh vien				|");
			System.out.println("| 9. Xuat danh sach san pham				|");
			System.out.println("| 10. Ngung kinh doanh san pham				|");
			System.out.println("| 11. Thong tin ca nhan					|");
			System.out.println("+=======================================================+");

			int luachon = ChucNang.chuanHoa(0, 11);
			switch (luachon) {
				case 1:
					this.themSanPham();
					break;
				case 2:
					this.chinhsuaSanPham();
					break;
				case 3:
					this.xoaSanPham();
					break;
				case 4:
					this.themNhanVien();
					break;
				case 5:
					this.chinhsuaThongTinNV();
					this.dsNhanVien.ghiVaoFile("NHAN_VIEN.txt");
					break;// sua lai
				case 6:
					this.xuatDSNV();
					break;
				case 7:
					this.xuatDSHD();
					break;
				case 8:
					DSThanhVien.xuatDSTV();
					break;
				case 9:
					ThucDon.xuatMenu(3);
					break;
				case 10:
					this.xoaSP();
					break;
				case 11:
					this.xuatThongTinCaNhan();
					break;
				case 0:
					return;
			}
		}
	}
}
