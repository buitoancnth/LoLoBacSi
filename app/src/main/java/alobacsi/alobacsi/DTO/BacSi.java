package alobacsi.alobacsi.DTO;

/**
 * Created by lequa on 22/11/2017.
 */

public class BacSi {
    private int IDBacSi;
    private String TenBacSi;
    private int SoSao;
    private String TenAnh;

    public BacSi(String tenBacSi) {
        TenBacSi = tenBacSi;
    }

    public BacSi(String tenBacSi, String tenAnh) {
        TenBacSi = tenBacSi;
        TenAnh = tenAnh;
    }

    public String getTenBacSi() {
        return TenBacSi;
    }

    public void setTenBacSi(String tenBacSi) {
        TenBacSi = tenBacSi;
    }

    public int getSoSao() {
        return SoSao;
    }

    public void setSoSao(int soSao) {
        SoSao = soSao;
    }

    public String getTenAnh() {
        return TenAnh;
    }

    public void setTenAnh(String tenAnh) {
        TenAnh = tenAnh;
    }
}
