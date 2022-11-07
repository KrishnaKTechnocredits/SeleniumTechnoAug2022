/*Assignment - 5 : 30th OCt'2022

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)
—-----------------------------------------------------*/
package Shruti.propertiesFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Shruti.utils.PropertyFileReader;

public class Assignment5 {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP: Launch Facebook");
		driver = Shruti.base.PreDefinedActions.start("https://www.facebook.com/");
	}

	@Test
	public void createAccount() throws InterruptedException {
		// click on Create Account
		System.out.println("STEP: Create Account");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);

		PropertyFileReader prop = new PropertyFileReader("src/Shruti/propertiesFile/login.properties");
		System.out.println("STEP: Enter First name");
		driver.findElement(By.xpath("//div[@id='reg_form_box']/div[1]/div[1]/div[1]/div/input"))
				.sendKeys(prop.getValue("firstname"));
		// System.out.println(prop.getProperty("firstname"));
		
		System.out.println("STEP: Enter Surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getValue("surname"));
		
		System.out.println("STEP: Enter Mobile Number");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(prop.getValue("mobilenumber"));
		
		System.out.println("STEP: Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(prop.getValue("password"));
		
		System.out.println("STEP: Select Birth Day");
		WebElement birthDay = driver.findElement(By.xpath("//select[@id='day']"));
		Select selectBirthDay = new Select(birthDay);
		selectBirthDay.selectByVisibleText(prop.getValue("birthdate"));
		
		System.out.println("STEP: Select Birth Month");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectBirthMonth = new Select(birthMonth);
		selectBirthMonth.selectByVisibleText(prop.getValue("birthmonth"));
		
		System.out.println("STEP: Select Birth Year");
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectBirthYear = new Select(birthYear);
		selectBirthYear.selectByVisibleText(prop.getValue("birthyear"));

		System.out.println("STEP: Select Gender");
		WebElement element = driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
		String gender = element.getText();
		if(gender.equals(prop.getValue("gender"))) {
			element.click();
			Thread.sleep(2000);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
