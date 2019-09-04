package com.epam.atm.Framework.pages;

import com.epam.atm.Framework.bo.InvalidUserName;
import com.epam.atm.Framework.bo.User;
import com.epam.atm.Framework.utils.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class,'enter')]")
    private WebElement enter;
    @FindBy(xpath = "//input[contains(@id,'login')]")
    private WebElement loginField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginEnter;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement passwordEnter;
    @FindBy(xpath = "//div[@class='passp-form-field__error']")
    private WebElement invalidPass;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage firstEnter() {
        waitVisibilityOfElementLocated(enter);
        Tools.highlightRedWithJS(enter);
        Tools.clickWithJS(enter);
        return new LoginPage(driver);
    }

    public LoginPage userName(User user) {
        waitVisibilityOfElementLocated(loginField);
        Tools.highlightRedWithJS(loginField);
        loginField.sendKeys(user.getLogin());
        Tools.clickWithJS(loginEnter);
        return this;
    }

    public LoginPage userPassword(User user) {
        waitVisibilityOfElementLocated(passwordField);
        Tools.highlightRedWithJS(passwordField);
        passwordField.sendKeys(user.getPassword());
        Tools.clickWithJS(passwordEnter);
        return this;
    }

    public LoginPage userName(InvalidUserName user) {
        waitVisibilityOfElementLocated(loginField);
        Tools.highlightRedWithJS(loginField);
        loginField.sendKeys(user.getLogin());
        Tools.clickWithJS(loginEnter);
        Assert.assertTrue(invalidPass.isDisplayed());
        System.out.println("Введено неверное имя пользователя");
        return this;
    }
}