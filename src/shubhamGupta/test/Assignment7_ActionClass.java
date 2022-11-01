package shubhamGupta.test;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import shubhamGupta.base.PredefinedActions;

public class Assignment7_ActionClass {

	WebDriver driver;

	@Test
	public void verifyDragAndDropFeature() {
		System.out.println("Step1: Launch Browser and load URL");
		driver = PredefinedActions.start("https://jqueryui.com/droppable/");

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		System.out.println("Step2: Switch to Frame");
		driver.switchTo().frame(frame);

		System.out.println("Step3: Performing drag and drop option");

		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions = new Actions(driver);

		actions.dragAndDrop(source, target).build().perform();
		System.out.println("Drag and Drop option is successfull");

	}

	@Test
	public void verifyDoubleClickFunctionality() throws InterruptedException {
		System.out.println("Step1: Launch Browser and load URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/");

		System.out.println("Step2: Scrolling till double click element is visible");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		WebElement doubleClickElement = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));

		PredefinedActions.scrollTillElement(doubleClickElement);
		Thread.sleep(3000);

		System.out.println("Step3: Clicking on double click element");
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClickElement).build().perform();

		System.out.println("Step4: Switching to alert box and capturing data from it");
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println("Text on alert is: " + alert.getText());
		alert.accept();

		System.out.println("Double click is validated.");

	}

	@Test
	public void verifyMouseHoverFunctionality() throws InterruptedException {
		System.out.println("Step1: Launch Browser and load URL");
		driver = PredefinedActions.start("https://www.flipkart.com/");

		System.out.println("Step2: Closing the login window");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		System.out.println("Step3: Mouse Hover on Fashion Icon");
		WebElement fashion = driver.findElement(By.xpath("(//div[@class='CXW8mj'])[4]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(fashion).build().perform();
		System.out.println("	Mouse hover is done on fashion category");
		Thread.sleep(1000);

		System.out.println("Step4: Printing count from each subsequent category.");

		List<WebElement> subCategories = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		for (WebElement subCategory : subCategories) {
			List<WebElement> subCategoriesUnderCategory = driver
					.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
			System.out.println(subCategory.getText() + " - " + subCategoriesUnderCategory.size());
			Thread.sleep(1000);
		}
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowsers();
		System.out.println("Browser is closed.\nTest case passed");
	}

}
