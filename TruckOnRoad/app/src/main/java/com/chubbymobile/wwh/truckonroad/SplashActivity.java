package com.chubbymobile.wwh.truckonroad;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashActivity extends FragmentActivity
        implements Animation.AnimationListener {

    Animation animFadeIn;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    private void init() {
        findViewById(R.id.ivsplash).getLayoutParams().width = getScreenWidth()/2;

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_fade_in);
        animFadeIn.setAnimationListener(this);

        linearLayout = findViewById(R.id.layout_linear);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.startAnimation(animFadeIn);
    }

    public int getScreenWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent i = new Intent(SplashActivity.this, IntermediateActivity.class);
        startActivity(i);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}
