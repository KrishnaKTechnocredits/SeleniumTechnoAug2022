/*Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert*/
package nilamP;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	public static void main(String[] args) throws Exception {
		System.out.println("STP 1- Browser Launched");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 2 - Hit URl");
		driver.get("http://automationbykrishna.com/#");

		String email = "nilam192@gamil.com";
		String passWd = "patel@123";
		System.out.println("STEP 3 - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		System.out.println("STEP 4 - Enter Email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
		System.out.println("STEP 5 - Enter password");
		driver.findElement(By.id("pwd")).sendKeys(passWd);
		System.out.println("STEP 6 - Click on the submit button");
		driver.findElement(By.id("submitb2")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		// alert.accept();

		System.out.println("STEP 7- Validate alert message is displayed");
		String expectedAlertMessage = "You successfully clicked on it";
		System.out.println("Expected  alert message:" + expectedAlertMessage);
		String actualAlertMessage = alert.getText();

		if (expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println(" Test Pass");
		} else {
			System.out.println(" Test Fail");
		}

		System.out.println("STEP 8: Accepting alert.");
		alert.accept();

	}

}

