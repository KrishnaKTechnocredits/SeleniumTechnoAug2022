/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.*/

package rashmiG.Assignment3_differentTypesOfAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rashmiG.Base.PredefinedActions;

public class HandlingAlerts {

	static WebDriver driver;
	Alert alertWin;
	String actualAlertText;
	String expectedAlertMessage;
	String actualAlertMessage;

	public void verifyAlert(String expectedAlertText) {
		alertWin = driver.switchTo().alert();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actualAlertText = alertWin.getText();
		alertWin.dismiss();
		System.out.println("Alert Text :" + actualAlertText);
		if (expectedAlertText.equals(actualAlertText))
			System.out.println("pass - valid text ");
		else
			System.out.println("fail - invalid text ");

	}

	public void verifyJavaScriptConfirmationAlert(String expectedAlertText) {
		verifyAlert(expectedAlertText);
		expectedAlertMessage = "You pressed Cancel!";
		actualAlertMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Alert message : " + actualAlertMessage);
		if (expectedAlertMessage.equals(actualAlertMessage))
			System.out.println("pass - valid alert message");
		else
			System.out.println("fail - invalid alert message");
	}

	public void verifyJavaScriptPromptAlert(String expectedAlertText) {
		String name = "Rashmi";
		alertWin = driver.switchTo().alert();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actualAlertText = alertWin.getText();
		alertWin.sendKeys(name);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alertWin.accept();
		System.out.println("Alert text :" + actualAlertText);
		if (expectedAlertText.equals(actualAlertText))
			System.out.println("pass - valid text ");
		else
			System.out.println("fail - invalid text ");

		String alertMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Alert Meassage :" + alertMessage);
		if (alertMessage.contains(name))
			System.out.println("pass - name is present");
		else
			System.out.println("fail - name not present");

	}

	public static void main(String[] args) throws InterruptedException {
		HandlingAlerts handAlerts = new HandlingAlerts();
		System.out.println("STEP - Launch the browser and hit the url");
		driver = PredefinedActions.start();
		System.out.println("STEP - Click on basic elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		System.out.println("====Alert======");
		System.out.println("STEP - Click on alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("VERIFY - alert ");
		String expectedAlertText = "You must be TechnoCredits student!!";
		handAlerts.verifyAlert(expectedAlertText);

		System.out.println("======JavaScript Confirmation=========");
		System.out.println("STEP - Click on Javascript confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("VERIFY - javascript confirmation alert");
		expectedAlertText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		handAlerts.verifyJavaScriptConfirmationAlert(expectedAlertText);

		System.out.println("======JavaScript Prompt=========");
		System.out.println("STEP - Click on Javascript prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("VERIFY - JavaScript Prompt alert");
		expectedAlertText = "Please enter your name :";
		handAlerts.verifyJavaScriptPromptAlert(expectedAlertText);

	}
}
