/*Assignment No 2 : 27th Oct 2022

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.*/

package rashmiG.Assignment2_Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP -  Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP - Hit url in browser");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(3000);

		System.out.println("STEP - Enter Email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("ras@yahoo.com");

		System.out.println("STEP - Enter password");
		driver.findElement(By.id("pwd")).sendKeys("12345678");
		System.out.println("STEP - Click on the submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		System.out.println("VERIFY- Validate that \"You successfully clicked on it\" message is displayed");
		Alert alertWindow = driver.switchTo().alert();
		Thread.sleep(3000);
		String exepctedAltertMessage = "You successfully clicked on it";
		String actualAltertMessage = alertWindow.getText();
		alertWindow.accept();
		if (exepctedAltertMessage.equals(actualAltertMessage))
			System.out.println("pass - accurate message is displayed");
		else
			System.out.println("fail - accurate message is not dispalyed");
		driver.close();
	}
}