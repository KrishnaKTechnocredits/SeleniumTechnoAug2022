package komalShrivastava.iFrames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import komalShrivastava.base.PredefinedActions;

public class IFramesTestScript2 {

	WebDriver driver;
		
	@BeforeTest
	public void launchURLAndClickOnIFrame() throws InterruptedException {
		driver = PredefinedActions.start();
		System.out.println("STEP : Click in IFrames Demo");
		driver.findElement(By.id("iframes")).click();
		Thread.sleep(10000);
	}
		
	@Test
	public void testScript1() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[@id='indexBody']/div/div/a")));
		
		System.out.println("STEP : Switch to Third Frame");
		driver.switchTo().frame(2);
		
		System.out.println("STEP : Click on Projects tab");
		driver.findElement(By.xpath("//table[@summary='selected tab']//td[@valign='middle']")).click();
		
		Thread.sleep(7000);
		
		System.out.println("Print the options");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='menucontainer']//li[@class='menuheader']"));
		for(WebElement e : list) {
			System.out.println(e.getText());
		}
		
		System.out.println("STEP : Switch to main window");
		driver.switchTo().defaultContent();
	}
	
	@AfterTest
	public void tearDown() {
	//	driver.close();
	}
}