package CHUCNANG;

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
		int[] thang = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.print("Nhap ngay: ");
		int day = ChucNang.chuanHoa(1, 31);
		System.out.print("Nhap thang: ");
		int month = ChucNang.chuanHoa(1, 12);
		System.out.print("Nhap nam: ");
		int year = ChucNang.chuanHoa(1, 2024);
		if (year % 4 == 0 && year % 100 != 0)
			thang[1]++;
		while (thang[month - 1] < day) {
			System.out.println("Gia tri khong hop le, vui long nhap lai");
			System.out.print("Nhap ngay: ");
			day = ChucNang.chuanHoa(1, 31);
			System.out.print("Nhap thang: ");
			month = ChucNang.chuanHoa(1, 12);
			System.out.print("Nhap nam: ");
			year = ChucNang.chuanHoa(1, 2024);
		}
	}

	@Override
	public String toString() {
		return this.getNgay() + "/" + this.getThang() + "/" + this.getNam();
	}
}
