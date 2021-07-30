package com.paypal.bfs.test.bookingserv.impl;


public interface RequestValidator<T> {
    void validate(T obj);
}
