package com.chubbymobile.wwh.truckonroad.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.bean.Booking;
import com.chubbymobile.wwh.truckonroad.presenter.BookingInfoPresenter;

public class WheelFragment extends Fragment implements IShowBookingView {

    private Button btn;
    private TextView model, make, location;
    private ProgressDialog pd = null;
    private BookingInfoPresenter bookingInfoPresenter;

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
        make = view.findViewById(R.id.make);
        location = view.findViewById(R.id.location);

        pd = new ProgressDialog(getActivity());
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
    public void toActivity(Booking booking) {
        model.setText(booking.getModel());
        make.setText(booking.getMake());
        location.setText(booking.getLocation());
    }

    @Override
    public void showFailedError() {
        Toast.makeText(getActivity(), "Failure occurred.", Toast.LENGTH_SHORT).show();
    }
}


