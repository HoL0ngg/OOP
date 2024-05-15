public class nvPhaChe extends NhanVien{

    public nvPhaChe(){
        super();
    }

    public nvPhaChe(String id, String ten) {
        super(id, ten);
    }

    public nvPhaChe(String id, String ten, DiaChi dc, String sdt, String email, NgayThang ngaysinh) {
        super(id, ten, dc, sdt, email, ngaysinh);
    }

    public void docDonHangTuFile(String filepath){
        DSHoaDon.docCTHDtuFile(filepath);
    }

    private void xuatDonHang(){
        System.out.println("+---------------------------------------------------------------+");
        System.out.format("%-1s %5s %-30s %-7s %-5s %-10s %-1s",
        "|",
        "ID",
        "|  Ten san pham",
        "|  Size",
        "|  SL",
        "|  Don gia",
        "|");
        System.out.println();
        System.out.println("+---------------------------------------------------------------+");
        // for(CTHD cthd : DSHoaDon.getCTHDList()){
        //     cthd.xuatThongTin();
        // }
        int i = 0;
        for(; i < DSHoaDon.getCTHDList().size() - 1; i++){
            DSHoaDon.getCTHDList().get(i).xuatThongTin();
            if(!DSHoaDon.getCTHDList().get(i + 1).getMaChitetHoadon().equalsIgnoreCase(DSHoaDon.getCTHDList().get(i).getMaChitetHoadon())){
                System.out.println("+---------------------------------------------------------------+");
            }
        }
        DSHoaDon.getCTHDList().get(i).xuatThongTin();
        System.out.println("+---------------------------------------------------------------+");
    }

    private void xulyDonHang(){
        while(true){
            this.xuatDonHang();
            System.out.println("0. Thoat");
            System.out.println("1. Hoan thanh don hang");
            int luachon = ChucNang.chuanHoa(0, 1);
            switch (luachon) {
                case 0:
                    return;
                case 1:
                    CTHD cthd = new CTHD();
                    cthd = DSHoaDon.getCTHDList().get(0);
                    while(DSHoaDon.getCTHDList().get(0).getMaChitetHoadon().equalsIgnoreCase(cthd.getMaChitetHoadon())){
                        DSHoaDon.getCTHDList().removeFirst();
                    }
                    DSHoaDon.ghiDSCTHDVaoFile("cthd.txt");
                    DSHoaDon.getCTHDList().clear();
                    DSHoaDon.docCTHDtuFile("cthd.txt");
                    break;
                default:
                    break;
            }
        }
    }
    @Override
    public void menu() {
        while (true) {
            DSHoaDon.docCTHDtuFile("cthd.txt");
            System.out.println("+===================================+");
            System.out.println("|         NHAN VIEN PHA CHE         |");
            System.out.println("+-----------------------------------+");
            System.out.println("| 1. Xem don hang                   |");
            System.out.println("| 0. Dang xuat                      |");
            System.out.println("+===================================+");
            int luachon = ChucNang.chuanHoa(0, 1);
            switch (luachon) {
                case 0:
                    return;
                case 1:
                    this.xulyDonHang();
                    break;
                default:
                    break;
            }
        }

    }
	public static void main(String[] args) {
        nvPhaChe nvpc = new nvPhaChe();
        nvpc.menu();
    }
}
