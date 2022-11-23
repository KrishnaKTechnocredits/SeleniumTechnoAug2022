package shraddhaRekhate.Assignment6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shraddhaRekhate.PredifinedActions;

public class Script2 {
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
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//font[text()='Projects']")).click();
	
	Thread.sleep(2000);
	
	List<WebElement> listOfWebElements=driver.findElements(By.xpath("//div[@class='menu']/ul/li"));
	  for(WebElement e: listOfWebElements) {
		System.out.println(e.getText());
	  }
	    System.out.println("Switch back to main window");
	    driver.switchTo().parentFrame();
    }
}
