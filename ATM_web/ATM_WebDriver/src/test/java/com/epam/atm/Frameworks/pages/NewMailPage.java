package com.epam.atm.Frameworks.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewMailPage extends AbstractPage {

    private static final String adress = "com-epam-at@yandex.ru";
    private static final String subject = "Selenium WebDriver AT";
    private static final String body = "Привет! Это сообщение написано с помощью Selenium WebDriver.";

    @FindBy(css = "div.mail-User-Name")
    private WebElement verifyLogin;
    @FindBy(css = "div.js-compose-field[name^='to']")
    private WebElement AdressField;
    @FindBy(xpath = "//input[contains(@class,'mail-Compose-Field')]")
    private WebElement subjectField;
    @FindBy(css = "div.cke_wysiwyg_div")
    private WebElement bodyField;
    @FindBy(xpath = "//span[text()='Сохранить и перейти']")
    private WebElement saveDraft;
    @FindBy(xpath = "//span[text()='Черновики']")
    private WebElement draft;

    public NewMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public NewMailPage newLetter() {
        waitVisibilityOfElementLocated(verifyLogin);
        Assert.assertTrue(verifyLogin.isDisplayed());
        new Actions(driver).sendKeys("w").build().perform();
        return new NewMailPage(driver);
    }

    public NewMailPage fillAdress() {
        waitForElementToBeClickable(AdressField);
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
        waitVisibilityOfElementLocated(bodyField);
        new Actions(driver).sendKeys(draft, Keys.chord(Keys.CONTROL, "s")).build().perform();
        waitForElementToBeClickable(saveDraft);
        saveDraft.click();
        return new NewMailPage(driver);
    }

}