package SANPHAM;

import java.security.DrbgParameters.Capability;

import CHUCNANG.ChucNang;

public abstract class SanPham {
	private String id;
	private String ten;
	private int giaTien[];
	private boolean trangthai;

	public static int maxLength = 0;

	// cac size co the co trong do uong
	public static int validSize = 3;
	public static String size[] = { "S", "M", "L", "XL", "XXL" };
	public static String[] duong = { "0%", "25%", "50%", "75%", "100%" };
	public static String[] da = { "0%", "25%", "50%", "75%", "100%" };

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
		if (this instanceof TraSua)
			this.setId("ts" + (ThucDon.indexOfCaPhe + 1));
		if (this instanceof CaPhe)
			this.setId("cp" + (ThucDon.thucdon.size() - ThucDon.indexOfCaPhe + 1));
		do {
			System.out.print("Nhap ten san pham: ");
			this.setTen(ChucNang.chuanHoaTen());
			if (!ThucDon.kiemTraTen(this.getTen())) {
				System.out.println("Ten san pham da ton tai. Vui long nhap lai.");
			}
		} while (!ThucDon.kiemTraTen(this.getTen()));
		int gia[] = new int[SanPham.validSize];
		for (int i = 0; i < SanPham.validSize; ++i) {
			System.out.print("Nhap vao gia size " + SanPham.size[i] + ": ");
			gia[i] = ChucNang.chuanHoa(1000, 60000);
		}
		this.setGiaTien(gia);
		this.setTrangthai(true);
	}
}
