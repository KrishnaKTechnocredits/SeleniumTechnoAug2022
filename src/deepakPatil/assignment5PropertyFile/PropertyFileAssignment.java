/*
Assignment - 5 : 30th OCt'2022

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)
 */

package deepakPatil.assignment5PropertyFile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import deepakPatil.base.StartupActions;
import deepakPatil.utils.PropertiesFileReader;

public class PropertyFileAssignment {
	WebDriver driver;
	
	@BeforeMethod
	public void startUp(){
		driver = StartupActions.launch("https://www.facebook.com/");
	}
	
	@Test
	public void signUpFacebook() throws InterruptedException {	
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[@role='button']")).click();
				
		//Creating object of PropertiesFileReader class. While creating object sending file path in constructor. Constructor loads file path to memory. Refer PropertiesFileReader class to know how file loads to memory.
		PropertiesFileReader fileRead = new PropertiesFileReader("src/deepakPatil/assignment5PropertyFile/SignUpDetails.properties");
		
		Thread.sleep(2000);
		
		//Enter First Name
		System.out.println("Enter First Name");
		//We retrieve values using getValue() method present in PropertiesFileReader. getValue() method returns value as string associated with key.
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fileRead.getValue("firstName"));
		
		//Enter Sur Name
		System.out.println("Enter Sur Name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(fileRead.getValue("surName"));
		
		//Enter Email
		System.out.println("Enter Email");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(fileRead.getValue("email"));
		
		//Enter Password
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(fileRead.getValue("password"));
		
		//Enter Date of Birth
		System.out.println("Enter Date of Birth");
		WebElement dobElement= driver.findElement(By.xpath("//select[@id='day']"));
		Select dobSelect = new Select(dobElement);
		dobSelect.selectByVisibleText(fileRead.getValue("dateOfBirth"));
		
		//Enter Month of Birth
		System.out.println("Enter Month of Birth");
		dobElement= driver.findElement(By.xpath("//select[@id='month']"));
		dobSelect = new Select(dobElement);
		dobSelect.selectByVisibleText(fileRead.getValue("monthOfBirth"));
		
		//Enter Year of Birth
		System.out.println("Enter Year of Birth");
		dobElement= driver.findElement(By.xpath("//select[@id='year']"));
		dobSelect = new Select(dobElement);
		dobSelect.selectByVisibleText(fileRead.getValue("yearOfBirth"));
		
		//Select Gender
		System.out.println("Select Gender");
		//Gender WebElements stored in WebElements list. Iterating each element and getting its text using enhanced for loop. If text equals to value of gender from property file then clicking on it. 
		List <WebElement> genderElements= driver.findElements(By.xpath("//span[@class='_5k_3']//label[@class='_58mt']"));
		for(WebElement e : genderElements) {
			if(e.getText().equalsIgnoreCase(fileRead.getValue("gender"))) {
				e.click();
			}
		}
		System.out.println("Test is Passed");
	}

	@AfterTest
	public void wrapUp() {
		driver.close();
	}

}
