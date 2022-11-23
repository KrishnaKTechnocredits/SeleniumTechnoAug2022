//Assignment 10 
/*TC_3

1. Launch your oranage HRM URL
2. User Login with valid credential
3. Verify User profile is displayed
4. Mouse Hover on Profile and Click on setting icon on profile
5. Verify user menu total 2 options displayed
6. Click on About
7. Verify Employee is more than 0
8. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup.

TC_4

1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero	*/

package komalShrivastava.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import komalShrivastava.base.PredefinedActions;

public class OrangeHRMAssignment10 {
	WebDriver driver;

	@BeforeMethod
	public void launchURL() {
		driver = PredefinedActions.start("https://kshrivastava-trials77.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Xl2ga9MMA@");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP : Validate Page title");
		String actualTitle = driver.findElement(By.xpath("//ul[@class='topbar-title']")).getText();
		Assert.assertEquals(actualTitle, "Employee Management");
	}

	@Test
	public void testScript1() throws InterruptedException{
		
		System.out.println("STEP : Verify User profile is displayed");
		WebElement img = driver.findElement(By.xpath("//div[@class='picture']"));
		Assert.assertEquals(true, img.isDisplayed());
		
		System.out.println("STEP : Mouse Hover on Profile");
		Actions action = new Actions(driver);
		action.moveToElement(img).build().perform();
		
		System.out.println("STEP : Click on setting icon on profile");
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']")).click();
		
		System.out.println("STEP : Verify user menu total 2 options displayed");
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@id='sidebar-profile-picture']//a[@class='sub-menu-item-link truncate']"));
		Assert.assertEquals(2, listOfOptions.size());
		
		System.out.println("STEP : Click on About");
		listOfOptions.get(1).click();
		
		System.out.println("STEP : Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
		List<WebElement> listOfInfo = driver.findElements(By.xpath("//div[@id='companyInfo']/div[1]/div"));
		
		System.out.println("STEP : Verify if Employee is more than 0");
		String emp = listOfInfo.get(2).getText();
			String[] str = emp.split(" ");
			for(String empData : str) {
				try {
					int num = Integer.parseInt(empData);
					System.out.println("Employee : " + num);
					Assert.assertNotEquals(0, num, "0 employees");
					break;
				}catch(NumberFormatException ne) {	
				 }
			}	
		
		for(WebElement info : listOfInfo) {
			System.out.println(info.getText());
		}
		action.click(driver.findElement(By.id("heartbeatSubmitBtn"))).build().perform();
		System.out.println("");
	}
	
	@Test
	public void testScript2() throws InterruptedException {
		
		Thread.sleep(10000);
		System.out.println("STEP : Click on My Info tab");
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']")).click();
		Thread.sleep(30000);
		
		System.out.println("STEP : Click on Salary tab");
		driver.findElement(By.xpath("//a[@ui-sref='pim.employees.profile.salary']")).click();
		
		Thread.sleep(5000);
		System.out.println("STEP : Verify if Payable field is displayed");
		WebElement payable = driver.findElement(By.xpath("//div[@id='pim_salary_details']//div[text()='Total Payable']"));
		Assert.assertTrue(payable.isDisplayed(), "Payable field is not avaialble");
		
		System.out.println("STEP : Verify the payable value");
		WebElement salary = driver.findElement(By.xpath("//div[@id='pim_salary_details']//div[text()='Total Payable']/following-sibling::div"));
		Assert.assertNotEquals("$0.0", salary.getText(), "Payable is $0.0");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
}