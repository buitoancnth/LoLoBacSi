package alobacsi.alobacsi.DTO;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by lequa on 30/10/2017.
 */

public class LoginModel  {

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public Boolean getBacSi() {
        return isBacSi;
    }

    public void setBacSi(Boolean bacSi) {
        isBacSi = bacSi;
    }

    private String Email;
    private  String MatKhau;
    private Boolean isBacSi;

    public LoginModel(String email, String matKhau, Boolean isBacSi) {
        Email = email;
        MatKhau = matKhau;
        this.isBacSi = isBacSi;
    }
}
