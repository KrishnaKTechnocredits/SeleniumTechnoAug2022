/*Assignment No 7 : 1st Nov 2022
 Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element

 */

package sanket.actionsclassdemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.PredefinedActions;

public class Assignment7ActionsClassDoubleClickAction {

	WebDriver driver;

	@BeforeMethod
	public void preTestSetup() throws Exception {

		System.out.println("STEP 1 - Launch Browser and hit URL.");
		driver = PredefinedActions.start();

		System.out.println("STEP 2 - Click on Basic Element tab.");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
	}

	@Test
	public void doubleClickOperations() throws Exception {

		WebElement element = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("STEP 3 - Scroll down to the target element.");

		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		System.out.println("STEP 4 - Double click on the target element.");

		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String actualText = alert.getText();
		String expectedText = "You successfully double clicked it";

		Assert.assertEquals(expectedText, actualText);
		System.out.println("Verified that double click action done successfully.");

		driver.switchTo().alert().accept();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
