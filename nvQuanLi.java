import java.util.Collections;
import java.util.Scanner;

public class nvQuanLi extends NhanVien{
	private DSNhanVien dsNhanVien;

	//getter/setters

	public nvQuanLi(){
		this.dsNhanVien = new DSNhanVien();
	}

	private void xuatDSNV(){
        sapXepTheoChucVu();
        System.out.println("------------------------------------------------------ NHAN VIEN QUAN LY ------------------------------------------------------");
        System.out.format("%-8s %-18s %-12s %-50s %-13s %-25s",
		"ID",
		"|  Ten",
		"|  Ngay sinh",
		"|  Dia chi",
		"|  SDT",
		"|  Email");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        int i = 0;
        while(this.dsNhanVien.getDSNV().get(i) instanceof nvQuanLi){
            this.dsNhanVien.getDSNV().get(i).xuatThongTin();
            ++i;
            if(i == this.dsNhanVien.getDSNV().size())
                break;
        }
        System.out.println();

        System.out.println("------------------------------------------------------ NHAN VIEN PHA CHE ------------------------------------------------------");
        System.out.format("%-8s %-18s %-12s %-50s %-13s %-25s",
		"ID",
		"|  Ten",
		"|  Ngay sinh",
		"|  Dia chi",
		"|  SDT",
		"|  Email");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        while (this.dsNhanVien.getDSNV().get(i) instanceof nvPhaChe) {
            this.dsNhanVien.getDSNV().get(i).xuatThongTin();
            ++i;
            if(i == this.dsNhanVien.getDSNV().size())
                break;
        }
        System.out.println();

        System.out.println("------------------------------------------------------ NHAN VIEN DAT HANG ------------------------------------------------------");
        System.out.format("%-8s %-18s %-12s %-50s %-13s %-25s",
		"ID",
		"|  Ten",
		"|  Ngay sinh",
		"|  Dia chi",
		"|  SDT",
		"|  Email");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        while (this.dsNhanVien.getDSNV().get(i) instanceof nvDatHang) {
            this.dsNhanVien.getDSNV().get(i).xuatThongTin();
            ++i;
            if(i == this.dsNhanVien.getDSNV().size())
                break;
        }
        System.out.println();
    }

    private void sapXepTheoChucVu(){
        Collections.sort(this.dsNhanVien.getDSNV(), new SoSanhTheoChucVu());
    }

	
	private void themNhanVien(){
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
			default:
				break;
		}
		do {
			nv.nhapThongTin();
			if(!this.dsNhanVien.kiemTraIDNV(nv.getId())){
				System.out.println("Ma nhan vien da ton tai. Vui long nhap lai.");
			}
		} while (!this.dsNhanVien.kiemTraIDNV(nv.getId()));
		int xacnhan = ChucNang.xacNhanThaoTac();
		switch (xacnhan) {
			case 0:
				nv = null;
				break;
			case 1:
				this.dsNhanVien.ghiVaoFile("NHAN_VIEN.txt", nv);
				// this.docDSNVTuFile("NHAN_VIEN");
				System.out.println("Them nhan vien thanh cong!");
				break;
		}
	}

	private NhanVien timkiemID(String id){
		for (NhanVien nv : this.dsNhanVien.getDSNV()){
			if (nv.getId().equalsIgnoreCase(id)){
				return nv;
			}
		}
		return null;
	}

	private int timkiemTenSP(String ten){
		for (int i = 0 ; i < ThucDon.thucdon.size(); ++i){
			if (ThucDon.thucdon.get(i).getTen().equalsIgnoreCase(ten)){
				return i;
			}
		}
		return -1;
	}
	
	private void docDSNVTuFile(String filepath){
		this.dsNhanVien.nhapNVtuFile(filepath);
	} 

	private void chinhsuaThongTinNV(){
		this.xuatDSNV();
		NhanVien nvThayDoiTT = null;
		//chuan hoa du lieu
		do {
			System.out.print("Nhap ID cua nhan vien muon chinh sua thong tin: ");
			String idNVtimkiem = ChucNang.chuanHoaChuoi();
			nvThayDoiTT = timkiemID(idNVtimkiem);
			if(nvThayDoiTT == null) {
				System.out.println("ID khong ton tai, vui long nhap lai");
			}
		} while (nvThayDoiTT == null);

		//Hoi chon can chinh sua gi
		while (true) {
			System.out.format("%-8s %-18s %-12s %-50s %-13s %-25s",
			"ID",
			"|  Ten",
			"|  Ngay sinh",
			"|  Dia chi",
			"|  SDT",
			"|  Email");
			System.out.println();
			nvThayDoiTT.xuatThongTin();
			System.out.println("\nChon thong tin can chinh sua");
			System.out.println("1. Chinh sua ID");
			System.out.println("2. Chinh sua ten");
			System.out.println("3. Chinh sua dia chi");
			System.out.println("4. Chinh sua so dien thoai");
			System.out.println("5. Chinh sua email");
			System.out.println("6. Chinh sua ngay sinh");
			System.out.println("0. Thoat");
			System.out.print("Moi nhap lua chon: ");
			int luachon = ChucNang.chuanHoa(0, 7);
			System.out.print("Nhap thong tin chinh sua: ");
			switch (luachon) {
				case 0:
					return;
				case 1:
					nvThayDoiTT.setId(ChucNang.chuanHoaChuoi());
					break;
				case 2:
					nvThayDoiTT.setTen(ChucNang.chuanHoaChuoi());
					break;
				case 3:
					DiaChi diachimoi = new DiaChi();
					diachimoi.nhapThongTin();
					nvThayDoiTT.setDc(diachimoi);
					break;
				case 4:
					nvThayDoiTT.setSdt(ChucNang.chuanHoaChuoi());
					break;
				case 5:
					nvThayDoiTT.setEmail(ChucNang.chuanHoaChuoi());
					break;
				case 6:
					NgayThang ngaysinhmoi = new NgayThang();
					ngaysinhmoi.nhapThongTin();
					nvThayDoiTT.setNgaysinh(ngaysinhmoi);
					break;
			}
		}
		//Them phan ghi vao file
	}

	private void themSanPham(){
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
				if (sp instanceof TraSua) ThucDon.setSanPhamVaoFile("trasua.txt", sp);
				if (sp instanceof CaPhe) ThucDon.setSanPhamVaoFile("caphe.txt", sp);
				ThucDon.thucdon.add(ThucDon.indexOfCaPhe * ((sp instanceof CaPhe) ? 1 : 0), sp);
				if (sp instanceof TraSua) ThucDon.indexOfCaPhe++;
				System.out.println("Da them san pham\n");
				break;
		}
	}

	private void xoaSanPham(){
		SanPham spxoa = null;
		do {
			System.out.print("\nNhap ma san pham muon xoa: ");
			String idxoa = ChucNang.chuanHoaChuoi();
			spxoa = ThucDon.timKiemSPTheoID(idxoa);
			if(spxoa == null){
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

	private void xuatDSNVTheoTen(){
		System.out.print("Tim kiem: ");
		String timkiem = ChucNang.chuanHoaChuoi();
		System.out.format("%-8s %-18s %-12s %-50s %-13s %-25s",
		"ID",
		"|  Ten",
		"|  Ngay sinh",
		"|  Dia chi",
		"|  SDT",
		"|  Email");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		for(NhanVien nv : this.dsNhanVien.getDSNV()){
			if(nv.getTen().contains(timkiem)){
				nv.xuatThongTin();
			}
		}
	}

	private void chinhsuaTen(int indexSpThayDoi){
		System.out.println("Nhap vao ten san pham muon chinh sua: ");
		String ten = ChucNang.chuanHoaChuoi();
		ThucDon.thucdon.get(indexSpThayDoi).setTen(ten);
	}

	private void chinhsuaDonGia(int indexSpThayDoi){
		Scanner scan = new Scanner(System.in);
		int tmp[] = new int[SanPham.validSize];
		for (int i = 0; i < SanPham.validSize; ++i){
			System.out.print("Nhap gia size " + SanPham.size[i] + ": ");
			tmp[i] = Integer.parseInt(scan.nextLine());
		}
		ThucDon.thucdon.get(indexSpThayDoi).setGiaTien(tmp);
	}

	private void chinhsuaSanPham(){
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


			//Phan nay chua lam !!!

			switch (luachon) {
				case 1:
					this.chinhsuaTen(indexSpThayDoi);
					break;
				case 2:
					this.chinhsuaDonGia(indexSpThayDoi);
					break;
				// case 3:
				// 	this.chinhsuaSoLuongHang(indexSpThayDoi);
				// 	break;
			}

			System.out.println("Ban co muon chinh sua nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Nhap lua chon: ");
			int chonTiep = ChucNang.chuanHoa(1, 2);
			if (chonTiep == 2) break;

		}
	}

	@Override
	public void menu() {
		ThucDon.thucdon.clear();
		this.dsNhanVien.getDSNV().clear();
		this.docDSNVTuFile("NHAN_VIEN.txt");
		ThucDon.setDonGiatuFile("trasua.txt");
		ThucDon.setDonGiatuFile("caphe.txt");
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
            System.out.println("| 6. Tim kiem thong tin nhan vien			|");
            System.out.println("| 7. Xuat danh sach nhan vien				|");
            System.out.println("+=======================================================+");

			// System.out.println("----------------------- NHAN VIEN QUAN LI -----------------------");
			// System.out.println("1. Them san pham moi");
			// System.out.println("2. Cap nhat va chinh sua thong tin san pham");
			// System.out.println("3. Xoa san pham");
			// System.out.println("4. Them nhan vien moi");
			// System.out.println("5. Chinh sua thong tin nhan vien");
			// System.out.println("6. Tim kiem thong tin nhan vien");
			// System.out.println("7. Xuat danh sach nhan vien");
			// System.out.println("8. Dang xuat");

			int luachon = ChucNang.chuanHoa(0, 7);
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
					break;
				case 6:
					this.xuatDSNVTheoTen();
					break;
				case 7:
					this.xuatDSNV();
					break;
				case 0:
					return;		
			}
		}
	}
}
