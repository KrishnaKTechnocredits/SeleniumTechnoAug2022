/*
 * 
Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location
 */
package HindaviIngle.DragDropDoubleClickMouseHover;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class Assignment_07_DragDrop {
	
	public WebDriver driver;
	@BeforeMethod
	void beforeMethod() {
		driver=PredefinedActions.start("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("Step2: Switch to outer frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
	}
	
	@Test
	
	void dragDropAssignment() {		
	System.out.println("Step3 - Drag 'Drag me to my target' element to 'Drop here'");
	WebElement sourceElement=driver.findElement(By.id("draggable"));
	WebElement targetElement=driver.findElement(By.id("droppable"));
	Actions action=new Actions(driver);
	action.dragAndDrop(sourceElement, targetElement).build().perform();	
	}
	
	@AfterMethod
	
	void cleaup() {
		driver.close();
		
	}
	

}

