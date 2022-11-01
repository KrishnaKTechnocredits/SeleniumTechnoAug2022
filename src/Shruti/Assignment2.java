/*Assignment No 2 : 27th Oct 2022

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert*/
package Shruti;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment2 {
	static void verifyAlertText(WebDriver driver, String expectedText) throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String actualText = alert.getText();

		if (expectedText.equals(actualText))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Shruti.base.PreDefinedActions.start("http://automationbykrishna.com");

		System.out.println("STEP: Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();
    	Thread.sleep(3000);
        System.out.println("STEP: Enter Email Address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("hpsparkling@gmail.com");

		System.out.println("STEP: Enter password");
		driver.findElement(By.id("pwd")).sendKeys("harshal123");

		System.out.println("STEP: Click On Submit Button");
		driver.findElement(By.id("submitb2")).click();

		verifyAlertText(driver, "You successfully clicked on it");
	}
}