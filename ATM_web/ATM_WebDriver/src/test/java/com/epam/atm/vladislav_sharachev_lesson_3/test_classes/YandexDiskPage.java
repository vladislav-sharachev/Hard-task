package com.epam.atm.vladislav_sharachev_lesson_3.test_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexDiskPage extends AbstractPage {

    private static final String diskURL = "https://disk.yandex.ru/client/disk";
    private static final String mailURL = "https://mail.yandex.ru/?uid=924890569#inbox";
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

    public YandexDiskPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public YandexDiskPage openDisk() {
        driver.get(diskURL);
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
        driver.get(mailURL);
        return this;
    }
}