package rashmiG.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	public static WebDriver driver;

	public final static WebDriver start() {
		return start("http://automationbykrishna.com/");
	}

	public final static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public static final void closeBrowser() {
		driver.close();
	}
}