package shubhamGupta.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shubhamGupta.base.PredefinedActions;

public class Assignment3_AlertBox {
	public static void main(String[] args) throws InterruptedException {

		// Creating some variables which will be required in testcase
		String simpleAlert = "You must be TechnoCredits student!!";
		String confirmationAlert = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String name = "Shubham";

		// Launching Chrome Browser
		System.out.println("Step 1: Launch Chrome Browser and open URL");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

		// Clicking on basic element tab and waiting for 2 sec to get loading complete
		System.out.println("Step 2: Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		// Scrolling till alert options are visible
		System.out.println("Step 3: Scroll till alert option is visible");
		WebElement multiselect = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		PredefinedActions.scrollTillElement(multiselect);

		// Clicking on alert button for generating alert box
		System.out.println("Step 4: Clicking on alert button to generating simple alert");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		// switching to alert box
		System.out.println("Step 5:Switching to alert ,validating its text and accepting it");

		Alert alert = driver.switchTo().alert();

		// Fetching information from alert box and comparing it with expected value. and
		// accepting the alert
		String actualSimpleAlertText = alert.getText();
		if (simpleAlert.equals(actualSimpleAlertText)) {
			System.out.println("	Text is matching with expected value and  is : \n	" + actualSimpleAlertText);
		}
		alert.accept();
		System.out.println("	Alert is accepted");

		// Clicking on Javascript Confirmation button to generating confirmation alert
		System.out.println("Step 6: Clicking on Javascript Confirmation button to generating confirmation alert");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		// switching to alert box
		System.out.println("Step 7:Switching to alert and accepting it");
		driver.switchTo().alert();

		// Fetching information from alert box and comparing it with expected value. and
		// accepting the alert
		String actualConfirmationAlertText = alert.getText();
		if (confirmationAlert.equals(actualConfirmationAlertText)) {
			System.out
					.println("	Text is matching with expected value and  is : \n	" + actualConfirmationAlertText);
		}

		alert.accept();
		System.out.println("	Confirmation Alert is accepted");

		// Vaidating the message displayed on screen after accepting confirmation alert
		// box.
		System.out.println("Step 8:Validating message displayed on screen after accepting confirmation alert box");
		String message = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedMessage1 = "You pressed OK!";

		if (expectedMessage1.equals(message)) {
			System.out.println("	Expected message is displaying and message is: " + message);
		} else {
			System.out.println("	Expected message is not displaying and message is: " + message);

		}

		// Clicking on Javascript Prompt button to generating Prompt alert
		System.out.println("Step 9: Clicking on Javascript Prompt button to generating prompt alert");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		// switching to alert box, sending data to it
		System.out.println("Step 10:Switching to prompt alert and sending data in it");
		driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();

		// Vaidating the message displayed on screen after sending data and accepting
		// prompt alert box.
		System.out.println("Step 11:Validating message displayed on screen after sending data in prompt alert and submitting it");

		String actualMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedMessage = "Hello " + name + "! How are you today?";

		if (expectedMessage.equals(actualMessage)) {
			System.out.println("	Expected message is displaying and message is: " + actualMessage);
		} else {
			System.out.println("	Expected message is not displaying and message is: " + actualMessage);

		}
		// Closing the browser
		System.out.println("Step 12: Closing the browser");
		PredefinedActions.closeAllBrowsers();
		System.out.println("Test Case passed!!");

	}

}
