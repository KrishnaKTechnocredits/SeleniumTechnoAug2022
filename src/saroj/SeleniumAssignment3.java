package saroj;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment3 {

	static void verifyTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	static void verifyText(Alert alert, String expectedText) {
		String actualText = alert.getText();
		if (expectedText.equals(actualText)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step - Hit url");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("Step - Click on Basic Elements in menu bar");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("Step - Click on Alert button");
		driver.findElement(By.xpath("//button[@id = \'javascriptAlert\']")).click();
		Alert alert = driver.switchTo().alert();

		System.out.println("Verify - alert title");
		verifyText(alert, "You must be TechnoCredits student!!");
		alert.accept();

		System.out.println("Step - Click on javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id = \'javascriptConfirmBox\']")).click();

		System.out.println("Verify - alert title");
		verifyText(alert, "Are you are doing your homework regularly, Press Okay else Cancel!!");
		alert.accept();

		System.out.println("Step - Click on JavaScript Prompt button");
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();
		verifyText(alert, "Please enter your name :");
		String name = "Saroj";
		alert.sendKeys(name);
		Thread.sleep(3000);
		alert.accept();
		// System.out.println("Filled name is: "+name);
		String alertMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(alertMessage);
		if (alertMessage.contains(name))
			System.out.println("Test is Passed");
		else
			System.out.println("Test is Failed");

		driver.close();
	}
}
