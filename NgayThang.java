public class NgayThang {
	private int ngay;
	private int thang;
	private int nam;

	public NgayThang(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public NgayThang() {
	}

	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		this.ngay = ngay;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public void nhapThongTin() {
		System.out.print("Nhap ngay: ");
		this.setNgay(Integer.parseInt(ChucNang.chuanHoaChuoi()));
		System.out.print("Nhap thang: ");
		this.setThang(Integer.parseInt(ChucNang.chuanHoaChuoi()));
		System.out.print("Nhap nam: ");
		this.setNam(Integer.parseInt(ChucNang.chuanHoaChuoi()));
	}

	@Override
	public String toString() {
		return this.getNgay() + "/" + this.getThang() + "/" + this.getNam();
	}
}
