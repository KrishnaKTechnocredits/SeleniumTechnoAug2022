/*
 * Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element
 */
package HindaviIngle.DragDropDoubleClickMouseHover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class Assignment_07_DoubleClick {
	WebDriver driver;
	@BeforeMethod
	void beforeMethodP() {
	driver=PredefinedActions.start("http://automationbykrishna.com/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.id("basicelements")).click();
	}
	
	@Test
	void doubleClickFunctionality() {
	System.out.println("Step 2 - Scroll till element visible");
	WebElement element=driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	
	System.out.println("Step 3: Perform double click on element");
	Actions action=new Actions(driver);
	action.doubleClick(element).build().perform();

	System.out.println("Step 4: Navigate alert window");
	
	Alert alert= driver.switchTo().alert();
	String actualMsg=alert.getText();
	String expectedMsg="You successfully double clicked it";
	System.out.println("Step 5: Validate actual and expected text on alert window");

	Assert.assertEquals(expectedMsg, actualMsg);
//	if(actualMsg.equals(expectedMsg)) {
//		System.out.println("Text is matching");
//		
//	}
	
	System.out.println("Step 6: Click on OK button");
	alert.accept();

	}

	@AfterMethod
	void cleanUp() {
	driver.close();
	}
}
