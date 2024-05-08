import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DSNhanVien {
    private ArrayList<NhanVien> dsnv;

    public DSNhanVien(){
        this.dsnv = new ArrayList<NhanVien>();
    }

    public DSNhanVien(ArrayList<NhanVien> dsnv){
        this.dsnv = dsnv;
    }

    public ArrayList<NhanVien> getDSNV(){
        return this.dsnv;
    }

    public void nhapNVtuFile(String path){
        File file = new File(path);
        NhanVien nv = null;
        try (Scanner scan = new Scanner(file)){
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("#");
                switch (Integer.parseInt(parts[0])) {
                    case 1:
                        nv = new nvQuanLi();
                        break;
                    case 2:
                        nv = new nvPhaChe();
                        break;
                    case 3:
                        nv  = new nvDatHang();
                    default:
                        break;
                }
                nv.setId(parts[1]);
                nv.setTen(parts[2]);
                DiaChi dc = new DiaChi(parts[3], parts[4], parts[5], parts[6], parts[7]);
                nv.setDc(dc);
                nv.setSdt(parts[8]);
                nv.setEmail(parts[9]);
                NgayThang ngaysinh = new NgayThang(Integer.parseInt(parts[10]), Integer.parseInt(parts[11]), Integer.parseInt(parts[12]));
                nv.setNgaysinh(ngaysinh);
                this.dsnv.add(nv);
            }
        } catch (Exception e) {
            System.out.println("Khong the mo file");
        }
    }

    public void ghiVaoFile(String filepath){
        
    }
    public void xuatDSNV(){
        sapXepTheoChucVu();
        for(NhanVien nv : this.dsnv){
            nv.xuatThongTin();
            System.out.println();
        }
    }

    private void sapXepTheoChucVu(){
        Collections.sort(this.dsnv, new SoSanhTheoChucVu());
    }

    public static void main(String[] args) {
        DSNhanVien danhsachNV = new DSNhanVien();
        danhsachNV.nhapNVtuFile("NHAN_VIEN.txt");
        danhsachNV.xuatDSNV();
    }
}
