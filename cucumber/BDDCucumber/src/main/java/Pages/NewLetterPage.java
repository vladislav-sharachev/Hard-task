package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;

public class NewLetterPage extends AbstractPage {

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


    public void firstAdress() {
        addressField.sendKeys("com-epam-at1@yandex.ru");
    }

    public void secondAdress() {
        addressField.sendKeys("com-epam-at2@yandex.ru");
    }

    public void thirdAdress() {
        addressField.sendKeys("com-epam-at3@yandex.ru");
    }

    public void saveDraft() {
        close.click();
        saveOk.click();
        driver.navigate().refresh();
    }

    public void clickToWriteLetter() {
        waitForElementToBeClickable(writeNewLetter);
        writeNewLetter.click();
        waitForElementIsVisible(addressField);
    }

    public void letterText() {
        subjectField.sendKeys("test letter");
        bodyField.sendKeys("test text");
    }

    public void letterWriteAndSave() {
        letterText();
        saveDraft();
    }
    public void writeFirstLetter() {
        clickToWriteLetter();
        firstAdress();
        letterWriteAndSave();
    }
    public void writeSecondLetter() {
        clickToWriteLetter();
        secondAdress();
        letterWriteAndSave();
    }
    public void writeThirdLetter() {
        clickToWriteLetter();
        thirdAdress();
        letterWriteAndSave();
    }
}