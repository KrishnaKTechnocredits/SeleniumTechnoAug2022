/*Script 1: Login to application & update the personal information

1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name*/

package manjiri.orangehrmautomationsuite.assignment8;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;
import manjiri.orangehrmautomationsuite.utils.PropertiesFileReader;

public class ApplicationLogin {
	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader("src/manjiri/orangehrmautomationsuite/propertiesfile/orangeHRMLogin");
	
	@BeforeMethod
	public void setup() {
		System.out.println("Step: Launch the browser and hit URL");
		driver = PredefinedActions.start("https://mchourikar-trials77.orangehrmlive.com/");
		
		//Added implicit wait for 35 sec
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}
	
	@Test
	public void applicationLogin() {
		System.out.println("Step: Enter Username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("username"));
		
		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));
		
		System.out.println("Step: Click on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Step: Click on MyInfo tab");
		driver.findElement(By.xpath("//div[@unique-name='uniqueName']/a[@data-automation-id='menu_pim_viewMyDetails']")).click();
		
		System.out.println("Step: Enter Firstname");
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.clear();
		firstName.sendKeys(prop.getValue("firstname"));
		
		System.out.println("Step: Enter Lastname");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys(prop.getValue("lastname"));
		
		System.out.println("Step: Enter Date of Birth");
		WebElement dateOfBirth = driver.findElement(By.xpath("//input[@id='emp_birthday']"));
		dateOfBirth.clear();
		dateOfBirth.sendKeys(prop.getValue("dob"));
		
		System.out.println("Step: Select Nationality");
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//li/span[text()='Indian']")).click();
		
		System.out.println("Step: Select Race and Ethnicity");
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//li/span[text()='Asian']")).click();
		
		System.out.println("Step: Click on save button");
		driver.findElement(By.xpath("//form[@id='pimPersonalDetailsForm']//button[@type='submit']")).click();
		
		System.out.println("Step: Validate if Successfully updated message is displayed");
		WebElement message = driver.findElement(By.xpath("//div[@class='toast-message'][text()='Successfully Updated']"));
		if(message.isDisplayed()) {
			System.out.println("Updated successfully !!!");
		}
		else {
			System.out.println("Failed to update !!!");
		}
		
		System.out.println("Step: Refresh Page");
		driver.navigate().refresh();
		
		System.out.println("Step: Validate updated name");
		String str = driver.findElement(By.xpath("//div[@class='picture']//parent::div[@id='sidebar-profile-picture']/a")).getText();
		if(str.contains(prop.getValue("firstname"))) {
			System.out.println("Name updated successfully !!!");
		}
		else {
			System.out.println("Failed to update name !!!");
		}
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
