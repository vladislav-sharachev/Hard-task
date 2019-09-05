package com.epam.atm.vladislav_sharachev_lesson_3;

import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.YandexDiskPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.DraftPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.LoginPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.NewMailPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.SendsPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MailTest {

    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {

        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "login", priority = 1)
    public void login() {
        new LoginPage(driver).open().firstEnter().userName().userNameEnter().password().passwordEnter();
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
        driver.quit();
    }
}
