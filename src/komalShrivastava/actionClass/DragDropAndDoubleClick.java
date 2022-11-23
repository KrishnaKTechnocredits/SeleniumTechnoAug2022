//Assignment No 7 : 1st Nov 2022 

/*Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location

---------------------------------------------------------------
Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element*/

package komalShrivastava.actionClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import komalShrivastava.base.PredefinedActions;

public class DragDropAndDoubleClick {

	WebDriver driver;
	
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
		
		Thread.sleep(5000);
		System.out.println("STEP : Switch to frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		Actions action = new Actions(driver);
		WebElement srcElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		
		System.out.println("STEP : Drag and Drop the element");
		action.dragAndDrop(srcElement, targetElement).build().perform();
	}
	
	@Test
	public void doubleClick() throws InterruptedException {
		driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP : Scroll till the link");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']")));
		
		System.out.println("STEP : Double Click on link");
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"))).build().perform();
		
		Alert alert = driver.switchTo().alert();
		String actualTxt = alert.getText();
		String expectedTxt = "You successfully double clicked it";
		
		System.out.println("STEP : Validate the text on alert");
		Assert.assertEquals(actualTxt, expectedTxt);
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("STEP : Close the browser");
		driver.close();
	}
}