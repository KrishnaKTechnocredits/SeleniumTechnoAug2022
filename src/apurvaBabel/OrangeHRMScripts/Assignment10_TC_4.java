/*Assignment10: TC_4
Test Steps :
1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero
*/

package apurvaBabel.OrangeHRMScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apurvaBabel.PredefinedActions;
import apurvaBabel.utils.PropertiesFileReader;

public class Assignment10_TC_4 {

	WebDriver driver;
	PropertiesFileReader property = new PropertiesFileReader(
			"src/apurvaBabel/OrangeHRMScripts/OrangeHRMLogin.properties");

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start(property.getValue("webURL"));
	}

	@Test
	public void tc_4() {
		System.out.println("Step2: Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(property.getValue("userName"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(property.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Step3: Click on Employee Management tab");
		driver.findElement(By.xpath("//a[@id='menu_item_37'][1]")).click();

		System.out.println("Step4: Click on My Info tab");
		driver.findElement(By.xpath("(//a[@class='top-level-menu-item'])[1]")).click();

		System.out.println("Step5: Verify user Personal info displayed");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
		if (driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed()) {
			System.out.println("  Personal details are displaying");
		} else {
			System.out.println("  Personal details are not displaying");
		}

		System.out.println("Step6: Click on \"\"Salary\"\"");
		driver.findElement(By.xpath("//a[@data-automation-id ='menu_employee_profile_Salary']")).click();

		System.out.println("Step7: Check the payable (CTC) amount is non-zero");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='payGrade']")));
		String ctc = driver.findElement(By.xpath("//div[@translate='Cost to the Company']/following-sibling::div"))
				.getText();
		String updatedCtc = "";
		for (int i = 0; i < ctc.length(); i++) {
			char ch = ctc.charAt(i);
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
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
