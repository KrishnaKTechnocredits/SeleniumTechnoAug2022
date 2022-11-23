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

package SwatiM.seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SwatiM.base.PredefinedActions;

public class Assignment6_iFrame {

	WebDriver driver;

	@BeforeMethod

	public void launchBrowser() throws InterruptedException {
		System.out.println("Step 1: Launch Chrome Browser and open URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/#");

		System.out.println("Step2: Click on IFrame Demo tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();

		Thread.sleep(2000);

	}

	@Test
	public void getAllOptionsFrom1stframe() throws InterruptedException {
		System.out.println("Step3: Switch to frame 1 Selenium");
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='indexBody']/iframe[1]"));
		// Switching to frame 1
		driver.switchTo().frame(frame1);
		System.out.println("	Switching to frame successfull");
		Thread.sleep(5000);

		// clicking on button
		System.out.println("Step4:clicking on right top icon");
		driver.findElement(By.xpath("//button[@class='navbar-toggler'][span[@class='navbar-toggler-icon']]")).click();
		System.out.println("click on icon is successful");

		System.out.println("Step5: verify all option on frame");
		// Printing all options present on list.
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@id='main_navbar']/ul/li/a"));
		for (WebElement e : listOfOptions) {
			if (e.getText() != "")
				System.out.println(e.getText());
		}
		System.out.println("STEP - Switch back to main window");
		driver.switchTo().parentFrame();
		String expectedText = "2017 © TechnoCredits by Krishna-Maulik";
		String actualText = driver.findElement(By.xpath("//footer[@class='sticky-footer']")).getText();
		Assert.assertEquals(expectedText, actualText, "Couldn't  switch back to main window");
		System.out.println("Switched back to main window");
	}
	
	@Test
	public void secondFrameHandle() throws InterruptedException {
		System.out.println("STEP - Switch to the 3rd frame");
		driver.switchTo().frame(2);
		Thread.sleep(3000);

		System.out.println("STEP - Click on projects tab");
		driver.findElement(By.xpath("//a[@href='./projects/index.html']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[@class='content']/h3[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP - print the list  projects");
		List<WebElement> listOfAllProjects = driver
				.findElements(By.xpath("//div[@class='menucontainer']//li[@class='menuheader']"));
		
		for (WebElement e : listOfAllProjects) {
			System.out.println(e.getText());
		}
		System.out.println("STEP - Switch back to main window");
		driver.switchTo().defaultContent();
		String actualText = driver.findElement(By.xpath("//a[@href='http://automationbykrishna.com']")).getText();
		if ("Automation By Krishna".equals(actualText)) {
			System.out.println("Pass - Switched  to main window");
		} else {
			System.out.println("Fail - Unable to switch to main window");
		}
	}

	@AfterMethod

	public void tearDown() {
		driver.close();
	}
}