package Sohail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	public static WebDriver driver;

	public static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;

	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void closeAllBrowser() {
		driver.quit();
	}
}
