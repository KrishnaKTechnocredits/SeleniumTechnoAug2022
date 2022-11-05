package Chirag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2_1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		String emailAddress = "chiragp3@gmail.com";
		String password = "Test@123";
		driver.findElement(By.name("emailId")).sendKeys(emailAddress);
		Thread.sleep(1000);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.id("submitb2")).click();
		Thread.sleep(1000);
		String Expected = "You successfully clicked on it";
		String Actual = driver.switchTo().alert().getText();
		if (Expected.equals(Actual)) {
			System.out.println("Test Case Passed");

		} else {
			System.out.println("Testcase Failed");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2);
		driver.quit();

	}

}
