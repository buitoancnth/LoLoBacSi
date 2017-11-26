package alobacsi.alobacsi.BenhNhan;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import alobacsi.alobacsi.R;


public class LoginActivity extends AppCompatActivity{

    private TextView quenMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        quenMatKhau = (TextView) findViewById(R.id.quenmatkhau);
        quenMatKhau.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showDialogQuenMatKhau();
            }

        });
    }
    public void showDialogQuenMatKhau() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_fogetpassword);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

}

