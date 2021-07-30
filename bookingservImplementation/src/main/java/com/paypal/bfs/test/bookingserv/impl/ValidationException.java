package com.paypal.bfs.test.bookingserv.impl;

import lombok.Data;

@Data
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
