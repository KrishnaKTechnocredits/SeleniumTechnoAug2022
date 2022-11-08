/*TC_3

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

package gauravSahu.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gauravSahu.InitialActions;
import technocredits.utils.PropertiesFileReader;

public class Assignment9 {

	WebDriver driver;
	PropertiesFileReader prop;

	@Test
	void launch() {
		driver = InitialActions.start("https://gsahu-trials77.orangehrmlive.com/auth/login");
		System.out.println("Step 2 : Login with credentials");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		prop = new PropertiesFileReader("src\\gauravSahu\\propertiesFile\\OrangeHRMLoginDetails.properties");

		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("userName"));
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test
	void testCase() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualName = driver.findElement(By.cssSelector("a.name")).getText();
		System.out.println(actualName);
		if(actualName.equals("Gaurav Sahu")) {
			System.out.println("Step 3 : Verify User profile is displayed");
		}
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector("div.image-container>img"))).build().perform();
		
		driver.findElement(By.cssSelector("div.image-container>a>i")).click();
		
		driver.findElement(By.cssSelector("a#aboutDisplayLink")).click();
		
		String reqText = driver.findElement(By.cssSelector("div#displayAbout>div:nth-child(2)>form>div>div>div>div:nth-child(3)>p")).getText();
		System.out.println(reqText);
		String[] textArray = reqText.split(" ");
		
		for(int i=0;i<textArray.length;i++) {
			try {
				int expEmpCount = Integer.parseInt(textArray[i]);
				if(expEmpCount>0) {
					System.out.println("Step : 7 -  Employee is more than 0");
					break;
				}
			}catch(Exception e) {
				
			}
		}
		
		prop = new PropertiesFileReader("src\\gauravSahu\\propertiesFile\\OrangeHRMInfoDetails.properties");
		
		String companyDetails = driver.findElement(By.cssSelector("div#displayAbout>div:nth-child(2)>form>div>div>div>div:nth-child(1)")).getText();
		String version = driver.findElement(By.cssSelector("div#displayAbout>div:nth-child(2)>form>div>div>div>div:nth-child(2)")).getText();
		String user = driver.findElement(By.cssSelector("div#displayAbout>div:nth-child(2)>form>div>div>div>div:nth-child(4)")).getText();
		String renewalOn = driver.findElement(By.cssSelector("div#displayAbout>div:nth-child(2)>form>div>div>div>div:nth-child(5)")).getText();
		
		String expcompanyDetails = prop.getValue("companyDetails");
		String expversion = prop.getValue("version");
		String expuser = prop.getValue("users");
		String exprenewalOn = prop.getValue("renewalOn");
		
		Assert.assertEquals(companyDetails, expcompanyDetails);
		Assert.assertEquals(version, expversion);
		Assert.assertEquals(user, expuser);
		Assert.assertEquals(renewalOn, exprenewalOn);
		
		System.out.println("Step : 8. Verify the company details  fields are getting displayed on information alert (Company Name, Version");
		
		driver.findElement(By.cssSelector("a#heartbeatSubmitBtn")).click();
		
		System.out.println("Step  : 9. Click on OK button on popup.");
		
		System.out.println("Test Case Passed");
	}

}
