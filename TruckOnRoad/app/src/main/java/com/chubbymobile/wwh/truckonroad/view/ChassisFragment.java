package com.chubbymobile.wwh.truckonroad.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.utility.ItemDecoration;
import com.chubbymobile.wwh.truckonroad.utility.log.ChassisAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChassisFragment extends Fragment {

    GridLayoutManager layoutManager;
    RecyclerView chassis_rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chassisview, container, false);

        chassis_rv = view.findViewById(R.id.ch_rv);

        List<String> dataList = new ArrayList<>();
        dataList.add("Standard variants");
        dataList.add("Optional variants");
        dataList.add("Price list");
        dataList.add("Market place");

        final ChassisAdapter adapter = new ChassisAdapter(dataList);
        chassis_rv.setAdapter(adapter);

        layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isHeader(position) ? layoutManager.getSpanCount() : 1;
            }
        });

        chassis_rv.setLayoutManager(layoutManager);
        chassis_rv.addItemDecoration(new ItemDecoration());

        return view;
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        layoutManager.smoothScrollToPosition(chassis_rv, new RecyclerView.State(), 0);
    }
}

