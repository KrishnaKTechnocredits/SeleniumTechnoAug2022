//Assignment 3 : Part 1 - JavaScript Alert

package komalShrivastava.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import komalShrivastava.base.PredefinedActions;

public class JavaScriptAlert {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP : Launch browser and Load URL");
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP : Click on Alert");
		WebElement element = driver.findElement(By.id("javascriptAlert"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		System.out.println("STEP : Click on JavaScript Alert");
		element.click();
		
		System.out.println("STEP : Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		String expectedMsg = "You must be TechnoCredits student!!";
		
		System.out.println("STEP : Validate the alert message");
		if(expectedMsg.equals(actualMsg))
			System.out.println("Result : Pass");
		else
			System.out.println("Fail");
		
		System.out.println("STEP : Accept the Alert");
		alert.accept();
		Thread.sleep(1000);
		
		System.out.println("STEP : Close the browser");
		driver.close();
	}
}