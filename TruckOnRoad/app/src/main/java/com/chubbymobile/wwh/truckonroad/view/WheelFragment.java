package com.chubbymobile.wwh.truckonroad.view;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.bean.Booking;
import com.chubbymobile.wwh.truckonroad.presenter.BookingInfoPresenter;
import com.chubbymobile.wwh.truckonroad.utility.log.LogManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class WheelFragment extends Fragment implements IShowBookingView {

    private Button btn;
    private TextView model;
    private ProgressDialog pd = null;
    private BookingInfoPresenter bookingInfoPresenter;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText edittext;
    int result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wheelview, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bookingInfoPresenter = new BookingInfoPresenter(this);

        btn = view.findViewById(R.id.resbtn);
        model = view.findViewById(R.id.model);

        pd = new ProgressDialog(getActivity());
        pd.setMessage("Loading……");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookingInfoPresenter.getBookingInfoToShow(result);
                LogManager.getLogger().i("TruckOnRoad", "reserve ticket: " + result);
            }
        });

        myCalendar = Calendar.getInstance();

        edittext = view.findViewById(R.id.date);
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                dsUpdates();
            }
        };

        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void dsUpdates() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy", Locale.US);
        result = myCalendar.get(Calendar.DAY_OF_MONTH);
        edittext.setText("Chosen: "+sdf.format(myCalendar.getTime()));
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
    public void toActivity(Booking booking) {
        model.setText(booking.getModel()+" reserved.");
    }

    @Override
    public void showFailedError() {
        Toast.makeText(getActivity(), "Fail to reserve.", Toast.LENGTH_SHORT).show();
    }
}


