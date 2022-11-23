/*Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)
1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)*/

package manjiri.assignment5;

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
import manjiri.utils.PropertiesFileReader;

public class PropertiesFileDemo {
	WebDriver driver;
	PropertiesFileReader propFile = new PropertiesFileReader("src/manjiri/propertiesfile/login.properties");
	
	@BeforeMethod
	public void setup() {	
		System.out.println("Launch Browser and Navigate to URL");
		driver = PredefinedActions.start("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@role='button'][@data-testid='open-registration-form-button']")).click();
	}
	
	@Test
	void facebookAccountCreation(){
		System.out.println("Enter First name");
		driver.findElement(By.xpath("//div[@id='reg_form_box']/div[1]/div[1]/div[1]/div/input")).sendKeys(propFile.getValue("userFirstName"));
		System.out.println("Enter Surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(propFile.getValue("userSurname"));
		System.out.println("Enter Email");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(propFile.getValue("userEmailAddress"));
		System.out.println("Enter Email");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys(propFile.getValue("userPassword"));
		
		System.out.println("Select Date of Birth");
		Select birthDay = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		birthDay.selectByValue(propFile.getValue("date"));
		
		Select birthMonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		birthMonth.selectByVisibleText(propFile.getValue("month"));
		
		Select birthYear = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		birthYear.selectByVisibleText(propFile.getValue("year"));
		
		System.out.println("Select Gender");
		List<WebElement> gender = driver.findElements(By.xpath("//span[@data-type='radio']"));
		
		for (WebElement e : gender) {
			if(e.getText().equals(propFile.getValue("gender"))) {
				e.click();
			}
		}
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Close Browser");
		PredefinedActions.closeBrowser();
	}
}
