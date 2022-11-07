package asthaSrivastava.assignment7;
/*Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element
*/


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;

public class DoubleClick {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws Exception{
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		System.out.println("STEP : Hit Url -http://automationbykrishna.com/");
		System.out.println("STEP - Click on Basic Elements Tab");
		driver.findElement(By.id("basicelements")).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void doubleClickOperations() throws InterruptedException {
		
		WebElement element = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP - Scroll till element visible");

		Actions actions = new Actions(driver);
		actions.doubleClick(element).click(element).build().perform();
	
		System.out.println("STEP - Perform double click on element");

		
		Alert alert = driver.switchTo().alert();
		String expectedMessage = "You successfully double clicked it";
		String actualMessage = alert.getText();
		System.out.println("VERIFY- Validate that you double click on element");
		System.out.println("VERIFY - Actual and Expected message should be same");
		if (expectedMessage.equals(actualMessage)) {
			System.out.println("TEST Pass");
		} else {
			System.out.println("TEST Fail");
		}
		
		alert.accept();
		System.out.println("STEP: Alert accepted");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
