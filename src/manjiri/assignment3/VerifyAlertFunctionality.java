/*Verify Alert functionality on automationbykrishna application.*/

package manjiri.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import manjiri.base.PredefinedActions;

public class VerifyAlertFunctionality {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch Browser and Click URL");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		
		System.out.println("Click on Basic Elements Tab");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Get Alert button under basic form");
		WebElement element = driver.findElement(By.id("javascriptAlert"));
		
		System.out.println("Scroll to the Alert button under basic form");
		PredefinedActions.scrollToElement(element);
		
		System.out.println("***Click on Alert Button****");
		element.click();
		
		String expectedMessage = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String actualMessage = alert.getText();
		alert.accept();
		
		if(expectedMessage.equals(actualMessage)) {
			System.out.println("Test case for Alert - pass !!!");
		}
		else {
			System.out.println("Test case for Alert - fail !!!");
		}
		
		System.out.println("***Click on JavaScript Confirmation Button****");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		String expectedMessage2 = "You pressed OK!";
		String actualMessage2 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		
		if(expectedMessage2.equals(actualMessage2)) {
			System.out.println("Test case for Javascript Confirmation - pass !!!");
		}
		else {
			System.out.println("Test case for Javascript Confirmation - fail !!!");
		}
		
		System.out.println("***Click on JavaScript Prompt Button****");
		driver.findElement(By.id("javascriptPromp")).click();
		
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Manjiri");
		alert3.accept();
		
		String expectedMessage3 = "Hello Manjiri! How are you today?";
		String actualMessage3 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		
		if(expectedMessage3.equals(actualMessage3)) {
			System.out.println("Test case for Javascript Prompt - pass !!!");
		}
		else {
			System.out.println("Test case for Javascript Prompt - fail !!!");
		}
	}
}
