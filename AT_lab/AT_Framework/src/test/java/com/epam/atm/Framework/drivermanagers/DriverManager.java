package com.epam.atm.Framework.drivermanagers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            setDriver(browserName);
        }
        return driver;
    }

    public static WebDriver setDriver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "c:\\_webdriver\\chromedriver\\chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setPlatform(Platform.WINDOWS);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "d:\\_webdriver\\chromedriver\\geckodriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setPlatform(Platform.WINDOWS);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}