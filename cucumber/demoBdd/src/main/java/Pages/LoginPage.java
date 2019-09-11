package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import DriverManager.DriverManager;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class LoginPage extends AbstractPage {
    private static WebDriver driver;

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
    @FindBy(xpath = "//div[text()='Такого аккаунта нет']")
    private TextBlock anException;
    @FindBy(xpath = "//span[@id='recipient-1']")
    private WebElement userIcon;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement logOff;
    @FindBy(xpath = "//div[text()='mail-for-bdd']")
    private WebElement oldUser;
    @FindBy(xpath = "//span[@data-lego='react' and contains(text(),'Удалить')]")
    private WebElement deleteUser;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/div/div/ul/li/div/a")
    private WebElement userOldSelect;

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
        waitForElementIsVisible(userOldSelect);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(userOldSelect).build().perform();
        waitForElementIsVisible(deleteUser);
        deleteUser.click();
    }
}