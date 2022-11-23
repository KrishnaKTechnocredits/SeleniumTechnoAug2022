package deepakPatil.assignment8LoginOrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import deepakPatil.base.StartupActions;
import deepakPatil.utils.PropertiesFileReader;

public class LoginOrangeHRM {
	
	WebDriver driver;
	PropertiesFileReader fileRead = new PropertiesFileReader("src/deepakPatil/assignment8LoginOrangeHRM/OrangeHRMDetails.properties");
	
	@BeforeTest
	void startUP() {
		driver = StartupActions.launch(fileRead.getValue("URL"));
	}
	
	@Test
	void updateDetailsOrangeHRM() {
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(fileRead.getValue("WaitTime")), TimeUnit.SECONDS);
		
		// Login with valid credentials
		driver.findElement(By.cssSelector("input[id=txtUsername]")).sendKeys(fileRead.getValue("Username"));
		driver.findElement(By.cssSelector("input[id=txtPassword]")).sendKeys(fileRead.getValue("Password"));
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		
		//Verify successful login
		String title=driver.getTitle();
		String expectedTitle= fileRead.getValue("WebSiteTitle");
		Assert.assertEquals(title, expectedTitle);
		
		//Enter First Name and Last Name
		driver.findElement(By.cssSelector("#top-ribbon-menu>div:nth-child(2) top-level-menu-item:nth-child(2) a")).click();
		WebElement fNameElement =driver.findElement(By.cssSelector("input[id=firstName]"));
		fNameElement.clear();
		fNameElement.sendKeys(fileRead.getValue("FirstName"));
		
		WebElement lNameElement = driver.findElement(By.cssSelector("input[id=lastName]"));
		lNameElement.clear();
		lNameElement.sendKeys(fileRead.getValue("LastName"));
		
		//Click on Save button
		driver.findElement(By.cssSelector("div[class=\"form-group schema-form-submit right\"] button")).click();
		
		//Get successful message
		String successMessage = driver.findElement(By.cssSelector("div[class=toast-message]")).getText();
		String exptectedMessage = fileRead.getValue("expectedSuccessMessage");
		Assert.assertEquals(successMessage, exptectedMessage);
		
		//Refresh page
		driver.navigate().refresh();
		
		//Verify Name is updated
		String updateddName =driver.findElement(By.cssSelector("a[class=name]")).getText();
		String expectedUpdatedName= fileRead.getValue("FirstName")+" "+fileRead.getValue("LastName");
		Assert.assertEquals(updateddName, expectedUpdatedName);
		
		System.out.println("Test is passed");
	}
	
	@AfterTest
	void wrapUp() {
		driver.close();
	}

}
