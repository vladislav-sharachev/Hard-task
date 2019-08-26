package com.epam.atm.vladislav_sharachev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverMailTest {

    private WebDriver driver;


    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "c:\\_webdriver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.get("https://yandex.ru");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void loginToTheMail() {

        WebElement enter = driver.findElement(By.xpath("//a[contains(@class,'enter')]")); //элемент "Войти"
        enter.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

        WebElement userName = driver.findElement(By.xpath("//input[contains(@id,'login')]")); //ввести логин
        userName.sendKeys("com-epam-at"); //epamtest123456 - пароль

        WebElement loginSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        loginSubmit.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("epamtest123456");

        WebElement passwordSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        passwordSubmit.click();

    }

    @Test(priority = 2)
    public void assertTheLogin() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mail-User-Name")));
        WebElement assertLogIn = driver.findElement(By.cssSelector("div.mail-User-Name"));
        Assert.assertTrue(assertLogIn.isDisplayed(), "No required element on the page!");
    }

    @Test(priority = 3)
    public void createANewMail() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.mail-ComposeButton")));

        WebElement newLetter = driver.findElement(By.cssSelector("a.mail-ComposeButton"));
        newLetter.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.js-compose-field[name^='to']")));

        WebElement fillAdress = driver.findElement(By.cssSelector("div.js-compose-field[name^='to']"));
        WebElement subject = driver.findElement(By.xpath("//input[contains(@class,'mail-Compose-Field')]"));
        WebElement messageBody = driver.findElement(By.cssSelector("div.cke_wysiwyg_div"));

        fillAdress.sendKeys("com-epam-at@yandex.ru");
        subject.sendKeys("Selenium WebDriver AT");
        messageBody.sendKeys("Привет! Это сообщение написано с помощью Selenium WebDriver." +
                " После написания ждем еще 3 сек - пока Яндекс сохранит черновик :)");
    }

    @Test(priority = 4)
    public void saveMail() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='как черновик']")));
        WebElement selectDraft = driver.findElement(By.xpath("//span[text()='как черновик']"));
        selectDraft.click();
    }

    @Test(priority = 5)
    public void verifyDraft() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'mail') " +
                        "and text()='Черновики']")));

        WebElement selectDraft = driver.findElement(By.xpath("//span[contains(@class,'mail') and text()='Черновики']"));
        selectDraft.click();
    }

    @Test(priority = 6)
    public void verifyDraftContent() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Это сообщение')]")));

        WebElement selectDraftLetter = driver.findElement(By.xpath("//span[contains(text()," +
                "'Это сообщение написано')]"));
        selectDraftLetter.click();

        WebElement verifyFillAdress = driver.findElement(By.xpath("//span[contains(@data-yabble-name," +
                "'com-epam-at')]"));
        Assert.assertTrue(verifyFillAdress.isDisplayed(), "No required element on the page!");

        WebElement verifySubject = driver.findElement(By.xpath("//input[@value='Selenium WebDriver AT']"));
        Assert.assertTrue(verifySubject.isDisplayed(), "No required element on the page!");

        WebElement verifyBody = driver.findElement(By.xpath("//div[contains(text(),'Привет! Это сообщение')]"));
        Assert.assertTrue(verifyBody.isDisplayed(), "No required element on the page!");

    }

    @Test(priority = 7)
    public void sendTheMail() throws InterruptedException {
        WebElement sendMessage = driver.findElement(By.xpath("//span[contains(text(),'Отправить')]"));
        sendMessage.click();

        Thread.sleep(3000); //Тот случай когда нужно подождать 3 сек - пока яндекс обработает отправку письма
    }

    @Test(priority = 8)
    public void verifyDraftAgain() {
        WebElement selectDraft = driver.findElement(By.xpath("//span[text()='Черновики']"));
        selectDraft.click();

        WebElement assertDraft = driver.findElement(By.xpath("//div[contains(text(),'нет писем')]"));
        Assert.assertTrue(assertDraft.isDisplayed(), "No required element on the page!");

    }

    @Test(priority = 9)
    public void verifySends() {
        WebElement selectSent = driver.findElement(By.xpath("//span[text()='Отправленные']"));
        selectSent.click();

        WebElement verifySent = driver.findElement(By.xpath("//span[contains(text(),'com-epam-at')]"));
        Assert.assertTrue(verifySent.isDisplayed(), "No required element on the page!");

    }

    @Test(priority = 10)
    public void logOff() {
        WebElement logOff = driver.findElement(By.xpath("//span[@id='recipient-1']"));
        logOff.click();

        WebElement logOffSelect = driver.findElement(By.xpath("//a[contains(text(),'Выйти')]"));
        logOffSelect.click();
    }

    @AfterClass //выполняется самым последним
    public void stopBrowser() {
        driver.quit();
    }
}