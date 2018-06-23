package com.chubbymobile.wwh.truckonroad.utility.log;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class ChassisAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String> dataList;

    public ChassisAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public boolean isHeader(int position) {
        return position == 0;
    }
}
