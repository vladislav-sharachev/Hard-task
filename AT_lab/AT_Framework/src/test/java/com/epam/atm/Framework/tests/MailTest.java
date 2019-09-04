package com.epam.atm.Framework.tests;

import com.epam.atm.Framework.bo.Message;
import com.epam.atm.Framework.drivermanagers.DriverManager;
import com.epam.atm.Framework.bo.User;
import com.epam.atm.Framework.pages.*;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MailTest {

    private static WebDriver driver;
    private static final String START_URL = "https://yandex.ru";

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        driver = DriverManager.getDriver("chrome");
        driver.get(START_URL);
    }

    @BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicit wait and maximize window")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "login", priority = 1)
    public void login() {
        new LoginPage(driver).firstEnter().userName(new User()).userPassword(new User());
    }

    @Test(description = "new letter", priority = 2)
    public void newMail() {
        new NewMailPage(driver).newLetter().letterText(new Message()).savedraft();
    }

    @Test(description = "go to Yandex Disk", priority = 3)
    public void yandexDisk() {
        new YandexDiskPage(driver).openDisk().deleteImage().restoreImage().openMail();
    }

    @Test(description = "check for drafts", priority = 4)
    public void draftAndSends() throws InterruptedException {
        new DraftsPage(driver).drafts().verifyLetter().send().verifyNonDraft();
    }

    @Test(description = "log off", priority = 5)
    public void logOut() {
        new SendsPageAndLogOut(driver).verifySends().logOut();
    }

    @AfterClass(description = "close browser")
    public void kill() {
        driver.quit();
    }
}