/*Assignment No 7 : 1st Nov 2022

Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location*/
package Shruti.draganddrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Shruti.base.PreDefinedActions;

public class DragDrop {
	WebDriver driver;

	@BeforeMethod
	void startUp() {
		driver = PreDefinedActions.start("https://jqueryui.com/droppable/");

		System.out.println("Step:Switch to iframe");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

	}

	@Test
	void testCaseDragAndDrop() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Step: Drag And Drop action");
		System.out.println("Text of source element before dragging: "
				+ driver.findElement(By.xpath("//div[@id='draggable']/p")).getText());
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));

		System.out.println("Text of target element before dropping of source element: "
				+ driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragElement, targetElement).build().perform();

		String expectedTextAfterDrop = "Dropped!";
		String actualTextAfterDrop = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		System.out.println(" Step: VERIFY: Actual element text after drop: " + actualTextAfterDrop);
		Assert.assertEquals(actualTextAfterDrop, expectedTextAfterDrop);

		System.out.println("Step: SWitch back to main browser");
		driver.switchTo().defaultContent();
	}

	@AfterMethod
	void close() {
		PreDefinedActions.closeBrowser();
	}
}