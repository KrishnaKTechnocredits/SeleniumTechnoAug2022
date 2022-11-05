/*Assignment No 10 : 4th Nov 2022

TC_4

1. Launch your orange HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero

*/

package sanket.orangeHRM_scripts;

import java.awt.AWTException;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sanket.base.PredefinedActions;
import sanket.utils.ProprtiesFileReaderUtil;

public class Assignment10OrangeHRMTestScript4 {

	WebDriver driver;
	ProprtiesFileReaderUtil prop = new ProprtiesFileReaderUtil("src/sanket/orangeHRM_scripts/orangehrm.properties");

	@BeforeMethod
	public void preTestSetup() throws Exception {

		System.out.println("STEP 1 - Launch Chrome Browser and OrangeHRM URL.");
		driver = PredefinedActions.start(prop.getValue("loginUrl"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")), TimeUnit.SECONDS);
		System.out.println("STEP 2 - Nevigate to Oranage URL.");
	}

	@Test
	public void orangeHRMTestEmpCTCDetails() throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
		System.out.println("STEP 3 - UserName is entered.");

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
		System.out.println("STEP 4 - Password is entered.");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Employee Management";

		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("STEP 5 - Login successfully in Orange HRM.");

		driver.findElement(By.xpath("//a[@ui-sref='pim.my_info']")).click();
		System.out.println("STEP 6 - Click on my info tab.");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[@id='personal_details_tab']/h4[text()='Personal Details']"))));

		String actualDeatil = driver
				.findElement(By.xpath("//div[@id='personal_details_tab']/h4[text()='Personal Details']")).getText();
		String expectedDetail = "Personal Details";
		Assert.assertEquals(expectedDetail, actualDeatil);
		System.out.println("STEP 7 - Verify user Personal info displayed.");

		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//a[@data-automation-id='menu_employee_profile_Salary']"))).build()
				.perform();
		System.out.println("STEP 8 - Click on Salary.");

		
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[@translate='Cost to the Company']/following-sibling::div"))));
		String salaryInString = driver
				.findElement(By.xpath("//div[@translate='Cost to the Company']/following-sibling::div")).getText();
		String actualCTCString = "";
		for (int index = 0; index < salaryInString.length(); index++) {
			char ch = salaryInString.charAt(index);
			if (Character.isDigit(ch)) {
				actualCTCString = actualCTCString + ch;
			}
		}
		actualCTCString = actualCTCString.substring(0, 6);
		int actualSalary = (Integer.parseInt(actualCTCString));
		if (actualSalary > 0)
			System.out.println("Verified that the payable (CTC) amount is non-zero");
		System.out.println("The salary is : " + actualCTCString);
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("STEP 9 -  Browser close Successfully.");
		driver.quit();
	}
}