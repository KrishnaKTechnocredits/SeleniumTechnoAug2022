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

public class Frameshandling1 {
	WebDriver driver;
	
	@BeforeMethod
	public void initprocess() {
		driver = PredefinedActions.start("http://automationbykrishna.com/");
	}
	
	@Test
	public void iframeprog1() throws InterruptedException {
		
		System.out.println("Click on Iframe Demo");
		driver.findElement(By.id("iframes")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[1]")));
		WebElement ele=driver.findElement(By.xpath("//iframe[1]"));
		
		System.out.println("Switch to frame1");
		driver.switchTo().frame(ele);
		
		System.out.println("Click on top right button from frame");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='navbar-toggler']")));
		ele=driver.findElement(By.xpath("//button[@class='navbar-toggler']"));
		ele.click();
		Thread.sleep(5000);
		
		System.out.println("Print the options present on Frame");
		List<WebElement> frameoption =driver.findElements(By.xpath("//ul[@class='navbar-nav mr-4 mb-2 mb-lg-0 pl-4 pl-lg-2']"));
		for(WebElement e:frameoption) {
			System.out.println(e.getText());
		}
		System.out.println("Switch back to main window");
		driver.switchTo().defaultContent();
	}

	@AfterMethod
	public void endprocess() {
		PredefinedActions.closeAllBrowser();
	}
}
