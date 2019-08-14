package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.checked;

final public class InvalidSearchValueExcaption extends Exception{
    public InvalidSearchValueExcaption(String message) {
        super(message);
    }
}
