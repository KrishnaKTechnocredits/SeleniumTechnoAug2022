package shubhamGupta.test;

import java.util.List;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import shubhamGupta.base.PredefinedActions;

/*Assignment No 6 : 31st Oct 2022

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
---------------------------------------------------------------
Script 2

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the 3rd frame & click on Projects tab
5. print the 
	Projects
	Apache Ant Libraries
	Apache Ivy
	Apache IvyDE
	Apache EasyAnt
5. Switch back to main window
*/
public class Assignment6_Iframes {

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

		System.out.println("Step3: Scroll till alert option is visible");
		PredefinedActions.scrollTillElement(frame3);

		System.out.println("Step4: Switch to frame 3 ");

		System.out.println("Step5: Scroll till alert option is visible");
		PredefinedActions.scrollTillElement(frame3);

		// Switching to frame 3
		driver.switchTo().frame(frame3);
		System.out.println("	Switching to frame successfull");
		Thread.sleep(5000);

		// clicking on button
		System.out.println("Step4: Clicking on project button");
		driver.findElement(By.xpath("//table[@summary='tab bar']/tbody/tr//table[@summary='non selected tab']"))
				.click();
		System.out.println("	Click on button is successful");
		Thread.sleep(2000);

		System.out.println("Step5: Getting all options present in frame");

		// Printing all options present on list.
		List<WebElement> contents = driver
				.findElements(By.xpath("//div[@class='menucontainer']//ul/li[@class='menuheader']"));
		for (WebElement element : contents) {
			System.out.println("      " + element.getText());
			Thread.sleep(1000);
		}

		/*
		 * List<WebElement> optionsOnFrame = driver .findElements(By.xpath(
		 * "//div[@class='menucontainer']//ul/li[@class='menuheader']/ul/descendant::li"
		 * )); System.out.println("    Options present under frame are- ");
		 * 
		 * for (WebElement element : optionsOnFrame) { System.out.println("      " +
		 * element.getText()); Thread.sleep(1000); }
		 */
		
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
