
/********Assignment No 2 : 27th Oct 2022

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert
 * *********/

package AMohini.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AMohini.CommonActions.*;

public class AlertHandel {

	public static void main(String[] args) throws Exception {

		System.out.println("STEP - Launch Chrome browser & load URL");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		/*****
		 * driver.findElement(By.id("firstname")).sendKeys("Mohini");
		 * driver.findElement(By.id("lastnamename")).sendKeys("Agarwal");
		 * 
		 * driver.findElement(By.id("female")).click();
		 ***********/

		driver.findElement(By.id("basicelements")).click();
		//Thread.sleep(1000);
		String emailAddress = "Mohinih.agarwal@gmail.com";
		String password = "Apple@123";
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailAddress);
		//Thread.sleep(1000);
		driver.findElement(By.id("pwd")).sendKeys(password);
		/******
		 * driver.findElement(By.id("h4")).click();
		 * 
		 * WebElement e = driver.findElement(By.id("bId")); Select select1 = new
		 * Select(e);
		 * 
		 * select1.selectByVisibleText("IT");
		 *********/

		driver.findElement(By.id("submitb2")).click();
		//Thread.sleep(1000);
		String Expected = "You successfully clicked on it";
		String Actual = driver.switchTo().alert().getText();
		if (Expected.equals(Actual)) {
			System.out.println("Test Case Passed");

		} else {
			System.out.println("Testcase Failed");
		}
		driver.switchTo().alert().accept();
		//Thread.sleep(2);
		driver.quit();

	}

}
