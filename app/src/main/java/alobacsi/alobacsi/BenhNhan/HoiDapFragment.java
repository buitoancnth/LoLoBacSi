package alobacsi.alobacsi.BenhNhan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alobacsi.alobacsi.DTO.ChuyenKhoa;
import alobacsi.alobacsi.DTO.HoiDap;
import alobacsi.alobacsi.R;

public class HoiDapFragment extends Fragment implements HoiDapAdapter.ItemClickListener{
    HoiDapAdapter adapter;
    Toolbar myToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoi_dap, container, false);

        myToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView mTitle = (TextView) view.findViewById(R.id.toolbar_title);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");//Ocultar ActivityBar anterior
        mTitle.setText("Hỏi Đáp");

        List<HoiDap> data = getListData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvHoiDap);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new HoiDapAdapter(getActivity().getApplicationContext(), data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private List<HoiDap> getListData() {
        List<HoiDap> list = new ArrayList<HoiDap>();
        HoiDap hoidap1=new HoiDap("Mình đã 23 tuổi rồi mà vẫn thấy thèm rượu, làm sao để cai rượu bác sĩ.........","20-11-2017");
        HoiDap hoidap2=new HoiDap("Mình đã 23 tuổi rồi mà vẫn thấy thèm rượu, làm sao để cai rượu bác sĩ.........","20-11-2017");
        HoiDap hoidap3=new HoiDap("Mình đã 23 tuổi rồi mà vẫn thấy thèm rượu, làm sao để cai rượu bác sĩ.........","20-11-2017");
        HoiDap hoidap4=new HoiDap("Mình đã 23 tuổi rồi mà vẫn thấy thèm rượu, làm sao để cai rượu bác sĩ.........","20-11-2017");
        HoiDap hoidap5=new HoiDap("Mình đã 23 tuổi rồi mà vẫn thấy thèm rượu, làm sao để cai rượu bác sĩ.........","20-11-2017");


        list.add(hoidap1);
        list.add(hoidap2);
        list.add(hoidap3);
        list.add(hoidap4);
        list.add(hoidap5);

        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        callFragment(new DSBacSiFragment());
    }
    public void callFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.addToBackStack("ChuyenKhoa");
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}
