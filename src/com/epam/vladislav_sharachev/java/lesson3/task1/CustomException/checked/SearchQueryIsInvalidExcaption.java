package com.epam.vladislav_sharachev.java.lesson3.task1.CustomException.checked;

final public class SearchQueryIsInvalidExcaption extends Exception{
    public SearchQueryIsInvalidExcaption(String message) {
        super(message);
    }
}
