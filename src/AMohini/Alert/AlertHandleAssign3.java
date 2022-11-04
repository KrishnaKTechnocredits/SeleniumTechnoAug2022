/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.
 */

package AMohini.Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AMohini.CommonActions.*;

public class AlertHandleAssign3 {
	
	static void verifyAction(String expectedText, String actualText) {
		
		if(expectedText.equals(actualText))
			System.out.println("Test is Passed");
		else
			System.out.println("Test is Failed");
	}

	public static void main(String[] args) throws InterruptedException {
		
		//Initialize Chrome browser , get URL to open , maximize the window and wait for 2 sec Load page
		System.out.println("STEP - Launch Chrome browser & load URL");
		WebDriver driver=PredefinedActions.start("http://automationbykrishna.com/");
		
		//Click on Basic elements menu option using Xpath/findelement ad click methods of WebDriver class
		
		System.out.println("STEP: Click on Basic Elements Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		// Scroll down on webpage using excuteScript method of JavascriptExecutor class
				JavascriptExecutor js = (JavascriptExecutor) driver; //type casted diver instance from WebDriver to JavascriptExecutor
				js.executeScript("window.scrollBy(0,200)");
		
		//Alert Button Handle		
				
		System.out.println("\n--Click on Alert Button to Accept it --");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert alert= driver.switchTo().alert();//switching to alert generated after click on Alert Button
		System.out.println("Message from Alert: "+alert.getText());//display message on alert
		alert.accept(); //accepted an Alert
		
		//Javascript Confirmation Alert :Accept
		
		System.out.println("\n--Click on Javascript Confirmation Alert Button and Accept--");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Message from Javascript Confirmation Alert Button: "+alert.getText());
		alert.accept();
		String expectedText="You pressed OK!";
		String actualText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		verifyAction(expectedText, actualText);
		
		//Javascript Confirmation Alert : Cancel
		
		System.out.println("\n--Click on Javascript Confirmation Alert Button and Cancel--");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Message from Javascript Confirmation Alert Button: "+alert.getText());
		alert.dismiss();
		expectedText="You pressed Cancel!";
		actualText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		verifyAction(expectedText, actualText);
		
		//Javascript Prompt Alert Button: Ebter Name
		
		System.out.println("\n--Click on Javascript Prompt Alert Button, Enter Name and Accept--");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		String name="Mohini";
		alert.sendKeys(name);
		alert.accept();
		String alertMessage= driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Message from Javascript Prompt Alert Button: "+alertMessage);
		verifyAction(expectedText, actualText);
		
		driver.close();
	}

}
