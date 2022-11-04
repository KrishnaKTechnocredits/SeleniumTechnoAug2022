/*Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location*/

package manjiri.assignment7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import manjiri.base.PredefinedActions;

public class DragAndDrop {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {	
		System.out.println("Launch Browser and Navigate to URL");
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		System.out.println("Switch to iFrame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Thread.sleep(3000);
	}
	
	@Test
	public void dragAndDropElement() {
		System.out.println("Locate Source and Destination Elements");
		WebElement srcElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		System.out.println("Create object of Actions class");
		Actions actions = new Actions(driver);
		actions.dragAndDrop(srcElement, targetElement).build().perform();
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Switch to original browser");
		driver.switchTo().defaultContent();
		System.out.println("Close Browser");
		PredefinedActions.closeBrowser();
	}
}
