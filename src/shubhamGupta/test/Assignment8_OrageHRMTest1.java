package shubhamGupta.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import shubhamGupta.base.PredefinedActions;
import shubhamGupta.utils.PropertyFileReader;

public class Assignment8_OrageHRMTest1 {
	WebDriver driver;
	PropertyFileReader prop = new PropertyFileReader("src\\shubhamGupta\\Files\\OrangeHrmMyInfo.properties");

	@BeforeMethod
	public void launchBrowserDoLogin() {
		System.out.println("Step 1: Launch Chrome Browser and open URL");
		driver = PredefinedActions.start("https://shubgupta-trials77.orangehrmlive.com/");

		System.out.println("Step2: Enter Credentials for Login");
		PredefinedActions.loginToOrangeHRM();

		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Employee Management";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Expected Title is: " + ExpectedTitle);
		System.out.println("Actual Title is: " + ActualTitle);
		System.out.println("Login Successful");

	}

	@Test
	public void verifyTest1SelectSendKeysNavigation() {

		System.out.println("Step3: Navigate to myInfo tab");
		driver.findElement(By.xpath("//a[@href='#/pim/my_info']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Step4: Enter Personal details");

		// Clearing existing data from firstName and adding new
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.clear();
		firstName.sendKeys(prop.getValue("firstName"));

		// Clearing existing data from middleName and adding new
		WebElement middleName = driver.findElement(By.xpath("//input[@id='middleName']"));
		middleName.clear();
		middleName.sendKeys(prop.getValue("middleName"));

		// Clearing existing data from lastName and adding new
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys(prop.getValue("lastName"));

		// Clearing existing data from employeeId and adding new
		WebElement empId = driver.findElement(By.xpath("//input[@id='employeeId']"));
		empId.clear();
		empId.sendKeys(prop.getValue("employeeId"));

		// Clearing existing data from otherId and adding new
		WebElement otherId = driver.findElement(By.xpath("//input[@id='otherId']"));
		otherId.clear();
		otherId.sendKeys(prop.getValue("otherId"));

		// Clearing existing data from emp_birthday and adding new
		WebElement dob = driver.findElement(By.xpath("//input[@id='emp_birthday']"));
		dob.clear();
		dob.sendKeys(prop.getValue("dob"));

		// Selecting Maritial status
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//ul/li/span[text()='Married']"))
				.click();

		// Selecting Gender
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//ul/li/span[text()='Male']")).click();

		// Selecting Nationality
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//ul/li/span[text()='Indian']")).click();

		// Clearing existing data from licenseNum and adding new
		WebElement licenseNum = driver.findElement(By.xpath("//input[@id='licenseNo']"));
		licenseNum.clear();
		licenseNum.sendKeys(prop.getValue("drivingLicense"));

		// Clearing existing data from licenseExpiry and adding new
		WebElement licenseExpiry = driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']"));
		licenseExpiry.clear();
		licenseExpiry.sendKeys(prop.getValue("licenseExpiry"));

		// Selecting Nationality
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//ul/li/span[text()='Indian']")).click();

		// Selecting Race
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//ul/li/span[text()='Asian']")).click();

		// Clicking on Save button
		WebElement save = driver
				.findElement(By.xpath("//div[@class='form-group schema-form-submit right']/button[@type='submit']"));
		save.click();
		System.out.println("Personal details filled and clicked on save button");

		// Verifying that data is saved successfully
		String confirmationMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		String expectedMessage = "Successfully Updated";
		Assert.assertEquals(confirmationMessage, expectedMessage);
		System.out.println(confirmationMessage);

		// Refreshing the page
		System.out.println("Step5: Refreshing the page.");
		driver.navigate().refresh();

		System.out.println("My Info page loaded");

		// Validating first name
		WebElement name = driver.findElement(By.xpath("//a[@class='name']"));

		String actualFirstNameString = name.getText();
		String expectedFirstName = prop.getValue("firstName") + " " + prop.getValue("lastName");
		Assert.assertEquals(actualFirstNameString, expectedFirstName);
		System.out.println("Updated name is displaying now.");
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowsers();
		System.out.println("Browser is closed");

	}
}