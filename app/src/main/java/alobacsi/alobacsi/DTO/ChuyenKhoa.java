package alobacsi.alobacsi.DTO;

/**
 * Created by lequa on 22/11/2017.
 */

public class ChuyenKhoa {
    private int IDChuyenKhoa;
    private String TenChuyenKhoa;
    private String TenAnh="img_khoa";
    public ChuyenKhoa(String tenChuyenKhoa) {
        TenChuyenKhoa = tenChuyenKhoa;
    }

    public ChuyenKhoa(String tenChuyenKhoa, String tenAnh) {
        TenChuyenKhoa = tenChuyenKhoa;
        TenAnh = tenAnh;
    }

    public String getTenChuyenKhoa() {
        return TenChuyenKhoa;
    }

    public void setTenChuyenKhoa(String tenChuyenKhoa) {
        TenChuyenKhoa = tenChuyenKhoa;
    }

    public String getTenAnh() {
        return TenAnh;
    }

    public void setTenAnh(String tenAnh) {
        TenAnh = tenAnh;
    }


}
