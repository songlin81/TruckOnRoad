package com.chubbymobile.wwh.truckonroad.model;

import com.chubbymobile.wwh.truckonroad.bean.Booking;

public interface OnBookingInfoListener {

    void getBookingInfoSuccess(Booking booking);

    void getBookingInfoFailed();
}
