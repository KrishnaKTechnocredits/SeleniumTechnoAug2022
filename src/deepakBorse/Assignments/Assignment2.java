/*
 *Assignment No 2 : 27th Oct 2022

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert
 */
package deepakBorse.Assignments;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import deepakBorse.base.PredefinedActions;

public class Assignment2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(1000);
		System.out.println("Step - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("Step - Enter Email address");
		driver.findElement(By.name("emailId")).sendKeys("Deepak.borse@gmail.com");
		System.out.println("Step - Enter Pa55word");
		driver.findElement(By.id("pwd")).sendKeys("Pa55word");
		System.out.println("Step - Click on the submit button");
		driver.findElement(By.id("submitb2")).click();
		Alert alert = driver.switchTo().alert();
		String alertmsg=alert.getText();
		String expectalert="You successfully clicked on it";
		System.out.println("Step - Validate that 'You successfully clicked on it' message is displayed");
		if(expectalert.equals(alertmsg)) {
			
			System.out.println("Step - Accept the alert");
			alert.accept();
			System.out.println("Test case- Passed");
		}
		else
			System.out.println("Test case - Failed");
		PredefinedActions.closeAllBrowser();
		System.out.println("End");
			
		
	}


}
