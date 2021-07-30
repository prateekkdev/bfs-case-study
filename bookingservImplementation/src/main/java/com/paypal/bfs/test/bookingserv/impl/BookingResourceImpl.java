package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BookingResourceImpl implements BookingResource {
    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        return null;
    }

    @Override
    public ResponseEntity<List<Booking>> getBookings() {
        return null;
    }
}
