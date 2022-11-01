package nilamP.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertDemo {
	public static void main(String[] args) throws Exception {

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

		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		Alert alert = driver.switchTo().alert();

		String expectedText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualText = alert.getText();
		if (expectedText.equals(actualText)) {
			System.out.println("Test case pass");
		} else {
			System.out.println("Test case fail");
		}

		alert.accept();

		String expectedText1 = "You pressed OK!";
		//System.out.println(expectedText1);
		String actualText1 = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(actualText1);
		if (expectedText1.equals(actualText1)) {
			System.out.println("Test case pass");
		} else {
			System.out.println("Test case fail");
		}
	}
}
