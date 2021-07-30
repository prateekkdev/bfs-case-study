package com.paypal.bfs.test.bookingserv.data.model.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {

    @Id @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    private Date dob;
    private Date checking;
    private Date checkout;

    private double totalPrice;
    private double deposit;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}