/*
Assignment No 6 : 31st Oct 2022

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

public class FrameCode1 {
	
	WebDriver driver;
	
	@BeforeTest
	public void startUp(){
		driver= StartupActions.launch();
	}
	
	@Test
	public void frameHande() throws InterruptedException {
		
		//Click on iFrame tab
		System.out.println("--Click on iFrame tab--");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(2000);
		
		System.out.println("--Switch to the first frame & click on top right button & print the options--");
		//Find element of frame
		WebElement e= driver.findElement(By.xpath("//iframe[@name='site1']"));
		//Used frame(element) method to switch to frame
		driver.switchTo().frame(e);
		
		Thread.sleep(2000);
		
		//click on top right button
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		Thread.sleep(2000);
		
		//Storing webelemts in List to with common value
		List <WebElement> le =driver.findElements(By.xpath("//div[@id=\"main_navbar\"]/ul/li"));
		//iterating weblements using for loop
		System.out.println("--Options are as below--");
		for(WebElement e1 : le) {
			String text=e1.getText();
			//used if as list contains blank string as well. Not supposed to print in console
			if(!text.equals(""))
				System.out.println(text);
		}
		
		//Switch back to main window
		System.out.println("--Switch back to main window--");
		driver.switchTo().defaultContent();
	}
	
	@AfterTest
	public void wrapUp() {
		driver.close();
	}
}
