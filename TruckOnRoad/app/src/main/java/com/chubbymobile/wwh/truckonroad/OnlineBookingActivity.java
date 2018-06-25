package com.chubbymobile.wwh.truckonroad;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

public class OnlineBookingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button service, repair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_booking);
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

        service = (Button)findViewById(R.id.buttonService);
        service.getLayoutParams().width = getScreenWidth()/2;
        service.getLayoutParams().height = getScreenHeight()/6;
        repair = (Button)findViewById(R.id.buttonRepair);
        repair.getLayoutParams().width = getScreenWidth()/2;
        repair.getLayoutParams().height = getScreenHeight()/6;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_item1) {
            startActivity(new Intent(OnlineBookingActivity.this, ListActivity.class));
        } else if (id == R.id.nav_item2) {
            startActivity(new Intent(OnlineBookingActivity.this, ListActivity.class));
        }else if (id == R.id.nav_item3) {
            startActivity(new Intent(OnlineBookingActivity.this, OnlineBookingActivity.class));
        }else if (id == R.id.nav_item4) {
            startActivity(new Intent(OnlineBookingActivity.this, ListActivity.class));
        }else if (id == R.id.nav_item5) {
            startActivity(new Intent(OnlineBookingActivity.this, ListActivity.class));
        }else {
            startActivity(new Intent(OnlineBookingActivity.this, EmptyActivity.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private int getScreenWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
    private int getScreenHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }
}
