package com.chubbymobile.wwh.truckonroad;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;

public class IntermediateActivity extends Activity {

    private MyHandler myHandler = new MyHandler();
    private MyCountDownTimer mc;

    @BindView(R.id.tv_time) TextView tv_time;
    @BindString(R.string.msgRedirect) String msgRedirect;
    @BindString(R.string.msgIgnore) String msgIgnore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        ButterKnife.bind(this);

        mc = new MyCountDownTimer(3000, 1000);
        mc.start();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startWelcomeActivity();
            }
        }, 3000);

        Uri uri = Uri.parse(getString(R.string.promotionaddress));
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);
    }

    @OnClick(R.id.tv_time)
    public void CancelCount(View arg0) {
        startWelcomeActivity();
    }

    private void startWelcomeActivity(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        myHandler.removeCallbacksAndMessages(null);
        mc.cancel();
    }

    private static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        public void onFinish() {
            tv_time.setText(msgRedirect);
        }

        public void onTick(long millisUntilFinished) {
            tv_time.setText(msgIgnore + "(" + millisUntilFinished / 1000 + ")");
        }
    }
}
