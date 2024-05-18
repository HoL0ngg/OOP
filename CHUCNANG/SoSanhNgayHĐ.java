package CHUCNANG;

import java.util.Comparator;
import HOADON.Hoadon;


public class SoSanhNgayHĐ implements Comparator<Hoadon> {

    @Override
    public int compare(Hoadon o1, Hoadon o2) {
        NgayThang date1 = o1.getNgayHoadon();
        NgayThang date2 = o2.getNgayHoadon();
        if (date1.getNam() != date2.getNam())
            return date1.getNam() - date2.getNam();
        if (date1.getThang() != date2.getThang())
            return date1.getThang() - date2.getThang();
        if (date1.getNgay() != date2.getNgay())
            return date1.getNgay() - date2.getNgay();
        return 0;
    }
    
}
