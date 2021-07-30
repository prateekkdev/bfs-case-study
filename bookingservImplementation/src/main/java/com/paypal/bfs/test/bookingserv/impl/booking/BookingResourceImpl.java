package com.paypal.bfs.test.bookingserv.impl.booking;

import com.paypal.bfs.test.bookingserv.api.booking.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;
import com.paypal.bfs.test.bookingserv.impl.mapper.BookingModelMapper;
import com.paypal.bfs.test.bookingserv.service.booking.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BookingResourceImpl implements BookingResource {

    private BookingService bookingService;
    private BookingRequestValidator bookingValidator;

    public BookingResourceImpl(BookingService bookingService, BookingRequestValidator bookingValidator) {
        this.bookingService = bookingService;
        this.bookingValidator = bookingValidator;
    }

    @Override
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST)
    public ResponseEntity<Booking> create(@RequestBody Booking booking, @RequestHeader Map<String, String> headers) {

        bookingValidator.validate(booking);

        BookingEntity bookingEntity = bookingService.createBooking(BookingModelMapper.bookingDtoToEntity(booking), headers.get("idempotency-key"));
        return ResponseEntity.ok().body(BookingModelMapper.bookingEntityToDto(bookingEntity));
    }

    @Override
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> getBookings() {

        List<Booking> list = bookingService.getAllBookings()
                .stream()
                .map(bookingEntity -> BookingModelMapper.bookingEntityToDto(bookingEntity))
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }
}
