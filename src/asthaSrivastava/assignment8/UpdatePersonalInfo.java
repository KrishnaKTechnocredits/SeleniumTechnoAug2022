/*Script 1: Login to application & update the personal information

1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name*/

package asthaSrivastava.assignment8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apurvaBabel.utils.PropertiesFileReader;
import asthaSrivastava.PredefinedActions;

public class UpdatePersonalInfo {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		System.out.println("STEP : Launch your Orange HRM site");
		driver = PredefinedActions.start("http://asrivastava-trials77.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void updateDetailsOnline() throws InterruptedException {
		PropertiesFileReader propertyDetails = new PropertiesFileReader(
				"src/asthaSrivastava/assignment8/login.properties");
		System.out.println("STEP : Login with valid credentials");

		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(propertyDetails.getValue("userName"));
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(propertyDetails.getValue("password"));
		driver.findElement(By.cssSelector("button[type=submit]")).click();

		System.out.println("STEP : Click on my info tab");
		driver.findElement(By.cssSelector("a[ui-sref='pim.my_info']")).click();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyDetails.getValue("myInfoPageWait")), TimeUnit.SECONDS);

		System.out.println("STEP : Update First Name and Last Name");
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(propertyDetails.getValue("firstName"));
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(propertyDetails.getValue("lastName"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyDetails.getValue("myInfoPageWait")), TimeUnit.SECONDS);

		System.out.println("STEP : Click on Save Button");
		driver.findElement(By.cssSelector("div[class='form-group schema-form-submit right']>button")).click();

		System.out.println("VERIFY : Validate Successfully Updated message on page ");
		String expectedMsg = "Successfully Updated";
		String actualMsg = driver.findElement(By.xpath("//div[@class = 'toast-message']")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);

		System.out.println("STEP : Refresh the page & validate the updated name");
		driver.navigate().refresh();
		
		String expectedUserName= propertyDetails.getValue("firstName") +" "+ propertyDetails.getValue("lastName");
		String actualUserName=	driver.findElement(By.cssSelector("#sidebar-profile-picture > a")).getText();
		
		Assert.assertEquals(actualUserName, expectedUserName);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
