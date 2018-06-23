package com.chubbymobile.wwh.truckonroad.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.bean.Parts;
import com.chubbymobile.wwh.truckonroad.presenter.PartsInfoPresenter;
import com.chubbymobile.wwh.truckonroad.utility.ItemListBaseAdapter;
import com.chubbymobile.wwh.truckonroad.utility.log.LogManager;

import java.util.ArrayList;

public class ElectricFragment extends Fragment implements IShowPartsView {

    ItemListBaseAdapter mAdapter;
    private PartsInfoPresenter partsInfoPresenter;
    private ListView lv1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.electricview, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv1 = view.findViewById(R.id.listV);
        partsInfoPresenter = new PartsInfoPresenter(this);
    }

    @Override
    public void toActivity(ArrayList<Parts> parts) {
        mAdapter = new ItemListBaseAdapter(getActivity(), parts);
        lv1.setAdapter(mAdapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                Parts obj_itemDetails = (Parts)o;
                mAdapter.setSelectedIndex(position);
                mAdapter.notifyDataSetChanged();
                LogManager.getLogger().i("TruckOnRoad", "Triggered: " + obj_itemDetails.getName());
            }
        });
    }

}


