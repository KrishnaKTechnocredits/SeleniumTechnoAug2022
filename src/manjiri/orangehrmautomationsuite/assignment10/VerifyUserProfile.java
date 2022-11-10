/*1. Launch your oranage HRM URL
2. User Login with valid credential
3. Verify User profile is displayed
4. Mouse Hover on Profile and Click on setting icon on profile
5. Verify user menu total 2 options displayed
6. Click on About
7. Verify Employee is more than 0
8. Verify the company details  fields are getting displayed on information alert 
(Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup.*/

package manjiri.orangehrmautomationsuite.assignment10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;
import manjiri.orangehrmautomationsuite.utils.PropertiesFileReader;

public class VerifyUserProfile {

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
	public void verifyUserProfile() {
		System.out.println("Step: Enter Username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("username"));

		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));

		System.out.println("Step: Click on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Step: Verify User Profile is displayed");
		WebElement ele =driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']/div[@class='picture']//following-sibling::a[@class='name']"));
		if(ele.isDisplayed()) {
			System.out.println("User Profile Verified");
		}
		else {
			System.out.println("User Profile not verified");
		}
		
		System.out.println("Step: Mouse Hover on User profile");
		Actions action = new Actions(driver);
		WebElement ele2 = driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']/div[@class='picture']/div[@class='image-container']"));
		action.moveToElement(ele2).build().perform();
		
		System.out.println("Step: Click on Settings");
		action.click(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']/div[@class='picture']/div[@class='image-container']/a/i[text()='ohrm_settings']"))).build().perform();
		
		System.out.println("Step: Verify the list of items displayed");
		List<WebElement> listOfItems = driver.findElements(By.xpath("//div[@class='picture']//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div//div"));
		System.out.println("Total items in list:" + listOfItems.size());
		System.out.println("Items in list menu are:");
		for(WebElement e : listOfItems) {
			System.out.println(e.getText());
		}
		
		System.out.println("Step: Click on About");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		String msg = driver.findElement(By.xpath("//div[@class='customized-modal-header']/h4[text()='About']")).getText();
		System.out.println("Text on header of newly opened dialog:" + msg);
		
		List<WebElement> listOfInfo = driver.findElements(By.xpath("//div[@id='companyInfo']/div//div"));
		LinkedHashMap<String,String> mapOfCompanyDetails = new LinkedHashMap<String,String>();
		System.out.println("Verify number of Employees");
		for(WebElement e2:listOfInfo) {
			String str2 = e2.getText();
			if(str2.contains("Employees")) {
				String[] arr =str2.split(" ");
				int num = Integer.parseInt(arr[1]);
				if(num > 0) {
					System.out.println("Pass - Number of employee are: " + num);
				}
				else {
					System.out.println("Fail - Invalid value for Number of Employees!!!");
				}
			}
			else {
				String[] arr2 = str2.split(":");
				mapOfCompanyDetails.put(arr2[0], arr2[1]);
			}
		}
		
		Set<String> actualList = mapOfCompanyDetails.keySet();
		Iterator<String> itr = actualList.iterator();
		String[] expectedList = {"Company Name", "Version", "Users", "Renewal on"};
		LinkedHashSet<String> expectedSetOfCompanyDetails =  new LinkedHashSet<String>(Arrays.asList(expectedList));
		Iterator<String> itr2 = expectedSetOfCompanyDetails.iterator();
		while(itr.hasNext()) {
			String s1 = itr.next();
			String s2 = itr2.next();
			Assert.assertEquals(s1, s2);
		}
		System.out.println("Information displayed successfully");
		
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn'][text()='Ok']")).click();
		System.out.println("Test case Pass!!!");
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
