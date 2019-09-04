package com.epam.atm.Framework.utils;

import com.epam.atm.Framework.drivermanagers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tools {
    private static WebDriver driver = DriverManager.getDriver("chrome");
    public static void highlightRedWithJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }
    public static void clickWithJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }
}