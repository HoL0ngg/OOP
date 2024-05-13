import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DSHoaDon {
    private List<Hoadon> DSHD = new ArrayList<>();
    private List<CTHD> CTHDList = new ArrayList<>();
    // public static List<Object[]> nhanvienList = new ArrayList<>();
    //so luong hoa don
    public static int SLHD = 1;

    public DSHoaDon() {
        // DSHD = data.getHoaDon("hoadon.txt");
        // CTHDList = data.getCTHD("cthd.txt");
    }


    public void them(int[] dssp, NhanVien nv) {
        // System.out.println("+=============================+");
        // System.out.println("|        THEM HOA DON         |");
        // System.out.println("+-----------------------------+");
        Hoadon hoadon = new Hoadon();
        // System.out.print("| Nhap ma hoa don: ");
        String maHoaDon = "HD" + DSHoaDon.SLHD++;
        hoadon.setMaNhanvien(nv.getId());
        hoadon.setMaHoadon(maHoaDon);

        NgayThang ngayHoaDon = new NgayThang();
        ngayHoaDon.nhapThongTin();
        
        hoadon.setNgayHoadon(ngayHoaDon);

        // System.out.println("+-----------------------------+");
        // System.out.println("|       CHI TIET HOA DON      |");
        // System.out.println("+-----------------------------+");

        //chi tiet hoa don
        List<CTHD> temp = new ArrayList<>();

        double tongTien = 0;

        CTHD cthd = new CTHD();
        cthd.setMaChitetHoadon(maHoaDon);
        for (int i = 0 ; i < dssp.length; ++i){
            int ten = i / SanPham.validSize;
			int size = i % SanPham.validSize;

            if (dssp[i] != 0){
                cthd.setId(ThucDon.thucdon.get(ten).getId());
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
    
    // public void xuat() {
    //     System.out.println("+=============================+");
    //     System.out.println("|        XUAT HOA DON         |");
    //     System.out.println("+-----------------------------+");
    //     System.out.printf("| Nhap ma hoa don: ");
    //     String ma = Rangbuoc.rangbuocMaHoadon();
    //     int found = 0;
    //     for (Hoadon hd : DSHD) {
    //         if (hd.getMaHoadon().equals(ma)) {
    //             Rangbuoc.clrscr();
    //             System.out.println("+===============================================================+");
    //             System.out.println("|                           HOA DON                             |");
    //             System.out.println("+---------------------------------------------------------------+");
    //             System.out.printf("| Ma hoa don: %-49s |\n", hd.getMaHoadon());
    //             System.out.printf("| Ma nhan vien: %-47s |\n", hd.getMaNhanvien());
    //             System.out.printf("| Ngay: %-55s |\n", Rangbuoc.traDate(hd.getNgayHoadon()));
    //             System.out.println("+_______________________________________________________________+");
    //             System.out.println("| STT   Ten      Loai    Size    SL      Don gia      Tien      |");
    //             System.out.println("+---------------------------------------------------------------+");
    //             int stt = 1;
    //             for (CTHD cthd : CTHDList) {
    //                 if (cthd.getMaChitetHoadon().equals(ma)) {
    //                     System.out.printf("| %-5s%-9s%-10s%-8s%-6d%-13.2f%-10.2f |\n",
    //                             stt++, getTenSP(cthd.getId()), getLoaiSP(cthd.getId()),
    //                             cthd.getSize(), cthd.getSoluongSanpham(),
    //                             cthd.getDonGia(), cthd.getDonGia() * cthd.getSoluongSanpham());
    //                 }
    //             }
    //             System.out.println("+---------------------------------------------------------------+");
    //             System.out.printf("| Tong tien: %-50.2f |\n", hd.getTienHoadon());
    //             System.out.println("+===============================================================+");
    //             found ++;
    //         }
    //     }
    //     if (found == 0) {
    //         System.out.println("Khong co thong tin hoa don!");
    //         System.out.println("Vui long thu lai!");
    //         return;
    //     }
    // }

    public void xuatToanboHoadon() {
        System.out.println("+===================================+");
        System.out.println("|         DANH SÁCH HÓA ĐƠN         |");
        System.out.println("+-----------------------------------+");
        for (Hoadon hoadon : DSHD) {
            hoadon.xuatHoadon();
        }
        System.out.println("+-----------------------------------+");
    }
//     public void quanlyDanhsachHoadon() {
//         setData();
//         int choose;
//         do {
//             System.out.println("+-----------------------------------------+");
//             System.out.println("|        DANH MUC QUAN LY HOA DON         |");
//             System.out.println("+-----------------------------------------+");
//             System.out.println("|    1. Them hoa don                      |");
//             System.out.println("|    2. Xoa hoa don                       |");
//             System.out.println("|    3. Tim kiem hoa don                  |");
//             System.out.println("|    4. Xuat hoa don                      |");
//             System.out.println("|    5. Xuat toan bo hoa don              |");
//             System.out.println("|    6. Xoa toan bo hoa don               |");
//             System.out.println("|    7. Sua thong tin hoa don             |");
//             System.out.println("|    0. Ket thuc thao tac voi hoa don     |");
//             System.out.println("+-----------------------------------------+");
//             System.out.println("|          Moi chon 1 thao tac !          |");
//             System.out.println("+-----------------------------------------+");
//             choose = Rangbuoc.rangbuocSo();
//             switch (choose) {
//                 case 1:
//                     them();
//                     break;
//                 case 2:
//                     xoa();
//                     break;
//                 case 3:
//                     timkiem();
//                     break;
//                 case 4:
//                     xuat();
//                     break;
// //                case 5:
// //                    break;
// //                case 6:
// //                    List<Hoadon> hoadonsFromFile = readHD();
// //                    hoadonList.addAll(hoadonsFromFile);
// //                    break;
// //                case 7:
// //                    writeHD(hoadonList);
// //                    break;
//                 case 0:
//                     data.setHoaDon(DSHD, "hoadon.txt");
//                     data.setCTHD(CTHDList, "cthd.txt");
//                     System.out.println("Thoat.........");
//                     return;
//             }
//         } while (choose != 0);
//     }

}
