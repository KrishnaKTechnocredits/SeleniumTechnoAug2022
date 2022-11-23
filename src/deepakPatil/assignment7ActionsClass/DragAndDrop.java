/*
Assignment No 7 : 1st Nov 2022
Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location
 */

package deepakPatil.assignment7ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import deepakPatil.base.StartupActions;

public class DragAndDrop {
	
	WebDriver driver;
	@BeforeTest
	void startUp() {	
		driver= StartupActions.launch("https://jqueryui.com/droppable/");
	}
	
	@Test
	void dragAndDrop() throws InterruptedException {
		
		//Switching to frame as drag elemenst is in frame
		WebElement frameElement= driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);
		
		//Created Actions class object to access Actions class method. Sending driver object to the constructor of Actions class.
		Actions act = new Actions(driver);
		
		//Getting target location text before drag and drop
		String beforeDropTxt = driver.findElement(By.xpath("//div[@id='droppable']")).getText();
		
		
		//Drag element WebElement
		WebElement dragElement= driver.findElement(By.xpath("//div[@id='draggable']"));
		//Drop element WebElement
		WebElement dropElement= driver.findElement(By.xpath("//div[@id='droppable']")); 
		act.dragAndDrop(dragElement, dropElement).build().perform();
		System.out.println("Dragged");
		
		//Getting target location text after drag and drop
		String afterDropText = driver.findElement(By.xpath("//div[@id='draggable']")).getText();
		
		//Assertion on text
		Assert.assertNotEquals(beforeDropTxt, afterDropText);
		
		System.out.println("Test is passed");
	}
	
	@AfterTest
	void wrapUp() {
		driver.close();
	}
}
