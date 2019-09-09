package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverManager.DriverManager;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@class,'enter')]")
    private Button enter;

    public MainPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverManager.getDriver())), this);
    }

    public void waitForEnterVisivle() {
        waitForElementIsVisible(enter.getWrappedElement());

    }

    public boolean isPleaseLoginMessageVisible() {
        return enter.isDisplayed();
    }

    public void clickToEnter() {
        enter.click();
    }
}