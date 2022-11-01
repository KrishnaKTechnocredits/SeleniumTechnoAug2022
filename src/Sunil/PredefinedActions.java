package Sunil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static public WebDriver start() {
		return start("file:///D:/TechnoCredits/Projects/Aug22/eclipse/SeleniumTechnoAug2022/src/Sunil/FirstPage.html");
	}
	
	static public WebDriver start(String url) {
		//System.out.println("STEP - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
}