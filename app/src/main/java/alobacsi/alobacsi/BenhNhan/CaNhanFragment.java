package alobacsi.alobacsi.BenhNhan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alobacsi.alobacsi.R;

/**
 * Created by lequa on 24/11/2017.
 */

public class CaNhanFragment extends Fragment {
    Toolbar myToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ca_nhan, container, false);

        myToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ///TextView mTitle = (TextView) view.findViewById(R.id.toolbar_title);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");//Ocultar ActivityBar anterior

        return view;
    }
}
