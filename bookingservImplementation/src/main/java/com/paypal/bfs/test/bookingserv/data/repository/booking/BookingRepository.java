package com.paypal.bfs.test.bookingserv.data.repository.booking;

import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {
}
