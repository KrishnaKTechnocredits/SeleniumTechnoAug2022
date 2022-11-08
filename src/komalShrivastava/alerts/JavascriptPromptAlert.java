//Assignment 3 : Part 3 - Javascript Prompt Alert

package komalShrivastava.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import komalShrivastava.base.PredefinedActions;

public class JavascriptPromptAlert {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP : Launch browser and Load URL");
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP : Click on Alert");
		WebElement element = driver.findElement(By.id("javascriptPromp"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		System.out.println("STEP : Click on Javascript Prompt Alert");
		element.click();
		
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Komal";
		
		System.out.println("STEP : Enter details in Alert prompt");
		alert.sendKeys(expectedMsg);
		
		System.out.println("STEP : Accept the Alert");
		alert.accept();
		
		System.out.println("STEP : Validate the entered text on UI");
		String str = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(str.contains(expectedMsg))
			System.out.println("Result : Pass");
		else
			System.out.println("Result : Fail");
		
		driver.close();
	}

}
