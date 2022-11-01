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

package komalShrivastava.testCases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import komalShrivastava.base.PredefinedActions;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = PredefinedActions.start();
		
		Thread.sleep(3000);
		System.out.println("STEP - Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		
		System.out.println("STEP - Enter email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("komald08@gmail.com");
		
		System.out.println("STEP - Enter password");
		driver.findElement(By.id("pwd")).sendKeys("123456789");
		
		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.id("submitb2")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		String expectedMsg = "You successfully clicked on it";
		
		System.out.println("STEP - Read the Alert message");
		System.out.println(actualMsg);
		
		Thread.sleep(2000);
		
		System.out.println("STEP - Accept the Alert");
		alert.accept();
		driver.quit();
		
		if(expectedMsg.equals(actualMsg))
			System.out.println("Test case : Pass");
		else
			System.out.println("Test case : Fail");
	}
}