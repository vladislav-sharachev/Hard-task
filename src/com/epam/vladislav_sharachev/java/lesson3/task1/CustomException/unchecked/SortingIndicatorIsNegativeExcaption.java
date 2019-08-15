package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked;

final public class SortingIndicatorIsNegativeExcaption extends RuntimeException {
    public SortingIndicatorIsNegativeExcaption(String message) {
        super(message);
    }
}
