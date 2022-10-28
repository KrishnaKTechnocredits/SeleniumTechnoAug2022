/*Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.
1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert*/

package manjiri.assignment2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import manjiri.base.PredefinedActions;

public class HandlingAlertPopup {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP - Launch Browser and URL");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		
		String emailAddress = "m@gmail.com";
		String password = "password";
		String expectedmessage = "You successfully clicked on it";
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailAddress);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.id("submitb2")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String actualMessage = alert.getText();
		alert.accept();	
		
		if(expectedmessage.equals(actualMessage))
			System.out.println("Test case Pass !!!");
		else
			System.out.println("Test case Fail !!!");
	}
}
