package Pages;

import DriverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class NewMailPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Написать (w, c)']")
    private Button writeNewLetter;
    @FindBy(css = "div.js-compose-field[name^='to']")
    private Form addressField;
    @FindBy(xpath = "//input[contains(@class,'mail-Compose-Field')]")
    private Form subjectField;
    @FindBy(css = "div.cke_wysiwyg_div")
    private Form bodyField;
    @FindBy(xpath = "//div[contains(@class,'cancel') and @title='Закрыть']")
    private WebElement close;
    @FindBy(xpath = "//span[@class='_nb-button-text' and text()='Сохранить и перейти']")
    private WebElement saveOk;


    public NewMailPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverManager.getDriver())), this);
    }

    public void writeFirstLetter() {
        writeNewLetter.click();
        waitForElementIsVisible(addressField);
        addressField.sendKeys("com-epam-at1@yandex.ru");
        subjectField.sendKeys("test letter");
        bodyField.sendKeys("test text");
        close.click();
        saveOk.click();
        DriverManager.getDriver().navigate().refresh();
    }

    public void writeSecondLetter() {
        waitForElementClickable(writeNewLetter);
        writeNewLetter.click();
        waitForElementIsVisible(addressField);
        addressField.sendKeys("com-epam-at2@yandex.ru");
        subjectField.sendKeys("test letter");
        bodyField.sendKeys("test text");
        close.click();
        saveOk.click();
        DriverManager.getDriver().navigate().refresh();
    }

    public void writeThirdLetter() {
        waitForElementClickable(writeNewLetter);
        writeNewLetter.click();
        waitForElementIsVisible(addressField);
        addressField.sendKeys("com-epam-at3@yandex.ru");
        subjectField.sendKeys("test letter");
        bodyField.sendKeys("test text");
        close.click();
        saveOk.click();
        DriverManager.getDriver().navigate().refresh();
    }

}