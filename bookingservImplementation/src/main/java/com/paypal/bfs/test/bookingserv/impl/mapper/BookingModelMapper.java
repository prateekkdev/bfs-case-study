package com.paypal.bfs.test.bookingserv.impl.mapper;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.data.model.booking.BookingEntity;

public class BookingModelMapper {

    public static BookingEntity bookingDtoToEntity(Booking booking) {

        return BookingEntity.builder()
                .firstName(booking.getFirstName())
                .lastName(booking.getLastName())
                .checking(booking.getCheckin())
                .checkout(booking.getCheckout())
                .addressLine1(booking.getAddress() == null || booking.getAddress().getLine1() == null ? "" : booking.getAddress().getLine1())
                .addressLine2(booking.getAddress() == null || booking.getAddress().getLine2() == null ? "" : booking.getAddress().getLine2())
                .city(booking.getAddress() == null || booking.getAddress().getCity() == null ? "" : booking.getAddress().getCity())
                .state(booking.getAddress() == null || booking.getAddress().getState() == null ? "" : booking.getAddress().getState())
                .country(booking.getAddress() == null || booking.getAddress().getCountry() == null ? "" : booking.getAddress().getCountry())
                .zipCode(booking.getAddress() == null || booking.getAddress().getZipCode() == null ? "" : booking.getAddress().getZipCode())
                .dob(booking.getDob() == null ? "" : booking.getDob())
                .totalPrice(booking.getTotalPrice())
                .deposit(booking.getDeposit() == null ? 0.0 : booking.getDeposit())
                .build();
    }

    public static Booking bookingEntityToDto(BookingEntity bookingEntity) {

        Booking booking = new Booking();
        booking.setId(bookingEntity.getBookingId());
        booking.setFirstName(bookingEntity.getFirstName());
        booking.setLastName(bookingEntity.getLastName());
        booking.setDob(booking.getDob() == null ? "" : bookingEntity.getDob());
        booking.setCheckin(bookingEntity.getChecking());
        booking.setCheckout(bookingEntity.getCheckout());
        booking.setTotalPrice(bookingEntity.getTotalPrice());
        booking.setDeposit(bookingEntity.getDeposit());

        Address address = new Address();
        address.setLine1(bookingEntity.getAddressLine1());
        address.setLine2(bookingEntity.getAddressLine2());
        address.setCity(bookingEntity.getCity());
        address.setState(bookingEntity.getState());
        address.setCountry(bookingEntity.getCountry());
        address.setZipCode(bookingEntity.getZipCode());

        booking.setAddress(address);

        return booking;
    }

}