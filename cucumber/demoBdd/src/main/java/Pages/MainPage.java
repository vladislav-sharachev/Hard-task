package Pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@class,'enter')]")
    private Button enter;


    public boolean isPleaseLoginMessageVisible() {
        return enter.isDisplayed();
    }

    public void clickToEnter() {
        enter.click();
    }
}