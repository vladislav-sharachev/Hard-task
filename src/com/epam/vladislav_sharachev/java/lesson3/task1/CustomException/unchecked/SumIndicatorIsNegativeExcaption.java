package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked;

final public class SumIndicatorIsNegativeExcaption extends RuntimeException {
    public SumIndicatorIsNegativeExcaption(String message) {
        super(message);
    }
}
