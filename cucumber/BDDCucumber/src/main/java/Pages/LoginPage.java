package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.*;

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
    @FindBy(xpath = "//div[text()='Такого аккаунта нет']")
    private TextBlock anException;
    @FindBy(xpath = "//span[@id='recipient-1']")
    private WebElement userIcon;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement logOff;
    @FindBy(xpath = "//div[text()='mail-for-bdd']")
    private WebElement lastUser;
    @FindBy(xpath = "//span[@data-lego='react' and contains(text(),'Удалить')]")
    private WebElement deleteLastUser;
    @FindBy(css = "div.passp-account-list-item-block >a")
    private WebElement lastUserToSelect;


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
        waitForElementIsVisible(lastUser);
        lastUser.click();
        waitForElementIsVisible(lastUserToSelect);
        Actions actions = new Actions(driver);
        actions.clickAndHold(deleteLastUser).build().perform();
        deleteLastUser.click();
    }
}