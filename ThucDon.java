import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ThucDon {
	public static ArrayList<SanPham> thucdon = new ArrayList<SanPham>();

	public ThucDon() {
	}

	public static void setDonGiatuFile(String path) {
		File file = new File(path);
		try (Scanner scan = new Scanner(file)) {
//			System.out.println("hehe");
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] parts = line.split("#");

				String id = parts[0].trim();
				String ten = parts[1].trim();
				
				SanPham.maxLength = ten.length() > SanPham.maxLength ? ten.length() : SanPham.maxLength;
				
				SanPham sp = null;

				if (path == "trasua.txt") {
					sp = new TraSua(id, ten);
				} else if (path == "caphe.txt") {
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
			// TODO: handle exception
		}
	}

	public static void xuatMenu(int loai) {
		if (loai == 1) {
			System.out.println("--------------------- Tra sua ---------------------");
			int cntTab = SanPham.maxLength / 8;
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
					for (int j = lengthTS; j <= cntTab; ++j) {
						System.out.print("\t");
					}
					
					
					int banggia[] = ts.getGiaTien();
					for (int j = 0; j < SanPham.validSize; ++j) {
						System.out.print(banggia[j] + "\t");
					}
					System.out.println();
				}
			}
			System.out.println();
		} else if (loai == 2){
			System.out.println("--------------------- Ca phe ---------------------");
			int cntTab = SanPham.maxLength / 8;
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
					int lengthTS = (sp.getTen().length() + 3) / 8;
					for (int j = lengthTS; j <= cntTab; ++j) {
						System.out.print("\t");
					}
	
					int banggia[] = cf.getGiaTien();
					for (int j = 0; j < SanPham.validSize; ++j) {
						System.out.print(banggia[j] + "\t");
					}
					System.out.println();
				}
			}
			System.out.println();
		} else {
			xuatMenu(1);
			xuatMenu(2);
		}
	}

}