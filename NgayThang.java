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
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap ngay: ");
		this.setNgay(Integer.parseInt(scan.nextLine()));
		System.out.println("Nhap thang");
		this.setThang(Integer.parseInt(scan.nextLine()));
		System.out.println("Nhap nam");
		this.setNam(Integer.parseInt(scan.nextLine()));
	}

	@Override
	public String toString(){
		return this.getNgay() + "/" + this.getThang() + "/" + this.getNam();
	}
}
