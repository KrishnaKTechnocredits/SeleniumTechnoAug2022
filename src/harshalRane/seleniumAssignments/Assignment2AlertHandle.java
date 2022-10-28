package harshalRane.seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment2AlertHandle {

	static void verifyAlertText(WebDriver driver, String expectedText) throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String actualText = alert.getText();

		if (expectedText.equals(actualText))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = harshalRane.base.PredefinedActions.start("http://automationbykrishna.com");

		System.out.println("STEP: Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(3000);

//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(3000);

		System.out.println("STEP: Enter Email Address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("hpsparkling@gmail.com");

		System.out.println("STEP: Enter password");
		driver.findElement(By.id("pwd")).sendKeys("harshal123");

		System.out.println("STEP: Click On Submit Button");
		driver.findElement(By.id("submitb2")).click();

		verifyAlertText(driver, "You successfully clicked on it");
	}
}
