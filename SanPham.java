import java.util.Scanner;

public abstract class SanPham {
	private String id;
	private String ten;
	private int giaTien[];

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

	public int getGiaTienAtIndex(int index){
		return giaTien[index];
	}


	//dung de cho nvQuanLi them SanPham vao List
	public void nhapThongTin(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap id san pham: ");
		this.setId(scan.nextLine());
		System.out.print("Nhap ten san pham: ");
		this.setTen(scan.nextLine());
		int gia[] = new int[SanPham.validSize]; 
		for (int i = 0 ; i < SanPham.validSize; ++i){
			System.out.print("Nhap vao gia size " + SanPham.size[i] + ": ");
			gia[i] = Integer.parseInt(scan.nextLine());
			System.out.println();
		}
		this.setGiaTien(gia);
		scan.close();
	}
}
