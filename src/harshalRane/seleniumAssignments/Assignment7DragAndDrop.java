package harshalRane.seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;

public class Assignment7DragAndDrop {
	
	public WebDriver driver;
	
	@Test
	public void setup() throws InterruptedException {
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
		Thread.sleep(5000);
		System.out.println("STEP 2: Drag and Drop");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Thread.sleep(5000);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop =driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		
		System.out.println("Step3: Validate that you move draggable element to target location");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'droppable']")).getText(),"Dropped!");
		Thread.sleep(3000);
		
		System.out.println("Element dropped successfully");
	}
	
	@Test
	void verifyDoubleClickOnElementFeature() throws InterruptedException {
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		Thread.sleep(2000);
		
		System.out.println("Step2: Click on Basic Element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);
		System.out.println("Step3: Scroll till element visible");
		PredefinedActions.scrollToElement(driver.findElement(By.xpath("//a[@ondblclick = 'doubleClick()']")));
		Thread.sleep(3000);

		System.out.println("Step4: Perform double click on element");
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(By.xpath("//a[@ondblclick = 'doubleClick()']"))).build().perform();

		System.out.println("Step5: Validate that you double click on element");
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		System.out.println("STEP6: Accept the alert");
		alert.accept();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
