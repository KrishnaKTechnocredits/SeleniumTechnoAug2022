package nehanig;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment6_1 {
	WebDriver driver;

	@BeforeMethod
	public void launchBrower() throws InterruptedException {
		System.out.println("Step : Launch Crome Browser and Hit URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/");

		System.out.println("Step : Switch to IFrame Demo");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(3000);
	}

	@Test
	public void getOptionsFromFirstFrame() throws InterruptedException {

		System.out.println("Step : Switch to First Frame");
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@name='site1']"));

		driver.switchTo().frame(frame1);
		System.out.println("Step : Switched to First Frame");
		Thread.sleep(3000);

		System.out.println("Step :Clicking on Right Top Button");
		driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
		System.out.println("Clicked Successfully on Button");

		System.out.println("Step : Getting all the options");
		List<WebElement> optionsOnFrame = driver
				.findElements(By.xpath("//ul[@class='navbar-nav mr-4 mb-2 mb-lg-0 pl-4 pl-lg-2']/li/a"));
		System.out.println("Options present under frame are: ");
		for (WebElement element : optionsOnFrame) {
			System.out.println("      " + element.getText());
			Thread.sleep(2000);
		}

		driver.switchTo().parentFrame();
		System.out.println("Switched to parent window.");

	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowser();
		System.out.println("Browser Closed");
	}

}
