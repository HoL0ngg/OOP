import java.util.Scanner;

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
		System.out.println("Nhap ngay");
		this.setNgay(ChucNang.chuanHoa(1, 31));
		System.out.println("Nhap thang");
		this.setThang(ChucNang.chuanHoa(1, 12));
		System.out.println("Nhap nam");
		this.setNam(ChucNang.chuanHoa(1, 2024));
	}
	public String xuatThongTin(){
		return this.getNgay() + "/" + this.getThang() + "/" + this.getNam();
	}
}
