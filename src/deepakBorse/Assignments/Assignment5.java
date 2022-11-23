package deepakBorse.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import deepakBorse.utils.PropertiesFileReader;
import deepakBorse.base.PredefinedActions;

public class Assignment5 {
	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader("src/deepakBorse/base/facebooksignup.properties");

	@BeforeMethod
	public void initprocess() {
		driver = PredefinedActions.start(prop.getValue("fburl"));
	};

	@Test
	public void fbsignuppage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Click on Create New Account link");

		driver.findElement(By.xpath(prop.getValue("createacctbutn"))).click();
		System.out.println("Enter Firstname");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(prop.getValue("firstname"));
		System.out.println("Enter Lastname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getValue("lastname"));
		System.out.println("Enter email address");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(prop.getValue("emailaddress"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println("Enter confirmation email address");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));

		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"))
				.sendKeys(prop.getValue("emailaddress"));
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(prop.getValue("password"));

		// //select[@id='day'] //select[@id='month'] //select[@id='year']

		// select Day form dropdown
		System.out.println("Enter DOB - Day");
		WebElement DOBElement = driver.findElement(By.xpath("//select[@id='day']"));
		Select DOBSelect = new Select(DOBElement);
		DOBSelect.selectByVisibleText(prop.getValue("day"));

		// select month form dropdown
		System.out.println("Enter DOB - Month");
		DOBElement = driver.findElement(By.xpath("//select[@id='month']"));
		DOBSelect = new Select(DOBElement);
		DOBSelect.selectByVisibleText(prop.getValue("month"));

		// select year form dropdown
		System.out.println("Enter DOB - year");
		DOBElement = driver.findElement(By.xpath("//select[@id='year']"));
		DOBSelect = new Select(DOBElement);
		DOBSelect.selectByVisibleText(prop.getValue("year"));

		List<WebElement> genderslect = driver.findElements(By.xpath("//span[@class='_5k_3']//label"));
		for (WebElement gen : genderslect) {
			// System.out.println(gen.getText());
			if (gen.getText().equals(prop.getValue("gender"))) {
				gen.click();

			}

		}
		System.out.println("Test case passed");
		Thread.sleep(2000);
	}

	@AfterMethod

	public void endprocess() {
		PredefinedActions.closeAllBrowser();
	}
}
