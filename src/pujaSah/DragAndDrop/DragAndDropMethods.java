/*Assignment No 7 : 1st Nov 2022

Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location*/

package pujaSah.DragAndDrop;

import pujaSah.Base.PredefinedActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropMethods {

	WebDriver driver;
	
	@BeforeMethod
	public void startUp() throws InterruptedException {
		System.out.println("STEP 1: Launch browser and hit url.");
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");	
		Thread.sleep(5000);
	}
	
	@Test
	public void dragAndDropTest() {
		System.out.println("STEP 2: Switching to frame.");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		System.out.println("Title of source element before dragging: " + driver.findElement(By.xpath("//div[@id='draggable']/p")).getText());
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		System.out.println("Title of target element before dropping of source element: " + driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions action = new Actions(driver);
		System.out.println("STEP 3: Drag source element and drop to target element.");
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		
		String expectedTextAfterDrop = "Dropped!";
		String actualTextAfterDrop = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		System.out.println("VERIFY: Actual element text after drop: " + actualTextAfterDrop);
		Assert.assertEquals(actualTextAfterDrop, expectedTextAfterDrop);
	}
	
	/*@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}*/
}
