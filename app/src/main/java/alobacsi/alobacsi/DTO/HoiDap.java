package alobacsi.alobacsi.DTO;

import java.util.Date;

/**
 * Created by lequa on 26/11/2017.
 */

public class HoiDap {
    private  String TenCauHoi;
    private String NgayHoi;

    public HoiDap(String tenCauHoi, String ngayHoi) {
        TenCauHoi = tenCauHoi;
        NgayHoi = ngayHoi;
    }

    public String getTenCauHoi() {
        return TenCauHoi;
    }

    public void setTenCauHoi(String tenCauHoi) {
        TenCauHoi = tenCauHoi;
    }

    public String getNgayHoi() {
        return NgayHoi;
    }

    public void setNgayHoi(String ngayHoi) {
        NgayHoi = ngayHoi;
    }
}
