package nehanig;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Assignment7_DoubleClick {
	WebDriver driver;
	@Test
	public void doubleClickOnElement() throws InterruptedException {
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		System.out.println("STEP - Launch chrome browser and hit url http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Click on Basic Element tab");
		WebElement element = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("STEP - Scroll till element visible");
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
		System.out.println("STEP - Perform double click on element");
		String expectedText = "You successfully double clicked it";
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		String actualText = al.getText();
		al.accept();
		System.out.println("VERIFY -Double click on element");
		System.out.println("Actual text: " + actualText);
		Assert.assertEquals(expectedText, actualText);
		System.out.println("Pass");
		Thread.sleep(3000);
	}
	@AfterMethod

	public void closeBrowser() {
		PredefinedActions.closeAllBrowser();
	}

}
