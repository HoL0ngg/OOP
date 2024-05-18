package CHUCNANG;
import java.util.Comparator;

import NHANVIEN.NhanVien;
import NHANVIEN.nvPhaChe;
import NHANVIEN.nvQuanLi;

public class SoSanhTheoChucVu implements Comparator<NhanVien>{

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        int num1;
        int num2;
        if (o1 instanceof nvQuanLi){
            num1 = 1;
        } else {
            if(o1 instanceof nvPhaChe){
                num1 = 2;
            } else {
                num1 = 3;
             }
        }
        if (o2 instanceof nvQuanLi){
            num2 = 1;
        } else {
            if(o2 instanceof nvPhaChe){
                num2 = 2;
            } else {
                num2 = 3;
             }
        }
        return num1 - num2;
    }
    
}
