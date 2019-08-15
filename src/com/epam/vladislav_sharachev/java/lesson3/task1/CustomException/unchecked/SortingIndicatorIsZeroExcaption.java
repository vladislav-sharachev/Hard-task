package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked;

public class SortingIndicatorIsZeroExcaption extends RuntimeException {
    public SortingIndicatorIsZeroExcaption(String message) {
        super(message);
    }
}