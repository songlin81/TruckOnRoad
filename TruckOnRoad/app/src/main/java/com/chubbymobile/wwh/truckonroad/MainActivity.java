package com.chubbymobile.wwh.truckonroad;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chubbymobile.wwh.truckonroad.bean.Booking;
import com.chubbymobile.wwh.truckonroad.presenter.BookingInfoPresenter;
import com.chubbymobile.wwh.truckonroad.view.IShowBookingView;

public class MainActivity extends AppCompatActivity implements IShowBookingView{

    private Button btn;
    private TextView model, make, location;
    private ProgressDialog pd = null;
    private BookingInfoPresenter bookingInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookingInfoPresenter = new BookingInfoPresenter(this);
        btn = (Button) findViewById(R.id.resbtn);
        model = (TextView) findViewById(R.id.model);
        make = (TextView) findViewById(R.id.make);
        location = (TextView) findViewById(R.id.location);
        pd = new ProgressDialog(this);
        pd.setMessage("Loading……");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookingInfoPresenter.getBookingInfoToShow(1);
            }
        });
    }

    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.cancel();
    }

    @Override
    public void toMainActivity(Booking booking) {
        model.setText(booking.getModel());
        make.setText(booking.getMake());
        location.setText(booking.getLocation());
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "Failure occurred.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*if (keyCode== KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(MainActivity.this, .class);
            startActivity(intent);
            finish();
        }
        */
        return super.onKeyDown(keyCode, event);
    }
}
