package Pages;

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
    private Button close;
    @FindBy(xpath = "//span[@class='_nb-button-text' and text()='Сохранить и перейти']")
    private Button saveOk;

    private void firstAddress() {
        addressField.sendKeys("com-epam-at1@yandex.ru");
    }

    private void secondAddress() {
        addressField.sendKeys("com-epam-at2@yandex.ru");
    }

    private void thirdAddress() {
        addressField.sendKeys("com-epam-at3@yandex.ru");
    }

    private void saveDraft() {
        close.click();
        saveOk.click();
        driver.navigate().refresh();
    }

    private void clickToWriteLetter() {
        waitForElementToBeClickable(writeNewLetter);
        writeNewLetter.click();
        waitForElementIsVisible(addressField);
    }

    private void letterText() {
        subjectField.sendKeys("test letter");
        bodyField.sendKeys("test text");
    }

    private void letterWriteAndSave() {
        letterText();
        saveDraft();
    }

    public void writeFirstLetter() {
        clickToWriteLetter();
        firstAddress();
        letterWriteAndSave();
    }

    public void writeSecondLetter() {
        clickToWriteLetter();
        secondAddress();
        letterWriteAndSave();
    }

    public void writeThirdLetter() {
        clickToWriteLetter();
        thirdAddress();
        letterWriteAndSave();
    }
}