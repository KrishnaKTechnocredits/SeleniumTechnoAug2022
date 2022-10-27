package AMohini.CommonActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	private static WebDriver driver;
	
	final static public WebDriver start() {
	return start("http://www.google.com");	
		
	}
	
	final static public WebDriver start(String url) {
		
		System.out.println("STEP - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

final static public void closeBrowser() {
	driver.close();
	
}
}


