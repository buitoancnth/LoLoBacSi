package alobacsi.alobacsi.BenhNhan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import alobacsi.alobacsi.R;


public class HomeUserFragment extends Fragment {
    Toolbar myToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_user, container, false);
       myToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView mTitle = (TextView) view.findViewById(R.id.toolbar_title);
       ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
       ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");//Ocultar ActivityBar anterior
        mTitle.setText("Trang Chủ");

        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_thong_bao, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                break;
        }

        return false;
    }
}
