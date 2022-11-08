package deepakBorse.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import deepakBorse.base.PredefinedActions;

public class Assignment3 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("\nClick on Alert Button");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Message: " + alert.getText());
		alert.accept();

		System.out.println("\nClick on Javascript Confirmation Alert Button and Accept");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Javascript Confirmation Alert message & Accept: " + alert.getText());
		alert.accept();
		String expectedText = "You pressed OK!";
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (expectedText.equals(actualText))
			System.out.println("Javascript Confirmation Alert message is Accepted -Test Passed");
		else
			System.out.println("Javascript Confirmation Alert message is not Accepted Test  Failed");

		System.out.println("\nClick on Javascript Confirmation Alert Button and Cancel");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Javascript Confirmation Alert Button & Cancel: " + alert.getText());
		alert.dismiss();
		expectedText = "You pressed Cancel!";
		actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (expectedText.equals(actualText))
			System.out.println("Javascript Confirmation Alert is cancel-Test is Passed");
		else
			System.out.println("Javascript Confirmation Alert is not cancel-Test is Failed");

		System.out.println("\nClick on Javascript Prompt Alert Button, Enter Name and Accept");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		String name = "Deepak Borse";
		alert.sendKeys(name);
		alert.accept();
		String alertMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Javascript Prompt Alert Button and enter the Name: " + alertMessage);
		if (alertMessage.contains(name))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");

		PredefinedActions.closeAllBrowser();

	}

}
