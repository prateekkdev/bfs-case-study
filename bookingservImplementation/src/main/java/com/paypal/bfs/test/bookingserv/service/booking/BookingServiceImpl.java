package com.paypal.bfs.test.bookingserv.service.booking;

import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;
import com.paypal.bfs.test.bookingserv.data.model.idempotency.IdempotencyEntity;
import com.paypal.bfs.test.bookingserv.data.repository.booking.BookingRepository;
import com.paypal.bfs.test.bookingserv.data.repository.idempotency.IdempotencyRepository;
import com.paypal.bfs.test.bookingserv.impl.ValidationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private IdempotencyRepository idempotencyRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, IdempotencyRepository idempotencyRepository) {
        this.bookingRepository = bookingRepository;
        this.idempotencyRepository = idempotencyRepository;
    }

    @Override
    @Transactional
    public BookingEntity createBooking(BookingEntity bookingEntity, String idempotencyKey) {

        Optional<IdempotencyEntity> key = idempotencyRepository.findById(idempotencyKey);

        if (key.isPresent()) {
            throw new ValidationException("Duplicate request");
        }

        // Done in transaction to ensure idempotency key and booking both are saved as part of transaction
        idempotencyRepository.save(new IdempotencyEntity(idempotencyKey));
        return bookingRepository.save(bookingEntity);
    }

    @Override
    public List<BookingEntity> getAllBookings() {

        List<BookingEntity> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(booking -> bookings.add(booking));
        return bookings;
    }
}
