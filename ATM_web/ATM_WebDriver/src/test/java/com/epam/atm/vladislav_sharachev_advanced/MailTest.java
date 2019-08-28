package com.epam.atm.vladislav_sharachev_advanced;

import com.epam.atm.vladislav_sharachev_advanced.test_classes.DraftPage;
import com.epam.atm.vladislav_sharachev_advanced.test_classes.LoginPage;
import com.epam.atm.vladislav_sharachev_advanced.test_classes.NewMailPage;
import com.epam.atm.vladislav_sharachev_advanced.test_classes.SendsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MailTest {

    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "login", priority = 1)
    public void login() {
        new LoginPage(driver).open().firstEnter().userName().userNameEnter().password().passwordEnter();
    }

    @Test(description = "new letter", priority = 2)
    public void newMail() {
        new NewMailPage(driver).newLetter().fillAdress().subject().body().savedraft();
    }

    @Test(description = "check for drafts", priority = 3)
    public void drafts() throws InterruptedException {
        new DraftPage(driver).drafts().selectTheDraft()
                .verifyAdress().verifySubject().verifyBody().send().draftAgain().verifyNonDraft();
    }

    @Test(description = "check sends and log off", priority = 4)
    public void sends() {
        new SendsPage(driver).checkSends()
                .verifyLetter().logOffIcon().logOff();
    }

    @AfterClass(description = "close browser")
    public void kill() {
        driver.close();
    }
}