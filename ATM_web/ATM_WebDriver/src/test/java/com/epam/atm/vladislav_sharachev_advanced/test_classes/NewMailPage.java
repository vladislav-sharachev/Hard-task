package com.epam.atm.vladislav_sharachev_advanced.test_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMailPage extends AbstractPage {

    private static final String adress = "com-epam-at@yandex.ru";
    private static final String subject = "Selenium WebDriver AT";
    private static final String body = "Привет! Это сообщение написано с помощью Selenium WebDriver." +
            " После написания ждем еще 5 сек - пока Яндекс сохранит черновик :)";

    @FindBy(css = "div.mail-User-Name")
    private WebElement verifyLogin;

    @FindBy(css = "a.mail-ComposeButton")
    private WebElement newLetter;

    @FindBy(css = "div.js-compose-field[name^='to']")
    private WebElement AdressField;

    @FindBy(xpath = "//input[contains(@class,'mail-Compose-Field')]")
    private WebElement subjectField;

    @FindBy(css = "div.cke_wysiwyg_div")
    private WebElement bodyField;

    @FindBy(xpath = "//span[text()='как черновик']")
    private WebElement saveDraft;

    public NewMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public NewMailPage newLetter() {
        waitVisibilityOfElementLocated(verifyLogin);
        newLetter.click();
        return new NewMailPage(driver);
    }

    public NewMailPage fillAdress() {
        waitVisibilityOfElementLocated(AdressField);
        AdressField.sendKeys(adress);
        return this;
    }

    public NewMailPage subject() {
        subjectField.sendKeys(subject);
        return this;
    }

    public NewMailPage body() {
        bodyField.sendKeys(body);
        return this;
    }

    public NewMailPage savedraft() {
        waitVisibilityOfElementLocated(saveDraft);
        saveDraft.click();
        return new NewMailPage(driver);
    }

}