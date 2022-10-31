package technocredits.iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;

public class IFrameDemo {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start();

		System.out.println("STEP - Navigate to IFrame Window");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();

		Thread.sleep(2000);
	}

	@Test
	public void iframeExample() {
		
		driver.switchTo().frame(0);
//		driver.switchTo().frame("site1");
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));

		String iframeElement = driver.findElement(By.xpath("//h1[@class='display-1 mt-0 mt-md-5 pb-1']")).getText();
		System.out.println("--------------> : " + iframeElement);
		
		
//		driver.switchTo().parentFrame();
//		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//footer[@class='sticky-footer']")).getText());
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowser();
	}
}
