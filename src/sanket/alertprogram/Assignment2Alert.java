/*Assignment No 2: 27th Oct 2022

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url (http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert
*/

package sanket.alertprogram;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2Alert {

	public static void main(String[] args) throws Exception {

		System.out.println("STEP 1 - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");

		System.out.println("STEP 2 - Hit url (http://automationbykrishna.com/)in browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(3000);

		System.out.println("STEP 3- Verify Application is loaded successfully.");
		String expectedTitle = "Login Signup Demo";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle))
			System.out.println("Pass - Page Login Signup Demo loaded Suceessfully.");
		else
			System.out.println("Fail - Page not loaded.");

		System.out.println("STEP 4- Click on basic element tab.");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		System.out.println("STEP 5- Enter Email address.");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("steve.barnett123@yahoo.com");

		System.out.println("STEP 6- Enter password.");
		driver.findElement(By.id("pwd")).sendKeys("steve123$");

		System.out.println("STEP 7- Click on the submit button.");
		driver.findElement(By.id("submitb2")).click();
		Thread.sleep(2000);

		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);

		String expectedMessage = "You successfully clicked on it";
		String actualMessage = alert1.getText();

		if (expectedMessage.equals(actualMessage))
			System.out.println("Paas - Alert Message Verified.");
		else
			System.out.println("Failed to get message");

		driver.switchTo().alert().accept();
		driver.quit();
	}
}
