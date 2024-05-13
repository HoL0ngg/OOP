import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ThucDon {

	public static ArrayList<SanPham> thucdon = new ArrayList<SanPham>();
	public static int indexOfCaPhe = 0;

	public ThucDon() {
	}

	public static void setDonGiatuFile(String path) {
		// File file = new File(path);
		try (Scanner scan = new Scanner(new File(path))) {
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] parts = line.split("#");

				String id = parts[0].trim();
				String ten = parts[1].trim();
				
				SanPham.maxLength = ten.length() > SanPham.maxLength ? ten.length() : SanPham.maxLength;
				
				SanPham sp = null;

				if (path.equals("trasua.txt")) {
					sp = new TraSua(id, ten);
					ThucDon.indexOfCaPhe++;
				} else if (path.equals("caphe.txt")) {
					sp = new CaPhe(id, ten);
				} else {
					System.out.println("Duong dan ko hop le!");
					return;
				}

				int tmp[] = new int[SanPham.validSize];
				for (int i = 0; i < SanPham.validSize; ++i) {
					tmp[i] = Integer.parseInt(parts[i + 2]);
				}

				sp.setGiaTien(tmp);

				thucdon.add(sp);

			}

		} catch (Exception e) {
			System.out.println("Khong the mo file de doc san pham");
		}
	}

	public static void xuatMenu(int loai) {
		int cntTab = (SanPham.maxLength / 8) + 1;
		if (loai == 1){
			System.out.println("---------------------------- Tra sua ----------------------------");
			for (int i = 0; i <= cntTab; ++i) {
				System.out.print("\t");
			}
			for (int i = 0; i < SanPham.validSize; ++i) {
					System.out.print(SanPham.size[i] + "\t");
			}
			System.out.println();
			int index = 1;
			for (SanPham sp : thucdon) {
				if (sp instanceof TraSua) {
				System.out.print((index++) + ". " + sp.getTen());
					
				int lengthTS = (sp.getTen().length() + 2 + (String.valueOf(index-1).length())) / 8;
	
					TraSua ts = (TraSua) sp;
					// tab ra cho dep
				for (int j = lengthTS; j <= cntTab;++j) {
					System.out.print("\t");
				}
				
					
					int banggia[] = ts.getGiaTien();
					for (int j = 0; j < SanPham.validSize; ++j) {
						System.out.print(ChucNang.chuanHoaGia(banggia[j]) + "\t");
					}
					System.out.println();
				}
			}
			System.out.println();
		} else if (loai == 2){
			System.out.println("---------------------------- Ca phe ----------------------------");
			for (int i = 0; i <= cntTab; ++i) {
				System.out.print("\t");
			}
			for (int i = 0; i < SanPham.validSize; ++i) {
				System.out.print(SanPham.size[i] + "\t");
			}
			System.out.println();
			int index = 1;
			for (SanPham sp : thucdon) {
				if (sp instanceof CaPhe) {
					System.out.print((index++) + ". " + sp.getTen());
		
					CaPhe cf = (CaPhe) sp;
						// tab ra cho dep
					int lengthTS = (sp.getTen().length() + 2 + (String.valueOf(index-1).length())) / 8;
					for (int j = lengthTS; j <= cntTab; ++j) {
						System.out.print("\t");
					}
		
					int banggia[] = cf.getGiaTien();
					for (int j = 0; j < SanPham.validSize; ++j) {
						System.out.print(ChucNang.chuanHoaGia(banggia[j]) + "\t");
					}
					System.out.println();
				}
			}
			System.out.println();
		} else {
			ThucDon.xuatMenu(1);
			ThucDon.xuatMenu(2);
		}
	}

	public static void xuatThongTinSP(SanPham sp){
		System.out.println("Ma san pham: " + sp.getId());
		System.out.println("Ten san pham: " + sp.getTen());
		int temp[] = sp.getGiaTien();
		System.out.print("Gia: ");
		for (int i = 0; i < SanPham.validSize; ++i) {
			System.out.print(ChucNang.chuanHoaGia(temp[i]) + "%-5s");
		}
		System.out.println();
	}
	
	//sap xep theo gia tien
	public static void sxTheoGia(){

	}

	public static SanPham timKiemSPTheoID(String id){
		for(SanPham sp : thucdon){
			if(sp.getId().equalsIgnoreCase(id)){
				return sp;
			}
		}
		return null;
	}

	public static boolean kiemTraID(String id){
		for(SanPham sp : ThucDon.thucdon){
			if(sp.getId().equalsIgnoreCase(id)){
				return false;
			}
		}
		return true;
	}

	public static void ghiDSVaoFile(){
		File file1 = new File("trasua.txt");
		File file2 = new File("caphe.txt");
		try (FileWriter fw1 = new FileWriter(file1, false); FileWriter fw2 = new FileWriter(file2, false)){
			for(SanPham sp : ThucDon.thucdon){
				StringBuilder sb = new StringBuilder();
				sb.append(sp.getId()).append("\t\t").append("#");
				sb.append(sp.getTen()).append("\t\t").append("#");
				int tmp[] = sp.getGiaTien();
				for (int i = 0; i < SanPham.validSize; ++i){
					sb.append(tmp[i]).append("#");
				}
				sb.deleteCharAt(sb.lastIndexOf("#"));
				sb.append(System.lineSeparator());
				if(sp instanceof TraSua){
					fw1.write(sb.toString());
				} else {
					fw2.write(sb.toString());
				}
			}
			fw1.flush();
			fw2.flush();
			fw1.close();
			fw2.close();
		} catch (Exception e) {
			System.out.println("Khong the mo file de ghi san pham");
		}
	}

	public static void setSanPhamVaoFile(String path, SanPham sp){
		try (FileWriter fw = new FileWriter(path, true)){
			StringBuilder sb = new StringBuilder();
			sb.append(sp.getId()).append("\t\t").append("#");
			sb.append(sp.getTen()).append("\t\t").append("#");
			int tmp[] = sp.getGiaTien();
			for (int i = 0; i < SanPham.validSize; ++i){
				sb.append(tmp[i]).append("#");
			}
			sb.deleteCharAt(sb.lastIndexOf("#"));
			sb.append(System.lineSeparator());
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		} catch (Exception err) {
			System.out.println("Khong the mo file de ghi san pham");
		}
	}
}
