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
		System.out.print("Nhap id: ");
		this.setId(ChucNang.chuanHoaChuoi());
		System.out.print("Nhap ten: ");
		this.setTen(ChucNang.chuanHoaChuoi());
		System.out.println("Nhap dia chi: ");
		DiaChi dc = new DiaChi();
		dc.nhapThongTin();
		this.setDc(dc);
		System.out.print("Nhap so dien thoai: ");
		this.setSdt(ChucNang.chuanHoaChuoi());
		System.out.print("Nhap dia chi email: ");
		this.setEmail(ChucNang.chuanHoaChuoi());
		System.out.println("Nhap ngay sinh: ");
		NgayThang ngaysinh = new NgayThang();
		ngaysinh.nhapThongTin();
		this.setNgaysinh(ngaysinh);
	}

	public void xuatThongTin() {
		System.out.format("%-8s %-18s %-15s %-55s %-13s %-33s",
				this.getId(),
				"|  " + this.getTen(),
				"|  " + this.getNgaysinh(),
				"|  " + this.getDc().xuatThongTin(),
				"|  " + this.getSdt(),
				"|  " + this.getEmail());
		System.out.println();
	}

	public void xuatThongTinCaNhan() {
		System.out.println("\nMa nhan vien: " + this.getId());
		System.out.println("Ho va ten: " + this.getTen());
		System.out.println("So dien thoai: " + this.getSdt());
		System.out.print("Chuc vu: ");
		if (this instanceof nvQuanLi) {
			System.out.print("Nhan vien quan ly");
		} else {
			if (this instanceof nvPhaChe) {
				System.out.print("Nhan vien pha che");
			} else {
				System.out.print("Nhan vien dat hang");
			}
		}
		System.out.println();
		System.out.println("Dia chi: " + this.getDc().xuatThongTin());
		System.out.println("Ngay sinh: " + this.getNgaysinh().toString());
		System.out.println("Email: " + this.getEmail());
		System.out.println();
	}

	public abstract void menu();
}
