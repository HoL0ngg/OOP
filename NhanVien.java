import java.util.Scanner;

public abstract class NhanVien {
	private String id;
	private String ten;
	private DiaChi dc;
	private String sdt;
	private String email;
	private NgayThang ngaysinh;

	public NhanVien() {
	}

	public NhanVien(String id, String ten) {
		this.id = id;
		this.ten = ten;
	}

	public NhanVien(String id, String ten, DiaChi dc, String sdt, String email, NgayThang ngaysinh) {
		this.id = id;
		this.ten = ten;
		this.dc = dc;
		this.sdt = sdt;
		this.email = email;
		this.ngaysinh = ngaysinh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public DiaChi getDc() {
		return dc;
	}

	public void setDc(DiaChi dc) {
		this.dc = dc;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String std) {
		this.sdt = std;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NgayThang getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(NgayThang ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public void nhapThongTin() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap id: ");
		this.setId(scan.nextLine());
		System.out.print("Nhap ten: ");
		this.setTen(scan.nextLine());
		System.out.println("Nhap dia chi: ");
		DiaChi dc = new DiaChi();
		dc.nhapThongTin();
		this.setDc(dc);
		System.out.print("Nhap so dien thoai: ");
		this.setSdt(scan.nextLine());
		System.out.print("Nhap dia chi email: ");
		this.setEmail(scan.nextLine());
		System.out.println("Nhap ngay sinh: ");
		NgayThang ngaysinh = new NgayThang();
		ngaysinh.nhapThongTin();
		this.setNgaysinh(ngaysinh);
		scan.close();
	}

	public void xuatThongTin(){
		System.out.println("ID: " + this.getId());
		System.out.println("Ho va ten: " + this.getTen());
		System.out.print("Chuc vu: ");
		if(this instanceof nvDatHang){
			System.out.println("Nhan vien dat hang");
		} else {
			if(this instanceof nvQuanLi){
				System.out.println("Nhan vien quan li");
			} else {
				System.out.println("Nhan vien pha che");
			}
		}
		System.out.println("Ngay sinh: " + this.getNgaysinh().xuatThongTin());
		System.out.println("Dia chi: " + this.getDc().xuatThongTin());
		System.out.println("So dien thoai: " + this.getSdt());
		System.out.println("Email: " + this.getEmail());
	}

	public abstract void menu();
}
