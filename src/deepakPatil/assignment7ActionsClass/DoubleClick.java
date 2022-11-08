/*
Assignment No 7 : 1st Nov 2022
Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element
 */

package deepakPatil.assignment7ActionsClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import deepakPatil.base.StartupActions;

public class DoubleClick {
	WebDriver driver;
	
	@BeforeTest
	void startup() {
		driver= StartupActions.launch();
	}
	
	@Test
	void doubleClick() throws InterruptedException {
		driver.findElement(By.id("basicelements")).click();
		
		
		//Click on Basic Element tab
		System.out.println("--Click on Basic Element tab--");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		
		//Scroll till element visible
		System.out.println("--Scroll till element visible--");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		//Perform double click on element
		System.out.println("--Perform double click on element--");
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		Alert alert=driver.switchTo().alert();
		
		System.out.println("--Validate that you double click on element--");
		String expectedText = "You successfully double clicked it";
		String alerText= alert.getText();
		alert.accept();
		
		Assert.assertEquals(expectedText, alerText);
		
		System.out.println("Test is passed");
	}
	
	@AfterTest
	void wrapUp() {
		driver.close();
	}
}
