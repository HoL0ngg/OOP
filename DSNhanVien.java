import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static void nhapNVtuFile(String path){
        File file = new File(path);
        try (Scanner scan = new Scanner(file)){
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
