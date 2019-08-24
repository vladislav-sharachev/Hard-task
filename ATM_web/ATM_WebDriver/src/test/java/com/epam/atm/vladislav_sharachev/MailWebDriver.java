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
        System.setProperty("webdriver.chrome.driver", "c:\\_webdriver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Maximize browser window via options, just an example
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://yandex.ru"); //открыть страницу

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement yaLoginEnter = driver.findElement(By.xpath
                ("/html/body/div[1]/div[1]/div/div[1]/div/a[1]")); //элемент "Войти"
        yaLoginEnter.click();
        Thread.sleep(3000);


        WebElement yaLoginIn = driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]")); //ввести логин
        yaLoginIn.click();
        yaLoginIn.sendKeys("com-epam-at"); //epamtest123456

        WebElement yaLoginEnter2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]"));
        yaLoginEnter2.click();

        Thread.sleep(3000);

        WebElement yaPassword = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
        yaPassword.click();
        yaPassword.sendKeys("epamtest123456");

        WebElement yaLoginEnter3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/form/div[2]/button[1]"));
        yaLoginEnter3.click();

        Thread.sleep(3000);

        WebElement yaMailLoginTrue = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[2]/div[3]/div[6]/div"));
        Assert.assertTrue(yaMailLoginTrue.isDisplayed(), "No required element on the page!");

        System.out.println("LogIn was successfully done.");

        WebElement yaWriteButton = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[2]/div[3]/div/div[1]/div/div/a"));
        yaWriteButton.click();

        Thread.sleep(3000);


        WebElement yaFillAdress = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/div[1]/label/div[3]/div"));
        WebElement yaSubject = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/label/div[3]/input"));
        WebElement yaMessageBody = driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/div"));

        yaFillAdress.sendKeys("vladislav_sharachev@epam.com");
        yaSubject.sendKeys("Selenium WebDriver AT");
        yaMessageBody.sendKeys("Hi, friend! This is an example of auto test.");
        Thread.sleep(3000);

        WebElement yaChoiceDraft = driver.findElement(By.xpath("//*[@id='nb-1']/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[2]/div/div[3]/div[2]/span/span[1]"));
        yaChoiceDraft.click();

        WebElement yaSelectDraft = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[2]/div[3]/div/div[2]/div[1]/a[5]/span"));
        yaSelectDraft.click();

        WebElement yaSelectDraftMail = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div/div/a/div/span[1]/span[2]/span"));
        yaSelectDraftMail.click();

        System.out.println("All tests were successfully finished.");
    }
}
