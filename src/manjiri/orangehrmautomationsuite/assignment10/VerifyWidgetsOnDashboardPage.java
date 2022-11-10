/*1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Login button on Login Page
4. Verify total 9 widget's are disply on Dashboard page
5. Verify below widget displayed on Dashboard Page
"Quick Access", 
"Buzz Latest Posts", 
"My Actions", 
"Headcount by Location", 
"Employees on Leave Today", 
"Time At Work", 
"Latest Documents", 
"Latest News" 
"COVID-19 Report"*/

package manjiri.orangehrmautomationsuite.assignment10;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;
import manjiri.orangehrmautomationsuite.utils.PropertiesFileReader;

public class VerifyWidgetsOnDashboardPage {

	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader(
			"src/manjiri/orangehrmautomationsuite/propertiesfile/orangeHRMLogin");

	@BeforeMethod
	public void setup() {
		System.out.println("Step: Launch the browser and hit URL");
		driver = PredefinedActions.start("https://mchourikar-trials77.orangehrmlive.com/");

		// Added implicit wait for 35 sec
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	@Test
	public void applicationLogin() {
		System.out.println("Step: Enter Username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("username"));

		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));

		System.out.println("Step: Click on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> listOfWidgets =driver.findElements(By.xpath("//div[@class='dashboard-layout']//div[@class='col-4 rh-3 oxd dashboard-widget-shell' or @class='col-8 rh-3 oxd dashboard-widget-shell']//span[@class='widget-header-text' or text()='COVID-19 Report' or text()='Headcount by Location']"));
		System.out.println(listOfWidgets.size());
		
		for(WebElement e : listOfWidgets) {
			System.out.println(e.getText());
		}
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
