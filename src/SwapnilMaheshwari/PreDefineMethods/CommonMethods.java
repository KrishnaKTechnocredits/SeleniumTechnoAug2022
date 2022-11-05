package SwapnilMaheshwari.PreDefineMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {
	
	static  WebDriver driver;
	static final WebDriver openBrowser(String url) throws InterruptedException{
		System.setProperty(":webdriver.chrome.driver",
				"D:\\TechnoCredits\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe, null");
		System.out.println("Step - Launch chrome browser");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		return driver;
	}
	static void closeBrowser() {
		driver.close();
	}
	static void closeAllBrowser() {
		driver.quit();
	}


}
