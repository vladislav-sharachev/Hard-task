package com.epam.atm.demo1v2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverMailTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "c:\\_webdriver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Maximize browser window via options, just an example
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://yandex.ru"); //открыть страницу
        driver.switchTo().window("yandex.ru");
        System.out.println("Browse was successfully quited.");
    }
}