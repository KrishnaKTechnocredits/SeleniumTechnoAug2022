package nehanig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		String emailAddress = "nehani.gupta@gmail.com";
		String password = "Twinkle96";
		driver.findElement(By.name("emailId")).sendKeys(emailAddress);
		Thread.sleep(2000);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.id("submitb2")).click();
		Thread.sleep(2000);
		String Expected = "You successfully clicked on it";
		String Actual = driver.switchTo().alert().getText();
		if (Expected.equals(Actual)) {
			System.out.println("Test-Pass");

		} else {
			System.out.println("Testcase-Fail");
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2);
		driver.quit();

	}

}
