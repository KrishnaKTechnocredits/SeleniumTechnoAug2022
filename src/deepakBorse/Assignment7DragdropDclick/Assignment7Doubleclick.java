/*
 * Assignment No 7 : 1st Nov 2022
 * Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element
 * 
 */
package deepakBorse.Assignment7DragdropDclick;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deepakBorse.PredefinedActions;

public class Assignment7Doubleclick {
WebDriver driver;
	
	@BeforeMethod
	public void initprocess() {
		driver = PredefinedActions.start("http://automationbykrishna.com/");
	}
	@Test
	public void dragdrop() throws InterruptedException {
		System.out.println("Click on the Basic Element Tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		System.out.println("Scroll at bottom");
		WebElement ele = (driver.findElement(By.xpath("//a[contains(text(),'Double-click on me')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(3000);
		//driver.switchTo().frame(0);
		Actions act=new Actions(driver);
		WebElement dbclk=driver.findElement(By.xpath("//a[contains(text(),'Double-click on me')]"));
		Thread.sleep(3000);
		act.doubleClick(dbclk).perform();	
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alertmsg=alert.getText();
		String expectalert="You successfully double clicked it";
		System.out.println("Step - Validate that 'You successfully double clicked it' message is displayed");
		if(expectalert.equals(alertmsg)) {
			
			System.out.println("Step - Accept the alert");
			alert.accept();
			System.out.println("Test case- Passed");
		}
		else
			System.out.println("Test case - Failed");
	}
	@AfterMethod
	public void endprocess() {
		PredefinedActions.closeAllBrowser();
	}
}
