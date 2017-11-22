package alobacsi.alobacsi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import alobacsi.alobacsi.DTO.ChuyenKhoa;

/**
 * Created by lequa on 21/11/2017.
 */

public class ChuyenKhoaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_chuyen_khoa, container, false);
        List<ChuyenKhoa> ck = getListData();
        GridView gv = (GridView)view.findViewById(R.id.gvChuyenKhoa)  ;
        gv.setAdapter(new ChuyenKhoaAdapter(getActivity().getApplicationContext(), ck));
        // Inflate the layout for this fragment



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
}
