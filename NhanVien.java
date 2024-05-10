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
		System.out.format("%-5s %-18s %-12s %-45s %-13s %-25s", 
		this.getId(),
		this.getTen(),
		this.getNgaysinh().xuatThongTin(),
		this.getDc().xuatThongTin(),
		this.getSdt(),
		this.getEmail());
		System.out.println();
	}

}
