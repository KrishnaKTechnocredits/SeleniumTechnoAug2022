package Shruti.AlertDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PromptAlert {
	public static void main(String[] args)throws InterruptedException {
		WebDriver driver = Shruti.base.PreDefinedActions.start("http://automationbykrishna.com");
		System.out.println("STEP  - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		System.out.println("STEP: Click on Javascript Prompt Button");

		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();

		Alert alert = driver.switchTo().alert();
	
		System.out.println("STEP: insert text in alert window");
		String name = "Shruti";
		alert.sendKeys(name);
		System.out.println("STEP: alert accepted");
		alert.accept();

		String Text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("STEP: Validate message");
		if (Text.contains(name)) {
			System.out.println("Pass");
		} 
		else {
			System.out.println("Fail");
		}

		Thread.sleep(2000);
		System.out.println("STEP: Click on Javascript Prompt Button");
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();
		System.out.println("STEP: alert declined");
		alert.dismiss();

		String expectedText = "User cancelled the prompt.";
		String actualText = driver.findElement(By.id("pgraphdemo")).getText();
		if (expectedText.equals(actualText)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
}