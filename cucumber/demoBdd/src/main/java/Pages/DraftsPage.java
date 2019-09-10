package Pages;

import DriverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class DraftsPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Черновики']")
    private WebElement selectDrafts;
    @FindBy(xpath = "//span[text()='com-epam-at1@yandex.ru']")
    private WebElement verifyFirstDraft;
    @FindBy(xpath = "//span[text()='com-epam-at2@yandex.ru']")
    private WebElement verifySecondDraft;
    @FindBy(xpath = "//span[text()='com-epam-at3@yandex.ru']")
    private WebElement verifyThirdDraft;
    @FindBy(xpath = "//div[contains(@class,'main-select')]/label[contains(@class,'Checkbox')]")
    private CheckBox selectAllDrafts;
    @FindBy(xpath = "//div[@title='Удалить (Delete)']")
    private Button deleteAllDrafts;
    @FindBy(xpath = "//div[text()='В папке «Черновики» нет писем.']")
    private WebElement theDraftsWereDeleted;

    public DraftsPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverManager.getDriver())), this);
    }

    public void goToDrafts() {
        selectDrafts.click();
    }

    public boolean verifyFirstDraft() throws InterruptedException {
        Thread.sleep(500);
        return verifyFirstDraft.isDisplayed();
    }

    public boolean verifySecondDraft() {
        return verifySecondDraft.isDisplayed();
    }

    public boolean verifyThirdDraft() {
        return verifyThirdDraft.isDisplayed();
    }

    public void selectAllDrafts() {
        selectAllDrafts.select();
    }

    public void deleteAllDrafts() {
        deleteAllDrafts.click();
    }

    public boolean verifyTheDraftsWereDeleted() {
        return theDraftsWereDeleted.isDisplayed();
    }
}