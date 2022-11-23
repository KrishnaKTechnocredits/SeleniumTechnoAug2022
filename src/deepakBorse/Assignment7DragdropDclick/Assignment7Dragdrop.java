/*
 * Assignment No 7 : 1st Nov 2022
Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location
 * 
 */
package deepakBorse.Assignment7DragdropDclick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deepakBorse.PredefinedActions;

public class Assignment7Dragdrop {
WebDriver driver;
	
	@BeforeMethod
	public void initprocess() {
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
	}
	@Test
	public void dragdrop() throws InterruptedException {
		driver.switchTo().frame(0);
		Actions act=new Actions(driver);
		System.out.println("Select object from");
		WebElement From=driver.findElement(By.xpath("//div[@id='draggable']/p"));
		System.out.println("Select object To");
		WebElement To=driver.findElement(By.xpath("//div[@id='droppable']"));
		act.dragAndDrop(From, To).build().perform();	
		Thread.sleep(5000);
	}
	@AfterMethod
	public void endprocess() {
		PredefinedActions.closeAllBrowser();
	}
}
