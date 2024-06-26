package NHANVIEN;

import java.util.ArrayList;
import java.util.Collections;
import CHUCNANG.ChucNang;
import CHUCNANG.DiaChi;
import CHUCNANG.NgayThang;
import CHUCNANG.SoSanhNgayTK;
import CHUCNANG.SoSanhTheoChucVu;
import HOADON.DSHoaDon;
import HOADON.DSThongKe;
import HOADON.ThongKe;
import SANPHAM.CaPhe;
import SANPHAM.SanPham;
import SANPHAM.ThucDon;
import SANPHAM.TraSua;
import THANHVIEN.DSThanhVien;

public class nvQuanLi extends NhanVien {
	private DSNhanVien dsNhanVien;
	private ThongKe tk;
	// private DSHoaDon dsHoaDon;

	public nvQuanLi() {
		super();
		this.dsNhanVien = new DSNhanVien();
		this.tk = new ThongKe();
	}

	private void xuatDSNV() {
		sapXepTheoChucVu();
		System.out.println(
				"------------------------------------------------------------------- NHAN VIEN QUAN LY -------------------------------------------------------------------");
		System.out.format("%-10s %-23s %-15s %-55s %-13s %-33s",
				"ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		while (this.dsNhanVien.getDSNV().get(i) instanceof nvQuanLi) {
			this.dsNhanVien.getDSNV().get(i).xuatThongTin();
			++i;
			if (i == this.dsNhanVien.getDSNV().size())
				break;
		}
		System.out.println();
		System.out.println(
				"------------------------------------------------------------------- NHAN VIEN PHA CHE -------------------------------------------------------------------");
		System.out.format("%-10s %-23s %-15s %-55s %-13s %-33s",
				"ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------");
		while (this.dsNhanVien.getDSNV().get(i) instanceof nvPhaChe) {
			this.dsNhanVien.getDSNV().get(i).xuatThongTin();
			++i;
			if (i == this.dsNhanVien.getDSNV().size())
				break;
		}
		System.out.println();
		System.out.println(
				"------------------------------------------------------------------- NHAN VIEN DAT HANG ------------------------------------------------------------------");
		System.out.format("%-10s %-23s %-15s %-55s %-13s %-33s",
				"ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------");
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

	private boolean daTonTaiThongTin(String dulieu) {
		for (NhanVien nv : this.dsNhanVien.getDSNV()) {
			if (nv.getEmail().equalsIgnoreCase(dulieu) || nv.getSdt().equalsIgnoreCase(dulieu)
					|| nv.getTen().equalsIgnoreCase(dulieu)) {
				return true;
			}
		}
		return false;
	}

	private void themNhanVien() {
		NhanVien nv = null;
		int luachon;
		System.out.println("\nNhap vi tri nhan vien can them: ");
		System.out.println("1. Nhan vien quan li");
		System.out.println("2. Nhan vien pha che");
		System.out.println("3. Nhan vien dat hang");
		System.out.print("Moi nhap lua chon: ");
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
		nv.setTen(ChucNang.chuanHoaTen());
		System.out.println("Nhap dia chi: ");
		DiaChi dc = new DiaChi();
		dc.nhapThongTin();
		nv.setDc(dc);

		do {
			System.out.print("Nhap so dien thoai: ");
			nv.setSdt(ChucNang.chuaHoaSDT());
			if (this.daTonTaiThongTin(nv.getSdt()) && this.daTonTaiThongTin(nv.getTen())) {
				System.out.println("Nhan vien da ton tai. Vui long nhap lai");
			}
		} while (this.daTonTaiThongTin(nv.getSdt()) && this.daTonTaiThongTin(nv.getTen()));

		do {
			System.out.print("Nhap dia chi email: ");
			nv.setEmail(ChucNang.chuanHoaEmail());
			if (this.daTonTaiThongTin(nv.getEmail())) {
				System.out.println("Email da ton tai. Vui long nhap lai");
			}
		} while (this.daTonTaiThongTin(nv.getEmail()));

		System.out.println("Nhap ngay thang nam sinh");
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

	private void xuatDSTK() {
		Collections.sort(DSThongKe.dstk, new SoSanhNgayTK());
		if (DSThongKe.dstk.size() == 0)
			return;
		System.out.println("Xuat lich su thong ke: ");
		for (ThongKe tk : DSThongKe.dstk) {
			tk.xuatThongKe();
		}
	}

	private void chinhsuaThongTinNV() {
		ArrayList<NhanVien> temp = this.timkiemNV();
		if (temp == null) {
			return;
		}
		int i = 1;
		System.out.println();
		System.out.format("%-3s %-10s %-23s %-15s %-55s %-13s %-33s",
				"STT",
				"|  ID",
				"|  Ten",
				"|  Ngay sinh",
				"|  Dia chi",
				"|  SDT",
				"|  Email");
		System.out.println();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (NhanVien nv : temp) {
			System.out.format("%-3s %-10s %-23s %-15s %-55s %-13s %-33s",
					i,
					"|  " + nv.getId(),
					"|  " + nv.getTen(),
					"|  " + nv.getNgaysinh(),
					"|  " + nv.getDc().xuatThongTin(),
					"|  " + nv.getSdt(),
					"|  " + nv.getEmail());
			System.out.println();
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
			++i;
		}
		System.out.print("Moi nhap so thu tu nhan vien can chinh sua: ");
		int index = ChucNang.chuanHoa(1, (i - 1));
		--index;
		NhanVien nvThayDoiTT = temp.get(index);
		// Hoi chon can chinh sua gi
		while (true) {
			System.out.println();
			System.out.format("%-10s %-23s %-15s %-55s %-13s %-33s",
					"ID",
					"|  Ten",
					"|  Ngay sinh",
					"|  Dia chi",
					"|  SDT",
					"|  Email");
			System.out.println();
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------------------");
			nvThayDoiTT.xuatThongTin();
			System.out.println("\nChon thong tin can chinh sua");
			System.out.println("0. Thoat");
			System.out.println("1. Chinh sua ten");
			System.out.println("2. Chinh sua dia chi");
			System.out.println("3. Chinh sua so dien thoai");
			System.out.println("4. Chinh sua email");
			System.out.println("5. Chinh sua ngay sinh");
			System.out.print("Moi nhap lua chon: ");
			int luachon = ChucNang.chuanHoa(0, 5);
			System.out.println("Nhap thong tin chinh sua");
			switch (luachon) {
				case 0:
					return;
				case 1:
					nvThayDoiTT.setTen(ChucNang.chuanHoaTen());
					break;
				case 2:
					DiaChi diachimoi = new DiaChi();
					diachimoi.nhapThongTin();
					nvThayDoiTT.setDc(diachimoi);
					break;
				case 3:
					// nvThayDoiTT.setSdt(ChucNang.chuaHoaSDT());
					String sdt = "";
					do {
						System.out.print("Nhap so dien thoai: ");
						sdt = ChucNang.chuaHoaSDT();
						if (this.daTonTaiThongTin(sdt)) {
							System.out.println("SDT da ton tai. Vui long nhap lai");
						}
					} while (this.daTonTaiThongTin(sdt));
					nvThayDoiTT.setSdt(sdt);
					break;
				case 4:
					// nvThayDoiTT.setEmail(ChucNang.chuanHoaEmail());
					String email = "";
					do {
						System.out.print("Nhap dia chi email: ");
						email = ChucNang.chuanHoaEmail();
						if (this.daTonTaiThongTin(email)) {
							System.out.println("Email da ton tai. Vui long nhap lai");
						}
					} while (this.daTonTaiThongTin(email));
					nvThayDoiTT.setEmail(email);
					break;
				case 5:
					NgayThang ngaysinhmoi = new NgayThang();
					ngaysinhmoi.nhapThongTin();
					nvThayDoiTT.setNgaysinh(ngaysinhmoi);
					break;
			}
			this.dsNhanVien.ghiVaoFile("NHAN_VIEN.txt");
		}
	}

	private void themSanPham() {
		SanPham sp = null;
		System.out.println("\nNhap loai do uong can them: ");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca phe");
		System.out.print("Moi nhap lua chon: ");
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
				if (sp instanceof TraSua) {
					ThucDon.setSanPhamVaoFile("trasua.txt", sp);
					ThucDon.thucdon.add(ThucDon.indexOfCaPhe, sp);
					ThucDon.indexOfCaPhe++;
				}
				if (sp instanceof CaPhe) {
					ThucDon.thucdon.add(sp);
					ThucDon.setSanPhamVaoFile("caphe.txt", sp);
				}
				System.out.println("Da them san pham\n");
				break;
		}
	}

	// private void xoaSanPham() {
	// SanPham spxoa = null;
	// do {
	// System.out.print("\nNhap ma san pham muon xoa: ");
	// String idxoa = ChucNang.chuanHoaChuoi();
	// spxoa = ThucDon.timKiemSPTheoID(idxoa);
	// if (spxoa == null) {
	// System.out.println("Khong ton tai san pham. Vui long nhap lai");
	// }
	// } while (spxoa == null);
	// ThucDon.xuatThongTinSP(spxoa);
	// int xacnhan = ChucNang.xacNhanThaoTac();
	// switch (xacnhan) {
	// case 0:
	// spxoa = null;
	// return;
	// case 1:
	// if (spxoa instanceof TraSua)
	// ThucDon.indexOfCaPhe--;
	// ThucDon.thucdon.remove(spxoa);
	// ThucDon.ghiDSVaoFile();
	// System.out.println("Da xoa san pham");
	// break;
	// }
	// }

	private ArrayList<NhanVien> timkiemNV() {
		System.out.print("Tim kiem: ");
		String timkiem = ChucNang.chuanHoaTen();
		ArrayList<NhanVien> result = new ArrayList<>();
		for (NhanVien nv : this.dsNhanVien.getDSNV()) {
			if (nv.getTen().toLowerCase().contains(timkiem.toLowerCase())) {
				result.add(nv);
			}
		}
		if (result.isEmpty()) {
			System.out.println("Khong co ket qua");
			result = null;
		}
		return result;
	}

	// private void kinhdoanhLaiSP() {
	// ArrayList<SanPham> list = new ArrayList<SanPham>();
	// for (SanPham sp : ThucDon.thucdon) {
	// if (sp.getTrangthai() == false) {
	// list.add(sp);
	// }
	// }
	// if (list.size() > 0) {
	// System.out.println("Chon stt san pham ban muon kinh doanh lai");
	// for (int i = 0; i < list.size(); ++i) {
	// System.out.println((i + 1) + ". " + list.get(i).getTen());
	// }
	// System.out.print("Moi nhap lua chon: ");
	// int luachon = ChucNang.chuanHoa(1, list.size()) - 1;
	// if (list.get(luachon) instanceof TraSua) {
	// ThucDon.setSanPhamVaoFile("trasua.txt", list.get(luachon));
	// ThucDon.thucdon.add(ThucDon.indexOfCaPhe, list.get(luachon));
	// ThucDon.indexOfCaPhe++;
	// }
	// if (list.get(luachon) instanceof CaPhe) {
	// ThucDon.thucdon.add(list.get(luachon));
	// ThucDon.setSanPhamVaoFile("caphe.txt", list.get(luachon));
	// }
	// System.out.println("Da kinh doanh lai san pham");
	// } else {
	// System.out.println("Khong co san pham da ngung kinh doanh");
	// }
	// }

	private void chinhsuaTen(int indexSpThayDoi) {
		String ten = "";
		do {
			System.out.print("Nhap vao ten san pham muon chinh sua: ");
			ten = ChucNang.chuanHoaTen();
			if (!ThucDon.kiemTraTen(ten)) {
				System.out.println("Ten san pham da ton tai. Vui long nhap lai.");
			}
		} while (!ThucDon.kiemTraTen(ten));
		ThucDon.thucdon.get(indexSpThayDoi).setTen(ten);
		ThucDon.ghiDSVaoFile();

	}

	// private void chinhsuaMa(int indexSpThayDoi) {
	// String id = "";
	// do {
	// System.out.print("Nhap vao ma san pham muon chinh sua: ");
	// id = ChucNang.chuanHoaChuoi();
	// if (!ThucDon.kiemTraID(id)) {
	// System.out.println("Ma san pham da ton tai. Vui long nhap lai.");
	// }
	// } while (!ThucDon.kiemTraID(id));
	// ThucDon.thucdon.get(indexSpThayDoi).setId(id);
	// ThucDon.ghiDSVaoFile();
	// }

	private void chinhsuaDonGia(int indexSpThayDoi) {
		int tmp[] = new int[SanPham.validSize];
		for (int i = 0; i < SanPham.validSize; ++i) {
			System.out.print("Nhap gia size " + SanPham.size[i] + ": ");
			tmp[i] = ChucNang.chuanHoa(1000, 60000);
		}
		ThucDon.thucdon.get(indexSpThayDoi).setGiaTien(tmp);
		ThucDon.ghiDSVaoFile();
	}

	private void chinhsuaSanPham() {
		ThucDon.xuatMenu(3);
		System.out.print("Nhap ten san pham can chinh sua: ");
		String tenSP = ChucNang.chuanHoaTen();
		int indexSpThayDoi = timkiemTenSP(tenSP);
		while (indexSpThayDoi == -1) {
			System.out.println("Ten nhap khong hop le, vui long nhap lai");
			System.out.print("Nhap ten san pham can chinh sua: ");
			tenSP = ChucNang.chuanHoaTen();
			indexSpThayDoi = timkiemTenSP(tenSP);
		}
		while (true) {
			// int luachon;
			System.out.println("Chon thong tin can chinh sua");
			System.out.println("1. Ten");
			System.out.println("2. Don gia");
			System.out.print("Moi nhap lua chon: ");
			int luachon = ChucNang.chuanHoa(1, 2);

			switch (luachon) {
				case 1:
					this.chinhsuaTen(indexSpThayDoi);
					// this.chinhsuaMa(indexSpThayDoi);
					System.out.println("San pham da duoc chinh sua!");
					break;
				case 2:
					this.chinhsuaDonGia(indexSpThayDoi);
					break;
			}

			System.out.println("Ban co muon chinh sua nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Moi nhap lua chon: ");
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
		System.out.print("Moi nhap lua chon: ");
		int luachon = ChucNang.chuanHoa(1, 2);
		ThucDon.xuatMenu(luachon);
		System.out.println("Nhap stt cua san pham muon ngung kinh doanh");
		System.out.print("Moi nhap lua chon: ");
		int vitriMon = ChucNang.chuanHoa(1,
				((luachon == 1) ? ThucDon.indexOfCaPhe
						: ThucDon.thucdon.size() -
								ThucDon.indexOfCaPhe))
				- 1;
		int hoilai = ChucNang.xacNhanThaoTac();
		if (hoilai == 0)
			return;
		SanPham spxoa = ThucDon.thucdon.get(vitriMon + ((luachon == 1) ? 0 : ThucDon.indexOfCaPhe));
		if (spxoa instanceof TraSua)
			ThucDon.indexOfCaPhe--;
		ThucDon.thucdon.remove(spxoa);
		ThucDon.ghiDSVaoFile();
		System.out.println("Da xoa san pham");
	}

	@Override
	public void menu() {
		while (true) {
			System.out.println("+=======================================================+");
			System.out.println("|	            NHAN VIEN QUAN LI  		 	|");
			System.out.println("+-------------------------------------------------------+");
			System.out.println("| 0. Dang xuat				   	        |");
			System.out.println("| 1. Them san pham moi					|");
			System.out.println("| 2. Chinh sua thong tin san pham		        |");
			System.out.println("| 3. Ngung kinh doanh san pham				|");
			System.out.println("| 4. Them nhan vien moi					|");
			System.out.println("| 5. Chinh sua thong tin nhan vien			|");
			System.out.println("| 6. Xuat danh sach nhan vien				|");
			System.out.println("| 7. Xuat danh sach hoa don				|");
			System.out.println("| 8. Xuat danh sach thanh vien				|");
			System.out.println("| 9. Xuat danh sach san pham				|");
			System.out.println("| 10. Xuat danh sach thong ke				|");
			System.out.println("| 11. Thong ke						|");
			System.out.println("| 12. Xuat thong tin ca nhan				|");
			System.out.println("+=======================================================+");
			System.out.print("Moi nhap lua chon: ");
			int luachon = ChucNang.chuanHoa(0, 11);
			switch (luachon) {
				case 1:
					this.themSanPham();
					break;
				case 2:
					this.chinhsuaSanPham();
					break;
				case 3:
					// this.xoaSanPham();
					this.xoaSP();
					break;
				case 4:
					this.themNhanVien();
					break;
				case 5:
					this.chinhsuaThongTinNV();
					break;// sua lai
				case 6:
					this.xuatDSNV();
					// this.dsNhanVien.ghiVaoFile("NHAN_VIEN.txt");
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
				case 12:
					this.xuatThongTinCaNhan();
					break;
				case 11:
					System.out.println("Moi nhap loai thong ke");
					System.out.println("1. Thong ke theo quy");
					System.out.println("2. Thong ke theo thang");
					System.out.print("Moi nhap lua chon: ");
					int chon = ChucNang.chuanHoa(1, 2);
					if (chon == 1)
						tk.thongKeQuy();
					if (chon == 2)
						tk.thongKeThang();
					break;
				case 10:
					this.xuatDSTK();
					break;
				case 0:
					System.out.println("");
					return;
			}
		}
	}
}
