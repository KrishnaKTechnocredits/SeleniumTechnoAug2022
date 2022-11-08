
/*
 * Script 1: Login to application & update the personal information

1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name
 */
package HindaviIngle.OrangeHrmScenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class Assignment_08_LoginNPersonalDetails {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	void beforeMethod() throws IOException {
		File file = new File(
				"D:\\TechnoCredit\\workspace\\Selenium_Oct22\\SeleniumTechnoAug2022\\src\\HindaviIngle\\PropertyFile\\OrangeHrmDetails");
		FileInputStream fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);
		System.out.println("--->" + prop.getProperty("url"));
		driver = PredefinedActions.start(prop.getProperty("url"));
	}

	@Test
	void updatePersonalDetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println("Step2 : fill login details from property file");
		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("txtPassword")).sendKeys(prop.getProperty("password"));
		// WebElement
		// element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit']"))));
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		wait.until(ExpectedConditions.visibilityOf(element)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Step3 : Click on My info Link");
		driver.findElement(By.xpath("//a[normalize-space()='My Info']")).click();

		System.out.println("Step3 : Fill personal deatils from property file");
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(prop.getProperty("fname"));

		driver.findElement(By.id("lastName")).clear();

		driver.findElement(By.id("lastName")).sendKeys(prop.getProperty("lname"));

		driver.findElement(By.id("employeeId")).clear();

		driver.findElement(By.id("employeeId")).sendKeys(prop.getProperty("eid"));

		driver.findElement(By.id("emp_birthday")).clear();

		driver.findElement(By.id("emp_birthday")).sendKeys(prop.getProperty("dob"));

//cant use select class here as element is not developed with select class
//	Select s = new Select(driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//select[@id='nation_code']")));
//	s.selectByVisibleText("American");
//	System.out.println("*** "+s.getOptions().get(2));

		System.out.println("Step 4 Click on Nationality dropdown");
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']")).click();

		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv'] //li/span[text()='Indian']")).click();

		System.out.println("Step 5 Click on Race dropdown");

		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//li/span[text()='Asian']")).click();
		
		System.out.println("Step 5 Click on Save button");
		driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']/button[@type='submit']")).click();

		System.out.println("Step6: Validate Successfully Updated message on page");
		String actualMessage = driver.findElement(By.xpath("//div[@class = 'toast-message']")).getText();
		String expectedMessage = "Successfully Updated";
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println("  Updated Successfully");

		System.out.println("Step7: Refresh the page & validate the updated name");
		driver.navigate().refresh();

		String actualName = driver.findElement(By.xpath("//a[text()='Reyaansh ingle']")).getText();
		String expectedName = "Reyaansh ingle";

		Assert.assertEquals(actualName, expectedName);
		System.out.println(" Name Updated Successfully");

	}

	@AfterMethod
	void cleanUp() {
		driver.close();
	}
}
