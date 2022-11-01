package technocredits.alertDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");

		String firstName = "sagar";
		String lastName = "yadav";
		String companyName = "globant";

		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);

		driver.findElement(By.id("UserLastName")).sendKeys(lastName);

		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);

		String expectedAlertMessage = firstName + " and " + lastName + " and " + companyName;

		String actualAlertText = alert.getText();

		System.out.println("Actual Text : " + actualAlertText);
		if (expectedAlertMessage.equals(actualAlertText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		alert.dismiss();
	}
}
