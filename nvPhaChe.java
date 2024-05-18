public class nvPhaChe extends NhanVien {

    public nvPhaChe() {
        super();
    }

    public nvPhaChe(String id, String ten) {
        super(id, ten);
    }

    public nvPhaChe(String id, String ten, DiaChi dc, String sdt, String email, NgayThang ngaysinh) {
        super(id, ten, dc, sdt, email, ngaysinh);
    }

    public void docDonHangTuFile(String filepath) {
        DSHoaDon.docCTHDtuFile(filepath);
    }

    private void xuatDonHang() {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.format("%-1s %5s %-30s %-7s %-5s %-10s %-15s %-1s",
                "|",
                "ID",
                "|  Ten san pham",
                "|  Size",
                "|  SL",
                "|  Don gia",
                "|  Trang thai",
                "|");
        System.out.println();
        System.out.println("+-------------------------------------------------------------------------------+");
        int i = 0;
        for (; i < DSHoaDon.getCTHDList().size() - 1; i++) {
            DSHoaDon.getCTHDList().get(i).xuatThongTin();
            if (!DSHoaDon.getCTHDList().get(i + 1).getMaChitetHoadon()
                    .equalsIgnoreCase(DSHoaDon.getCTHDList().get(i).getMaChitetHoadon())) {
                System.out.println("+-------------------------------------------------------------------------------+");
            }
        }
        DSHoaDon.getCTHDList().get(i).xuatThongTin();
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    private void xulyDonHang() {
        while (true) {
            this.xuatDonHang();
            System.out.println("+===================================+");
            System.out.println("|  0. Thoat                         |");
            System.out.println("|  1. Hoan thanh don hang           |");
            System.out.println("+===================================+");
            int luachon = ChucNang.chuanHoa(0, 1);
            switch (luachon) {
                case 0:
                    return;
                case 1:
                    int index = 0;
                    CTHD cthd = new CTHD();
                    for (CTHD temp : DSHoaDon.getCTHDList()) {
                        if (temp.isHoanthanh()) {
                            ++index;
                            continue;
                        }
                        cthd = DSHoaDon.getCTHDList().get(index);
                        if (temp.getMaChitetHoadon().equalsIgnoreCase(cthd.getMaChitetHoadon())) {
                            temp.setHoanthanh(true);
                        }
                    }
                    DSHoaDon.ghiDSCTHDVaoFile("cthd.txt");
                    break;
            }
        }
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("+===================================+");
            System.out.println("|         NHAN VIEN PHA CHE         |");
            System.out.println("+-----------------------------------+");
            System.out.println("| 0. Dang xuat                      |");
            System.out.println("| 1. Xem don hang                   |");
            System.out.println("| 2. Thong tin ca nhan              |");
            System.out.println("+===================================+");
            int luachon = ChucNang.chuanHoa(0, 2);
            switch (luachon) {
                case 0:
                    return;
                case 1:
                    this.xulyDonHang();
                    break;
                case 2:
                    this.xuatThongTinCaNhan();
                    break;
                default:
                    break;
            }
        }

    }

    public static void main(String[] args) {
        DSHoaDon.docCTHDtuFile("cthd.txt");
        DSHoaDon.docHDtuFile("hoadon.txt");
        nvPhaChe nv = new nvPhaChe();
        nv.menu();
    }
}
