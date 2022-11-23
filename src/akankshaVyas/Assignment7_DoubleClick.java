/*
 * Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element

---------------------------------------------------------------
 */

package akankshaVyas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;

public class Assignment7_DoubleClick {
	
	WebDriver driver;
	
	@BeforeMethod
	void start() {
		driver=PredefinedActions.start();
	}
	
	@Test
	void testCaseDoubleClick() {
		//wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Step :Click on Basic Element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		System.out.println("Step:Scroll till element visible");
		WebElement element=driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		PredefinedActions.scrollToElement(element);
		
		System.out.println("Step: Perform double click on element");
		Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	//	actions.moveToElement(element).doubleClick().build().perform();(Another way to use)
		
		System.out.println("Step: After click handle alert");
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		

	}
	
	@AfterMethod
	void close(){
		PredefinedActions.closeBrowser();
		
	}
}
