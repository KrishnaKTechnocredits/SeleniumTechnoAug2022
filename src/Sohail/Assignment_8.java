package Sohail;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Sohail.*;

public class Assignment_8 {
	WebDriver driver;
	PropertiyFileReader prop = new PropertiyFileReader(
			"G:\\Technocredits\\Git\\SeleniumTechnoAug2022\\src\\Sohail\\OrangeHRM.properties");

	@BeforeTest
	void launch() throws InterruptedException {
		driver = PredefinedActions.openBrowser("https://smujawar-trials77.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	void login() throws InterruptedException, IOException {

		driver.findElement(By.id("txtUsername")).sendKeys(prop.getValue("userName"));
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");
		}
		driver.findElement(By.xpath("//a[@class='name']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(prop.getValue("firtsName"));
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(prop.getValue("lastName"));
		driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']//button[@type='submit']"))
				.click();
		String name = driver.findElement(By.xpath("//a[@class='name']")).getText();
		if (name.equals("John Sands")) {
			System.out.println("Info Updated Successfully");
		}
		Thread.sleep(10000);
	}

	@AfterTest
	void closeChromeBrowser() {
		PredefinedActions.closeAllBrowser();
	}

}
