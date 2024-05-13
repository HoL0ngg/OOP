import java.util.Comparator;

public class SoSanhDiemTIchLuy implements Comparator<ThanhVien> {

    @Override
    public int compare(ThanhVien o1, ThanhVien o2) {
        return Integer.compare(o1.getDiemtichluy(), o2.getDiemtichluy());
    }
    
}
