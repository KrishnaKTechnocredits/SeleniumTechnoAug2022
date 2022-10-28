/*
 * 
 * Step1 : Hit url http://automationbykrishna.com/#
 * Step2 :Click on Basic element
 * Step3 : Click on Javascript confirmation button. 
 */
 
 
package HindaviIngle.Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import HindaviIngle.base.PredefinedActions;

public class AssignmentNo3_Program2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		System.out.println("STEP1 -Verify Url load successfully.");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP2 -Click on Alert button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		
		System.out.println("STEP3 -Switch to Alert");

		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);		
		
		System.out.println("STEP4 -Click on OK button on alert");

		alert.accept();
		
		String actualText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedText="You pressed OK!";
		
		System.out.println("STEP5 -Verify text on page");

		if(actualText.equals(expectedText)) {
			System.out.println("Actual and Expected Alert text is matching");		
		}else {
			System.out.println("Actual and Expected Alert text is not matching");		

		}
			driver.close();
		
	}

}
