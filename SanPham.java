public abstract class SanPham {
	private String id;
	private String ten;
	private int giaTien[];
	private boolean trangthai;

	public static int maxLength = 0;

	// cac size co the co trong do uong
	public static int validSize = 3;
	public static String size[] = { "S", "M", "L", "XL", "XXL" };

	public SanPham() {
	}

	public SanPham(String id, String ten) {
		this.id = id;
		this.ten = ten;
	}

	public String getTen() {
		return ten;
	}

	public boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getValidSize() {
		return validSize;
	}

	public int[] getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int[] giaTien) {
		this.giaTien = giaTien;
	}

	public int getGiaTienAtIndex(int index) {
		return giaTien[index];
	}

	// dung de cho nvQuanLi them SanPham vao List
	public void nhapThongTin() {
		do {
			System.out.print("Nhap id san pham: ");
			this.setId(ChucNang.chuanHoaChuoi());
			if (!ThucDon.kiemTraID(this.getId())) {
				System.out.println("Ma san pham da ton tai. Vui long nhap lai.");
			}
		} while (!ThucDon.kiemTraID(this.getId())); // Kiem tra ID da ton tai trong ds chua
		System.out.print("Nhap ten san pham: ");
		this.setTen(ChucNang.chuanHoaChuoi());
		int gia[] = new int[SanPham.validSize];
		for (int i = 0; i < SanPham.validSize; ++i) {
			System.out.print("Nhap vao gia size " + SanPham.size[i] + ": ");
			gia[i] = Integer.parseInt(ChucNang.chuanHoaChuoi());
			// System.out.println();
		}
		this.setGiaTien(gia);
		this.setTrangthai(true);
	}
}
