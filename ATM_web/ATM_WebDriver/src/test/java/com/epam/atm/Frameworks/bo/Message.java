package com.epam.atm.Frameworks.bo;

public class Message {
    private static final String ADDRESS = "com-epam-at@yandex.ru";
    private static final String SUBJECT = "Selenium WebDriver AT";
    private static final String BODY = "Привет! Это сообщение написано с помощью Selenium WebDriver.";

    public String getAdress() {
        return ADDRESS;
    }

    public String getSubject() {
        return SUBJECT;
    }

    public String getBody() {
        return BODY;
    }

}