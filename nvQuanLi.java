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
				scan.close();
				return;
			case 1:
				this.dsNhanVien.getDSNV().add(nv);
				scan.close();
				break;
			default:
				nv = null;
				scan.close();
				return;
		}
	}

	public NhanVien timkiemID(String id){
		for (NhanVien nv : this.dsNhanVien.getDSNV()){
			if (nv.getId() == id){
				return nv;
			}
		}
		return null;
	}

	public void chinhsuaThongTinNV(){
		Scanner scan = new Scanner(System.in);
		NhanVien nvThayDoiTT = null;
		//chuan hoa du lieu
		do {
			System.out.print("Nhap ID cua nhan vien muon chinh sua thong tin: ");
			String idNVtimkiem = scan.nextLine();
			nvThayDoiTT = timkiemID(idNVtimkiem);
			if(nvThayDoiTT == null) {
				System.out.println("ID khong ton tai, vui long nhap lai");
				System.out.print("Nhap ID cua nhan vien muon chinh sua thong tin: ");
			}
		} while (nvThayDoiTT == null);

		//Hoi chon can chinh sua gi
		System.out.println("Chon thong tin can chinh sua");
		System.out.println("1. Chinh sua id");
		System.out.println("2. Chinh sua ten");
		System.out.println("3. Chinh sua dia chi");
		System.out.println("4. Chinh sua so dien thoai");
		System.out.println("5. Chinh sua email");
		System.out.println("6. Chinh sua ngay sinh");
		System.out.print("Moi nhap lua chon: ");
		int luachon = Integer.parseInt(scan.nextLine());
		System.out.print("Nhap thong tin chinh sua: ");
		switch (luachon) {
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

		scan.close();
	}
}
