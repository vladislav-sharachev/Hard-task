package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.unchecked;

final public class MySortMinusExcaption extends RuntimeException {
    public MySortMinusExcaption(String message) {
        super(message);
    }
}
