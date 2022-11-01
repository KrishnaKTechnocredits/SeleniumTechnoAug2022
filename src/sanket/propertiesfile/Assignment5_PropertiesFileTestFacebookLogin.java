package sanket.propertiesfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.*;
import sanket.utils.ProprtiesFileReaderUtil;

public class Assignment5_PropertiesFileTestFacebookLogin {

	WebDriver driver;

	@BeforeMethod
	public void preTestSetup() throws Exception {

		System.out.println("Step1 - Launch Browser and hit facebook URL.");
		driver = PredefinedActions.start("https://www.facebook.com/");
		Thread.sleep(3000);
	}

	@Test
	public void PropertiesFileFacebook() throws Exception {

		System.out.println("Step2 - Verify Application is loaded successfully.");
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle);

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		System.out.println("Step3 - Nevigate to Create New Account on Facebook and click on it");

		Thread.sleep(3000);

		ProprtiesFileReaderUtil propertyLogin = new ProprtiesFileReaderUtil(
				"src/sanket/propertiesfile/facebooklogin.properties");

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(propertyLogin.getValue("firstName"));
		System.out.println("Step4 - Enter Name");

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(propertyLogin.getValue("surName"));
		System.out.println("Step5 - Enter Surname");

		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(propertyLogin.getValue("mobileNumber"));
		System.out.println("Step6 - Enter Mobile");

		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(propertyLogin.getValue("newPassword"));
		System.out.println("Step7 - Enter New Password");

		System.out.println("Step8 - Enter Date");
		WebElement dateElement = driver.findElement(By.xpath("//select[@id='day']"));
		Select noOfDropDownElementDate = new Select(dateElement);
		noOfDropDownElementDate.selectByVisibleText(propertyLogin.getValue("date"));

		System.out.println("Step9 - Enter Month");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		Select noOfDropDownElementMonth = new Select(monthElement);
		noOfDropDownElementMonth.selectByVisibleText(propertyLogin.getValue("month"));

		System.out.println("Step10 - Enter Year");
		WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
		Select noOfDropDownElementYear = new Select(yearElement);
		noOfDropDownElementYear.selectByVisibleText(propertyLogin.getValue("year"));

		System.out.println("Step11 - Select Gender");
		driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//span[2]/input[@value='2']")).click();

		Thread.sleep(3000);
	}

	@AfterTest
	public void closeBrowser() {
		PredefinedActions.closeBrowser();
	}

}
