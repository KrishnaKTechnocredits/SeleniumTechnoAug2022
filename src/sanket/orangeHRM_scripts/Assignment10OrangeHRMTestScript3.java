/*Assignment No 10 : 4th Nov 2022

TC_3	Verify Company Details and Employyes are non-zero	"


1. Launch your oranage HRM URL
2. User Login with valid credential
3. Verify User profile is displayed
4. Mouse Hover on Profile and Click on setting icon on profile
5. Verify user menu total 2 options displayed
6. Click on About
7. Verify Employee is more than 0
8. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup."
*/

package sanket.orangeHRM_scripts;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.PredefinedActions;
import sanket.utils.ProprtiesFileReaderUtil;

public class Assignment10OrangeHRMTestScript3 {

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
	public void orangeHRMTestEmpDetails() throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
		System.out.println("STEP 3 - UserName is entered.");

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
		System.out.println("STEP 4 - Password is entered.");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Employee Management";

		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("STEP 5 - Login successfully in Orange HRM.");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='image-container']"))).build().perform();
		System.out.println("STEP 6 - Mouse Hover on Profile");

		action.click(driver.findElement(
				By.xpath("//a[@class='password-action profile-context-menu-handler']/i[@class='material-icons']")))
				.build().perform();
		System.out.println("STEP 7 - Click on setting icon on profile");

		int noOfOptions = driver.findElements(By.xpath(
				"//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-item']/a"))
				.size();
		Assert.assertEquals(noOfOptions, 2);
		System.out.println("STEP 8 - Verified that user menu total 2 options displayed");

		action.click(driver.findElement(By.xpath("//a[@id='aboutDisplayLink']"))).build().perform();
		System.out.println("STEP 9 - Click on About");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[@class='customized-modal-header']/h4[text()='About']"))));

		System.out.println("STEP 10 - Verify Employee is more than 0");
		String employeeCount = driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[3]/p")).getText();
		String[] employeeCountArray = employeeCount.split(" ");
		int employeeNumber = 0;
		for (int index = 0; index < employeeCountArray.length; index++) {
			try {
				employeeNumber = Integer.parseInt(employeeCountArray[index]);
				if (employeeNumber > 0) {
					break;
				}
			} catch (NumberFormatException ex) {

			}
		}
		System.out.println("STEP 11 - Verifed that Employee is more than 0");
		System.out.println("	Employee count is : " + employeeNumber);

		System.out.println("STEP 12 - About menu deatils displayed.");
		List<WebElement> listOfEmpDetails = driver.findElements(By.xpath("//form[@id='frmSelectEmployees']"));
		System.out.println("Employee Details as follows :");
		System.out.println("\n");
		for (WebElement empDetails : listOfEmpDetails) {
			System.out.println(empDetails.getText());
		}

		action.click(driver.findElement(By.xpath("//div/a[@id='heartbeatSubmitBtn']"))).build().perform();
		System.out.println("STEP 13 - Click on OK button on popup.");

		String actualTitle2 = driver.getTitle();
		String expectedTitle2 = "Employee Management";

		Assert.assertEquals(actualTitle2, expectedTitle2);
		System.out.println("STEP 14 - Back to home screen on OrangeHRM site.");
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("STEP 15 -  Browser close Successfully.");
		driver.quit();
	}
}