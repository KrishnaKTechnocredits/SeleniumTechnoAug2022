/*1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the first frame & click on top right button & print the options
	About
	Downloads
	Documentations
	Project
	Support
	Blog
5. Switch back to main window*/

package manjiri.assignment6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;

public class IframeDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void printOptionOfFirstIframe() throws InterruptedException {
		System.out.println("Step: Switch to Iframe tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();

		System.out.println("Step: Switch to first iFrame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
		Thread.sleep(5000);
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@id='main_navbar']/ul//li/a"));

		for (WebElement e : list1) {
			System.out.println(e.getText());
		}
		
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
	}
	
	@Test
	public void printOptionOfThirdIframe() throws InterruptedException {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[text()='Projects']")).click();
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
