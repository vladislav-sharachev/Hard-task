package com.epam.atm.vladislav_sharachev_lesson_3;

import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.YandexDiskPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.DraftPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.LoginPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.NewMailPage;
import com.epam.atm.vladislav_sharachev_lesson_3.test_classes.SendsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MailTest {

    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "c:\\_webdriver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "login", priority = 1)
    public void login() throws InterruptedException {
        new LoginPage(driver).open().firstEnter().userName().userNameEnter().password().passwordEnter().jsExecotor();
    }

//    @Test(description = "new letter", priority = 2)
//    public void newMail() {
//        new NewMailPage(driver).newLetter().fillAdress().subject().body().savedraft();
//    }
//
//    @Test(description = "check for drafts", priority = 4)
//    public void drafts() throws InterruptedException {
//        new DraftPage(driver).drafts().selectTheDraft()
//                .verifyAdress().verifySubject().verifyBody().send().draftAgain().verifyNonDraft();
//    }
//
//    @Test(description = "go to Yandex Disk", priority = 3)
//    public void yandexDisk() {
//        new YandexDiskPage(driver).openDisk().deleteImage().restoreImage().openMail();
//    }
//
//    @Test(description = "check sends and log off", priority = 5)
//    public void sends() {
//        new SendsPage(driver).checkSends()
//                .verifyLetter().logOffIcon();
//    }


//    @Test
//    public static void drowBorder(WebElement element, WebDriver driver) {
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("argument[0].style.border='3px solid red'", element);
//    }


//    @AfterClass(description = "close browser")
//    public void kill() {
//        driver.close();
//    }
}