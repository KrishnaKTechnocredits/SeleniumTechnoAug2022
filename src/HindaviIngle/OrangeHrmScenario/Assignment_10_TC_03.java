
/*
 * 1. Launch your oranage HRM URL
2. User Login with valid credential
3. Verify User profile is displayed
4. Mouse Hover on Profile and Click on setting icon on profile
5. Verify user menu total 2 options displayed
6. Click on About
7. Verify Employee is more than 0
8. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup.
 */
package HindaviIngle.OrangeHrmScenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

import HindaviIngle.base.PredefinedActions;

public class Assignment_10_TC_03 {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	void beforeMethod() throws IOException {
		File file = new File(
				"D:\\TechnoCredit\\workspace\\Selenium_Oct22\\SeleniumTechnoAug2022\\src\\HindaviIngle\\PropertyFile\\OrangeHrmDetails");
		FileInputStream fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);
		System.out.println("--->" + prop.getProperty("url"));
		driver = PredefinedActions.start(prop.getProperty("url"));
	}

	@Test

	void tC3() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println("Step2 : fill login details from property file");
		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("txtPassword")).sendKeys(prop.getProperty("password"));
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		wait.until(ExpectedConditions.visibilityOf(element)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Step3 : Click on My info Link");
		driver.findElement(By.xpath("//a[normalize-space()='My Info']")).click();

		System.out.println("Step4 Verify User profile is displayed");
		WebElement profileName = driver.findElement(By.xpath("//a[text()='Reyaansh ingle']"));
		if (profileName.isDisplayed() == true) {
			System.out.println("Profile name displaying correct");

		} else {
			System.out.println("Incorrect Profile name");
		}

		System.out.println("Step 5 Verify user menu total 2 options displayed");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))).build().perform();
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']")).click();

		System.out.println("Step5: Verify user menu total 2 options displayed");

		int expectedOptions = 2;
		int actualOptions = driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div/div")).size();
		Assert.assertEquals(actualOptions, expectedOptions);

		System.out.println("  Two options displayed");

		System.out.println("Step6: Click on About");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();

		System.out.println("Step7: Verify Employee is more than 0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='companyInfo']")));

		String employeesInfo = driver
				.findElement(By.xpath("//div[@id='companyInfo']//div//p[contains(text(),'Employees:')]")).getText();

		String[] strArr = employeesInfo.split(" ");

		int empCount = Integer.parseInt(strArr[1]);

		if (empCount > 0) {
			System.out.println("  Employees are more than 0 ,count is " + empCount);
		} else {
			System.out.println("  Employee count is 0");
		}

		System.out.println(
				"Step 8:Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on");

		List<WebElement> listOfElement = driver.findElements(By.xpath("//div[@id='companyInfo']//div//p"));
		if (listOfElement.size() > 0) {
			for (WebElement e : listOfElement) {
				System.out.println("Details-->" + e.getText());
			}

		} else {
			System.out.println("Details are not visible");
		}

		System.out.println("Step9: Click on OK button on popup");
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
