package deepakPatil.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartupActions {
	
	private static WebDriver driver;
	
	final static public WebDriver launch(String URL) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		System.out.println("--Launch Chrome Browser--");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("--Open URL--");
		driver.get(URL);
		return driver;
	}
	
	final static public WebDriver launch(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		System.out.println("--Launch Chrome Browser--");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
