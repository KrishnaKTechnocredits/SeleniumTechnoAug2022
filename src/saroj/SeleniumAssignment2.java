package saroj;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment2 {

	public static void main(String[] args) throws Exception {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Steps - Hit the URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("Step - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(3000);
		System.out.println("Step - Enter Email address");
		String email = "sarojkumari123@gmail.com";
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);

		System.out.println("Step - Enter password");
		String password = "happy123";
		driver.findElement(By.id("pwd")).sendKeys(password);

		System.out.println("Step - Click on the submit button");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("Verify - You successfully clicked on it message is displayed");
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "You successfully clicked on it";
		String actualMsg = alert.getText();
		if (expectedMsg.equals(actualMsg)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		System.out.println("Step - Accept the alert");
		alert.accept();
		Thread.sleep(3000);
		driver.close();
	}
}
