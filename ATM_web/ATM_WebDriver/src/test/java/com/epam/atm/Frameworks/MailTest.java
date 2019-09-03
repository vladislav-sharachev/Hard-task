package com.epam.atm.Frameworks;

import com.epam.atm.Frameworks.bo.User;
import com.epam.atm.Frameworks.test_classes.*;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MailTest {

    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        driver = new DriverManager(driver).goDriver();
    }

    @Test(description = "login", priority = 1)
    public void login() {
        new LoginPage(driver).open().firstEnter().userName(new User()).userNameEnter().password(new User()).passwordEnter();
    }

    @Test(description = "new letter", priority = 2)
    public void newMail() {
        new NewMailPage(driver).newLetter().fillAdress().subject().body().savedraft();
    }

    @Test(description = "check for drafts", priority = 4)
    public void drafts() throws InterruptedException {
        new DraftPage(driver).drafts().selectTheDraft()
                .verifyAdress().verifySubject().verifyBody().send().draftAgain().verifyNonDraft();
    }

    @Test(description = "go to Yandex Disk", priority = 3)
    public void yandexDisk() {
        new YandexDiskPage(driver).openDisk().deleteImage().restoreImage().openMail();
    }

    @Test(description = "check sends and log off", priority = 5)
    public void sends() {
        new SendsPage(driver).checkSends()
                .verifyLetter().logOffIcon().logOff();
    }

    @AfterClass(description = "close browser")
    public void kill() {
        driver.close();
    }
}