package com.paypal.bfs.test.bookingserv.api.booking;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    ResponseEntity<Booking> create(Booking booking, Map<String, String> headers);

    /**
     * Get all bookings
     *
     * @return all bookings
     */
    ResponseEntity<List<Booking>> getBookings();
}
