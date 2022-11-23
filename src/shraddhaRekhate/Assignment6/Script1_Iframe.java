package shraddhaRekhate.Assignment6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shraddhaRekhate.PredifinedActions;

public class Script1_Iframe {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
	System.out.println("Launch browser ad hit url automation by Krishna");
	 driver =PredifinedActions.start("http://automationbykrishna.com");
	 Thread.sleep(2000);
	}
	
	@Test
	public void printOptionFromIframe() throws InterruptedException {
	System.out.println("Click on iFrame Tab");
	driver.findElement(By.xpath("//a[@id='iframes']")).click();
	
	System.out.println("Switch to first frame and click on top right button and print options About Download"
			+ "Documentations Project Support Blog");
	
	Thread.sleep(2000);
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
	
	Thread.sleep(2000);
	
	List<WebElement> listOfWebElements=driver.findElements(By.xpath("//div[@id='main_navbar']/ul/li/a"));
	  for(WebElement e: listOfWebElements) {
		System.out.println(e.getText());
	  }
	    System.out.println("Switch back to main window");
	    driver.switchTo().parentFrame();
    }
}
