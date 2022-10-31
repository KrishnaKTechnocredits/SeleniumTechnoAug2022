package nilamP.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptPromptDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STP 1- Browser Launched");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 2 - Hit URl");
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP 3 - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		System.out.println("STEP: Click on Javascript Confirmation Button");

		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println("STEP: add text in alert window");
		String name = "Nilam";
		alert.sendKeys(name);
		System.out.println("STEP: alert accepted");
		alert.accept();

		String message = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("STEP: Validate message");
		if (message.contains(name)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		Thread.sleep(2000);
		System.out.println("STEP: Click on Javascript Confirmation Button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP: alert declined");
		alert.dismiss();

		String expectedText = "User cancelled the prompt.";
		String actualText = driver.findElement(By.id("pgraphdemo")).getText();
		if (expectedText.equals(actualText)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
