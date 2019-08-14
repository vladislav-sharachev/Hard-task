package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked;

final public class NegativeSortingIndicatorExcaption extends RuntimeException {
    public NegativeSortingIndicatorExcaption(String message) {
        super(message);
    }
}
