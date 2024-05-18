package HOADON;

import java.util.ArrayList;

public class ThongKe {
    
    private ArrayList<PhieuThongKe> DSPTK;
    
    public ThongKe(){
        this.DSPTK = new ArrayList<>();
    }
    
    public void themPhieuThongke(PhieuThongKe phieu){
        DSPTK.add(phieu);
    }
    
    //Thống kê doanh thu theo tháng
    public double ThongKeTheoThang(int thang, int nam){
        double tongDoanhthu = 0.0;
        for(PhieuThongKe phieu: DSPTK){
            if(phieu.getNgay().getThang() == thang && phieu.getNgay().getThang() == nam){
                tongDoanhthu += phieu.ThongkeNgay();
            }
        }
        return tongDoanhthu;
    }
    
    //Thống kê doanh thu theo quý
    public double ThongKeTheoQuy(int quy, int nam){
        double tongDoanhthu = 0.0;
        for(PhieuThongKe phieu : DSPTK){
            int thang = phieu.getNgay().getThang();
            int quytheothang = (int) Math.ceil(thang / 3.0);
            if(quytheothang == quy && phieu.getNgay().getNam() == nam){
                tongDoanhthu += phieu.ThongkeNgay();
            }
        }
        return tongDoanhthu;
    }
    
    //Thống kê doanh thu theo năm
    public double ThongKeTheoNam(int nam){
        double tongDoanhthu = 0.0;
        for(PhieuThongKe phieu : DSPTK){
            if(phieu.getNgay().getNam() == nam){
                tongDoanhthu += phieu.ThongkeNgay();
            }
        }
        return tongDoanhthu;
    }
    
    public static void main(String[] args){
        ThongKe thongKe = new ThongKe();
        
        
    }
}
