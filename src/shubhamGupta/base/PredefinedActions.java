package shubhamGupta.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import shubhamGupta.utils.PropertyFileReader;

public class PredefinedActions {
	private static WebDriver driver;
	private static PropertyFileReader prop;

	final static public WebDriver start() {
		return start("https://www.google.com/");

	}

	final static public WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;

	}

	static public void verifyTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	final static public void closeBrowser() {
		driver.close();
	}

	final static public void closeAllBrowsers() {
		driver.quit();
	}

	// method to scroll until element is visible
	static public void scrollTillElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", element);
	}

	
	final static public void loginToOrangeHRM() {
		prop = new PropertyFileReader("src\\shubhamGupta\\Files\\OrangeHrm.properties");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("userName"));
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	} 

}
