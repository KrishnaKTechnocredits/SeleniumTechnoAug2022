package sanket.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	private static WebDriver driver;

	final static public WebDriver start() {
		return start("http://automationbykrishna.com/");
	}

	final static public WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	//Scrolling:
	static void scrollToElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
	}

	final static public void closeBrowser() {
		driver.close();
	}
}
