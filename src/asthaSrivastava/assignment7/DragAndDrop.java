package asthaSrivastava.assignment7;
/*Assignment No 7 : 1st Nov 2022

Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location
*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;

public class DragAndDrop {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
		System.out.println("STEP - Hit URL https://jqueryui.com/droppable/ in browser");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void dragAndDropOperations() {
		Actions actions = new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		System.out.println("STEP - Drag \"Dram me to my target\" element to \"Drop here\"");

		actions.dragAndDrop(src, target).build().perform();
		String expectedText = "Dropped!";
		String actualText = driver.findElement(By.xpath("//div[@id='droppable']")).getText();
		Assert.assertEquals(expectedText, actualText);

		System.out.println("VERIFY - Validate that you move draggable element to target location");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}