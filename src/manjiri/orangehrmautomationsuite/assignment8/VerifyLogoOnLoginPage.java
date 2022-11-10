/*"1. Launch your oranage HRM URL
2. Verify Logo displayed on Login Page
3. User Login with valid credential
4. User should navigate to home page, Verify ""Employee Management"" header should be visible.
"*/

package manjiri.orangehrmautomationsuite.assignment8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;
import manjiri.orangehrmautomationsuite.utils.PropertiesFileReader;

public class VerifyLogoOnLoginPage {
	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader(
			"src/manjiri/orangehrmautomationsuite/propertiesfile/orangeHRMLogin");

	@BeforeMethod
	public void setup() {
		System.out.println("Step: Launch the browser and hit URL");
		driver = PredefinedActions.start("https://mchourikar-trials77.orangehrmlive.com/");

		// Added implicit wait for 35 sec
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	@Test
	public void verifyLogoAndLogin() {
		System.out.println("Step: Verify Logo displayed on login page");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='orangehrm-logo']")).isDisplayed(), "Logo not displayed");
		
		System.out.println("Step: Enter Username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("username"));

		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));

		System.out.println("Step: Click on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Step: Verify Employee Management header is displayed");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='page-title tooltipped title1']//div[text()='Employee Management']")).isDisplayed(), "Header not displayed");
		System.out.println("Test case successfully executed");
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
