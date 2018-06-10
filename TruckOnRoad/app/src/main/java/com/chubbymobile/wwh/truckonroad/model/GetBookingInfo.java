package com.chubbymobile.wwh.truckonroad.model;

import com.chubbymobile.wwh.truckonroad.bean.Booking;

public class GetBookingInfo implements IGetBooking {

    @Override
    public void getBookingInfo(final int id, final OnBookingInfoListener listener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (id == 1) {
                    Booking booking = new Booking();
                    booking.setModel("FH 540 4x2 Tractor");
                    booking.setMake("Volvo");
                    booking.setLocation("Goteborg ARHK");
                    booking.setId("1");
                    listener.getBookingInfoSuccess(booking);
                } else {
                    listener.getBookingInfoFailed();
                }
            }
        }.start();
    }
}
