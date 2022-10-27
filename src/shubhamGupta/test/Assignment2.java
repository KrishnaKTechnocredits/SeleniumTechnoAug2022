package shubhamGupta.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import shubhamGupta.base.PredefinedActions;

/*Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert

*/
public class Assignment2 {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Step 1: Launch Chrome Browser and open URL");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

		System.out.println("Step 2: Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("Step 3: Enter Email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("shubgpta1995@gmail.com");

		System.out.println("Step 4: password");
		driver.findElement(By.id("pwd")).sendKeys("bingo");

		System.out.println("Step 5: Click on submit buton");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("Step 6: Switching to alert box");

		Alert alert = driver.switchTo().alert();
		String actualAlertMsg = alert.getText();
		System.out.println("Alert message is :" + actualAlertMsg);
		String expectedAlertMsg = "You Successfully clicked on it";

		if (actualAlertMsg.equals(expectedAlertMsg)) {
			System.out.println("Alert message is matching with the expected");
		} else {
			System.out.println("Alert message is not matching with the expected");

		}
		System.out.println("Step 7: Accepting the alert");
		alert.accept();

		System.out.println("Step 8: Closing the browser");
		driver.close();
		System.out.println("Browser is closed, Test passed!!");

	}
}
