package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked;

public class ZeroSortingIndicatorExcaption extends RuntimeException {
    public ZeroSortingIndicatorExcaption(String message) {
        super(message);
    }
}