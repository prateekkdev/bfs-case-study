package com.paypal.bfs.test.bookingserv.impl.booking;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.impl.ValidationException;
import com.paypal.bfs.test.bookingserv.impl.RequestValidator;
import com.paypal.bfs.test.bookingserv.utils.GenericDateFormatter;
import org.springframework.stereotype.Component;

@Component
public class BookingRequestValidator implements RequestValidator<Booking> {
    @Override
    public void validate(Booking booking) {
        if (booking.getFirstName() == null || booking.getFirstName().isEmpty()) {
            throw new ValidationException("Firstname should not be empty");
        }

        if(booking.getFirstName().length() > 255) {
            throw new ValidationException("Firstname is too large");
        }

        if (booking.getLastName() == null || booking.getLastName().isEmpty()) {
            throw new ValidationException("Lastname should not be empty");
        }

        if (booking.getLastName().length() > 255) {
            throw new ValidationException("Lastname is too large");
        }

        if (booking.getCheckin() == null || booking.getCheckin().isEmpty()) {
            throw new ValidationException("Checkin should not be empty");
        }

        if(!GenericDateFormatter.isCorrectDateTimeFormat(booking.getCheckin())) {
            throw new ValidationException("Checkin date format is not correct");
        }

        if (booking.getCheckout() == null || booking.getCheckout().isEmpty()) {
            throw new ValidationException("Checkout should not be empty");
        }

        if (!GenericDateFormatter.isCorrectDateTimeFormat(booking.getCheckout())) {
            throw new ValidationException("Checkout date format is not correct");
        }

        if (booking.getDob() != null && !booking.getDob().isEmpty() && !GenericDateFormatter.isCorrectDateFormat(booking.getDob())) {
            throw new ValidationException("Date of birth is not in correct format");
        }
    }

    private void validateDateFormat() {

    }
}
