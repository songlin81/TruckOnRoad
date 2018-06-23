package com.chubbymobile.wwh.truckonroad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.chubbymobile.wwh.truckonroad.utility.Adapter;
import com.chubbymobile.wwh.truckonroad.view.ChassisFragment;
import com.chubbymobile.wwh.truckonroad.view.ElectricFragment;
import com.chubbymobile.wwh.truckonroad.view.EngineFragment;
import com.chubbymobile.wwh.truckonroad.view.WheelFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private TabLayout tlMain;
    private ViewPager vpMain;
    private Adapter adapter;

    private int[] tabIcons = {
            R.drawable.engine,
            R.drawable.wheel,
            R.drawable.chassis,
            R.drawable.battery
    };

    private ArrayList<String> titleList = new ArrayList<String>() {{
        add("W");
        add("E");
        add("A");
        add("T");
    }};

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new EngineFragment());
        add(new WheelFragment());
        add(new ElectricFragment());
        add(new ChassisFragment());
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        vpMain.setOffscreenPageLimit(4);

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
            tlMain.getTabAt(i).setText(""); //Put text within the icon image to avoid cut from resize
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_item1) {
            vpMain.setCurrentItem(0);
        } else if (id == R.id.nav_item2) {
            vpMain.setCurrentItem(1);
        }else if (id == R.id.my_account) {
            startActivity(new Intent(MainActivity.this, AccountActivity.class));
        }else {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }else if (id != R.id.action_notifications) {
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
            return true;
        }else {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
