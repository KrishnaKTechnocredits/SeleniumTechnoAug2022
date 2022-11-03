package saroj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saroj.utils.PropertyFilesReader;

public class SeleniumAssignment8 {

	WebDriver driver;
	PropertyFilesReader prop = new PropertyFilesReader("src/saroj/propertiesFiles/orangeHRMLDetails.properties");

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step - Launch the Browser");
		driver = PredefinedActions.start(prop.getValue("url"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("wait")), TimeUnit.SECONDS);
		System.out.println("Step - Navigate to Orange HRM");
	}

	@Test
	public void OrangeHrmLogin() throws InterruptedException {
		System.out.println("Step - Enter User name");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(prop.getValue("Username"));
		System.out.println("Step - Enter Password");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(prop.getValue("Password"));
		System.out.println("Step - Press Submit button");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login failed");
		}

		System.out.println("Step - Click on my info tab");
		driver.findElement(By.xpath("//a[text()='My Info ']")).click();

		Thread.sleep(3000);
		System.out.println("Step - Update the require details");
		System.out.println("Enter First Name");
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(prop.getValue("FirstName"));
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(prop.getValue("LastName"));
		System.out.println("Enter Employee Id");
		driver.findElement(By.xpath("//input[@id='employeeId']")).clear();
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(prop.getValue("EmpId"));
		System.out.println("Enter DOB");
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).clear();
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(prop.getValue("DOB"));

		System.out.println("Enter Marital Status");
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id=\"emp_marital_status_inputfileddiv\"]//li[2]/span")).click();
		// WebElement maritalElement =
		// driver.findElement(By.xpath("//div[@id=\"emp_marital_status_inputfileddiv\"]//li[2]/span"));
		// Select select = new Select(maritalElement);
		// select.selectByVisibleText(prop.getValue("MaritalStatus"));
		System.out.println("Marital Status updated");

		System.out.println("Enter Gender");
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv'] //li[2]/span")).click();
		System.out.println("Gender Selected");

		System.out.println("Enter Nationality");
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv'] //li/span[text()='Indian']")).click();
		System.out.println("Nationality Selected");

		System.out.println("Enter Licence Expiry date");
		driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']")).clear();
		// driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']")).click();
		driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']"))
				.sendKeys(prop.getValue("LicenseExpiryDate"));

		System.out.println("Enter EEO");
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//li/span[text()='Asian']")).click();
		System.out.println("EEO Selected");

		System.out.println("Step - Enter Save button");
		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		System.out.println("Step - Validate Successfully Updated message on page");
		String expectedmsg = "Successfully Updated";
		String actualmsg = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualmsg, expectedmsg, actualmsg);

		System.out.println("Refresh the page");
		driver.navigate().refresh();

		System.out.println("Step - validate the updated name");
		Thread.sleep(6000);
		WebElement actualname = driver.findElement(By.xpath("//a[@class='name']"));
		String actualname1 = actualname.getText();
		String expectedname1 = prop.getValue("FirstName") + " " + prop.getValue("LastName");

		if (expectedname1.equals(actualname1)) {
			System.out.println("Name updated" + expectedname1);
		} else {
			System.out.println("Name not updated" + actualname1);
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
