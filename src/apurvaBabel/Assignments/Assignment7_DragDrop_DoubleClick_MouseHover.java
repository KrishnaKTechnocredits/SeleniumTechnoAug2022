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
	Like wise for others
*/
package apurvaBabel.Assignments;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import apurvaBabel.PredefinedActions;

public class Assignment7_DragDrop_DoubleClick_MouseHover {

	WebDriver driver;

	@Test
	void verifyDragAndDropElementFeature() throws InterruptedException {
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");
		PredefinedActions.scrollViewToElement(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));

		System.out.println("Step2: Drag \"Drag me to my target\" element to \"Drop here\"");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));
		Thread.sleep(2000);

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(1000);

		System.out.println("Step3: Validate that you move draggable element to target location");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'droppable']")).getText(), "Dropped!");

		System.out.println("Element dropped successfully");
	}

	@Test
	void verifyDoubleClickOnElementFeature() throws InterruptedException {
		driver = PredefinedActions.start();

		System.out.println("Step2: Click on Basic Element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Step3: Scroll till element visible");
		PredefinedActions.scrollViewToElement(driver.findElement(By.xpath("//a[@ondblclick = 'doubleClick()']")));
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

	@Test
	void verifyMouseHoverFeature() throws InterruptedException {
		driver = PredefinedActions.start("https://www.flipkart.com/");
		Thread.sleep(3000);

		System.out.println("Step2: Click on cross button on login");
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();

		System.out.println("Step3: Mouse hover on Fashion Icon");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();

		System.out.println("Step4: Validate that menu is displayed");
		int totalCount = driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		if (totalCount > 0) {
			System.out.println("Menu is displayed");
		} else {
			System.out.println("Menu is not displayed");
		}
		Thread.sleep(1000);

		System.out.println("Step5: Print each section's subsection count");
		List<WebElement> sections = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		for (WebElement section : sections) {
			List<WebElement> subSection = driver.findElements(By.xpath("//div[@class = '_3XS_gI']/a"));
			System.out.println("  " + section.getText() + " --> " + subSection.size());
		}
		Thread.sleep(2000);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
