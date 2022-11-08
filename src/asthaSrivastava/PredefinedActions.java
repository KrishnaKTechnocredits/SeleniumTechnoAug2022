package asthaSrivastava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	final static public WebDriver start() {
		return start("file:///E:/Java2022/Assignments/Selenium/FirstHtmlPage.html");
	}
	
	final static public WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver","src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	public static void main(String[] args) {
		
	}
}
