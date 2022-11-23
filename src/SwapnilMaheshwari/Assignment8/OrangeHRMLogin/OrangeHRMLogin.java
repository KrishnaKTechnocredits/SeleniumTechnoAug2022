package SwapnilMaheshwari.Assignment8.OrangeHRMLogin;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SwapnilMaheshwari.PreDefineMethods.CommonMethods;

public class OrangeHRMLogin {
	WebDriver driver;

	@BeforeTest

	void browserOpen() {
		System.out.println("Step-Launch the Orange HRM applicagtion");
		driver = CommonMethods.openBrowser("https://smaheshwari-trials77.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	void login() {

		System.out.println("Step- Login with valid user name and credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("I1Zfc@L9Cj");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Step - Click on my info tab & Update the require details & click on Save button");
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Swapnil");
		String fname = driver.findElement(By.xpath("//input[@id='firstName']")).getText();
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Maheshwari");
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//div/ul/li[2]/span")).click();
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//div/ul/li[3]/span")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//li//span[text()='Indian']")).click();
		driver.findElement(By.xpath("//button[@class=' btn waves-effect waves-green ']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validate sucessfully updataed message on page");
		String expectedText = "Successfully Updated";
		String actualText = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Record updated successfully");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Validate that detatils updated on page");
		String fullName = driver.findElement(By.xpath("//a[@class='name'][text()='Swapnil Maheshwari']")).getText();
		String actualFullName = "Swapnil Maheshwari";
		Assert.assertEquals(fullName, actualFullName);
		System.out.println("Name updated successfully");
	}
}
