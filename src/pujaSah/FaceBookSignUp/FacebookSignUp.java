/*Assignment - 5 : 30th OCt'2022

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)*/

package pujaSah.FaceBookSignUp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pujaSah.Base.PredefinedActions;
import pujaSah.utils.PropertiesFileReader;

public class FacebookSignUp {
	WebDriver driver;
	
	@BeforeMethod
	public void startUp() {
		System.out.println("STEP1: Launch browser and hit url");
		driver = PredefinedActions.start("https://www.facebook.com");
	}
	
	@Test
	public void testFacebookSignUpPage() throws InterruptedException {
		
		System.out.println("STEP2: Click on Create New Account button");
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[@role='button']")).click();
		Thread.sleep(2000);
		
		PropertiesFileReader prop = new PropertiesFileReader("src/pujaSah/FaceBookSignUp/loginDetails.properties");
		
		System.out.println("STEP3: Enter FirstName");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(prop.getValue("firstName"));
		
		System.out.println("STEP4: Enter Surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getValue("surname"));
		
		System.out.println("STEP5: Enter emailid");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(prop.getValue("emailAddress"));
		
		System.out.println("STEP5: Re-enter emailid");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(prop.getValue("emailAddress"));
		
		System.out.println("STEP6: Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(prop.getValue("password"));
		
		System.out.println("STEP7: Enter Date of birth");
		WebElement element = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dobSelect = new Select(element);
		dobSelect.selectByVisibleText(prop.getValue("dateOfBirth"));
		
		System.out.println("STEP8: Enter Month of birth");
		element = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		dobSelect = new Select(element);
		dobSelect.selectByVisibleText(prop.getValue("monthOfBirth"));
		
		System.out.println("STEP9: Enter Year of birth");
		element = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		dobSelect = new Select(element);
		dobSelect.selectByVisibleText(prop.getValue("yearOfBirth"));
		
		System.out.println("STEP10: Click on your Gender");
		List<WebElement> genderList = driver.findElements(By.xpath("//span[@data-name='gender_wrapper']//label"));

		for(WebElement curGender : genderList) {
			if(curGender.getText().equals(prop.getValue("gender"))) {
				curGender.click();
			}	
		}
		System.out.println("Test has passed");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();	
	}
}
