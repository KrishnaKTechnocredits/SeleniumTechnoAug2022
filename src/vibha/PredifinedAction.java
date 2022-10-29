package vibha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredifinedAction {
	
	 final static public WebDriver start() {
		System.out.println("Step 1 --> Launch crome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("");
		return driver;
	}

}
