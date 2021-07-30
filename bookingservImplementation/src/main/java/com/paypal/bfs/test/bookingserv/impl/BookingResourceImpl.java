package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;
import com.paypal.bfs.test.bookingserv.impl.mapper.BookingModelMapper;
import com.paypal.bfs.test.bookingserv.service.booking.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookingResourceImpl implements BookingResource {

    private BookingService bookingService;

    public BookingResourceImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST)
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        BookingEntity bookingEntity = bookingService.createBooking(BookingModelMapper.map(booking));
        return ResponseEntity.ok().body(BookingModelMapper.map(bookingEntity));
    }

    @Override
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> getBookings() {

        List<Booking> list = bookingService.getAllBookings()
                .stream()
                .map(bookingEntity -> BookingModelMapper.map(bookingEntity))
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }
}
