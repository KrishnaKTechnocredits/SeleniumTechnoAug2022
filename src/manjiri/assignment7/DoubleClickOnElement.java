/*Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element*/

package manjiri.assignment7;

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

public class DoubleClickOnElement {
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {	
		System.out.println("Launch Browser and Navigate to URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/");
	}
	
	@Test
	public void doubleClickOnElement() throws InterruptedException {
		
		String expectedResult = "You successfully double clicked it";
		
		System.out.println("Click on Basic Elements Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("Get element Locator");
		WebElement doubleClickElement = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		System.out.println("Scroll to the Element");
		PredefinedActions.scrollToElement(doubleClickElement);
		Thread.sleep(3000);
		System.out.println("Create Object of Actions class");
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClickElement).build().perform();
		System.out.println("Switch to alert, get text of the message displayed and accept the alert");
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		alert.accept();
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Close Browser");
		PredefinedActions.closeBrowser();
	}
}
