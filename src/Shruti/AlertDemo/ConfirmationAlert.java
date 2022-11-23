package Shruti.AlertDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ConfirmationAlert {
	public static void main(String[] args)throws InterruptedException {
		System.out.println("Step1: Launch Chrome Browser and hit Url ");
		WebDriver driver = Shruti.base.PreDefinedActions.start("http://automationbykrishna.com");
		System.out.println("Step2: Click On Basic Element ");
		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");
		System.out.println("Step3: Click on JavascriptConfirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
        Alert alert = driver.switchTo().alert();
	    Thread.sleep(2000);
	    System.out.println("Step4: Verify AlertText") ;
	    String ExpectedTxt = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualTxt = alert.getText();
		  if(actualTxt.equals(ExpectedTxt)) {
			  System.out.println("-- Test Case Pass--");
		  }
		  else {
			  System.out.println("Fail");
		  }
		  System.out.println("Step5: Press OK to Accept alert or to cancel press Cancel");
		  System.out.println("if you Press ok then verify text ");
		  alert.accept();
		  String expectedTxt1 = "You pressed OK!" ;
		  String actualTxt1 = driver.findElement(By.id("pgraphdemo")).getText();
		  if(actualTxt1.equals(expectedTxt1)) {
			  System.out.println("Test case pass");
		  }
		  else {
			  System.out.println("Test Case Fail");
		  }
	}
	
}