
/*
 * Step1 : Hit url http://automationbykrishna.com/#
 * Step 2 :Click on Basic element
 * Step3 : Click on Alert button 
 */
package HindaviIngle.Alert;
//import HindaviIngle.base.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import HindaviIngle.base.PredefinedActions;

public class AssignmentNo03_Program1 {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		System.out.println("STEP1 -Verify Url load successfully.");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP2 -Click on Alert button");
		driver.findElement(By.id("javascriptAlert")).click();
		
		System.out.println("STEP3 -Switch to Alert");

		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);

		String expectedText="You must be TechnoCredits student!!";
		String actualText=alert.getText();
		
		System.out.println("STEP4 -Validate actual and expected text");

		if(actualText.equals(expectedText)) {
			System.out.println("Actual and Expected Alert text is matching");		
		}else {
			System.out.println("Actual and Expected Alert text is not matching");		
		}
		
		System.out.println("STEP5 -Click on OK button on alert");

		alert.accept();
		driver.close();
		
	}

}
