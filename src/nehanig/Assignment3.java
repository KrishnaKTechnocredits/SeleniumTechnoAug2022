package nehanig;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	static WebDriver driver;

	
	static void verifyAlert() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("----------------------------------------------");
		System.out.println("Alert");
		System.out.println("STEP: Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		String expectedText = "You must be TechnoCredits student!!";
		System.out.println("STEP: Switch to Alert");
		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);
		System.out.println("STEP: Get actual text on alert popup");
		String actualText = alert.getText();

		System.out.println("STEP: Verify actual text to be as per expected text");
		if (actualText.equals(expectedText)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		System.out.println("STEP: Click OK on Alert popup");
		alert.accept();
	}

	static void verifyJavascriptConfirmation() throws InterruptedException {
		System.out.println("-------------------------------------------------");
		System.out.println("Javascript Confirmation");
		System.out.println("STEP: Click on javascript Confirmation Button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		String expectedText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		System.out.println("STEP: Switch to Alert");
		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);
		System.out.println("STEP: Get actual text on alert popup");
		String actualText = alert.getText();

		System.out.println("STEP: Verify actual text to be as per expected text");
		if (actualText.equals(expectedText)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		System.out.println("STEP: Click OK on Alert popup");
		alert.accept();

		System.out.println("STEP: Verify text after clicking OK on javascript confirmation popup");
		String expected = "You pressed OK!";
		String actual = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actual.equals(expected)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	static void verifyJavascriptPrompt() throws InterruptedException {
		System.out.println("--------------------------------------------------");
		System.out.println("Javascript Prompt");
		System.out.println("STEP: Click on javascript Confirmation Button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		String name = "Nehani Gupta";
		System.out.println("STEP: Switch to Alert");
		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);
		System.out.println("STEP: Enter name");
		alert.sendKeys(name);

		System.out.println("STEP: Click OK on Alert popup");
		alert.accept();

		String message = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		System.out.println("STEP: Verify name in message after clicking OK on javascript prompt");
		if (message.contains(name)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Launch automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		System.out.println("STEP: Click on Basic Elements Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);
		System.out.println("STEP: Scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		verifyAlert();
		verifyJavascriptConfirmation();
		verifyJavascriptPrompt();
	}
}
