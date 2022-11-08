/*
 * Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)

//*

  String mainWindowID=driver.getWindowHandle();
	Set<String> multiplenWindowId = driver.getWindowHandles();
	System.out.println("main window is :" + mainWindowID);
	System.out.println("multiple windows id are :" + multiplenWindowId);
	Iterator<String> itr =multiplenWindowId.iterator();
	while(itr.hasNext()) {
		String currentWindow=itr.next();
		if(!currentWindow.equals(mainWindowID)) {
			driver.switchTo().window(currentWindow);
*
/
 */


package akankshaVyas;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;
import akankshaVyas.base.PropertiesFileReader;

public class Assignment5_Property {
WebDriver driver;

@BeforeMethod
void m1() {
	driver=PredefinedActions.start("https://facebook.com/#");
}
	
	@Test
	void m2() throws InterruptedException {
		
		System.out.println("Step2 - Verify Application is loaded successfully.");
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"checking title");
		
		Thread.sleep(2000);
		System.out.println("Nevigate to Create New Account on Facebook and click on it");
		driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]/a")).click();
		
		//property file path
		PropertiesFileReader propertiesFileReader = new PropertiesFileReader("src/akankshaVyas/Akanksha.Properties");
		
		//Thread.sleep(5000);
		System.out.println("STEP - Enter fname,surname,email and password");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(propertiesFileReader.getValue("Firstname"));
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(propertiesFileReader.getValue("Lastname"));
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(propertiesFileReader.getValue("email"));
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(propertiesFileReader.getValue("newPassword"));
		
		System.out.println("Step - Select day");
		WebElement dateElement=driver.findElement(By.id("day"));
		Select dateSelect = new Select(dateElement);
		dateSelect.selectByVisibleText(propertiesFileReader.getValue("date"));
		
		System.out.println("Step - Select month");
		WebElement monthElement=driver.findElement(By.id("month"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText(propertiesFileReader.getValue("month"));
		
		System.out.println("Step - Select year");
		WebElement yearElement=driver.findElement(By.id("year"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText(propertiesFileReader.getValue("year"));
		
		System.out.println("Step - Select Gender");
		WebElement genderRadiobtn = driver.findElement(By.xpath("//label[text()='Female']"));
		String genderbtn = genderRadiobtn.getText();
		if (genderbtn.equals(propertiesFileReader.getValue("gender"))) {
			genderRadiobtn.click();
		}
		
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		}
	
	@AfterMethod
	void m3() {
		PredefinedActions.closeAllBrowser();
	}
}

