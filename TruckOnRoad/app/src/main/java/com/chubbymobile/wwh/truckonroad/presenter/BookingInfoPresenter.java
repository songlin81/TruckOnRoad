package com.chubbymobile.wwh.truckonroad.presenter;

import android.os.Handler;
import com.chubbymobile.wwh.truckonroad.bean.Booking;
import com.chubbymobile.wwh.truckonroad.model.GetBookingInfo;
import com.chubbymobile.wwh.truckonroad.model.IGetBooking;
import com.chubbymobile.wwh.truckonroad.model.OnBookingInfoListener;
import com.chubbymobile.wwh.truckonroad.view.IShowBookingView;

public class BookingInfoPresenter {

    private IGetBooking iGetBooking;
    private IShowBookingView iShowBookingView;
    private Handler mHandler = new Handler();

    public BookingInfoPresenter(IShowBookingView iShowBookingView) {
        this.iShowBookingView = iShowBookingView;
        this.iGetBooking = new GetBookingInfo();
    }

    public void getBookingInfoToShow(int id) {
        iShowBookingView.showLoading();
        iGetBooking.getBookingInfo(id, new OnBookingInfoListener() {

            @Override
            public void getBookingInfoSuccess(final Booking booking) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iShowBookingView.toActivity(booking);
                        iShowBookingView.hideLoading();
                    }
                });
            }

            @Override
            public void getBookingInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iShowBookingView.showFailedError();
                        iShowBookingView.hideLoading();
                    }
                });
            }
        });
    }
}
