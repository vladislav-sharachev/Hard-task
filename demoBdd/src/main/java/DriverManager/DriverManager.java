package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver;

	private DriverManager() {}

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:\\_webdriver\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}
