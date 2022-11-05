package saroj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saroj.utils.PropertyFilesReader;

public class OrangeHRMLogin {

	WebDriver driver;
	PropertyFilesReader prop = new PropertyFilesReader("src/saroj/propertiesFiles/orangeHRMLDetails.properties");
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step - Launch the Browser");
		driver = PredefinedActions.start(prop.getValue("url"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("wait")),TimeUnit.SECONDS);
		System.out.println("Step - Navigate to Orange HRM");
	}
	
	@Test
	public void OrangeHrmLogin() {
		System.out.println("Step - Enter User name");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(prop.getValue("Username"));
		System.out.println("Step - Enter Password");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(prop.getValue("Password"));
		System.out.println("Step - Press Submit button");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String title = driver.getTitle();
		if(title.equals("Employee Management")) {
			System.out.println("Login Successful");
		}else {
			System.out.println("Login failed");
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
