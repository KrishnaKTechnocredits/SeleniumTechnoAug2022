/*Assignment - 5 : 30th OCt'2022 

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to  https://www.facebook.com/ 
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)*/
package asthaSrivastava.assignment5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import asthaSrivastava.PredefinedActions;
import asthaSrivastava.utils.PropertiesFileReader;

@Test
public class FacebookFillPageUsingPropFile {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws Exception {
		System.out.println("STEP : Launch Browser and Hit Facebook URL - https://www.facebook.com/ ");
		driver = PredefinedActions.start("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public void clickOnCreateNewAccount() throws Exception{
		System.out.println("STEP : Click on Create New Account");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(3000);
		
		System.out.println("STEP: Fill the details using properties file");
		PropertiesFileReader properties = new PropertiesFileReader("src/asthaSrivastava/Files/login.properties");
		
		System.out.println("STEP : Enter First Name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(properties.getValue("userName"));
		
		System.out.println("STEP : Enter Last Name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(properties.getValue("lastName"));
		
		System.out.println("STEP : Enter Mobile Number or Email Address");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys(properties.getValue("emailId"));
		
		System.out.println("STEP : Enter New Password");
		driver.findElement(By.cssSelector("input[id=password_step_input]")).sendKeys(properties.getValue("userPassword"));
		
		System.out.println("STEP : Enter BirthDate");
		WebElement element = driver.findElement(By.xpath("//div//span[1]/select[@name='birthday_day']"));
		Select select = new Select(element);
		select.selectByVisibleText(properties.getValue("birthDate"));
				
		
		System.out.println("STEP : Enter BirthMonth");
		element =driver.findElement(By.xpath("//div//span[1]/select[@name='birthday_month']"));
		select = new Select(element);
		select.selectByVisibleText(properties.getValue("birthMonth"));
		
		System.out.println("STEP : Enter BirthYear");
		element =driver.findElement(By.xpath("//div//span[1]/select[@name='birthday_year']"));
		select = new Select(element);
		select.selectByVisibleText(properties.getValue("birthYear"));
		
		System.out.println("STEP : Select Gender");
		List<WebElement> selectGender = driver.findElements(By.xpath("//label[@class='_58mt']"));
		for(WebElement gender: selectGender) {
			if(gender.getText().equalsIgnoreCase(properties.getValue("gender")));
			gender.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}
