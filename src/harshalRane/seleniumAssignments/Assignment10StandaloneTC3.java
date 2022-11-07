package harshalRane.seleniumAssignments;

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

import harshalRane.base.PredefinedActions;
import harshalRane.utils.PropertiesFileReader;

public class Assignment10StandaloneTC3 {
	WebDriver driver;
	PropertiesFileReader property = new PropertiesFileReader(
			"src/harshalRane/propertiesFile/OrangeHRM.properties");

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start(property.getValue("url"));
	}

	@Test
	public void tc_3() {
		System.out.println("Step2: Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(property.getValue("username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(property.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		System.out.println("Step3: Verify User profile is displayed");
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))));
		if (driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']")).isDisplayed()) {
			System.out.println("  User profile displayed");
		} else {
			System.out.println(" User profile displayed");
		}

		System.out.println("Step4: Mouse Hover on Profile and Click on setting icon on profile");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))).build().perform();
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']")).click();

		System.out.println("Step5: Verify user menu total 2 options displayed");
		int expectedOptions = 2;
		int actualOptions = driver
				.findElements(
						By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div/div"))
				.size();
		Assert.assertEquals(actualOptions, expectedOptions);
		System.out.println("  2 options displayed");

		System.out.println("Step6: Click on About");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();

		System.out.println("Step7: Verify Employee is more than 0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='companyInfo']")));

		String employeesInfo = driver
				.findElement(By.xpath("//div[@id='companyInfo']//div//p[contains(text(),'Employees:')]")).getText();
		String[] empArr = employeesInfo.split(" ");
		int empCount = Integer.parseInt(empArr[1]);
		if (empCount > 0) {
			System.out.println("  Employees are more than 0 ,count is " + empCount);
		} else {
			System.out.println("  Employee count is 0");
		}

		System.out.println(
				"Step8: Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
		List<WebElement> aboutInfo = driver.findElements(By.xpath("//div[@id='companyInfo']//div//p"));
		if (aboutInfo.size() > 0) {
			System.out.println("Details -->");
			for (WebElement details : aboutInfo) {
				System.out.println("  " + details.getText());
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
