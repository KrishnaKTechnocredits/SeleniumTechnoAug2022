/*Assignment No 2 : 27th Oct 2022
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
package adittyThakare;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import manjiri.base.PredefinedActions;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("STEP: Go to automationbykrishna.com");
		driver.get("http://automationbykrishna.com/#");
		/*
		 * String firstName="Aditty"; String lastName="Thakare"; String
		 * companyName="Tibco"; driver.findElement(By.id("basicelements")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		 * driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		 * driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
		 * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		 * Alert alert=driver.switchTo().alert(); Thread.sleep(3000); String
		 * expectedAlertText = firstName+" and "+lastName+" and "+companyName; String
		 * alertText=alert.getText(); if(expectedAlertText.equals(alertText)) {
		 * System.out.println("Pass!"); } else { System.out.println("FAIL"); }
		 * alert.accept();
		 */
		System.out.println("STEP: Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		String emailAddress = "test@gmail.com";
		String password = "password";
		String expectedAlertText = "You successfully clicked on it";
		Thread.sleep(2000);
		System.out.println("STEP: Enter email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailAddress);
		System.out.println("STEP: Enter password");
		driver.findElement(By.id("pwd")).sendKeys(password);
		System.out.println("STEP: Click on Submit");
		driver.findElement(By.id("submitb2")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String actualAlertText=alert.getText();
		alert.accept();
		
		System.out.println("VERIFY: Confirm Alert text message");
		if(expectedAlertText.equals(actualAlertText)) {
			System.out.println("Test Case Passed!");
		}
		else {
			System.out.println("Test Case Failed");
		}
		
	}

}
