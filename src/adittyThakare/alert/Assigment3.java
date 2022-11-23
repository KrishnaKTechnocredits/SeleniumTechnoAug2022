/*Assignment - 3 : 28th Oct'2022
Verify Alert functionality on automationbykrishna application.*/

package adittyThakare.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import manjiri.base.PredefinedActions;

public class Assigment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		System.out.println("STEP: Click URL");

		System.out.println("STEP: Click on Basic Elements Tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("STEP: Click on Alert button");
		driver.findElement(By.id("javascriptAlert")).click();
		String expectedAlertMessage = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String actualAlertMessage = alert.getText();
		alert.accept();
		System.out.println("VERIFY - Alert text confirmation");
		if (expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Alert Button Test Case - PASS");
		} else {
			System.out.println("Alert Button Test Case - FAIL");
		}

		System.out.println("\nSTEP: Click on Javascript Confirmation Button");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.accept();
		System.out.println("VERIFY: Javascript Confirmation");
		String expectedAlertMessage1 = "You pressed OK!";
		String actualAlertMessage1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (expectedAlertMessage1.equals(actualAlertMessage1)) {
			System.out.println("Javascript Confirmation Button Test Case - PASS");
		} else {
			System.out.println("Javascript Confirmation Button Test Case - FAIL");
		}

		System.out.println("\nSTEP: Click on Javascript Prompt Button");
		driver.findElement(By.id("javascriptPromp")).click();
		Alert alert2 = driver.switchTo().alert();
		String name = "Aditty";
		System.out.println("STEP: Enter name in alert window");
		alert2.sendKeys(name);
		Thread.sleep(2000);
		alert2.accept();
		System.out.println("VERIFY: Javascript Prompt Button Confirmation");
		String actualAlertMessage2 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualAlertMessage2.contains(name)) {
			System.out.println("Javascript Prompt Button Test Case - PASS");
		} else {
			System.out.println("Javascript Prompt Button Test Case - PASS");
		}
	}
}
