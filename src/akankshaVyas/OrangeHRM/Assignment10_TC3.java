/*
 * /*Assignment10: TC_4
Test Steps :
1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero
___________________________________________________________________________
Test Case 3
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

package akankshaVyas.OrangeHRM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;
import akankshaVyas.base.PropertiesFileReader;

public class Assignment10_TC3 {

	WebDriver driver;

	@BeforeMethod
	void start() {

		System.out.println("Step 1. launch your orange HRM site");
		driver = PredefinedActions.start("https://avyas-trials77.orangehrmlive.com/client/#/dashboard");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	}

	@Test
	void testCase3() throws InterruptedException {

		// object of property file reader
		PropertiesFileReader propertiesFileReader = new PropertiesFileReader(
				"src\\akankshaVyas\\PropertiesFiles\\OrangeHrmLoginCredentials.properties");

		System.out.println("Step : 2. Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(propertiesFileReader.getValue("Username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(propertiesFileReader.getValue("Password"));
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

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))).build().perform();
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']")).click();

		System.out.println("Step 5: Verify user menu total 2 options displayed");
		int expectedOptions = 2;
		int actualOptions = driver.findElements(By.xpath(
				"//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div[@class='sub-menu-container']/div"))
				.size();
		Assert.assertEquals(actualOptions, expectedOptions);
		System.out.println("  2 options displayed");

		System.out.println("Step6: Click on About");
		driver.findElement(By.cssSelector("a#aboutDisplayLink")).click();
		String about = driver.findElement(By.cssSelector("div.customized-modal-header>h4")).getText();
		if (about.equals("About"))
			System.out.println("About tag is present");

		System.out.println("Step7: Verify Employee is more than 0");
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
				" Step8: Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");

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
		System.out.println("Test case passed");

	}

	@Test
	void testCase4() throws InterruptedException {

		// object of property file reader
		PropertiesFileReader propertiesFileReader = new PropertiesFileReader(
				"src\\akankshaVyas\\PropertiesFiles\\OrangeHrmLoginCredentials.properties");

		System.out.println("Step : 2. Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(propertiesFileReader.getValue("Username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(propertiesFileReader.getValue("Password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("3. Click on my info tab & Update the require details & click on Save button");
		driver.findElement(By.xpath("//a[@class='top-level-menu-item'][@ui-sref='pim.my_info']")).click();

		System.out.println("Step 5. Verify user Personal info displayed");
		WebDriverWait wait = new WebDriverWait(driver, 9000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));

		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed()) {
			System.out.println("  Personal details are displaying");
		} else {
			System.out.println("  Personal details are not displaying");
		}

		System.out.println("Step  6. Click on \"\"Salary\"\"");
		Thread.sleep(2500);
		driver.findElement(By.xpath("(//a[@class='top-level-menu-item'])[2]")).click();

		System.out.println("tab salary clicked");
		System.out.println("Step7: Check the payable (CTC) amount is non-zero");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='payGrade']")));
		String actualCTC = driver
				.findElement(By.xpath("//div[@translate='Cost to the Company']/following-sibling::div")).getText();
		System.out.println(actualCTC);
		Thread.sleep(2000);
		String expectedCTC = "$168,500.00";
		Assert.assertEquals(actualCTC, expectedCTC, "CTC value check");

		String valueCTC = "";
		for (int index = 0; index < actualCTC.length(); index++) {
			char ch = actualCTC.charAt(index);
			if (Character.isDigit(ch)) {
				valueCTC = valueCTC + ch;
			}
		}
		System.out.println(valueCTC);

		int salaryCTC = Integer.parseInt(valueCTC);
		System.out.println(salaryCTC);
		if (salaryCTC > 0)
			System.out.println("Salary is non zero");

	}

	@AfterMethod
	void close() {
		PredefinedActions.closeAllBrowser();
	}
}
