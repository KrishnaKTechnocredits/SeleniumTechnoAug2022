package nehanig;

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

public class Assignment10 {
	WebDriver driver;
	PropertiesFileReader property = new PropertiesFileReader("src\\nehanig\\OrangeHRM.properties");

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start("https://ngupta-trials77.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	}

	@Test

	public void testCase3() throws InterruptedException, IOException {
		File file = new File("src\\nehanig\\OrangeHRM.properties");
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		Thread.sleep(3000);

		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");

			WebDriverWait wait = new WebDriverWait(driver, 50);
			System.out.println("Step: Verify User profile is displayed");
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))));
			if (driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']")).isDisplayed()) {
				System.out.println("User profile displayed");
			} else {
				System.out.println("User profile displayed");
			}

			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))).build()
					.perform();
			driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']")).click();

			System.out.println("Step: Verify user menu total 2 options displayed");
			int expectedOptions = 2;
			int actualOptions = driver.findElements(By.xpath(
					"//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div[@class='sub-menu-container']/div"))
					.size();
			Assert.assertEquals(actualOptions, expectedOptions);
			System.out.println("2 options displayed");

			System.out.println("Step: Click on About");
			driver.findElement(By.cssSelector("a#aboutDisplayLink")).click();
			String about = driver.findElement(By.cssSelector("div.customized-modal-header>h4")).getText();
			if (about.equals("About"))
				System.out.println("About tag is present");

			System.out.println("Step: Verify Employee is more than 0");
			String employeeCount = driver.findElement(By.xpath("//p[contains(text(),'Employees')]")).getText();
			System.out.println(employeeCount);

			String arr[] = employeeCount.split(" ");
			String empCount = arr[1];
			int empPresentCount = Integer.parseInt(empCount);
			boolean flag = false;
			if (empPresentCount > 0) {
				flag = true;
			}
			Assert.assertEquals(flag, true, "checking count for employee more than 0");
			System.out.println("Employee count is more then 0. Actual count is: " + employeeCount);

			System.out.println(
					" Step: Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");

			List<WebElement> aboutInfo = driver.findElements(By.xpath("//div[@id='companyInfo']//div//p"));
			if (aboutInfo.size() > 0) {
				System.out.println("Details -->");
				for (WebElement details : aboutInfo) {
					System.out.println("  " + details.getText());
				}
			} else {
				System.out.println("Details are not visible");
			}

			System.out.println("Step: Click on OK button on popup");
			driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
			System.out.println("Test case passed");
		}

	}

	@AfterMethod
	void closeChromeBrowser() {
		PredefinedActions.closeAllBrowser();
	}

}
