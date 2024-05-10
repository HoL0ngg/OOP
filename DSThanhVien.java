import java.util.ArrayList;

public class DSThanhVien {
    public static ArrayList<ThanhVien> DSTV = new ArrayList<>();

    public DSThanhVien() {
    }

    public ArrayList<ThanhVien> getDSTV() {
        return DSTV;
    }

    public void setDSTV(ArrayList<ThanhVien> dSTV) {
        DSTV = dSTV;
    }

    public static void themThanhVien(int tong){
        ThanhVien tv = new ThanhVien();
        System.out.println("Xin moi nhap thong tin");
        System.out.print("Nhap ten cua ban: ");
        String ten = ChucNang.chuanHoaChuoi();
        
        //tim kiem trong danh sach coi co ten chua
        for (ThanhVien Thanhvien : DSThanhVien.DSTV){
            if (Thanhvien.getTen().equalsIgnoreCase(ten)){
                Thanhvien.setDiemtichluy(Thanhvien.getDiemtichluy() + tong);
                return;
            }
        }

        tv.nhapThongTin(tong);
    }
}