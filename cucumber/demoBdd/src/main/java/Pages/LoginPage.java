package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import DriverManager.DriverManager;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@id,'login')]")
    private Form loginField;
    @FindBy(xpath = "//button[@type='submit']")
    private Button loginEnter;
    @FindBy(xpath = "//input[@type='password']")
    private Form passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private Button passwordEnter;
    @FindBy(css = "div.mail-User-Name")
    private TextBlock verifyInput;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/div/div/div[1]/form/div[1]/div[2]")
    private TextBlock anException;
    @FindBy(xpath = "//span[@id='recipient-1']")
    private WebElement userIcon;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement logOff;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/div/div/form/a")
    private WebElement oldUser;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/div/div/ul/li/div/span/span")
    private WebElement deleteUser;

    public LoginPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverManager.getDriver())), this);
    }

    public void typeUsername(String username) {
        waitForElementIsVisible(loginField);
        this.loginField.sendKeys(username);
    }

    public void clickToSubmitUserName() {
        loginEnter.click();
    }

    public void typePassword(String password) {
        waitForElementIsVisible(passwordField);
        this.passwordField.sendKeys(password);
    }

    public void clickToSubmitPassword() {
        passwordEnter.click();
    }

    public boolean inputIsSuccessful() {
        return verifyInput.isDisplayed();
    }

    public boolean anExceptionShowed() {
        waitForElementIsVisible(anException.getWrappedElement());
        return anException.isDisplayed();
    }

    public void logOut() {
        userIcon.click();
        waitForElementToBeClickable(logOff);
        logOff.click();
    }

    public void deleteOldUser() {
        waitForElementIsVisible(oldUser);
        oldUser.click();
        waitForElementIsVisible(deleteUser);
        deleteUser.click();
    }
}