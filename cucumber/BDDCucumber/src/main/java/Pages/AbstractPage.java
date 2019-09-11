package Pages;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class AbstractPage {
    protected WebDriver driver = DriverManager.getDriver();

    public AbstractPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DriverManager
                .getDriver())), this);
    }

    public void waitForElementIsVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), 30)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), 30)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}