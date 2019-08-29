package com.epam.atm.vladislav_sharachev_lesson_3.test_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SendsPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Отправленные']")
    private WebElement sends;
    @FindBy(xpath = "//span[contains(text(),'com-epam-at')]")
    private WebElement verifySends;
    @FindBy(xpath = "//span[@id='recipient-1']")
    private WebElement userIcon;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement logOff;

    public SendsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SendsPage checkSends() {
        waitVisibilityOfElementLocated(sends);
        sends.click();
        return new SendsPage(driver);
    }

    public SendsPage verifyLetter() {
        waitVisibilityOfElementLocated(verifySends);
        Assert.assertTrue(verifySends.isDisplayed());
        return new SendsPage(driver);
    }

    public SendsPage logOffIcon() {
        userIcon.click();
        return new SendsPage(driver);
    }

    public SendsPage logOff() {
        logOff.click();
        return new SendsPage(driver);
    }

}