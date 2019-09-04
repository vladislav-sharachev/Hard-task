package com.epam.atm.Framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DraftsPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(@class,'mail') and text()='Черновики']")
    private WebElement selectDrafts;
    @FindBy(xpath = "//span[text()='com-epam-at']")
    private WebElement verifyDraft;
    @FindBy(xpath = "//span[contains(@data-yabble-name,'com-epam-at')]")
    private WebElement verifyAdress;
    @FindBy(xpath = "//input[@value='Selenium WebDriver AT']")
    private WebElement verifySubject;
    @FindBy(xpath = "//div[contains(text(),'Привет! Это сообщение')]")
    private WebElement verifyBody;
    @FindBy(xpath = "//span[contains(text(),'Отправить')]")
    private WebElement sendLetter;
    @FindBy(xpath = "//span[text()='Черновики']")
    private WebElement choiceDraft;
    @FindBy(xpath = "//div[contains(text(),'нет писем')]")
    private WebElement verifyDraftAgain;


    public DraftsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DraftsPage drafts() {
        waitForElementToBeClickable(selectDrafts);
        selectDrafts.click();
        waitVisibilityOfElementLocated(verifyDraft);
        verifyDraft.click();
        return new DraftsPage(driver);
    }

    public DraftsPage verifyLetter() {
        waitVisibilityOfElementLocated(verifyAdress);
        Assert.assertTrue(verifyAdress.isDisplayed());
        Assert.assertTrue(verifySubject.isDisplayed());
        Assert.assertTrue(verifyBody.isDisplayed());
        return new DraftsPage(driver);
    }

    public DraftsPage send() {
        sendLetter.click();
        return new DraftsPage(driver);
    }

    public DraftsPage verifyNonDraft() throws InterruptedException {
        Thread.sleep(2000); //ждем пока яндекс обработает отправку!
        choiceDraft.click();
        waitVisibilityOfElementLocated(verifyDraftAgain);
        Assert.assertTrue(verifyDraftAgain.isDisplayed());
        return new DraftsPage(driver);
    }
}