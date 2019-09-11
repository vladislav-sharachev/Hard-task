package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;

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


    public void goToDrafts() {
        selectDrafts.click();
        driver.navigate().refresh();
    }

    public boolean verifyFirstDraft() {
        waitForElementIsVisible(verifyFirstDraft);
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