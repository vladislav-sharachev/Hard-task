package com.epam.atm.vladislav_sharachev_advanced.test_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(@class,'mail') and text()='Черновики']")
    private WebElement selectDraft;

    @FindBy(xpath = "//span[contains(text(),'Это сообщение написано')]")
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
    private WebElement getVerifyDraftAgain;


    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DraftPage drafts() {
        waitForElementToBeClickable(selectDraft);
        selectDraft.click();
        return new DraftPage(driver);
    }

    public DraftPage selectTheDraft() {
        waitVisibilityOfElementLocated(verifyDraft);
        verifyDraft.click();
        return new DraftPage(driver);
    }

    public DraftPage verifyAdress() {
        waitVisibilityOfElementLocated(verifyAdress);
        verifyAdress.isDisplayed();
        return new DraftPage(driver);
    }

    public DraftPage verifySubject() {
        verifySubject.isDisplayed();
        return new DraftPage(driver);
    }

    public DraftPage verifyBody() {
        verifyBody.isDisplayed();
        return new DraftPage(driver);
    }

    public DraftPage send() {
        sendLetter.click();
        return new DraftPage(driver);
    }

    public DraftPage draftAgain() throws InterruptedException {
        Thread.sleep(3000); //ждем пока яндекс обработает отправку!
        choiceDraft.click();
        return new DraftPage(driver);
    }

    public DraftPage verifyNonDraft() {
        getVerifyDraftAgain.isDisplayed();
        return new DraftPage(driver);
    }
}