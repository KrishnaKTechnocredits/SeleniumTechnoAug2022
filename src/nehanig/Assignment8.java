package nehanig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment8 {
	WebDriver driver;
	PropertiesFileReader property = new PropertiesFileReader("src\\nehanig\\OrangeHRM.properties");

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start("https://ngupta-trials77.orangehrmlive.com/auth/seamlessLogin");

		driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertiesFileReader.getValue("waitingTime")),
				TimeUnit.SECONDS);
	}

	@Test

	public void orangeHRMLogin() throws InterruptedException, IOException {
		File file = new File("src\\nehanig\\OrangeHRM.properties");
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		Thread.sleep(3000);

		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");

			System.out.println("Step: Verify login successfully");
			Assert.assertEquals(driver.getTitle(), "Employee Management");

			System.out.println("Step: Click on my info tab");
			driver.findElement(By.xpath("(//a[@class='top-level-menu-item'])[2]")).click();

			System.out.println("Step: Update the require details");
			driver.findElement(By.xpath("//input[@id='firstName']")).clear();
			driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(prop.getProperty("firstName"));
			driver.findElement(By.xpath("//input[@id='middleName']")).clear();
			driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(prop.getProperty("middleName"));
			driver.findElement(By.xpath("//input[@id='lastName']")).clear();
			driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(prop.getProperty("lastName"));
			driver.findElement(By.xpath("//input[@id='emp_birthday']")).clear();
			driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(prop.getProperty("dateOfBirth"));

			System.out.println("Step: Click on Save button");
			driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']/button[@type='submit']"))
					.click();

			System.out.println("Step: Validate Successfully Updated message on page");
			String actualMessage = driver.findElement(By.xpath("//div[@class = 'toast-message']")).getText();
			String expectedMessage = "Successfully Updated";
			Assert.assertEquals(actualMessage, expectedMessage);
			System.out.println("Updated Successfully");

			System.out.println("Step: Refresh the page & validate the updated name");
			driver.navigate().refresh();

			String expectedName = prop.get("firstName") + " " + prop.getProperty("lastName");
			String actualName = driver.findElement(By.xpath("//a[@class='name']")).getText();
			Assert.assertEquals(actualName, expectedName);

			System.out.println("Name updated successfully");

			Thread.sleep(10000);
		}
	}

	@AfterTest
	void closeChromeBrowser() {
		PredefinedActions.closeAllBrowser();
	}

}
