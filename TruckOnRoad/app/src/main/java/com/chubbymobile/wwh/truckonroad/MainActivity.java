package com.chubbymobile.wwh.truckonroad;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import com.chubbymobile.wwh.truckonroad.utility.Adapter;
import com.chubbymobile.wwh.truckonroad.view.ChassisFragment;
import com.chubbymobile.wwh.truckonroad.view.ElectricFragment;
import com.chubbymobile.wwh.truckonroad.view.EngineFragment;
import com.chubbymobile.wwh.truckonroad.view.WheelFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private TabLayout tlMain;
    private ViewPager vpMain;
    private Adapter adapter;

    private int[] tabIcons = {
            R.drawable.wheel,
            R.drawable.chassis,
            R.drawable.battery,
            R.drawable.engine
    };

    private ArrayList<String> titleList = new ArrayList<String>() {{
        add("W");
        add("E");
        add("A");
        add("T");
    }};

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new WheelFragment());
        add(new ChassisFragment());
        add(new ElectricFragment());
        add(new EngineFragment());
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tlMain = (TabLayout) findViewById(R.id.tlMain);
        tlMain.setTabMode(TabLayout.MODE_FIXED);

        vpMain = (ViewPager) findViewById(R.id.vpMain);

        adapter = new Adapter(getSupportFragmentManager(), titleList, fragmentList);
        vpMain.setAdapter(adapter);
        tlMain.setupWithViewPager(vpMain, true);

        setupTabIconsTitles();
        getLineIndicator();
    }

    private void setupTabIconsTitles() {
        int childCount = 4;
        for (int i = 0; i < childCount; i++) {
            tlMain.getTabAt(i).setIcon(tabIcons[i]);
            tlMain.getTabAt(i).setText("");
        }
    }

    private void getLineIndicator() {
        tlMain.setRotationX(180);
        LinearLayout tabListed = ((LinearLayout) tlMain.getChildAt(0));
        for(int position = 0;position<tabListed.getChildCount();position++) {
            LinearLayout item=((LinearLayout) tabListed.getChildAt(position));
            item.setRotationX(180);
        }
    }
}
