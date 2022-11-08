/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.
 */

package SwatiM.seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import SwatiM.base.PredefinedActions;

public class Assignment3_WindAlert2 {

	static void verifyAlertMessage(String expectedAlertMessage, Alert alert) {
		String actualAlertMessage = alert.getText();
		if (expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Alert message is as expected");
		} else {
			System.out.println("Alert message is not as expected");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");

		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP -  Scroll till alert option is visible");
		WebElement alertElement = driver.findElement(By.xpath("//button[@id = 'javascriptAlert']"));
		PredefinedActions.scrollViewToElement(alertElement);
		Thread.sleep(2000);

		System.out.println("STEP -  Click on Alert button");
		alertElement.click();
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP -  Verify alert message and Accept the alert");
		verifyAlertMessage("You must be TechnoCredits student!!", alert);
		alert.accept();
		System.out.println("STEP - Click on Javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox']")).click();
		driver.switchTo().alert();

		System.out.println("STEP - Verify alert message and Accept the alert");
		verifyAlertMessage("Are you are doing your homework regularly, Press Okay else Cancel!!", alert);
		alert.accept();

		System.out.println("STEP - Verify display message after accepting the alert");
		String expectedText = "You pressed OK!";
		String actualText = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		if (expectedText.equals(actualText)) {
			System.out.println("Message is as expected");
		} else {
			System.out.println("Message is not as expected");
		}

		System.out.println("STEP -Click on Javascript Promt button");
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();
		driver.switchTo().alert();

		System.out.println("STEP - Send data in promt alert and accept the alert");
		String name = "Swati";
		alert.sendKeys(name);
		alert.accept();

		System.out.println("STEP - Verify display message after accepting the alert");
		actualText = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		if (actualText.contains(name)) {
			System.out.println("Message is as expected");
		} else {
			System.out.println("Message is not as expected");
		}

		driver.close();
	}
}
