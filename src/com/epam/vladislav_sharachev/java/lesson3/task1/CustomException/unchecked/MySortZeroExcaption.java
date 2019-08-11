package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked;

public class MySortZeroExcaption extends RuntimeException {
    public MySortZeroExcaption(String message) {
        super(message);
    }
}