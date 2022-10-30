package vibha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws Exception {
		System.out.println("Step 1 --> Launch crome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("step:-2 hit Url (http://automationbykrishna.com/)in browser");
		driver.get("http://automationbykrishna.com/");
		// driver.manage().window().maximize();

		System.out.println("Step:-3 Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("Step:-4 Enter Email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("vibha@gmail.com");

		System.out.println("Step:-5 Enter Email password");
		driver.findElement(By.id("pwd")).sendKeys("vibha123");

		System.out.println("Step:-6 Click on submit button");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("Step:-7 Validate that\"You successfully clicked on it\"message is displayed");
		Alert alert = driver.switchTo().alert();
		String expectedAlertMessage = ("You successfully clicked on it");
		String actualAlertMessage = alert.getText();
		if (expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("test Pass");
		} else {
			System.out.println("test Fail");
		}
		Thread.sleep(3000);

		System.out.println("Step 8 :-accept the alert");
		alert.accept();
		driver.close();
	}
}
