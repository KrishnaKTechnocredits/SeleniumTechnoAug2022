/*
 * 1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero
 */
package HindaviIngle.OrangeHrmScenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class Assignment10_TC_04 {
	
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	void beforeMethod() throws IOException {
		File file = new File(
				"D:\\TechnoCredit\\workspace\\Selenium_Oct22\\SeleniumTechnoAug2022\\src\\HindaviIngle\\PropertyFile\\OrangeHrmDetails");
		FileInputStream fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);
		System.out.println("--->" + prop.getProperty("url"));
		driver = PredefinedActions.start(prop.getProperty("url"));

	}
	@Test
	void  tC4() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		System.out.println("Step2 : fill login details from property file");
		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("txtPassword")).sendKeys(prop.getProperty("password"));
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		wait.until(ExpectedConditions.visibilityOf(element)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Step3 : Click on My info Link");
		driver.findElement(By.xpath("//a[normalize-space()='My Info']")).click();
		
		
		System.out.println("Step5: Verify user Personal info displayed");
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
	void closeBrowser() {
		driver.close();
	}
	}


