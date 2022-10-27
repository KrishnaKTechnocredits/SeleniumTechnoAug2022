/*
 * Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert
 */
package HindaviIngle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentNo_02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("STEP 1 - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 2 - Hit url");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP 3-Enter Email address");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("hindavijadhav@gmail.com");
		System.out.println("STEP 4-Enter password");
		driver.findElement(By.id("pwd")).sendKeys("123456");
		System.out.println("STEP 5-Click on the submit button");
		driver.findElement(By.id("submitb2")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		String expectedMsg = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		if (expectedMsg.equals(actualMsg)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");

		}

		alert.accept();
		driver.close();
	}

}
