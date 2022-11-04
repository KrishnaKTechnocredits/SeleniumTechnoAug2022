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
package gauravSahu.Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws Exception {
		String actualUrl = "http://automationbykrishna.com/";
		String alertMsg = "You successfully clicked on it";

		System.setProperty("webdriver.chrome.driver",
				"E:\\\\AUG 2022 CLASS\\\\Selenium2022\\\\SeleniumTechnoAug2022\\\\drivers\\\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		if (actualUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Step : Correct Url Launched");
		}

		driver.findElement(By.id("basicelements")).click();
		System.out.println("Step 2 : Basic element tab opened");
		Thread.sleep(2000);

		driver.findElement(By.id("exampleInputEmail1")).sendKeys("grvs4893@gmail.com");
		System.out.println("Step 3 : Enter mail id");
		Thread.sleep(2000);

		driver.findElement(By.id("pwd")).sendKeys("grvs4893");
		System.out.println("Step 4 : Password Entered");
		Thread.sleep(2000);

		driver.findElement(By.id("submitb2")).click();
		System.out.println("Step 5 : Click on the submit button");
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		String currentAlertMsg = alert.getText();
		if (currentAlertMsg.equals(alertMsg)) {
			System.out.println("Step 6 :Validate that \"You successfully clicked on it\" message is displayed ");
		}

		System.out.println("Step : 7 - Alert Accepted");
		alert.accept();

		Thread.sleep(3000);

		driver.close();
	}

}
