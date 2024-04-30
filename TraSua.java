import java.util.Scanner;

public class TraSua extends SanPham {
	
	public TraSua() {
		super();
	}
	
	public TraSua(String id, String ten) {
		super(id, ten);
	}

	@Override
	public void nhapThongTin(){
		super.nhapThongTin();
		Scanner scan = new Scanner(System.in);
		System.out.print("");
	}

}
