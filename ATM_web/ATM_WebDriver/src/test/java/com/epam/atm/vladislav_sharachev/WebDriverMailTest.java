package com.epam.atm.vladislav_sharachev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverMailTest {

    private WebDriver driver;

    @BeforeClass
    public void startBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Maximize browser window via options, just an example
        driver = new ChromeDriver(options);

        driver.get("https://yandex.ru"); //открыть страницу

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void loginToTheMail() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaLoginEnter = driver.findElement(By.xpath("//a[contains(@class,'enter')]")); //элемент "Войти"
        yaLoginEnter.click();
        Thread.sleep(3000);

        WebElement yaLoginIn = driver.findElement(By.xpath("//input[contains(@id,'login')]")); //ввести логин
        yaLoginIn.click();
        yaLoginIn.sendKeys("com-epam-at"); //epamtest123456

        WebElement yaLoginEnter2 = driver.findElement(By.xpath("//button[@type='submit']"));
        yaLoginEnter2.click();

        Thread.sleep(3000);

        WebElement yaPassword = driver.findElement(By.xpath("//input[@type='password']"));
        yaPassword.click();
        yaPassword.sendKeys("epamtest123456");

        WebElement yaLoginEnter3 = driver.findElement(By.xpath("//button[@type='submit']"));
        yaLoginEnter3.click();

        Thread.sleep(3000);

    }

    @Test(priority = 2)
    public void assertTheLogin() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaMailLoginTrue = driver.findElement(By.cssSelector("div.mail-User-Name"));
        Assert.assertTrue(yaMailLoginTrue.isDisplayed(), "No required element on the page!");

        System.out.println("LogIn was successfully done.");
    }

    @Test(priority = 3)
    public void createANewMail() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaWriteButton = driver.findElement(By.cssSelector("a.mail-ComposeButton"));
        yaWriteButton.click();

        Thread.sleep(3000);


        WebElement yaFillAdress = driver.findElement(By.cssSelector("div.js-compose-field[name^='to']"));
        WebElement yaSubject = driver.findElement(By.xpath("//input[contains(@class,'mail-Compose-Field')]"));
        WebElement yaMessageBody = driver.findElement(By.cssSelector("div.cke_wysiwyg_div"));

        yaFillAdress.sendKeys("com-epam-at@yandex.ru");
        yaSubject.sendKeys("Selenium WebDriver AT");
        yaMessageBody.sendKeys("Привет! Это сообщение написано с помощью Selenium WebDriver");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void saveMail() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaChoiceDraft = driver.findElement(By.xpath("//span[text()='как черновик']"));
        yaChoiceDraft.click();
    }

    @Test(priority = 5)
    public void verifyDraft() throws InterruptedException {
        new WebDriverWait(driver, 5);
        Thread.sleep(3000);

        WebElement yaSelectDraft = driver.findElement(By.xpath("//span[contains(@class,'mail') and text()='Черновики']"));
        yaSelectDraft.click();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void verifyDraftContent() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaSelectDraftMail = driver.findElement(By.xpath("//span[text()='Это сообщение написано с помощью Selenium WebDriver']"));
        yaSelectDraftMail.click();

        WebElement yaVerifyTo = driver.findElement(By.xpath("//span[contains(@data-yabble-name,'com-epam-at')]"));
        Assert.assertTrue(yaVerifyTo.isDisplayed(), "No required element on the page!");

        WebElement yaVerifySubject = driver.findElement(By.xpath("//input[@value='Selenium WebDriver AT']"));
        Assert.assertTrue(yaVerifySubject.isDisplayed(), "No required element on the page!");

        WebElement yaVerifyBody = driver.findElement(By.xpath("//div[contains(text(),'Привет! Это сообщение написано с помощью Selenium WebDriver')]"));
        Assert.assertTrue(yaVerifyBody.isDisplayed(), "No required element on the page!");

    }

    @Test(priority = 7)
    public void sendTheMail() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaSendMessage = driver.findElement(By.xpath("//span[contains(text(),'Отправить')]"));
        yaSendMessage.click();

        Thread.sleep(3000);
    }

    @Test(priority = 8)
    public void verifyDraftAgain() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaSelectDraft2 = driver.findElement(By.xpath("//span[text()='Черновики']"));
        yaSelectDraft2.click();

        WebElement yaAssertDraft = driver.findElement(By.xpath("//div[contains(text(),'нет писем')]"));
        Assert.assertTrue(yaAssertDraft.isDisplayed(), "No required element on the page!");

        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void verifySends() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaSelectSends = driver.findElement(By.xpath("//span[text()='Отправленные']"));
        yaSelectSends.click();

        WebElement yaVerifySends = driver.findElement(By.xpath("//span[contains(text(),'com-epam-at')]"));
        Assert.assertTrue(yaVerifySends.isDisplayed(), "No required element on the page!");

        Thread.sleep(3000);
    }
    @Test(priority = 10)
    public void logOff() throws InterruptedException {
        new WebDriverWait(driver, 5);
        WebElement yaLogOff = driver.findElement(By.xpath("//span[@id='recipient-1']"));
        yaLogOff.click();

        WebElement yaLogOffSelect = driver.findElement(By.xpath("//a[contains(text(),'Выйти')]"));
        yaLogOffSelect.click();
    }

        @AfterClass //выполняется самым последним
        public void afterClass() {
            System.out.println("All tests were successfully finished.");
        }
}