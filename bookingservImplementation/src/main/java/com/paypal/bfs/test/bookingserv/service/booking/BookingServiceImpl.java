package com.paypal.bfs.test.bookingserv.service.booking;

import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;
import com.paypal.bfs.test.bookingserv.data.repository.booking.BookingRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingEntity createBooking(BookingEntity bookingEntity) {
        return bookingRepository.save(bookingEntity);
    }

    @Override
    public List<BookingEntity> getAllBookings() {

        List<BookingEntity> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(booking -> bookings.add(booking));
        return bookings;
    }
}
