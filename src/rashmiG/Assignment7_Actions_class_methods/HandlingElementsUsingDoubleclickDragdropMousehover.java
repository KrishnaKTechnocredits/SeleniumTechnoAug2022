/*Assignment No 7 : 1st Nov 2022

Script 1: Drag & Drop

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
6. Validate that you double click on element

---------------------------------------------------------------

Script 3: Mouse hover

1. Launch chrome browser
2. Hit url(https://www.flipkart.com/)in browser.
3. Click on cross button on login
4. Mouse hover on Fashion Icon
5. Validate that menu is displayed
6. print each section's subsection count
	Men's Top Wear - 11
	Men's Buttom Wear - 11
	Like wise for others*/

package rashmiG.Assignment7_Actions_class_methods;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import rashmiG.Base.PredefinedActions;

public class HandlingElementsUsingDoubleclickDragdropMousehover {
	WebDriver driver;

	@Test
	public void dragAndDropElement() throws InterruptedException {
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
		System.out.println("STEP - Launch browser and hit url");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		System.out.println("STEP - Switch to iframe");
		Actions act = new Actions(driver);
		// Thread.sleep(2000);
		WebElement draggableElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetLocation = driver.findElement(By.xpath("//div[@id='droppable']"));
		String beforedropText = targetLocation.getText();
		System.out.println("Before Drag and drop text of targetlocation  : " + beforedropText);
		act.dragAndDrop(draggableElement, targetLocation).build().perform();
		String afterDropText = targetLocation.getText();
		System.out.println("After Drag and drop text of targetlocation : " + afterDropText);
		System.out.println("STEP - Drag \"Drag me to my target\" element to \"Drop here\"");
		Assert.assertNotEquals(beforedropText, afterDropText);
		System.out.println("VERIFY -  draggable element moved to target location");
		System.out.println("Script Pass");
	}

	@Test
	public void doubleClickOnElement() throws InterruptedException {
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		System.out.println("STEP - Launch chrome browser and hit url http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Click on Basic Element tab");
		WebElement element = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("STEP - Scroll till element visible");
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		System.out.println("STEP - Perform double click on element");
		String expectedText = "You successfully double clicked it";
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		String actualText = al.getText();
		al.accept();
		System.out.println("VERIFY -  that you double click on element");
		System.out.println("Actual text: " + actualText);
		Assert.assertEquals(expectedText, actualText);
		System.out.println("Script pass");
	}

	@Test
	public void mouseHoverElement() {
		driver = PredefinedActions.start("https://www.flipkart.com/");
		System.out.println("STEP - Launch chrome browser and hit url https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("STEP -  Click on cross button on login");
		WebElement FashIconelement = driver.findElement(By.xpath("//div[@class='eFQ30H'][4]/a/div[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(FashIconelement).build().perform();
		System.out.println("STEP - Mouse hover on Fashion Icon");
		List<WebElement> listOfSections = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		if (listOfSections.size() > 0) {
			System.out.println("VERIFY - Menu is displayed");
		} else {
			System.out.println("VERIFY - Menu is not displayed");
		}
		System.out.println("STEP - each section's subsection count");
		for (WebElement section : listOfSections) {
			act.moveToElement(section).build().perform();
			List<WebElement> listOfSubsections = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
			System.out.println(section.getText() + " - " + listOfSubsections.size());
		}
	}
		
	@AfterMethod
	public void tearDown() {
			driver.close();
	}
}