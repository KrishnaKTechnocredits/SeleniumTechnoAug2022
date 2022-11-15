/*TC_4

1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero*/
package asthaSrivastava.assignment10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import asthaSrivastava.PredefinedActions;
import asthaSrivastava.utils.PropertiesFileReader;

public class TC4_Salary {

	WebDriver driver;
	PropertiesFileReader propertyDetails = new PropertiesFileReader(
			"src/asthaSrivastava/assignment10/OrangeHRMTC3.properties");

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = PredefinedActions.start("http://asrivastava-trials77.orangehrmlive.com");
		System.out.println("STEP : Launch Orange HRM Url");
	}

	@Test
	public void tC4() {
		System.out.println("Step2: Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(propertyDetails.getValue("userName"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(propertyDetails.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("STEP: Click on Employee Management tab");
		driver.findElement(By.cssSelector("a[class='main-menu-item-1 active']")).click();

		System.out.println("STEP: Click on My Info tab");
		driver.findElement(By.cssSelector("div[id='top_level_menu_item_menu_item_40']>a")).click();

		System.out.println("VERIFY : Verify user Personal info displayed");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
		if (driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed()) {
			System.out.println("  Personal details gets displayed");
		} else {
			System.out.println("  Personal details are not displayed");
		}

		System.out.println("STEP : Click on \"\"Salary\"\"");
		driver.findElement(By.xpath("//a[@data-automation-id ='menu_employee_profile_Salary']")).click();

		System.out.println("VERIY : Check the payable (CTC) amount is non-zero");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='payGrade']")));
		String actualCTC = driver.findElement(By.cssSelector("div[ng-bind*='costToCompany']")).getText();
		String updatedCtc = "";
		for (int i = 0; i < actualCTC.length(); i++) {
			char ch = actualCTC.charAt(i);
			if (Character.isDigit(ch)) {
				updatedCtc = updatedCtc + ch;
			}
		}
		int ctcValue = (Integer.parseInt(updatedCtc)) / 100;
		if (ctcValue != 0) {
			System.out.println("  Employee's CTC amount is non zero , it is : " + ctcValue);
		} else {
			System.out.println("  Employee's CTC amount is non zero");
		}
		System.setProperty("webdriver.chrome.silentOutput", "true");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
