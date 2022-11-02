/*Assignment No 7 : 1st Nov 2022
Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element*/

package pujaSah;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pujaSah.Base.PredefinedActions;

public class DoubleClickMethods {

WebDriver driver;
	
	@BeforeMethod
	public void startUp() throws InterruptedException {
		System.out.println("STEP 1: Launch browser and hit url.");
		driver = PredefinedActions.start("http://automationbykrishna.com/");	

		System.out.println("STEP 2: Click on basic Elements.");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void doubleClickTest() {
		WebElement doubleClickElement = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));

		JavascriptExecutor js = (JavascriptExecutor)driver;

		System.out.println("STEP 3: Scroll upto the element");
		js.executeScript("arguments[0].scrollIntoView(true)",doubleClickElement);

		Actions actions = new Actions(driver);
		System.out.println("STEP 4: Double click on element");
		actions.doubleClick(doubleClickElement).build().perform();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Message is: "+ alert.getText());
	}
	
	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}

