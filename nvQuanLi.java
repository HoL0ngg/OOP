import java.util.Scanner;

public class nvQuanLi extends NhanVien{



    public void chinhsuaThucDon(){
		Scanner scan = new Scanner(System.in);
		ThucDon.xuatMenu(3);	//xuat toan bo menu
		System.out.println("Chon mon can chinh sua: ");
		System.out.println("1. Tra sua");
		System.out.println("2. Ca Phe");
		System.out.print("Moi nhap lua chon: ");
		int LuaChon = Integer.parseInt(scan.nextLine());
		System.out.println("Chon loai can chinh sua: ");
		System.out.println("1. Ten");
		System.out.println("2. Don gia");
		int Loai = Integer.parseInt(scan.nextLine());
		int index = 0;	//dem
		for (SanPham sp : ThucDon.thucdon){
			if (index == LuaChon){
				//sua thong tin o day

				break;
			}
			if (sp instanceof CaPhe){
				//tang bien dem
			}
		}
		scan.close();
	}

}
