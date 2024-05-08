import java.util.ArrayList;
import java.util.Scanner;

public class nvQuanLi extends NhanVien{
	private DSNhanVien dsNhanVien;

	//getter/setters

	public nvQuanLi(){
		this.dsNhanVien = new DSNhanVien();
	}

	public void themNhanVien(){
		Scanner scan = new Scanner(System.in);
		NhanVien nv = null;
		int luachon;
		do {
			System.out.println("Nhap kieu nhan vien can them: ");
			System.out.println("1. Nhan vien quan li");
			System.out.println("2. Nhan vien pha che");
			System.out.println("3. Nhan vien dat hang");
			System.out.print("Moi nhap lua chon: ");
			luachon = (Integer.parseInt(scan.nextLine()));
			if(luachon < 1 || luachon > 3){
				System.out.println("Loai nhan vien khong hop le. Vui long nhap lai.");
			}
		} while (luachon < 1 || luachon > 3);

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
		nv.nhapThongTin();
		System.out.println("Xac nhan them nhan vien: ");
		System.out.println("0. Khong xac nhan");
		System.out.println("1. Xac nhan");
		int xacnhan = Integer.parseInt(scan.nextLine());
		switch (xacnhan) {
			case 0:
				nv = null;
				break;
			case 1:
				this.dsNhanVien.getDSNV().add(nv);
				System.out.println("Them nhan vien thanh cong");
				break;
			default:
				nv = null;
				break;
		}
		scan.close();
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

	public void chinhsuaThongTinNV(){
		docDSNVTuFile("NHAN_VIEN.txt");
		this.dsNhanVien.xuatDSNV();
		Scanner scan = new Scanner(System.in);
		NhanVien nvThayDoiTT = null;
		//chuan hoa du lieu
		do {
			System.out.print("Nhap ID cua nhan vien muon chinh sua thong tin: ");
			String idNVtimkiem = scan.nextLine();
			nvThayDoiTT = timkiemID(idNVtimkiem);
			if(nvThayDoiTT == null) {
				System.out.println("ID khong ton tai, vui long nhap lai");
			}
		} while (nvThayDoiTT == null);

		//Hoi chon can chinh sua gi
		while (true) {
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
			int luachon = Integer.parseInt(scan.nextLine());
			System.out.print("Nhap thong tin chinh sua: ");
			switch (luachon) {
				case 0:
					return;
				case 1:
					nvThayDoiTT.setId(scan.nextLine());
					break;
				case 2:
					nvThayDoiTT.setTen(scan.nextLine());
					break;
				case 3:
					DiaChi diachimoi = new DiaChi();
					diachimoi.nhapThongTin();
					nvThayDoiTT.setDc(diachimoi);
					break;
				case 4:
					nvThayDoiTT.setSdt(scan.nextLine());
					break;
				case 5:
					nvThayDoiTT.setEmail(scan.nextLine());
					break;
				case 6:
					NgayThang ngaysinhmoi = new NgayThang();
					ngaysinhmoi.nhapThongTin();
					nvThayDoiTT.setNgaysinh(ngaysinhmoi);
					break;
				default:
					break;
			}
		}
		//Them phan ghi vao file
	}

	public void themSanPham(){
		Scanner scan = new Scanner(System.in);
		SanPham sp = null;
		System.out.println("Nhap loai do uong can them: ");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca phe");
		System.out.print("Moi nhap lua chon: ");
		int LuaChon = Integer.parseInt(scan.nextLine());
		while (LuaChon < 1 || LuaChon > 2) {
			System.out.println("Vui long nhap lai!");
			System.out.println("Nhap loai do uong can them: ");
			System.out.println("1. Tra sua");
			System.out.println("2. Ca phe");
			System.out.print("Moi nhap lua chon: ");
			LuaChon = Integer.parseInt(scan.nextLine());
		}
		switch (LuaChon) {
			case 1:
				sp = new TraSua();
				break;
			case 2:
				sp = new CaPhe();
				break;
		}
		sp.nhapThongTin();
		ThucDon.thucdon.add(sp);

		scan.close();
	}

	public void chinhsuaSanPham(){
		Scanner scan = new Scanner(System.in);
		ThucDon.xuatMenu();
		System.out.print("Nhap ten san pham can chinh sua: ");
		String tenSP = scan.nextLine();
		int indexSpThayDoi = timkiemTenSP(tenSP);
		while (indexSpThayDoi == -1) {
			System.out.println("Ten nhap khong hop le, vui long nhap lai");
			System.out.print("Nhap ten san pham can chinh sua: ");
			tenSP = scan.nextLine();
			indexSpThayDoi = timkiemTenSP(tenSP);
		}
		while (true) {
			int luachon;
			do {
				System.out.println("Chon thong tin can chinh sua");
				System.out.println("1. Ten");
				System.out.println("2. Don gia");
				System.out.println("3. So luong hang");
				luachon = Integer.parseInt(scan.nextLine());
			} while (luachon < 1 || luachon > 3);

			//xu li o day
			// switch (luachon) {
			// 	case 1:
			// 		this.chinhsuaTen(indexSpThayDoi);
			// 		break;
			// 	case 2:
			// 		this.chinhsuaDonGia(indexSpThayDoi);
			// 		break;
			// 	case 3:
			// 		this.chinhsuaSoLuongHang(indexSpThayDoi);
			// 		break;
			// }

			System.out.println("Ban co muon chinh sua nua khong ?");
			System.out.println("1. Co");
			System.out.println("2. Khong");
			System.out.print("Nhap lua chon: ");
			int chonTiep = Integer.parseInt(scan.nextLine());
			//copy tu ben nvDatHang qua
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
		scan.close();
	}
}
