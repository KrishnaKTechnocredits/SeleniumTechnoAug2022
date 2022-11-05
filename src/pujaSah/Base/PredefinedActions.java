package pujaSah.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	private static WebDriver driver;

	final static public WebDriver start() {
		return start("http://automationbykrishna.com/");
	}

	// method to launch Chrome browser and hit given url .//
	final static public WebDriver start(String url) {
		// Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe"); // System.setProperty("webdriver.chrome.driver",
																						// ".//resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(url);// Hit URL
		return driver;
	}

	// enable scrolling on current page upto given element
	static public void scrollToElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	final static public void closeBrowser() {
		driver.close();
	}

	final static public void closeAllBrowsers() {
		driver.quit();
	}
}
