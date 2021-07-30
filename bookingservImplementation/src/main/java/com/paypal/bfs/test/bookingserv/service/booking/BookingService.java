package com.paypal.bfs.test.bookingserv.service.booking;

import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;

import java.util.List;

public interface BookingService {

    BookingEntity createBooking(BookingEntity bookingEntity, String idempotencyKey);

    List<BookingEntity> getAllBookings();
}
