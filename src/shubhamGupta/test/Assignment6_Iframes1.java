package shubhamGupta.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import shubhamGupta.base.PredefinedActions;

public class Assignment6_Iframes1 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() throws InterruptedException {

		System.out.println("Step 1: Launch Chrome Browser and open URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/#");

		System.out.println("Step2: Switch on IFrame Demo tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(2000);

	}

	@Test
	public void getAllOptionsFrom1stframe() throws InterruptedException {

		System.out.println("Step3: Switch to frame 1 Selenium");
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@name='site1']"));

		// Switching to frame 1

		driver.switchTo().frame(frame1);
		System.out.println("	Switching to frame successfull");
		Thread.sleep(5000);

		// clicking on button
		System.out.println("Step4: Clicking on right top button");
		driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
		System.out.println("    Click on button is successful");

		System.out.println("Step5: Getting all options present in frame");

		// Printing all options present on list.
		List<WebElement> optionsOnFrame = driver
				.findElements(By.xpath("//ul[@class='navbar-nav mr-4 mb-2 mb-lg-0 pl-4 pl-lg-2']/li/a"));
		System.out.println("    Options present under frame are- ");
		for (WebElement element : optionsOnFrame) {
			System.out.println("      " + element.getText());
			Thread.sleep(1000);
		}
		// Switch to main window
		driver.switchTo().parentFrame();
		System.out.println("Switched to parent window.");
	}

	@Test
	public void getAllOptionsFrom2ndframe() throws InterruptedException {
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@title='site3']"));

		System.out.println("Step 3: Scroll till alert option is visible");
		PredefinedActions.scrollTillElement(frame3);

		System.out.println("Step4: Switch to frame 3 ");

		System.out.println("Step 5: Scroll till alert option is visible");
		PredefinedActions.scrollTillElement(frame3);

		// Switching to frame 3
		driver.switchTo().frame(frame3);
		System.out.println("	Switching to frame successfull");
		Thread.sleep(5000);

		// clicking on button
		System.out.println("Step4: Clicking on project button");
		driver.findElement(By.xpath("//table[@summary='tab bar']/tbody/tr//table[@summary='non selected tab']"))
				.click();
		System.out.println("    Click on button is successful");
		Thread.sleep(2000);

		System.out.println("Step5: Getting all options present in frame");

		// Printing all options present on list.
		List<WebElement> optionsOnFrame = driver
				.findElements(By.xpath("//div[@class='menucontainer']//ul/li[@class='menuheader']/ul/descendant::li"));
		System.out.println("    Options present under frame are- ");

		for (WebElement element : optionsOnFrame) {
			System.out.println("      " + element.getText());
			Thread.sleep(1000);
		}
		// Switch to main window
		driver.switchTo().parentFrame();
		System.out.println("Switched to parent window.");
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowsers();
		System.out.println("Browser Closed");
	}

}
