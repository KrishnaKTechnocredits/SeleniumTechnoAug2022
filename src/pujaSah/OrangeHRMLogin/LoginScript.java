/*Assignment:8

Script 1: Login to application & update the personal information

1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name*/

package pujaSah.OrangeHRMLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pujaSah.Base.PredefinedActions;
import pujaSah.utils.PropertiesFileReader;

public class LoginScript {

	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader("src/pujaSah/OrangeHRMLogin/OrangeHRMLoginDetails.properties");

	@BeforeMethod
	public void startUp() throws InterruptedException {
		driver=PredefinedActions.start(prop.getValue("applicationURL"));
		System.out.println("STEP 1: Launch browser and hit Orange HRM URL");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")),TimeUnit.SECONDS);
	}
	
	@Test
	public void OrangeHRMLogin() throws InterruptedException{
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
		System.out.println("STEP 2: Enter username");
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
		System.out.println("STEP 3: Enter password");
		
		System.out.println("STEP 4: Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		String title = driver.getTitle();
		if(title.equals("Employee Management")){
			System.out.println("Successfully logged in");
		}
		else{
			System.out.println("Log in failed");
		}
		
		driver.findElement(By.xpath("//top-level-menu-item[@automation-id='menu_pim_viewMyDetails']//a[@ng-if='!!sref && !menuTooltip']")).click();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("myInfoPageWait")), TimeUnit.SECONDS);
		System.out.println("STEP 5: Click on My info tab");
	
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(prop.getValue("firstName"));
		System.out.println("STEP 6: Enter First name");
		
		driver.findElement(By.xpath("//input[@id='middleName']")).clear();
		System.out.println("STEP 7: Clear middle name");
		
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(prop.getValue("lastName"));
		System.out.println("STEP 8: Enter Last name");
	
		driver.findElement(By.xpath("//input[@id='employeeId']")).clear();
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(prop.getValue("employeeId"));
		System.out.println("STEP 9: Enter Employee id");
	
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//ul/li[2]/span")).click();
		System.out.println("STEP 10: Select Mariatal status");
	
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//ul/li[2]/span")).click();
		System.out.println("STEP 11: Select Gender");
	
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//ul/li/span[text()='Indian']")).click();
		System.out.println("STEP 12: Select Nationality");
		
		driver.findElement(By.xpath("//input[@id='licenseNo']")).clear();
		driver.findElement(By.xpath("//input[@id='licenseNo']")).sendKeys(prop.getValue("LicNo"));
		System.out.println("STEP 13: Enter driver's license number");
	
		driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']//button[@type='submit']")).click();
		System.out.println("STEP 14: Click on Save button");
		Thread.sleep(2000);
		
		String actualMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	    String expectedMessage = "Successfully Updated";
	    Assert.assertEquals(actualMessage,expectedMessage);
	    System.out.println("STEP 15 - Validate message on the page.");
		
		driver.navigate().refresh();
		System.out.println("STEP 16 - Refresh the Page.");
		Thread.sleep(10000);
	
		String expectedUserName = prop.getValue("firstName")+ " " + prop.getValue("lastName");
		System.out.println("Expected userName: " + expectedUserName);
		String actualUserName = driver.findElement(By.xpath("//a[@href='/client/#/pim/my_info']")).getText();
		System.out.println("Actual userName: " + actualUserName);
		Thread.sleep(10000);
		Assert.assertEquals(actualUserName, expectedUserName);
	}
	
	/*@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}*/
}

