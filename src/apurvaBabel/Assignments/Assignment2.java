/*Assignment No 2 :

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert
*/

package apurvaBabel.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws Exception {
		System.out.println("Step1: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step2: Hit url(http://automationbykrishna.com/)in browser");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("Step3: Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("Step4: Enter Email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("apurva@gmail.com");

		System.out.println("Step5: Enter password");
		driver.findElement(By.id("pwd")).sendKeys("apurva17");

		System.out.println("Step6: Click on the submit button");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("Step7: Validate that \"You successfully clicked on it\" message is displayed");
		Alert alert = driver.switchTo().alert();
		String expectedAlertMessage = ("You successfully clicked on it");
		String actualAlertMessage = alert.getText();
		if (expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		Thread.sleep(3000);
		System.out.println("Step8: Accept the alert");
		alert.accept();
		driver.close();
	}
}
