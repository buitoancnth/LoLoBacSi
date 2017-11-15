package alobacsi.alobacsi;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import alobacsi.alobacsi.DTO.ApiUtils;
import alobacsi.alobacsi.DTO.LoginModel;
import alobacsi.alobacsi.DTO.SOService;

public class LoginActivity extends AppCompatActivity {
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        final EditText email=(EditText) findViewById(R.id.txtEmail);
        final EditText matKhau=(EditText) findViewById(R.id.txtPassword);
        final CheckBox isBacsi=(CheckBox) findViewById(R.id.cbLaBacSi);
        Button dangNhap=(Button) findViewById(R.id.btnDangNhap);
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    mService = ApiUtils.getSOService();
                    LoginModel login=new LoginModel(email.getText().toString(),matKhau.getText().toString(),isBacsi.isChecked());
                    loginHT(login);
                }
                catch (Exception e){
                    e.printStackTrace();
                }


            }
        });



    }
    public void loginHT(LoginModel login) {
        mService.loginHT(login).enqueue(new retrofit2.Callback<Integer>() {
            @Override
            public void onResponse(retrofit2.Call<Integer> call, retrofit2.Response<Integer> response) {
                if(response.isSuccessful()) {
                    //Toast.makeText(getApplicationContext(),response.body().intValue()+"",Toast.LENGTH_LONG).show();
                    if(response.body().intValue()==1){
                        Intent it=new Intent(LoginActivity.this,TrangChuBNActivity.class);
                        startActivity(it);
                    }
                    else if(response.body().intValue()==2){
                        Intent it=new Intent(LoginActivity.this,TrangChuBSActivity.class);
                        startActivity(it);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Tài khoản không hợp lệ",Toast.LENGTH_LONG).show();

                    }
                }else {
                }
            }
            @Override
            public void onFailure(retrofit2.Call<Integer> call, Throwable t) {

            }
        });
    }
}
