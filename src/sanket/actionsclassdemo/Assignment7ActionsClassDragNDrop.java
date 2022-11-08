/*Assignment No 7 : 1st Nov 2022
 Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Drag me to my target" element to "Drop here"
4. validate that you move draggable element to target location
 */

package sanket.actionsclassdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.PredefinedActions;

public class Assignment7ActionsClassDragNDrop {

	WebDriver driver;

	@BeforeMethod
	public void preTestSetup() throws Exception {

		System.out.println("STEP 1 - Launch Browser and hit URL.");
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");

		driver.switchTo().frame(driver.findElement(By.xpath("//iFrame[@class='demo-frame']")));
		System.out.println("STEP 2 - Switch to Drag and Drop Frame.");

		Thread.sleep(3000);
	}

	@Test
	public void dragAndDropOperations() {

		WebElement dragSource = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropTarget = driver.findElement(By.xpath("//div[@id='droppable']"));

		System.out.println("STEP 3 - Perform Drag and Drop operaion.");
		Actions act = new Actions(driver);
		act.dragAndDrop(dragSource, dropTarget).build().perform();

		String expectedText = "Dropped!";
		String actualText = driver.findElement(By.xpath("//div[@id='droppable']")).getText();
		Assert.assertEquals(expectedText, actualText);

		System.out.println("Verified that draggable element dropped at target location.");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
