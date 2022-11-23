/*
 * Assignment No 6 : 31st Oct 2022

Script 1

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the first frame & click on top right button & print the options
	About
	Downloads
	Documentations
	Project
	Support
	Blog
5. Switch back to main window
 */
package deepakBorse.Assignment6Frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deepakBorse.PredefinedActions;

public class Frameshandling2 {
	WebDriver driver;
	
	@BeforeMethod
	public void initprocess() {
		driver = PredefinedActions.start("http://automationbykrishna.com/");
	}
	
	@Test
	public void iframeprog2() throws InterruptedException {
		
		System.out.println("Click on Iframe Demo");
		driver.findElement(By.id("iframes")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[3]")));
		WebElement ele=driver.findElement(By.xpath("//iframe[3]"));
		
		System.out.println("Switch to frame-3");
		driver.switchTo().frame(ele);
		
		System.out.println("Click on Project tab from frame");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='navbar-toggler']")));
		driver.findElement(By.xpath("//font[contains(.,'Projects')]")).click();
		
		//Thread.sleep(9000);
		
		System.out.println("Print the options present on Frame");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[@class='menuheader']")));
		List<WebElement> frameoption =driver.findElements(By.xpath("//div[@class='menu']"));
		for(WebElement e:frameoption) {
			System.out.println(e.getText());
		}
		System.out.println("\nSwitch back to main window");
		driver.switchTo().defaultContent();
		String actualText = driver.findElement(By.xpath("//a[@href='http://automationbykrishna.com']")).getText();
		if ("Automation By Krishna".equals(actualText)) {
			System.out.println("Pass - Switched back to main window");
		} else {
			System.out.println("Fail - Unable to switch to main window");
		}
	}

	@AfterMethod
	public void endprocess() {
		PredefinedActions.closeAllBrowser();
	}
}
