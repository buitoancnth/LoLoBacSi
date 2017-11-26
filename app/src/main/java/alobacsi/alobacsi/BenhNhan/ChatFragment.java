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

import alobacsi.alobacsi.DTO.Chat;
import alobacsi.alobacsi.R;

public class ChatFragment extends Fragment implements ChatAdapter.ItemClickListener{
    ChatAdapter adapter;
    Toolbar myToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        myToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView mTitle = (TextView) view.findViewById(R.id.toolbar_title);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");//Ocultar ActivityBar anterior
        mTitle.setText("Bac Si Toan");



        List<Chat> data = getListData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvChat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new ChatAdapter(getActivity().getApplicationContext(), data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private List<Chat> getListData() {
        List<Chat> list = new ArrayList<Chat>();
        Chat chat1=new Chat("dk may bac si a",false);
        Chat chat2=new Chat("dk may benh nhan a",true);



        list.add(chat1);
        list.add(chat1);

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
