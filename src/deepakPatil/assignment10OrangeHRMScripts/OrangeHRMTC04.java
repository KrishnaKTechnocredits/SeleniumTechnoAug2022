/*
TC_4

1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on "Salary"
7. Check the payable (CTC) amount is non-zero
*/


package deepakPatil.assignment10OrangeHRMScripts;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deepakPatil.base.StartupActions;
import deepakPatil.utils.PropertiesFileReader;

public class OrangeHRMTC04 {
	
	PropertiesFileReader fileRead = new PropertiesFileReader("D:\\Automation Class-TechnoCredit\\SeleniumTechnoAug2022\\src\\deepakPatil\\assignment10OrangeHRMScripts\\OrangeHRMDetails.properties");
	WebDriver driver;
	
	@BeforeMethod
	void startUP() {
		driver= StartupActions.launch(fileRead.getValue("URL"));
		driver.findElement(By.cssSelector("input[id=txtUsername]")).sendKeys(fileRead.getValue("Username"));
		driver.findElement(By.cssSelector("input[id=txtPassword]")).sendKeys(fileRead.getValue("Password"));
		driver.findElement(By.cssSelector("button[type=submit]")).click();
	}
	
	@Test
	void verifyMyInfoTab() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		System.out.println("Step-Click on My Info tab");
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#top-ribbon-menu>div:nth-child(2) top-level-menu-item:nth-child(2) a"))));
		e.click();
		
		System.out.println("Step-Verify user Personal info displayed");
		WebElement profileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#personal_details_tab>h4")));
		Assert.assertTrue(profileElement.isDisplayed());
		
		System.out.println("Step-Click on Salary");
		driver.findElement(By.cssSelector("a[data-automation-id=menu_employee_profile_Salary]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='payGrade']")));
		String salaryTextFromElement=driver.findElement(By.cssSelector("div[translate='Total Payable']+div")).getText();
		String salaryText="";
		char ch=' ';
		for(int index=0; index<salaryTextFromElement.length(); index++) {
			ch = salaryTextFromElement.charAt(index);
			if(Character.isDigit(ch)) {
				salaryText=salaryText+ch;
			}
		}
		salaryText= salaryText.substring(0,salaryText.length()-2);
		int salary = Integer.parseInt(salaryText);
		System.out.println("Employee salary is "+salary);
		assertTrue(salary!=0,"Salary is zero");
	}
	
	@AfterMethod
	void wrapUP() {
		driver.close();
	}
}
