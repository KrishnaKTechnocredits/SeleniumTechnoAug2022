/*Assignment8: TestCaseID 1
Test Steps :
1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name
*/

package apurvaBabel.OrangeHRMScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apurvaBabel.PredefinedActions;
import apurvaBabel.utils.PropertiesFileReader;

public class Assignment8_TestCaseID1 {

	WebDriver driver;
	PropertiesFileReader property = new PropertiesFileReader(
			"src/apurvaBabel/OrangeHRMScripts/OrangeHRMLogin.properties");

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start(property.getValue("webURL"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(property.getValue("implicitWait")), TimeUnit.SECONDS);
	}

	@Test
	public void loginWithOrangeHRMAndFurtherSteps() {
		System.out.println("Step2: Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(property.getValue("userName"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(property.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Step3: Verify login successfully");
		Assert.assertEquals(driver.getTitle(), "Employee Management");

		System.out.println("Step4: Click on my info tab");
		driver.findElement(By.xpath("(//a[@class='top-level-menu-item'])[2]")).click();

		System.out.println("Step5: Update the require details");
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(property.getValue("firstName"));
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(property.getValue("lastName"));
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).clear();
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(property.getValue("dateOfBirth"));

		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv'] //li/span[text()='Indian']")).click();

		System.out.println("Step6: Click on Save button");
		driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']/button[@type='submit']"))
				.click();

		System.out.println("Step7: Validate Successfully Updated message on page");
		String actualMessage = driver.findElement(By.xpath("//div[@class = 'toast-message']")).getText();
		String expectedMessage = "Successfully Updated";
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println("  Updated Successfully");

		System.out.println("Step8: Refresh the page & validate the updated name");
		driver.navigate().refresh();

		String expectedName = property.getValue("firstName") + " " + property.getValue("lastName");
		String actualName = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(actualName, expectedName);

		System.out.println("  Name updated successfully");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
