package alobacsi.alobacsi;


import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

//    ConstraintLayout clLayout;
//    LayoutInflater layoutInflater;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_tin_tuc:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_hoi_dap:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_trang_chu:
                    //mTextMessage.setText(R.string.title_notifications);
                    callFragment(new HomeUserFragment());
                    getSupportActionBar().setCustomView(R.layout.action_bar_home);
                    return true;
                case R.id.navigation_khoa:
//                   callFragment(new ChuyenKhoaFragment());
                    callFragment(new DSBacSiFragment());
                    getSupportActionBar().setCustomView(R.layout.action_bar_chuyen_khoa);
                    return true;
                case R.id.navigation_tai_khoan:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_home);
        callFragment(new HomeUserFragment());

    }
    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

}
