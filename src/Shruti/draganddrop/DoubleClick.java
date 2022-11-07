/*Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element*/
package Shruti.draganddrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Shruti.base.PreDefinedActions;

public class DoubleClick {
	WebDriver driver;

	@BeforeMethod
	void start() {
		driver=PreDefinedActions.start("http://automationbykrishna.com");
	}

	@Test
	void testCaseDoubleClick() {
		//wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		System.out.println("Step :Click on Basic Element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Step:Scroll till element visible");
		WebElement element=driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("Step: Perform double click on element");
		Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
		System.out.println("Step: After click handle alert");
		Alert alert=driver.switchTo().alert();
		System.out.println("--Validate that you double click on element--");
		String expectedText = "You successfully double clicked it";
		String alerText= alert.getText();
		alert.accept();

		Assert.assertEquals(expectedText, alerText);

		System.out.println("Test is passed");


	}

	@AfterMethod
	void close(){
		PreDefinedActions.closeBrowser();

	}
}