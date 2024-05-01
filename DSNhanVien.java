import java.util.ArrayList;

public class DSNhanVien {
    private static ArrayList<NhanVien> dsnv;

    public DSNhanVien(){
        DSNhanVien.dsnv = new ArrayList<NhanVien>();
    }

    public DSNhanVien(ArrayList<NhanVien> dsnv){
        DSNhanVien.dsnv = dsnv;
    }

    public ArrayList<NhanVien> getDSNV(){
        return DSNhanVien.dsnv;
    }
}
