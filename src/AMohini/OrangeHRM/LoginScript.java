package AMohini.OrangeHRM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AMohini.CommonActions.*;
import AMohini.utils.PropertyFileReader;

public class LoginScript {

	WebDriver driver;
	PropertyFileReader prop = new PropertyFileReader("src/AMohini/OrangeHRM/OrangeHRM.properties");

	@BeforeMethod

	void orangeSetup() throws InterruptedException {

		System.out.println("STEP : Launch browser and hit URL");
		driver = PredefinedActions.start(prop.getValueForKey("applicationURL"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValueForKey("implicitWait")),
				TimeUnit.SECONDS);
		System.out.println("STEP : Navigate to Orange HRM");

	}

	@Test
	public void doLoginonOrangeHRM() {

		// Logging in
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValueForKey("userName"));
		System.out.println("STEP : User Name Enetered");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValueForKey("password"));
		System.out.println("STEP : Password Enetered");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("STEP : Click on Login Button");

		// Login Validation
		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Logged In Succesfully");
		} else
			System.out.println("Login Failed");

		// Move to my info page

		driver.findElement(By.xpath("//a[@ui-sref='pim.my_info']")).click();

		// Enter First Name
		System.out.println("Enter First Name");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(prop.getValueForKey("fName"));

		// Enter Last Name
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(prop.getValueForKey("lName"));

		// Enter Employee ID
		System.out.println("Enter Employee ID");
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(prop.getValueForKey("empID"));

		// Enter Employee BirthDate
		System.out.println("Enter BirthDate");
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(prop.getValueForKey("empDOB"));

		// Select Marrital Status
		System.out.println("Select Marrital Status");
		WebElement MStatus = (WebElement) driver.findElements(By.xpath("//div[@id='emp_marital_status_inputfileddiv']"));
		Select MarritalStatus = new Select(MStatus);
		MarritalStatus.selectByVisibleText(prop.getValueForKey("mstatus"));
		
		// Select Gender
		System.out.println("Select Gender");
		WebElement GenderElement = (WebElement) driver.findElements(By.xpath("//div[@id='emp_gender_inputfileddiv']"));
		Select Gender = new Select(GenderElement);
		Gender.selectByVisibleText(prop.getValueForKey("gender"));
		
		// Select Nationality
		System.out.println("Select Nationality");
		WebElement NationalityEle = (WebElement) driver.findElements(By.xpath("//div[@id='nation_code_inputfileddiv']"));
		Select Nationality = new Select(NationalityEle);
		Nationality.selectByVisibleText(prop.getValueForKey("nationality"));
		
		// Enter License Expiry Date
		System.out.println("Enter License Expiry Date");
		driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']")).sendKeys(prop.getValueForKey("LicExp"));
		
		// Select Ethnicity
		System.out.println("Select Ethnicity");
		WebElement EthnicityEle = (WebElement) driver.findElements(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']"));
		Select Ethnicity = new Select(EthnicityEle);
		Ethnicity.selectByVisibleText(prop.getValueForKey("ethnicity"));
		
		
		
		driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']//button[@type='submit']")).click();
//		Alert alert= driver.switchTo().alert();//switching to alert generated after click on Alert Button
//		System.out.println("Message from Alert: "+alert.getText());//display message on alert
//		alert.accept(); //accepted an Alert
//		

	}

//	@AfterMethod
//	public void cleanUp() {
//		PredefinedActions.closeBrowser();
//		
//	}
}
