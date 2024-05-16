import java.util.Comparator;

public class SoSanhNgaySinh implements Comparator<ThanhVien> {

    @Override
    public int compare(ThanhVien o1, ThanhVien o2) {
        NgayThang date1 = o1.getNgaysinh();
        NgayThang date2 = o2.getNgaysinh();
        if (date1.getNam() != date2.getNam())
            return date1.getNam() - date2.getNam();
        if (date1.getThang() != date2.getThang())
            return date1.getThang() - date2.getThang();
        if (date1.getNgay() != date2.getNgay())
            return date1.getNgay() - date2.getNgay();
        return 0;
    }
}
