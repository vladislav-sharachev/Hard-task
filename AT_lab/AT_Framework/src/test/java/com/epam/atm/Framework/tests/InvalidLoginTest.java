package com.epam.atm.Framework.tests;

import com.epam.atm.Framework.bo.InvalidUserName;
import com.epam.atm.Framework.drivermanagers.DriverManager;
import com.epam.atm.Framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InvalidLoginTest {

    private static WebDriver driver;
    private static final String START_URL = "https://yandex.ru";

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        driver = DriverManager.getDriver("chrome");
        driver.get(START_URL);
    }

    @BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicit wait and maximize window")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "login")
    public void login() {
        new LoginPage(driver).firstEnter().userName(new InvalidUserName());
    }

    @AfterClass(description = "close browser")
    public void kill() {
        driver.quit();
    }
}