/*
 * Assignment:8

Script 1: Login to application & update the personal information

1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name

 */

package akankshaVyas.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;
import akankshaVyas.base.PropertiesFileReader;

public class Assignment8_Login {

	WebDriver driver;

	@BeforeMethod
	void startFun() {
		System.out.println("Step : 1. launch your orange HRM site");
		driver = PredefinedActions.start("https://avyas-trials77.orangehrmlive.com/");
	}

	@Test
	void testCaseLogin() throws InterruptedException {

		// implicit wait
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);

		// object of property file reader
		PropertiesFileReader propertiesFileReader = new PropertiesFileReader(
				"src\\akankshaVyas\\PropertiesFiles\\OrangeHrmLoginCredentials.properties");

		System.out.println("Step : 2. Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(propertiesFileReader.getValue("Username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(propertiesFileReader.getValue("Password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("3. Click on my info tab & Update the require details & click on Save button");
		driver.findElement(By.xpath("//a[@class='top-level-menu-item'][@ui-sref='pim.my_info']")).click();

		driver.findElement(By.xpath("//input[@id='firstName']")).clear();

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akanksha");

		driver.findElement(By.xpath("//input[starts-with(@id,'lastName')]")).clear();
		driver.findElement(By.xpath("//input[starts-with(@id,'lastName')]")).sendKeys("Vyas");

		System.out.println("Step click on dropdown of Ethinicity");
		driver.findElement(By.xpath("(//input[@class='select-dropdown'])[5]")).click();

		System.out.println("click through select asian");
		driver.findElement(By.xpath("//div[@class='select-wrapper initialized']/ul/li/span[text()='Asian']")).click();

		System.out.println("Step :click on save");
		WebElement ele1 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		ele1.click();

		System.out.println("Step7: Validate Successfully Updated message on page");
		String actualMessage = driver.findElement(By.xpath("//div[@class = 'toast-message']")).getText();
		String expectedMessage = "Successfully Updated";
		Assert.assertEquals(actualMessage, expectedMessage, "Check for save message");
		System.out.println("  Updated Successfully");

		System.out.println("5. Refresh the page & validate the updated name");
		driver.navigate().refresh();

		String actualText = driver.findElement(By.xpath("//a[@class='name']")).getText();
		String expectedtext = "Akanksha Vyas";
		Assert.assertEquals(actualText, expectedtext, "name check successfully");
	}

	@AfterMethod
	void close() {
		PredefinedActions.closeAllBrowser();
	}
}
