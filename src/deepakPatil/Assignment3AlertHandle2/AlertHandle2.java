/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.
 */

package deepakPatil.Assignment3AlertHandle2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import deepakPatil.Base.PredefinedActions;

public class AlertHandle2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= PredefinedActions.start("http://automationbykrishna.com");
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		
		System.out.println("\n--Click on Alert Button--");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert alert= driver.switchTo().alert();
		System.out.println("Message from Alert: "+alert.getText());
		alert.accept();
		
		System.out.println("\n--Click on Javascript Confirmation Alert Button and Accept--");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Message from Javascript Confirmation Alert Button: "+alert.getText());
		alert.accept();
		String expectedText="You pressed OK!";
		String actualText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(expectedText.equals(actualText))
			System.out.println("Test is Passed");
		else
			System.out.println("Test is Failed");
		
		System.out.println("\n--Click on Javascript Confirmation Alert Button and Cancel--");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Message from Javascript Confirmation Alert Button: "+alert.getText());
		alert.dismiss();
		expectedText="You pressed Cancel!";
		actualText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(expectedText.equals(actualText))
			System.out.println("Test is Passed");
		else
			System.out.println("Test is Failed");
		
		System.out.println("\n--Click on Javascript Prompt Alert Button, Enter Name and Accept--");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		String name="Deepak";
		alert.sendKeys(name);
		alert.accept();
		String alertMessage= driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Message from Javascript Prompt Alert Button: "+alertMessage);
		if(alertMessage.contains(name))
			System.out.println("Test is Passed");
		else
			System.out.println("Test is Failed");
		
		driver.close();
	}
}
