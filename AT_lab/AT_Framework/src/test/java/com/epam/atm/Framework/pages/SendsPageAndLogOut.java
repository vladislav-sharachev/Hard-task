package com.epam.atm.Framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SendsPageAndLogOut extends AbstractPage {

    @FindBy(xpath = "//span[text()='Отправленные']")
    private WebElement sends;
    @FindBy(xpath = "//span[contains(text(),'com-epam-at')]")
    private WebElement verifySends;
    @FindBy(xpath = "//span[@id='recipient-1']")
    private WebElement userIcon;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement logOff;

    public SendsPageAndLogOut(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SendsPageAndLogOut verifySends() {
        waitVisibilityOfElementLocated(sends);
        sends.click();
        waitVisibilityOfElementLocated(verifySends);
        Assert.assertTrue(verifySends.isDisplayed());
        return new SendsPageAndLogOut(driver);
    }

    public SendsPageAndLogOut logOut() {
        userIcon.click();
        waitForElementToBeClickable(logOff);
        logOff.click();
        return new SendsPageAndLogOut(driver);
    }
}