package pujaSah;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	private static WebDriver driver;
	
	final static public WebDriver start(){
		return start("http://automationbykrishna.com/");
	}
	
	//method to launch Chrome browser and hit given url  .//
	final static public WebDriver start(String url){
		System.out.println("STEP1- Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe"); //System.setProperty("webdriver.chrome.driver", ".//resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP2- Hit URL");
		driver.get(url);

		System.out.println("VERIFY- Application is loaded and Title is PujaSah-Technocredits:");
		String expectedTitle = "PujaSah - Technocredits";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass \n");
		else 
			System.out.println("Fail \n");	
		
		return driver;
	}
	
	// enable scrolling on current page upto given element 
	static public void scrollToElement(WebElement element){
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element); 
	}
	
	final static public void closeBrowser(){
		driver.close();
	}
	
	final static public void closeAllBrowsers(){
		driver.quit();
	}
}
