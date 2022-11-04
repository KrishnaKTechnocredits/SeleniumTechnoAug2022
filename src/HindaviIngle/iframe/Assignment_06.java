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
package HindaviIngle.iframe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class Assignment_06 {
	WebDriver driver;
	@BeforeMethod
	void beforeMethod() throws InterruptedException {
		System.out.println("STEP1:Navigate to automationbykrishna.com");
		driver=PredefinedActions.start("http://automationbykrishna.com/");
		System.out.println("STEP 2- Click on iFrame tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(2000);
	}
	@Test
	
	void iframe1Assignment01() throws InterruptedException {
		System.out.println("STEP 3- Switch to the first frame");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
		Thread.sleep(7000);
		
		System.out.println("STEP 4- Click on top right button ");

		WebElement element=driver.findElement(By.xpath("//button//span[@class='navbar-toggler-icon']"));
		element.click();
		Thread.sleep(5000);
		//String label=element.getText();
		System.out.println("STEP5:List of Actions:");

		List<WebElement> listOfElement = driver.findElements(By.xpath("//div[@id ='main_navbar']//li/a"));
		//System.out.println("--->"+listOfElement.toString());
		Thread.sleep(4000);
		for(WebElement name:listOfElement) {
			System.out.println(name.getText());		
		}
		Thread.sleep(3000);
		
		System.out.println("STEP6 - Switch back to main window");
		driver.switchTo().parentFrame();
		System.out.println("Main window --->"+driver.getTitle());

		driver.close();
		
		
	}
	@Test
	void iframe3Assignment01() throws InterruptedException {
		System.out.println("STEP 1- Switch to the third frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		
		Thread.sleep(4000);
		System.out.println("STEP 2- Click on project tab");
		driver.findElement(By.xpath("//font[text()='Projects']")).click();
		Thread.sleep(5000);

		
		System.out.println("STEP 3- Print options from project tab");

		List<WebElement> listOfMenu=driver.findElements(By.xpath("//li[@class='menuheader']"));
		
		for(WebElement element:listOfMenu) {
			
			System.out.println(element.getText());
		}
		
		System.out.println("STEP 4- Switch back to main window");
		driver.switchTo().parentFrame();
		System.out.println("Main window --->"+driver.getTitle());
		
		

	}


}
