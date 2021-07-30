package com.paypal.bfs.test.bookingserv.booking;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.impl.booking.BookingRequestValidator;
import org.junit.jupiter.api.Test;

class BookingRequestValidatorTest {

    @Test
    public void whenAllOK_ValidationSuccess() {

        BookingRequestValidator validator = new BookingRequestValidator();
        Booking booking = sampleBooking();

        assert false == hasValidationException(booking, validator);
    }

    @Test
    public void whenNoFirstName_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setFirstName(null);

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenFirstNameIsLargerThan255_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setFirstName("slfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkj");

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenNoLastName_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setLastName(null);

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenLastNameIsLargerThan255_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setLastName("slfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkjslfjsdlkfjslkfjsdlkj");

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenNoCheckin_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setCheckin(null);

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenCheckinFormatNotCorrect_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setCheckin("2021/06/31 12:00:00");

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenNoCheckout_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setCheckout(null);

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenCheckoutFormatNotCorrect_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setCheckout("2021/10/31 12:00:00");

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenNoCheckinLaterThanCheckout_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setCheckin("2021-08-31 12:00:00");
        booking.setCheckout("2021-07-31 12:00:00");

        assert true == hasValidationException(booking, validator);
    }

    @Test
    public void whenDateOfBirthFormatNotCorrect_ValidationException() {

        BookingRequestValidator validator = new BookingRequestValidator();

        Booking booking = sampleBooking();
        booking.setDob("2021/08");

        assert true == hasValidationException(booking, validator);
    }

    private boolean hasValidationException(Booking booking, BookingRequestValidator validator) {

        try {
            validator.validate(booking);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private Booking sampleBooking() {

        Booking booking = new Booking();
        booking.setFirstName("Prateek");
        booking.setLastName("Kesarwani");
        booking.setDob("1989-09-17");
        booking.setCheckin("2021-07-31 12:00:00");
        booking.setCheckout("2021-08-01 11:00:00");
        booking.setTotalPrice(8000.00);
        booking.setDeposit(1000.00);

        Address address = new Address();
        address.setLine1("Brigade Lakefront");
        address.setLine2("Whitefield");
        address.setCity("Bengaluru");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipCode("560048");

        booking.setAddress(address);

        return booking;
    }
}