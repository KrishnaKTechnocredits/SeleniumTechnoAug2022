package AMohini.CommonActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	private static WebDriver driver;
	
	final static public WebDriver start() throws InterruptedException {
	return start("http://www.google.com");	
		
	}
	
	final static public WebDriver start(String url) throws InterruptedException {
		
		System.out.println("STEP - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(2000);
		return driver;
	}

final static public void closeBrowser() {
	driver.close();
	
}
}


