/*1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero
*/

package manjiri.orangehrmautomationsuite.assignment10;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;
import manjiri.orangehrmautomationsuite.utils.PropertiesFileReader;

public class VerifyUserSalary {
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
	public void verifyUserSalary() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		System.out.println("Step: Enter Username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("username"));

		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));

		System.out.println("Step: Click on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Step: Click on MyInfo tab");
		driver.findElement(By.xpath("//div[@unique-name='uniqueName']/a[@data-automation-id='menu_pim_viewMyDetails']"))
				.click();
		
		System.out.println("Step: Verify user Personal Info displayed");
		WebElement ele = driver.findElement(By.xpath("//h4[text()='Personal Details']"));
		if(ele.isDisplayed()) {
			System.out.println("User Personal Information is displayed!!!");
		}
		else {
			System.out.println("User Personal Information is not displayed");
		}
		
		System.out.println("Click on Salary");
		driver.findElement(By.xpath("//top-level-menu-item[@automation-id='menu_employee_profile_Salary']")).click();
		
		System.out.println("Check the payable CTC amount");
		
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='payGrade']")));
		String ctc = driver.findElement(By.xpath("//div[@translate='Cost to the Company']/following-sibling::div"))
				.getText();
		String updatedctc="";
//		ctc += ctc.replace(ctc.charAt(0), ' ');
		for(int index = 0; index < ctc.length(); index++) {
			if(Character.isDigit(ctc.charAt(index))) {
				updatedctc += ctc.charAt(index);
			}
		}
//		int totalCTC = Integer.parseInt(ctc.trim());
		int totalCTC = Integer.parseInt(updatedctc)/100;
		if(totalCTC > 0) {
			System.out.println("Total Payable amount is:" + totalCTC);
		}
		else {
			System.out.println("Invalid amount!!!");
		}
		System.out.println("Test case Pass !!!");
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
