package SwapnilMaheshwari.PreDefineMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {
	
	static  WebDriver driver;
	public static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver","D:\\TechnoCredits\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		System.out.println("Step - Launch chrome browser");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void closeAllBrowser() {
		driver.quit();
	}


}
