package com.paypal.bfs.test.bookingserv.impl.mapper;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;

public class BookingModelMapper {

    public static BookingEntity map(Booking booking) {

        return BookingEntity.builder()
                .firstName(booking.getFirstName())
                .lastName(booking.getLastName())
                .addressLine1(booking.getAddress().getLine1())
                .addressLine2(booking.getAddress().getLine2())
                .city(booking.getAddress().getCity())
                .state(booking.getAddress().getState())
                .country(booking.getAddress().getCountry())
                .zipCode(booking.getAddress().getZipCode())
                .dob(booking.getDob())
                .totalPrice(booking.getTotalPrice())
                .deposit(booking.getDeposit())
                .build();
    }

    public static Booking map(BookingEntity bookingEntity) {

        Booking booking = new Booking();

        Address address = new Address();
        address.setLine1(bookingEntity.getAddressLine1());
        address.setLine2(bookingEntity.getAddressLine2());
        address.setCity(bookingEntity.getCity());
        address.setState(bookingEntity.getState());
        address.setCountry(bookingEntity.getCountry());
        address.setZipCode(bookingEntity.getZipCode());

        booking.setAddress(address);
        booking.setFirstName(bookingEntity.getFirstName());
        booking.setLastName(bookingEntity.getLastName());
        booking.setDob(bookingEntity.getDob());
        booking.setTotalPrice(bookingEntity.getTotalPrice());
        booking.setDeposit(bookingEntity.getDeposit());

        return booking;
    }

}