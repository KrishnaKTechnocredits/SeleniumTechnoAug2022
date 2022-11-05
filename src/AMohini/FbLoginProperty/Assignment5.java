/*Assignment - 5 : 30th OCt'2022

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)*/

package AMohini.FbLoginProperty;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AMohini.CommonActions.*;
import AMohini.utils.PropertyFileReader;

public class Assignment5 {
	WebDriver driver;
	
	
	//logic to be executed before all test cases 
	@BeforeMethod
	public void loadPage() throws InterruptedException{
		driver = PredefinedActions.start("https://www.facebook.com/");//Navigate to https://www.facebook.com/
	}
	
	//Creating object with Propertyfile path in constructor of PropertyFileReader class. 
	// PropertyFileReader class  methods retrive values as per key passed on the file path loaded by  Constructor  into memory.
	
	PropertyFileReader fileRead = new PropertyFileReader("src/AMohini/FbLoginProperty/FBsignup.properties");
	
	@Test
	public void facebookSignUp() throws InterruptedException {	
	driver.findElement(By.xpath("//div[@class='_6ltg']/a[@role='button']")).click();//Click on "Create New Account"
	driver.manage().timeouts().implicitlyWait(Long.parseLong(fileRead.getValueForKey("implicitWait")),TimeUnit.SECONDS);
	//Fill the details using Properties file (text area, drop down, radio buttons)
	
	//Thread.sleep(2000);
	
			//Enter First Name
			System.out.println("Enter First Name");
			//getValueForKey() method present in PropertyFileReader. Searches for the property with the specified key in this property list
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fileRead.getValueForKey("fName"));
	
			//Enter Last Name
			System.out.println("Enter Last Name");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(fileRead.getValueForKey("lName"));
			
			//Enter Email ID
			System.out.println("Enter Email");
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(fileRead.getValueForKey("email"));
			
			//Enter Password
			System.out.println("Enter Password");
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(fileRead.getValueForKey("password"));
			
			//Enter Date of Birth
			System.out.println("Enter Date of Birth");
			WebElement DOB= driver.findElement(By.xpath("//select[@id='day']"));
			Select dobSelect = new Select(DOB);
			dobSelect.selectByVisibleText(fileRead.getValueForKey("dateOfBirth"));
			
			//Enter Month of Birth
			System.out.println("Enter Month of Birth");
			DOB= driver.findElement(By.xpath("//select[@id='month']"));
			dobSelect = new Select(DOB);
			dobSelect.selectByVisibleText(fileRead.getValueForKey("monthOfBirth"));
			
			//Enter Year of Birth
			System.out.println("Enter Year of Birth");
			DOB= driver.findElement(By.xpath("//select[@id='year']"));
			dobSelect = new Select(DOB);
			dobSelect.selectByVisibleText(fileRead.getValueForKey("yearOfBirth"));
			
			//Select Gender
			System.out.println("Select Gender");
			//Gender WebElements stored in WebElements list. Iterating each element and getting its text using enhanced for loop. If text equals to value of gender from property file then clicking on it. 
			List <WebElement> genderElements= driver.findElements(By.xpath("//span[@class='_5k_3']//label[@class='_58mt']"));
			for(WebElement e : genderElements) {
				if(e.getText().equalsIgnoreCase(fileRead.getValueForKey("gender"))) {
					e.click();
				}
			}
			System.out.println("Test is Passed");
			//Thread.sleep(5000);
		}

		@AfterTest
		public void cleanUp() {
			driver.close();
		}	
	
		
	}
	
	
	


