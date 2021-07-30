package com.paypal.bfs.test.bookingserv.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericDateFormatter {

    public static Date stringToDateTime(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateTimeToString(Date date) {
        return new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(date);
    }

    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateToString(Date date) {
        return new SimpleDateFormat("MM-dd-yyyy").format(date);
    }

    public static boolean isCorrectDateTimeFormat(String date) {
        if (stringToDateTime(date) == null) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectDateFormat(String date) {
        if (stringToDate(date) == null) {
            return false;
        }
        return true;
    }
}