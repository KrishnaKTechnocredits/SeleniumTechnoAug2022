//Assignment 8 
/*1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name"*/

package komalShrivastava.orangeHRMScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import komalShrivastava.base.PredefinedActions;
import komalShrivastava.utility.PropertyFileReader;

public class TestScript1 {

	WebDriver driver;
	
	@BeforeTest
	public void launchURL() {
		driver = PredefinedActions.start("https://kshrivastava-trials77.orangehrmlive.com/");
	}
	
	@Test
	public void loginTest() throws InterruptedException{
		PropertyFileReader prop = new PropertyFileReader();
		driver.findElement(By.id("txtUsername")).sendKeys(prop.getPropertyValue("orangeHRMUsername"));
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getPropertyValue("orangeHRMPassword"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("STEP : Validate Page title");
		String actualTitle = driver.findElement(By.xpath("//ul[@class='topbar-title']")).getText();
		Assert.assertEquals(actualTitle, "Employee Management");
		
		System.out.println("STEP : Click on My Info tab");
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']")).click();
		
		System.out.println("STEP : Verify if My info tab is loaded");
		String actualTabTile= driver.findElement(By.id("personal_details_tab")).getText();
		Assert.assertEquals(actualTabTile,"Personal Details");
		
		System.out.println("STEP : Update the information");
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.clear();
		firstName.sendKeys("Komal");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.clear();
		lastName.sendKeys("Shrivastava");
		
		System.out.println("STEP : Click on Save button");
		driver.findElement(By.xpath("//form[@id='pimPersonalDetailsForm']//button[@type='submit']")).click();
		
		System.out.println("Validate the Success message");
		String actualMsg = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		
		Assert.assertEquals(actualMsg, "Successfully Updated");
		
		System.out.println("STEP : Refresh the Page");
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		System.out.println("STEP : Validate the updated name");
		String actualName = driver.findElement(By.xpath("//div[@id='left-menu']//a[@class='name']")).getText();
		Assert.assertEquals(actualName, "Komal Shrivastava", "Incorrect Name, Details not updated");
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("STEP :  Close the browser");
		//driver.close();
	}
}