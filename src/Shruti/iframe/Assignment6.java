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
—-----------------------------------------------------
*/
package Shruti.iframe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment6 {
WebDriver driver;
	
	@BeforeTest
	public void startUp(){
		driver= Shruti.base.PreDefinedActions.start("http://automationbykrishna.com");
	}
	
	@Test
	public void frameHandle() throws InterruptedException {
		
		//Click on iFrame tab
		System.out.println(" Step: Click on iFrame tab--");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(2000);
		
		System.out.println("Step: Switch to the first frame & click on top right button & print the options--");
		//Find element of frame
		WebElement e= driver.findElement(By.xpath("//iframe[@name='site1']"));
		//Used frame(element) method to switch to frame
		driver.switchTo().frame(e);
		
		Thread.sleep(2000);
		
		//click on top right button
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		Thread.sleep(2000);
		
		//Storing webelements in List
		List <WebElement> list =driver.findElements(By.xpath("//div[@id=\"main_navbar\"]/ul/li"));
		
		System.out.println("--Options are as below--");
		for(WebElement ele : list) {
			String text=ele.getText();
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