package CHUCNANG;

import java.util.Comparator;
import HOADON.ThongKe;

public class SoSanhNgayTK implements Comparator<ThongKe>{

    @Override
    public int compare(ThongKe o1, ThongKe o2) {
        NgayThang date1 = o1.getNgayTk();
        NgayThang date2 = o2.getNgayTk();
        if (date1.getNam() != date2.getNam())
            return date1.getNam() - date2.getNam();
        if (date1.getThang() != date2.getThang())
            return date1.getThang() - date2.getThang();
        if (date1.getNgay() != date2.getNgay())
            return date1.getNgay() - date2.getNgay();
        return 0;
    }
    
}
