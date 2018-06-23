package com.chubbymobile.wwh.truckonroad.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.utility.CustomList;
import com.chubbymobile.wwh.truckonroad.utility.log.LogManager;

public class EngineFragment extends Fragment {

    ListView list;
    String[] titles = {
            "Parts Enquiry",
            "Customer Credit",
            "Service History",
            "Settings"
    } ;
    Integer[] images = {
            R.drawable.parts,
            R.drawable.profile,
            R.drawable.history,
            R.drawable.settings
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.engineview, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        CustomList adapter = new CustomList(getActivity(), titles, images);
        list=view.findViewById(R.id.listV);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogManager.getLogger().i("TruckOnRoad", "Triggered: " + titles[+position]);
                //TODO: Add detail act here...
            }
        });
    }
}


