package Sohail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	public static WebDriver driver;

	public static void openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"G:\\Technocredits\\eclipse-java-2022-06-R-win32-x86_64\\Selenium_Practice\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

	}

	public static void closeBrowser() {
		driver.quit();
	}
}
