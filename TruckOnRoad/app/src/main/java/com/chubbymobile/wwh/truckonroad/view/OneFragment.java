package com.chubbymobile.wwh.truckonroad.view;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.ViewGroup.LayoutParams;

import com.chubbymobile.wwh.truckonroad.DetailActivity;
import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.utility.ListViewAdapter;

public class OneFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView lview1, lview2;
    ListViewAdapter lviewAdapter;

    private final static String entry1[] = {"08:00 - 09:00","09:00 - 10:00","10:00 - 11:00","11:00 - 12:00"};
    private final static String entry2[] = {"0 available", "2 available","0 available", "1 available",};

    private final static String entry3[] = {"13:00 - 14:00","14:00 - 15:00","15:00 - 16:00","17:00 - 18:00"};
    private final static String entry4[] = {"3 available", "2 available","1 available", "1 available",};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.oneview, container, false);

        lview1 = view.findViewById(R.id.listView2);
        lviewAdapter = new ListViewAdapter(getActivity(), entry1, entry2){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                view.setLayoutParams(new ViewGroup.LayoutParams(getScreenWidth(), getScreenHeight()/10));
                return view;
            }
        };
        lview1.setAdapter(lviewAdapter);
        lview1.setOnItemClickListener(this);
        lview2 = view.findViewById(R.id.listView1);
        lviewAdapter = new ListViewAdapter(getActivity(), entry3, entry4);
        lview2.setAdapter(lviewAdapter);
        lview2.setOnItemClickListener(this);
        return view;
    }
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("ticketId", position);
        startActivity(intent);
    }

    private int getScreenHeight() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    private int getScreenWidth() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
}