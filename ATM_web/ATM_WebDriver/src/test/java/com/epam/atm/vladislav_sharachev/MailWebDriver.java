package com.epam.atm.vladislav_sharachev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MailWebDriver {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Maximize browser window via options, just an example
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://yandex.ru"); //открыть страницу

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement yaLoginEnter = driver.findElement(By.xpath
                ("//a[contains(@class,\"enter\")]")); //элемент "Войти"
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

        WebElement yaMailLoginTrue = driver.findElement(By.cssSelector("div.mail-User-Name"));
        Assert.assertTrue(yaMailLoginTrue.isDisplayed(), "No required element on the page!");

        System.out.println("LogIn was successfully done.");

        WebElement yaWriteButton = driver.findElement(By.cssSelector("a.mail-ComposeButton"));
        yaWriteButton.click();

        Thread.sleep(3000);


        WebElement yaFillAdress = driver.findElement(By.cssSelector("div.js-compose-field[name^='to']"));
        WebElement yaSubject = driver.findElement(By.xpath("//input[contains(@class,'mail-Compose-Field')]"));
        WebElement yaMessageBody = driver.findElement(By.cssSelector("div.cke_wysiwyg_div"));

        yaFillAdress.sendKeys("vladislav_sharachev@epam.com");
        yaSubject.sendKeys("Selenium WebDriver AT");
        yaMessageBody.sendKeys("Hi, friend! This is an example of auto test.");
        Thread.sleep(3000);

        WebElement yaChoiceDraft = driver.findElement(By.xpath("//span[text()='как черновик']"));
        yaChoiceDraft.click();

        WebElement yaSelectDraft = driver.findElement(By.xpath("//span[contains(@class,'mail') and text()='Черновики']"));
        yaSelectDraft.click();

        WebElement yaSelectDraftMail = driver.findElement(By.xpath("//span[contains(text(),'Hi, friend!')]"));
        yaSelectDraftMail.click();

        //div[1]//span[@title='vladislav_sharachev@epam.com']

        System.out.println("All tests were successfully finished.");
    }
}
