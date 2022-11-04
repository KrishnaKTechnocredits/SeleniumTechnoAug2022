/*
 * Assignment No 6 : 31st Oct 2022

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


package akankshaVyas;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;

public class Assignemnt6_iFrame {
	WebDriver driver;
	@BeforeMethod
	void m1() throws InterruptedException {
	driver=PredefinedActions.start("http://automationbykrishna.com/");
	System.out.println("STEP - Navigate to IFrame Window");
	driver.findElement(By.xpath("//a[@id='iframes']")).click();

	Thread.sleep(2000);
	}
	
	@Test
	void testCaseIframe0() throws InterruptedException {
		
		System.out.println("Step : Switch to iframe 0");
		Thread.sleep(2000);
	//	driver.switchTo().frame(0); (by frame index)
		driver.switchTo().frame("site1"); //(by String= name)
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']"))); (by Xpath)
		
		System.out.println("STEP 5 - Click on nevigation bar on top right button.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		
		Thread.sleep(2000);
		System.out.println("Step6 :Switch to the first frame & click on top right button & print the options");
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@id='main_navbar']"));
		for(WebElement printAllOption : listOfOptions)
			System.out.println(printAllOption.getText());
		
		
		System.out.println("Switch back to main window");
		driver.switchTo().parentFrame();//(come out from immediate iframe)
//		driver.switchTo().defaultContent();(switch at immediate browser)
		System.out.println(driver.findElement(By.xpath("//footer[@class='sticky-footer']")).getText());
			
	}
	
	@Test
	void testCaseIframe1() {
		
		System.out.println("STEP: Switch to iframe 2");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.switchTo().frame(2);
		
		System.out.println("STEP : Click on project");
		driver.findElement(By.xpath("//table[@summary='non selected tab']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //implicit wait
		
		System.out.println("STEP : Print all options under project button");
		List<WebElement> listOfProject = driver.findElements(By.xpath("//div[@class='menu']"));
			for(WebElement printAllProjectOptions : listOfProject)
			System.out.println(printAllProjectOptions.getText());
	}
	
	@AfterMethod
	void close() {
		PredefinedActions.closeAllBrowser();
	}
}
