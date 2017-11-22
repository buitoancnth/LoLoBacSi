package alobacsi.alobacsi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;
import alobacsi.alobacsi.DTO.BacSi;


public class DSBacSiFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_ds_bac_si, container, false);
        List<BacSi> ck = getListData();
        GridView gv = (GridView)view.findViewById(R.id.gvBacSi)  ;
        gv.setAdapter(new DSBacSiAdapter(getActivity().getApplicationContext(), ck));
        // Inflate the layout for this fragment



        return view;
    }
    private List<BacSi> getListData() {
        List<BacSi> list = new ArrayList<BacSi>();
        BacSi bs1=new BacSi("Đinh Hưu Quân","img_huu_quan");bs1.setSoSao(1);
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
}
