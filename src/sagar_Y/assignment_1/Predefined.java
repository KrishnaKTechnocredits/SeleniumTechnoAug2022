package sagar_Y.assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Predefined {
	
	WebDriver driver;

	static WebDriver getTitle(String url) {
		
		System.out.println("STEP 1- Launch Chrome Browser\n");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(url);
		
		return driver;
		
	}

}
