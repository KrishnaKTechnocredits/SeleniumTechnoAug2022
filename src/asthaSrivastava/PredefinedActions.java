package asthaSrivastava;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	private static WebDriver driver;
	
	final static public WebDriver start() {
		//return start("file:///E:/Java2022/Assignments/Selenium/FirstHtmlPage.html");
		return start("http://automationbykrishna.com");
	}
	
	final static public WebDriver start(String url) {
		System.out.println("STEP - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	static public void scrollToElement(WebElement element){
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	static public void closeBrowser() {
		driver.close();
	}
	
	static public void closeAllBrowser() {
		driver.quit();
	}
}