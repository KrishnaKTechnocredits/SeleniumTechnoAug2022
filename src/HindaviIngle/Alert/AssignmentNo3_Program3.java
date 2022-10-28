/*
 * Step1 : Hit url http://automationbykrishna.com/#
 * Step2 :Click on Basic element
 * Step3 : Click on Javascript prompt button.
 * Step4: Click ok button
 * Step5: Verify text after clicked on ok button
 */
package HindaviIngle.Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import HindaviIngle.base.PredefinedActions;

public class AssignmentNo3_Program3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		System.out.println("STEP1 -Verify Url load successfully.");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP2 -Click on Alert button");
		driver.findElement(By.id("javascriptPromp")).click();

		System.out.println("STEP3 -Switch to Alert");

		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String input = "Hindavi";
		alert.sendKeys(input);
		alert.accept();
		System.out.println("STEP4 -Verify input given in text");

		String actualText = driver.findElement(By.id("pgraphdemo")).getText();
		if (actualText.contains(input)) {
			System.out.println("Its correct");
		} else {
			System.out.println("Fail");
		}
		driver.close();
	}

}
