import java.util.Scanner;

public class nvQuanLi extends NhanVien{
	private DSNhanVien dsNhanVien;

	//getter/setters

	public void themNhanVien(){
		Scanner scan = new Scanner(System.in);
		NhanVien nv = null;
		System.out.println("Nhap kieu nhan vien can them: ");
		System.out.println("1. Nhan vien quan li");
		System.out.println("2. Nhan vien pha che");
		System.out.println("3. Nhan vien dat hang");
		System.out.print("Moi nhap lua chon: ");
		int LuaChon = Integer.parseInt(scan.nextLine());
		while (LuaChon < 1 || LuaChon > 3){
			System.out.println("Lua chon khong hop li, vui long nhap lai.");
			System.out.print("Moi nhap lua chon: ");
			LuaChon = Integer.parseInt(scan.nextLine());
		}
		switch (LuaChon) {
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
				break;
			default:
				nv = null;
				break;
		}
		scan.close();
	}

	private NhanVien timkiemID(String id){
		for (NhanVien nv : this.dsNhanVien.getDSNV()){
			if (nv.getId() == id){
				return nv;
			}
		}
		return null;
	}

	private SanPham timkiemTenSP(String ten){
		for (SanPham sp : ThucDon.thucdon){
			if (sp.getTen().equalsIgnoreCase(ten)){
				return sp;
			}
		}
		return null;
	}

	public void chinhsuaThongTinNV(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap ID cua nhan vien muon chinh sua thong tin: ");
		String idNVtimkiem = scan.nextLine();

		//chuan hoa du lieu
		NhanVien nvThayDoiTT = timkiemID(idNVtimkiem);
		while (nvThayDoiTT != null){
			System.out.println("ID khong ton tai, vui long nhap lai");
			System.out.print("Nhap ID cua nhan vien muon chinh sua thong tin: ");
			idNVtimkiem = scan.nextLine();
			nvThayDoiTT = timkiemID(idNVtimkiem);
		}

		//Hoi chon can chinh sua gi
		System.out.println("Chon thong tin can chinh sua");
		System.out.println("1. Chinh sua id");
		System.out.println("2. Chinh sua ten");
		System.out.println("3. Chinh sua dia chi");
		System.out.println("4. Chinh sua so dien thoai");
		System.out.print("Moi nhap lua chon: ");

		scan.close();
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
		SanPham spThayDoi = timkiemTenSP(tenSP);
		while (spThayDoi == null) {
			System.out.println("Ten nhap khong hop le, vui long nhap lai");
			System.out.print("Nhap ten san pham can chinh sua: ");
			tenSP = scan.nextLine();
			spThayDoi = timkiemTenSP(tenSP);
		}
		scan.close();
	}
}
