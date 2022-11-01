package vibha;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class PredifinedAction {
	
	private static WebDriver driver;
	
	final static public WebDriver start() {
		return start("http://automationbykrishna.com");
		
	}
	
	 final static public WebDriver start(String url) {
		System.out.println("Step 1 --> Launch crome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("url");
		driver.manage().window().maximize();
		return driver;
	}

	 final public static void verifyTitle(String expectedTitle) {
		 String actualTitle=driver.getTitle();
		 if(expectedTitle.equals(actualTitle)) {
			 System.out.println("pass");
		 }else {
			 System.out.println("fail");
		 }
	 }
	 
	 final public static void scrollviewToElement(WebElement element) {
		 JavascriptExecutor je=(JavascriptExecutor)driver;
		 je.executeScript("arguments[0].scrollIntoView", element);
	 }
}
