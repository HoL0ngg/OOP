public class test {
	public static void main(String[] args) {
		DSNhanVien dsnv = new DSNhanVien();
		DSHoaDon.docHDtuFile("hoadon.txt");
		DSHoaDon.docCTHDtuFile("cthd.txt");
		DSHoaDon.SLHD = DSHoaDon.getDSHD().size() + 1;
		dsnv.nhapNVtuFile("NHAN_VIEN.txt");
		ThucDon.setDonGiatuFile("trasua.txt");
		ThucDon.setDonGiatuFile("caphe.txt");
		while (true) {
			NhanVien nhanvien = null;
			while (nhanvien == null) {
				System.out.println("+========================================+");
				System.out.println("|         EINHORN COFFE - TEA SHOP       |");
				System.out.println("+----------------------------------------+");
				System.out.println("|                 DANG NHAP              |");
				System.out.println("+----------------------------------------+");
				System.out.print(" Username: ");
				String name = ChucNang.chuanHoaChuoi().trim();
				System.out.print(" Password: ");
				String pass = ChucNang.chuanHoaChuoi().trim();
				for (NhanVien nv : dsnv.getDSNV()){
					// ten dang nhap voi mat khau chua biet xai cai nao
					if (nv.getTen().equals(name) && nv.getSdt().equals(pass)){
						nhanvien = nv;
						break;
					}
				}
			}
			nhanvien.menu();
		}
	}
}
