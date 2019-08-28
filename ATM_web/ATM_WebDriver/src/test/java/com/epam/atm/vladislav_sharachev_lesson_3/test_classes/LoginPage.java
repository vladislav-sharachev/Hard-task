package com.epam.atm.vladislav_sharachev_lesson_3.test_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private static final String URL = "https://yandex.ru";
    private static final String userLogin = "com-epam-at";
    private static final String userPassword = "epamtest123456";

    @FindBy(xpath = "//a[contains(@class,'enter')]")
    private WebElement enter;
    @FindBy(xpath = "//input[contains(@id,'login')]")
    private WebElement loginField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginEnter;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement passwordEnter;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public LoginPage firstEnter() {
        waitVisibilityOfElementLocated(enter);
        enter.click();
        return new LoginPage(driver);
    }

    public LoginPage userName() {
        waitVisibilityOfElementLocated(loginField);
        loginField.sendKeys(userLogin);
        return this;
    }

    public LoginPage userNameEnter() {
        loginEnter.click();
        return new LoginPage(driver);
    }

    public LoginPage password() {
        waitVisibilityOfElementLocated(passwordField);
        passwordField.sendKeys(userPassword);
        return this;
    }

    public LoginPage passwordEnter() {
        passwordEnter.click();
        return new LoginPage(driver);
    }
}