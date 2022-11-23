//Assignment 3 : Part 2 - Javascript Confirmation Alert

package komalShrivastava.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import komalShrivastava.base.PredefinedActions;

public class JavascriptConfirmationAlert {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP : Launch browser and Load URL");
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP : Click on Alert");
		WebElement element = driver.findElement(By.id("javascriptConfirmBox"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		System.out.println("STEP : Click on Javascript Confirmation Alert");
		element.click();
		
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualMsg = alert.getText();
		
		System.out.println("STEP : Compare Actual and Expected Message");
		if(expectedMsg.equals(actualMsg))
			System.out.println("Result : Pass");
		else
			System.out.println("Result: Fail");
		
		System.out.println("STEP : Accept the Alert");
		alert.accept();
		
		String str = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(str.contains("OK"))
			System.out.println("Result : Pass");
		else
			System.out.println("Result : Fail");
		driver.close();
	}
}