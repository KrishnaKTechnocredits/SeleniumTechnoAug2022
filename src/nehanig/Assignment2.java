package nehanig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws Exception {
		System.out.println("Launch Crome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Hit URL");
		driver.get("http://automationbykrishna.com/#");

		System.out.println("Click on basic Element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("Enter MailID");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("nehani.gupta@gmail.com");

		System.out.println("Enter Password");
		String password = "Twinkle96";
		Thread.sleep(2000);

		System.out.println("Click on Submit Button");
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.id("submitb2")).click();
		Thread.sleep(2000);

		System.out.println("Validation");
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