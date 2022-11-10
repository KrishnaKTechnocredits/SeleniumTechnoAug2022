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

public class ThirdIframeDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void printOptionOfThirdIframe() throws InterruptedException {
		
		System.out.println("Step: Switch to Iframe tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tBody/tr/td[2]/font/b")).click();
		
		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='menu']/ul/li"));
		for(WebElement e : options) {
			System.out.println(e.getText());
		}
		
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
