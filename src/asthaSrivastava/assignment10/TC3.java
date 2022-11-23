/*TC_3

1. Launch your orange HRM URL
2. User Login with valid credential
3. Verify User profile is displayed
4. Mouse Hover on Profile and Click on setting icon on profile
5. Verify user menu total 2 options displayed
6. Click on About
7. Verify Employee is more than 0
8. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup.
*/
package asthaSrivastava.assignment10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import asthaSrivastava.PredefinedActions;
import asthaSrivastava.utils.PropertiesFileReader;

public class TC3 {

	WebDriver driver;
	PropertiesFileReader propertyDetails = new PropertiesFileReader(
			"src/asthaSrivastava/assignment10/OrangeHRMTC3.properties");

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = PredefinedActions.start("http://asrivastava-trials77.orangehrmlive.com");
		System.out.println("STEP : Launch Orange HRM Url");
	}

	@Test
	public void tC3() {
		System.out.println("Step2: Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(propertyDetails.getValue("userName"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(propertyDetails.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='name']"))));
		System.out.println("VERIFY : Verify User profile is displayed");
		if(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']")).isDisplayed()) {
			System.out.println("User Profile is displayed");
		}else {
			System.out.println("User Profile is not displayed");
		
		}
		
		Actions actions = new Actions(driver);
		System.out.println("STEP : Mouse Hover on Profile");
		actions.moveToElement(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))).build().perform();
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']")).click();
		
		System.out.println("VERIFY : Verify user menu total 2 options displayed ");
		int expectedOptions = 2;
		int actualOptions= driver.findElements(By.xpath(""
				+ "//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div/div")).size();
		Assert.assertEquals(expectedOptions, actualOptions);
		System.out.println(" 2 options displayed");
		
		System.out.println("STEP : Click on About");
		driver.findElement(By.cssSelector("a[id='aboutDisplayLink']")).click();
		System.setProperty("webdriver.chrome.silentOutput","true");
		
		System.out.println("VERIFY : Verify Employee is more than 0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#companyInfo")));
		
		String empInfo= driver.findElement(By.cssSelector(""
				+ "div#companyInfo>div>div:nth-child(3)>p")).getText();
		
		String[] empArr = empInfo.split(" ");
		int empCount = Integer.parseInt(empArr[1]);
		if (empCount > 0) {
			System.out.println("  Employees are more than 0 ,count is " + empCount);
		} else {
			System.out.println("  Employee count is 0");
		}

		System.out.println(
				"VERIFY: Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
		List<WebElement> aboutInfo = driver.findElements(By.xpath("//div[@id='companyInfo']//div//p"));
		if (aboutInfo.size() > 0) {
			System.out.println("Details -->");
			for (WebElement details : aboutInfo) {
				System.out.println("  " + details.getText());
			}
		} else {
			System.out.println("Details are not visible");
		}

		System.out.println("STEP: Click on OK button on popup");
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}