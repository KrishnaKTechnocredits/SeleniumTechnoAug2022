/*Verify Alert functionality on automationbykrishna application.*/
package Shruti.AlertDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SimpleAlert {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver = Shruti.base.PreDefinedActions.start("http://automationbykrishna.com");
		System.out.println("Step1: Launch Chrome Browser and Hit Url ");
		System.out.println("Step2: Click On Basic Element ");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Step3: Click on Alert ");
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");
		driver.findElement(By.id("javascriptAlert")).click();
		Thread.sleep(2000);
		System.out.println("Step4: Switch to Alert ");
		Alert alert = driver.switchTo().alert();
		String expectedTxt = "You must be TechnoCredits student!!";
		System.out.println("Step5: Verify Alert text is as per Expected ");
		System.out.println(" Get the actual text ");
		String actualTxt = alert.getText();
		if(actualTxt.equals(expectedTxt)) {
			System.out.println(" Test Case Successfully Pass");
		}
		else 
			System.out.println(" Test Case Fail");
		System.out.println("Step6: Click on Ok to Accept the alert");
		alert.accept();
	}
}