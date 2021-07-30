package com.paypal.bfs.test.bookingserv.api.booking;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    ResponseEntity<Booking> create(Booking booking);

    /**
     * Get all bookings
     *
     * @return all bookings
     */
    ResponseEntity<List<Booking>> getBookings();
}