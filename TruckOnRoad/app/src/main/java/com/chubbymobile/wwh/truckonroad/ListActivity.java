package com.chubbymobile.wwh.truckonroad;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.chubbymobile.wwh.truckonroad.utility.Adapter;
import com.chubbymobile.wwh.truckonroad.view.ChassisFragment;
import com.chubbymobile.wwh.truckonroad.view.ElectricFragment;
import com.chubbymobile.wwh.truckonroad.view.EngineFragment;
import com.chubbymobile.wwh.truckonroad.view.OneFragment;
import com.chubbymobile.wwh.truckonroad.view.WheelFragment;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private TabLayout tlMain;
    private ViewPager vpMain;
    private Adapter adapter;

    private ArrayList<String> titleList = new ArrayList<String>() {{
        add("MON");
        add("TUE");
        add("WED");
        add("THU");
        add("FRI");
        add("SAT");
        add("SUN");
    }};

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new OneFragment());
        add(new OneFragment());
        add(new OneFragment());
        add(new OneFragment());
        add(new OneFragment());
        add(new OneFragment());
        add(new OneFragment());
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tlMain = (TabLayout) findViewById(R.id.tlMain);
        tlMain.setTabMode(TabLayout.MODE_FIXED);

        vpMain = (ViewPager) findViewById(R.id.vpMain);
        vpMain.setOffscreenPageLimit(7);

        adapter = new Adapter(getSupportFragmentManager(), titleList, fragmentList);
        vpMain.setAdapter(adapter);
        tlMain.setupWithViewPager(vpMain, true);

        setupTabIconsTitles();

        // image should be used instead of text, to avoid line wrap;
        // also switch image when click, adding event here.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tlMain);
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
    }

    private void setupTabIconsTitles() {
        int childCount = 7;
        for (int i = 0; i < childCount; i++) {
            tlMain.getTabAt(i).setText(titleList.get(i));
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_item1) {
            startActivity(new Intent(ListActivity.this, ListActivity.class));
        } else if (id == R.id.nav_item2) {
            startActivity(new Intent(ListActivity.this, ListActivity.class));
        }else if (id == R.id.nav_item3) {
            startActivity(new Intent(ListActivity.this, OnlineBookingActivity.class));
        }else if (id == R.id.nav_item4) {
            startActivity(new Intent(ListActivity.this, ListActivity.class));
        }else if (id == R.id.nav_item5) {
            startActivity(new Intent(ListActivity.this, ListActivity.class));
        }else {
            startActivity(new Intent(ListActivity.this, EmptyActivity.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
