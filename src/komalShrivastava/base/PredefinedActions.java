package komalShrivastava.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	final static public WebDriver start() {
		return start("http://www.automationbykrishna.com/");
	}
	final static public WebDriver start(String url) {
		System.out.println("STEP - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver",".//drivers/chromedriver_106.exe" );
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP - Hit URL");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
}