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
package asthaSrivastava.assignment2_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP - Launch Chrome Browser");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Hit url(http://automationbykrishna.com/)in browser.");
		driver.get("http://automationbykrishna.com/#");
		
		String emailId ="test123@gmail.com";
		String passWord = "test3423";

		System.out.println("STEP - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP - Enter Email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailId);
		
		System.out.println("STEP -  Enter password");
		driver.findElement(By.id("pwd")).sendKeys(passWord);
		
		System.out.println("STEP -Click on the submit button");
		driver.findElement(By.id("submitb2")).click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);

		String expectedText = "You successfully clicked on it";
		String actualAlertText = alert.getText();
		
		System.out.println("Actual Alert Text is : " +actualAlertText);
		
		System.out.println("VERIFY - Validate that \"You successfully clicked on it\" message is displayed");
		if (expectedText.equals(actualAlertText)) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test Fail");
		}
		System.out.println("STEP - Accept the alert");
		alert.accept();
	}
}
