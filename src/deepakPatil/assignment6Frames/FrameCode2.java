/*
 Assignment No 6 : 31st Oct 2022
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


package deepakPatil.assignment6Frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import deepakPatil.base.StartupActions;

public class FrameCode2 {

	WebDriver driver;

	@BeforeTest
	public void startUp() {
		driver = StartupActions.launch();
	}

	@Test
	public void frameHande() throws InterruptedException {

		// Click on iFrame tab
		System.out.println("--Click on iFrame tab--");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(2000);

		System.out.println("--Switch to the 3rd frame & click on Projects tab--");
		// Find element of frame
		WebElement e = driver.findElement(By.xpath("//iframe[@name='site1']"));
		// Used frame(element) method to switch to frame
		driver.switchTo().frame(2);

		Thread.sleep(2000);

		// click on top right button
		driver.findElement(By.xpath("//table[@summary='tab bar']/tbody/tr//table[@summary='non selected tab']")).click();
		Thread.sleep(2000);

		// Storing webelemts in List to with common value
		List<WebElement> le = driver.findElements(By.xpath("//div[@class='menucontainer']//ul/li[@class='menuheader']"));
		// iterating weblements using for loop
		System.out.println("--Options are as below--");
		for (WebElement e1 : le) {
			String text = e1.getText();
			// used if as list contains blank string as well. Not supposed to print in
			// console
			if (!text.equals(""))
				System.out.println(text);
		}

		// Switch back to main window
		System.out.println("--Switch back to main window--");
		driver.switchTo().defaultContent();
	}

	@AfterTest
	public void wrapUp() {
		driver.close();
	}
}
