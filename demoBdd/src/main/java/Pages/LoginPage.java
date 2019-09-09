package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverManager.DriverManager;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
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
    private WebElement verifyInput;

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
    public boolean
}