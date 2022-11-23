/*
TC_3

1. Launch your oranage HRM URL
2. User Login with valid credential
3. Verify User profile is displayed
4. Mouse Hover on Profile and Click on setting icon on profile
5. Verify user menu total 2 options displayed
6. Click on About
7. Verify Employee is more than 0
8. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup.
*/

package deepakPatil.assignment10OrangeHRMScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import deepakPatil.base.StartupActions;
import deepakPatil.utils.PropertiesFileReader;

public class OrangeHRMTC03 {
	
	PropertiesFileReader fileRead = new PropertiesFileReader("D:\\Automation Class-TechnoCredit\\SeleniumTechnoAug2022\\src\\deepakPatil\\assignment10OrangeHRMScripts\\OrangeHRMDetails.properties");
	WebDriver driver;
	
	@BeforeTest
	void startUp() {
		driver= StartupActions.launch(fileRead.getValue("URL"));
		// Login with valid credentials
		driver.findElement(By.cssSelector("input[id=txtUsername]")).sendKeys(fileRead.getValue("Username"));
		driver.findElement(By.cssSelector("input[id=txtPassword]")).sendKeys(fileRead.getValue("Password"));
		driver.findElement(By.cssSelector("button[type=submit]")).click();
	}
	
	@Test
	void verifyCompanyDetails() throws InterruptedException {
		
		System.out.println("Step-Verify User profile is displayed");
		WebElement profile=driver.findElement(By.cssSelector("a[class='name']"));
		Assert.assertTrue(profile.isDisplayed(), "Profile is not displayed");
		
		System.out.println("Step-Mouse Hover on Profile and Click on setting icon on profile");
		Actions act = new Actions(driver);
		WebElement profilePic = driver.findElement(By.cssSelector("div[class=image-container]"));
		act.moveToElement(profilePic).build().perform();
		driver.findElement(By.cssSelector("div[class=picture] i[class=material-icons]")).click();
		
		System.out.println("Step-Verify user menu total 2 options displayed");
		List<WebElement> optionList= driver.findElements(By.cssSelector("div[class='picture'] div[class=sub-menu-item]"));
		Assert.assertEquals(optionList.size(), Integer.parseInt(fileRead.getValue("ProfilePicOptionsExpected")));
		
		System.out.println("Step-Click on About");
		optionList.get(1).click();
		
		System.out.println("Step-Verify Employee is more than 0");
		Thread.sleep(5000);
		String employees=driver.findElement(By.xpath("//div[@class='col s12'][3]")).getText();
		int employeeCount=Integer.parseInt(employees.substring(11, 13));
		if(employeeCount>0)
			System.out.println("Employee count is "+ employeeCount+". Test is passed.");
		else
			System.out.println("Employee count is "+ employeeCount+". Test is failed.");
		
		System.out.println("Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
		List <WebElement> popupOptions = driver.findElements(By.xpath("//div[@class='col s12']"));
		if(popupOptions.size()==5) {
			System.out.println("Verify popup options displayed");
			for(WebElement e : popupOptions) {
				if(e.isDisplayed()) {
					System.out.println(e.getText()+" Option is displayed");
				}else {
					System.out.println(e.getText()+" Option is not displayed");
				}
			}
		}
		
		
		System.out.println("Step-Click on OK button on popup");
		driver.findElement(By.cssSelector("a[id=heartbeatSubmitBtn]")).click();
		
		System.out.println("Test is passed");
	}
	
	@AfterTest
	void wrapUp() {
		driver.close();
	}

}
