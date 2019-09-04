package com.epam.atm.Frameworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOff extends AbstractPage {

    @FindBy(xpath = "//span[@id='recipient-1']")
    private WebElement userIcon;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement logOff;

    public LogOff(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LogOff logOff() {
        userIcon.click();
        waitForElementToBeClickable(logOff);
        logOff.click();
        return new LogOff(driver);
    }

}