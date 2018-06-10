package com.chubbymobile.wwh.truckonroad.startup;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class PPApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

