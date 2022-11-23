package nehanig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class Assignment7_DragDrop {
	WebDriver driver;

	@Test
	public void dragAndDropElement() throws InterruptedException {
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
		System.out.println("STEP - Launch browser and hit url");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		System.out.println("STEP - Switch to iframe");
		Actions actions = new Actions(driver);
		WebElement draggableElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetLocation = driver.findElement(By.xpath("//div[@id='droppable']"));
		String beforedropText = targetLocation.getText();
		System.out.println("Before Drag and drop text of target location  : " + beforedropText);
		actions.dragAndDrop(draggableElement, targetLocation).build().perform();
		String afterDropText = targetLocation.getText();
		System.out.println("After Drag and drop text of targetlocation : " + afterDropText);
		System.out.println("STEP - Drag \"Drag me to my target\" element to \"Drop here\"");
		Assert.assertNotEquals(beforedropText, afterDropText);
		System.out.println("VERIFY - Draggable element moved to target location");
		System.out.println("Script Pass");
		Thread.sleep(3000);
	}
		
		@AfterMethod

		public void closeBrowser() {
			PredefinedActions.closeAllBrowser();
	}
}
