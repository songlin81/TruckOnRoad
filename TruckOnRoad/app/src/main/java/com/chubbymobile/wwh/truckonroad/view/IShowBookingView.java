package com.chubbymobile.wwh.truckonroad.view;

import com.chubbymobile.wwh.truckonroad.bean.Booking;

public interface IShowBookingView {

    void showLoading();

    void hideLoading();

    void toActivity(Booking booking);

    void showFailedError();

}

