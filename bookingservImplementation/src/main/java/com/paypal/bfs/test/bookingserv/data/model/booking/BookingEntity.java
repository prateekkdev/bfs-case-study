package com.paypal.bfs.test.bookingserv.data.model.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {

    @Id @GeneratedValue
    private int bookingId;

    private String firstName;
    private String lastName;

    private String dob;
    private String checking;
    private String checkout;

    private double totalPrice;
    private double deposit;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}