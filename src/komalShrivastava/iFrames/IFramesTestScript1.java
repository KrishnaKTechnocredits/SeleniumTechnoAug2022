package komalShrivastava.iFrames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import komalShrivastava.base.PredefinedActions;

public class IFramesTestScript1 {

	WebDriver driver;
		
	@BeforeTest
	public void launchURLAndClickOnIFrame() throws InterruptedException {
		driver = PredefinedActions.start();
		System.out.println("STEP : Click in IFrames Demo");
		driver.findElement(By.id("iframes")).click();
		Thread.sleep(5000);
	}
		
	@Test
	public void testScript1() throws InterruptedException {
		System.out.println("STEP : Switch to First Frame");
		driver.switchTo().frame(0);
		
		System.out.println("STEP : Click on top right button");
		driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
		
		Thread.sleep(5000);
		
		System.out.println("Print the options");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='navbar-collapse justify-content-end collapse show']//li/a"));
		for(WebElement e : list) {
			System.out.println(e.getText());
		}
		
		System.out.println("STEP : Switch to main window");
		driver.switchTo().defaultContent();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}