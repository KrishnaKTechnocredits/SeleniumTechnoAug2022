/*Assignment - 3 :
Verifiy Alert functionality on automationbykrishna application.
*/

package apurvaBabel.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import apurvaBabel.PredefinedActions;

public class Assignment3_DifferentAlerts {
	static void verifyAlertMessage(String expectedAlertMessage, Alert alert) {
		String actualAlertMessage = alert.getText();
		if (expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Alert message is as expected");
		} else {
			System.out.println("Alert message is not as expected");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step2: Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("Step3: Scroll till alert option is visible");
		WebElement alertElement = driver.findElement(By.xpath("//button[@id = 'javascriptAlert']"));
		PredefinedActions.scrollViewToElement(alertElement);
		Thread.sleep(2000);

		System.out.println("Step4: Click on Alert button");
		alertElement.click();
		Alert alert = driver.switchTo().alert();

		System.out.println("Step5: Verify alert message and Accept the alert");
		verifyAlertMessage("You must be TechnoCredits student!!", alert);
		alert.accept();

		System.out.println("Step6: Click on Javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox']")).click();
		driver.switchTo().alert();

		System.out.println("Step7: Verify alert message and Accept the alert");
		verifyAlertMessage("Are you are doing your homework regularly, Press Okay else Cancel!!", alert);
		alert.accept();

		System.out.println("Step8: Verify display message after accepting the alert");
		String expectedText = "You pressed OK!";
		String actualText = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		if (expectedText.equals(actualText)) {
			System.out.println("Message is as expected");
		} else {
			System.out.println("Message is not as expected");
		}

		System.out.println("Step9: Click on Javascript Promt button");
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();
		driver.switchTo().alert();

		System.out.println("Step10: Send data in promt alert and accept the alert");
		String name = "Apurva";
		alert.sendKeys(name);
		alert.accept();

		System.out.println("Step11: Verify display message after accepting the alert");
		actualText = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']")).getText();
		if (actualText.contains(name)) {
			System.out.println("Message is as expected");
		} else {
			System.out.println("Message is not as expected");
		}

		driver.close();
	}
}
