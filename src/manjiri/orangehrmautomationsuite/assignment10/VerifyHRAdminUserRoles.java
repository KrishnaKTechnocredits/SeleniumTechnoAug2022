/*"1. Launch your oranage HRM URL
2. User Login with valid credential
3. Click on HR Administration tab from left panel
4. Click on Manage User Roles tab from top panel
5. Verify by default 50 record should get display in table.
6. Verify total record and showing count of record in right corner of page"*/

package manjiri.orangehrmautomationsuite.assignment10;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;
import manjiri.orangehrmautomationsuite.utils.PropertiesFileReader;

public class VerifyHRAdminUserRoles {
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
	public void verifyHRAdminUserRoles() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		System.out.println("Step: Enter Username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("username"));

		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));

		System.out.println("Step: Click on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Click on HR Administration tab from left panel");
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@id='menu-content']/ul/li[@data-level='2']"));
		list1.get(0).click();
		
		System.out.println("Step: Click on Manage User Roles");
		driver.findElement(By.xpath("//top-level-menu-item[@automation-id='menu_admin_viewUserRoles']//a[text()='Manage User Roles ']")).click();
		
		System.out.println("Step: Verify by default 50 records are present in the table");
//		PredefinedActions.scrollToElement(driver.findElement(By.xpath("//div[@class='select-wrapper']//span[text()='50']")));
		PredefinedActions.scrollToElement(driver.findElement(By.xpath("//div[@class='select-wrapper']//input")));
		//driver.findElement(By.xpath("//div[@class='select-wrapper']//span[text()='50']")).click();
//		System.out.println(driver.findElement(By.xpath("//div[@class='select-wrapper']//input")).getAttribute("value"));
		String defaultCount = driver.findElement(By.xpath("//div[@class='select-wrapper']//input")).getAttribute("value");
		Assert.assertTrue(Integer.parseInt(defaultCount) == 50, "Default count is: " + defaultCount);
		
		System.out.println("Verify total record and showing count of record in right corner of page");
		List<WebElement> totalRows = driver.findElements(By.xpath("//list[@listData='listData']//tbody//tr"));
		Assert.assertTrue(totalRows.size() == 9);
		Assert.assertTrue(driver.findElement(By.cssSelector(".summary")).isDisplayed());
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
