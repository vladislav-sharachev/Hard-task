package com.epam.vladislav_sharachev.java.lesson7.task1.Excaptions;

public class FieldNotFoundExcaption extends NoSuchFieldException {
    public FieldNotFoundExcaption(String message) {
        super(message);
    }
}
