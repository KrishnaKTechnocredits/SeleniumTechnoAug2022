package akankshaVyas.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	private static WebDriver driver;

	final static public WebDriver start() {
		return start("http://automationpractice.com/");
	}

	final static public WebDriver start(String url) {
		System.out.println("STEP: Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	public	static void scrollToElement(WebElement element){
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void closeAllBrowser() {
		driver.quit();
	}
}
