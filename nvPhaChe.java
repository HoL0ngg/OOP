public class nvPhaChe extends NhanVien{

    @Override
    public void menu() {
        // TODO Auto-generated method stub
        while (true) {
            System.out.println("+===================================+");
            System.out.println("|         NHAN VIEN PHA CHE         |");
            System.out.println("+-----------------------------------+");
            System.out.println("| 1. Xem don hang                   |");
            System.out.println("| 0. Dang xuat                      |");
            System.out.println("+===================================+");
            int luachon = ChucNang.chuanHoa(0, 1);
            if (luachon == 0) break;
        }

    }
	
}
