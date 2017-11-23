package alobacsi.alobacsi.BenhNhan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import alobacsi.alobacsi.DTO.BacSi;
import alobacsi.alobacsi.R;


public class DSBacSiFragment extends Fragment implements DSBacSiAdapter.ItemClickListener{
    DSBacSiAdapter adapter;
    Toolbar myToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ds_bac_si, container, false);


        myToolbar = (Toolbar) view.findViewById(R.id.toolbar);

        TextView mTitle = (TextView) view.findViewById(R.id.toolbar_title);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");//Ocultar ActivityBar anterior
        mTitle.setText("Khoa Tai Mũi Họng");

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    Log.i("MainActivity", "popping backstack");
                    fm.popBackStack();
                } else {
                    Log.i("MainActivity", "nothing on backstack, calling super");
                    getActivity().onBackPressed();
                }

            }

        });
        List<BacSi> data = getListData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvBacSi);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        adapter = new DSBacSiAdapter(getActivity().getApplicationContext(), data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private List<BacSi> getListData() {
        List<BacSi> list = new ArrayList<BacSi>();
        BacSi bs1=new BacSi("Đinh Hữu Quân","img_huu_quan");bs1.setSoSao(1);
        BacSi bs2=new BacSi("Lê Quang Tam","img_anh_nguoi_2");bs2.setSoSao(2);
        BacSi bs3=new BacSi("Bùi Viết Toàn","img_anh_nguoi_3");bs3.setSoSao(3);
        BacSi bs4=new BacSi("Võ Quốc Tin","img_anh_nguoi_4");bs4.setSoSao(3);
        BacSi bs5=new BacSi("Nguyễn Hoàng Thông","img_anh_nguoi_5");bs5.setSoSao(5);
        BacSi bs6=new BacSi("Đinh Hữu Đinh","img_anh_nguoi_6");bs6.setSoSao(4);

        list.add(bs1);list.add(bs2);
        list.add(bs3);list.add(bs4);
        list.add(bs5);list.add(bs6);

        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        callFragment(new CaNhanBSFragment());
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_tim_kiem, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            default:break;
        }

        return false;
    }
    public void callFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.addToBackStack("DSBacSi");
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

}
