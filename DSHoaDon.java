import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DSHoaDon {
    private static List<Hoadon> DSHD = new ArrayList<>();
    private static List<CTHD> CTHDList = new ArrayList<>();

    // so luong hoa don
    public static int SLHD = 1;

    public DSHoaDon() {
    }

    public static List<Hoadon> getDSHD() {
        return DSHD;
    }

    public static void setDSHD(List<Hoadon> dSHD) {
        DSHD = dSHD;
    }

    public static List<CTHD> getCTHDList() {
        return CTHDList;
    }

    public static void setCTHDList(List<CTHD> cTHDList) {
        CTHDList = cTHDList;
    }

    public static int getSLHD() {
        return SLHD;
    }

    public static void setSLHD(int sLHD) {
        SLHD = sLHD;
    }

    public static void docHDtuFile(String path) {
		// File file = new File(path);
		try (Scanner scan = new Scanner(new File(path))) {
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] parts = line.split("#");

				String id = parts[0].trim();
				String maNV = parts[1].trim();

                Hoadon hd = new Hoadon();

                hd.setMaHoadon(id);
                hd.setMaNhanvien(maNV);

                NgayThang date = new NgayThang(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));

                hd.setNgayHoadon(date);

                hd.setTienHoadon(Integer.parseInt(parts[5]));

                DSHoaDon.DSHD.add(hd);
			}

		} catch (Exception e) {
			System.out.println("Khong the mo file de doc san pham");
		}
	}

    public static void docCTHDtuFile(String path) {
		// File file = new File(path);
		try (Scanner scan = new Scanner(new File(path))) {
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] parts = line.split("#");

				String idHD = parts[0].trim();
				String tenSP = parts[1].trim();
				
				CTHD cthd = new CTHD();

                cthd.setMaChitetHoadon(idHD);
                cthd.setTen(tenSP);

				cthd.setSize(Integer.parseInt(parts[2]));
                cthd.setSoluongSanpham(Integer.parseInt(parts[3]));
                cthd.setDonGia(Integer.parseInt(parts[4]));

                DSHoaDon.CTHDList.add(cthd);
			}

		} catch (Exception e) {
			System.out.println("Khong the mo file de doc san pham");
		}
	}

    public static void them(int[] dssp, NhanVien nv) {
        Hoadon hoadon = new Hoadon();
        String maHoaDon = "HD" + DSHoaDon.SLHD++;
        hoadon.setMaNhanvien(nv.getId());
        hoadon.setMaHoadon(maHoaDon);

        NgayThang ngayHoaDon = new NgayThang();
        ngayHoaDon.nhapThongTin();

        hoadon.setNgayHoadon(ngayHoaDon);

        // chi tiet hoa don
        List<CTHD> temp = new ArrayList<>();

        int tongTien = 0;

        CTHD cthd = new CTHD();
        cthd.setMaChitetHoadon(maHoaDon);
        for (int i = 0; i < dssp.length; ++i) {
            int ten = i / SanPham.validSize;
            int size = i % SanPham.validSize;

            if (dssp[i] != 0) {
                cthd.setTen(ThucDon.thucdon.get(ten).getTen());
                cthd.setSize(size);
                cthd.setSize(size);
                cthd.setSoluongSanpham(dssp[i]);
                cthd.setDonGia(ThucDon.thucdon.get(ten).getGiaTienAtIndex(size));
                temp.add(cthd);
                double tien = cthd.getDonGia() * cthd.getSoluongSanpham();
                tongTien += tien;
            }
        }
        for (CTHD ctHD : temp) {
            CTHDList.add(ctHD);
        }
        hoadon.setTienHoadon(tongTien);
        DSHD.add(hoadon);
    }

    public void xoa() {

    }

    public void timkiem() {

    }

    public static void xuatToanboHoadon() {
        System.out.println("+===================================+");
        System.out.println("|         DANH SACH HOA DON         |");
        System.out.println("+-----------------------------------+");
        for (Hoadon hoadon : DSHD) {
            hoadon.xuatHoadon();
        }
        System.out.println("+-----------------------------------+");
    }

}
