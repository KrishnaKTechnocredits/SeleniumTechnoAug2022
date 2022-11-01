package SwapnilMaheshwari.Assignment4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreDefinedFunction {
		static WebDriver browswerOpen() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\TechnoCredits\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(3000);
		return driver;
		}
}
