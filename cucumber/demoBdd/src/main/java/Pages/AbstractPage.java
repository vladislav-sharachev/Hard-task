package Pages;

import DriverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    public void waitForElementIsVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), 30)
                .until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForElementClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), 30)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}