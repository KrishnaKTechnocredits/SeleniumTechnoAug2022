package SwapnilMaheshwari.Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedFunctions {

	public final static WebDriver browserOpen() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		System.out.println("Step -Launch chrome browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step - Hit url(html page created)in browser");
		driver.get("D:\\TechnoCredits\\SeleniumTechnoAug2022\\src\\SwapnilMaheshwari\\Testing.html");
		driver.manage().window().maximize();
		return driver;
	}

}
