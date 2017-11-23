package alobacsi.alobacsi.BenhNhan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alobacsi.alobacsi.DTO.ChuyenKhoa;
import alobacsi.alobacsi.R;

/**
 * Created by lequa on 21/11/2017.
 */

public class ChuyenKhoaFragment extends Fragment implements ChuyenKhoaAdapter.ItemClickListener{
    ChuyenKhoaAdapter adapter;
    Toolbar myToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {






        View view = inflater.inflate(R.layout.fragment_chuyen_khoa, container, false);

        myToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView mTitle = (TextView) view.findViewById(R.id.toolbar_title);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");//Ocultar ActivityBar anterior
        mTitle.setText("Chuyên Khoa");



        List<ChuyenKhoa> data = getListData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvChuyenKhoa);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        adapter = new ChuyenKhoaAdapter(getActivity().getApplicationContext(), data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private List<ChuyenKhoa> getListData() {
        List<ChuyenKhoa> list = new ArrayList<ChuyenKhoa>();
        ChuyenKhoa dongy=new ChuyenKhoa("Đông Y","img_khoa_dong_y");
        ChuyenKhoa rang=new ChuyenKhoa("Răng","img_khoa_rang");
        ChuyenKhoa nhi=new ChuyenKhoa("Nhi","img_khoa_nhi");
        ChuyenKhoa san=new ChuyenKhoa("Sản","img_khoa_san");
        ChuyenKhoa tmh=new ChuyenKhoa("Tai Mũi Họng","img_khoa_tai_mui_hong");
        ChuyenKhoa ctch=new ChuyenKhoa("Chấn Thương","img_khoa_chan_thuong_chinh_hinh");


        list.add(dongy);
        list.add(rang);
        list.add(nhi);list.add(san);
        list.add(tmh);
        list.add(ctch);

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
