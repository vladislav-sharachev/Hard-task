package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.Text;
import ru.yandex.qatools.htmlelements.element.*;

public class DraftsPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Черновики']")
    private CheckBox selectDrafts;
    @FindBy(xpath = "//span[text()='com-epam-at1@yandex.ru']")
    private TextBlock verifyFirstDraft;
    @FindBy(xpath = "//span[text()='com-epam-at2@yandex.ru']")
    private TextBlock verifySecondDraft;
    @FindBy(xpath = "//span[text()='com-epam-at3@yandex.ru']")
    private TextBlock verifyThirdDraft;
    @FindBy(xpath = "//div[contains(@class,'main-select')]/label[contains(@class,'Checkbox')]")
    private CheckBox selectAllDrafts;
    @FindBy(xpath = "//div[@title='Удалить (Delete)']")
    private Button deleteAllDrafts;
    @FindBy(xpath = "//div[text()='В папке «Черновики» нет писем.']")
    private TextBlock theDraftsWereDeleted;
    @FindBy(xpath = "//span[@id='recipient-1']")
    private HtmlElement userIcon;


    public void goToDrafts() {
        selectDrafts.click();
        waitForElementToBeClickable(userIcon);
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

    public void verifyAllDrafts() {
        Assert.assertTrue("Element should be visible", verifyFirstDraft());
        Assert.assertTrue("Element should be visible", verifySecondDraft());
        Assert.assertTrue("Element should be visible", verifyThirdDraft());
    }
}