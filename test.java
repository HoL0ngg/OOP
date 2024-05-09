public class test {
	public static void main(String[] args) {
		ThucDon.setDonGiatuFile("trasua.txt");
		ThucDon.setDonGiatuFile("caphe.txt");
		// nvDatHang nvdh = new nvDatHang();
		// nvdh.nhanDonHang();
		nvQuanLi nvql = new nvQuanLi();
		nvDatHang nvdh = new nvDatHang();
		nvql.themSanPham();
		nvdh.nhanDonHang();
	}
}
