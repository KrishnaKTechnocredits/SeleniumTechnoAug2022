/*Assignment No 2 : 27th Oct 2022

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch Chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert*/

package pujaSah;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicForms {

	public static void main (String[] args) throws Exception {
		System.out.println("STEP1: Launch chrome browser and hit url");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP2: Hit url");
		driver.get("http://automationbykrishna.com/#");
		
		System.out.println("STEP3: Click on Basic Elements link.");
		driver.findElement(By.id("basicelements")).click();
			
		Thread.sleep(2000);
		String maidId = "pujasah6@gmail.com";
		String password = "pujaPassword1";
		
		System.out.println("STEP4: Enter email address.");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(maidId);
		
		System.out.println("STEP5: Enter password.");
		driver.findElement(By.id("pwd")).sendKeys(password);
		
		System.out.println("STEP6: Click Submit button.");
		driver.findElement(By.id("submitb2")).click();
		
		System.out.println("STEP7: Switching to alert.");
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		
		System.out.println("VERIFY: Expected alert message is displayed.");
		String expectedAlertMessage = "You successfully clicked on it";
		System.out.println("Expected  alert message:" + expectedAlertMessage);
		String actualAlertMessage = alert.getText();
		
		if(expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		System.out.println("STEP8: Accepting alert.");
		alert.accept();
	}
}
