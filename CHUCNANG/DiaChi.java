package CHUCNANG;

public class DiaChi {
	private String TinhThanh;
	private String QuanHuyen;
	private String PhuongXa;
	private String SoNha;
	private String TenDuong;

	public DiaChi() {
	}

	public DiaChi(String tinhThanh, String quanHuyen, String phuongXa, String soNha, String tenDuong) {
		TinhThanh = tinhThanh;
		QuanHuyen = quanHuyen;
		PhuongXa = phuongXa;
		SoNha = soNha;
		TenDuong = tenDuong;
	}

	public String getTinhThanh() {
		return TinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		TinhThanh = tinhThanh;
	}

	public String getQuanHuyen() {
		return QuanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		QuanHuyen = quanHuyen;
	}

	public String getPhuongXa() {
		return PhuongXa;
	}

	public void setPhuongXa(String phuongXa) {
		PhuongXa = phuongXa;
	}

	public String getSoNha() {
		return SoNha;
	}

	public void setSoNha(String soNha) {
		SoNha = soNha;
	}

	public String getTenDuong() {
		return TenDuong;
	}

	public void setTenDuong(String tenDuong) {
		TenDuong = tenDuong;
	}

	public void nhapThongTin() {
		System.out.print("Nhap tinh thanh: ");
		this.setTinhThanh(ChucNang.chuanHoaChuoi());
		System.out.print("Nhap quan huyen: ");
		this.setQuanHuyen(ChucNang.chuanHoaChuoi());
		System.out.print("Nhap phuong xa: ");
		this.setPhuongXa(ChucNang.chuanHoaChuoi());
		System.out.print("Nhap so nha: ");
		this.setSoNha(ChucNang.chuanHoaSoNha());
		System.out.print("Nhap ten duong: ");
		this.setTenDuong(ChucNang.chuanHoaChuoi());
	}

	public String xuatThongTin() {
		return this.getSoNha() + " " + this.getTenDuong() + "," + this.getQuanHuyen() + "," + this.getPhuongXa() + ","
				+ this.getTinhThanh();
	}
}
