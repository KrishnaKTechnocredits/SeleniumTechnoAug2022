/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.*/

package pujaSah.AlertTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pujaSah.Base.PredefinedActions;

public class VerifyAlertFunctionality {

	public static void main(String[] args) throws Exception{
		
		System.out.println("STEP 1: Launch chrome browser and hit url--------");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/index.html");
		
		System.out.println("STEP 2: Click on Basic Elements--------");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP 2: Click on Alert button--------");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		
		System.out.println("VERIFY: correct alert message is generated");
		String expectedAlertMessage = "You must be TechnoCredits student!!";
		String actualAlertMessage = alert.getText();
		System.out.println("Expected alert message:" + expectedAlertMessage);
		System.out.println("Actual alert message:" + actualAlertMessage);
		
		if(expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
		
		System.out.println("STEP 3: Accept alert--------");
		alert.accept();
		
		System.out.println("STEP 4: Click on Javascript Confirmation button--------");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		
		alert = driver.switchTo().alert();
		Thread.sleep(2000);

		System.out.println("VERIFY: correct alert message is generated");
		expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		actualAlertMessage = alert.getText();
		
		System.out.println("Expected alert message:" + expectedAlertMessage);
		System.out.println("Actual alert message:" + actualAlertMessage);
		
		if(expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
		
		System.out.println("STEP 5: Accept alert--------");
		alert.accept();
		Thread.sleep(2000);
		
		System.out.println("STEP 6: Click on Javascript Prompt button--------");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		alert = driver.switchTo().alert();
		Thread.sleep(2000);

		System.out.println("VERIFY: correct alert message is generated");
		expectedAlertMessage = "Please enter your name :";
		actualAlertMessage = alert.getText();
		System.out.println("Expected alert message:" + expectedAlertMessage);
		System.out.println("Actual alert message:" + actualAlertMessage);
		
		if(expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
		
		System.out.println("STEP 7: Enter name in the alert text box--------");
		String name = "Puja Sah";
		System.out.println("Entered name: +name");
		
		alert.sendKeys(name);
		Thread.sleep(2000);
		
		System.out.println("STEP 8: Accept alert--------");
		alert.accept();
		Thread.sleep(2000);
		
		String actual_return_msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Actual Alert return message: "+ actual_return_msg);	
		
		System.out.println("VERIFY: Return alert message contains the name entered");
		if(actual_return_msg.contains(name)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
	
		System.out.println("STEP 6: Click on Javascript Prompt button--------");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		alert = driver.switchTo().alert();
		Thread.sleep(2000);

		System.out.println("VERIFY: correct alert message is generated when alert is accepted without entering name");
		System.out.println("STEP 3: Accept alert--------");
		alert.accept();
		Thread.sleep(2000);
		
		String expected_return_message = "User cancelled the prompt.";
		actual_return_msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Actual Alert return message: "+ actual_return_msg);	
		System.out.println("Expected Alert return message: "+ expected_return_message);	
		
		if(expected_return_message.equals(actual_return_msg)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
		
		System.out.println("STEP 6: Click on Javascript Prompt button--------");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		alert = driver.switchTo().alert();
		Thread.sleep(2000);

		System.out.println("VERIFY: correct alert message is generated when alert is cancelled without entering name");
		System.out.println("STEP 3: Accept alert--------");
		alert.dismiss();
		expected_return_message = "User cancelled the prompt.";
		actual_return_msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Actual Alert return message: "+ actual_return_msg);	
		System.out.println("Expected Alert return message: "+ expected_return_message);	
		
		if(expected_return_message.equals(actual_return_msg)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
		
		System.out.println("STEP 6: Click on Javascript Prompt button--------");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		alert = driver.switchTo().alert();

		System.out.println("VERIFY: correct alert message is generated when user cancels the button after entering name");
				
		System.out.println("STEP 7: Enter name in the alert text box--------");
		name = "Puja Sah";
		alert.sendKeys("name");
		
		System.out.println("STEP 8: Press cancel button--------");
		alert.dismiss();
		expected_return_message = "User cancelled the prompt.";
		actual_return_msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Actual Alert return message: "+ actual_return_msg);	
		System.out.println("Expected Alert return message: "+ expected_return_message);	
		
		if(expected_return_message.equals(actual_return_msg)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
		
		System.out.println("STEP 6: Click on Open MultiWindow button--------");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
	}
}	
		
		
		
		
		
