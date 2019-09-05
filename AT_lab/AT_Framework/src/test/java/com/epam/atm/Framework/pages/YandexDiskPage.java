package com.epam.atm.Framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexDiskPage extends AbstractPage {

    @FindBy(xpath = "//img[contains(@src,'/1')]/parent::div/div")
    private WebElement image;
    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    private WebElement trashImage;
    @FindBy(xpath = "//a[@id='/trash']")
    private WebElement trash;
    @FindBy(css = "div.listing-item__fields")
    private WebElement contextMenuImage;
    @FindBy(css = "div.resources-actions-popup__action_type_restore")
    private WebElement contextMenuOk;
    @FindBy(xpath = "//div[@class='b-progressbar__fill']")
    private WebElement restoreLine;
    @FindBy(xpath = "//a[contains(@class,'Disk')]/span[text()='Диск']")
    private WebElement clickDisk;
    @FindBy(xpath = "//a[@href='https://mail.yandex.ru' and contains(@class,'menu__link')]")
    private WebElement clickMail;

    public YandexDiskPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public YandexDiskPage openDisk() {
        waitForElementToBeClickable(clickDisk);
        clickDisk.click();
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        return this;
    }

    public YandexDiskPage deleteImage() {
        waitVisibilityOfElementLocated(image);
        Actions deleteImage = new Actions(driver);
        deleteImage.dragAndDrop(image, trashImage).doubleClick(trash).build().perform();
        return new YandexDiskPage(driver);
    }

    public YandexDiskPage restoreImage() {
        waitVisibilityOfElementLocated(contextMenuImage);
        Actions restoreImage = new Actions(driver);
        restoreImage.contextClick(contextMenuImage).build().perform();
        restoreImage.click(contextMenuOk).build().perform();
        return new YandexDiskPage(driver);
    }

    public YandexDiskPage openMail() {
        waitVisibilityOfElementLocated(restoreLine);
        clickMail.click();
        return this;
    }
}