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
5. Switch back to main window*/

package pujaSah.WorkingOnFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pujaSah.Base.PredefinedActions;

public class FramesTesting {
	
	WebDriver driver;
	@BeforeMethod
	public void startUp() {
		System.out.println("STEP 1: Launch browser and hit url");
		driver = PredefinedActions.start("http://automationbykrishna.com/");
	}
	
	@Test
	public void TestFrames() throws InterruptedException {
		System.out.println("STEP 2: Click on IFrame Demo");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(5000);
		
		System.out.println("STEP 3: Switch to first frame");
		driver.switchTo().frame(0);
		
		System.out.println("STEP 4: Print the text displayed on the frame");
		System.out.println(driver.findElement(By.xpath("//h1[@class='display-1 mt-0 mt-md-5 pb-1']")).getText());
	
		System.out.println("STEP 5: Click on top right button");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		
		System.out.println("STEP 6 : Print first option");
		System.out.println(driver.findElement(By.xpath("//li[@class='nav-item dropdown']/a[@data-toggle='dropdown']")).getText());
		Thread.sleep(1000);
		
		System.out.println("STEP 7 : Print second option");
		System.out.println(driver.findElement(By.xpath("//div[@id='main_navbar']//li[3]//span")).getText());
		Thread.sleep(1000);
		
		System.out.println("STEP 8: Print third option");
		System.out.println(driver.findElement(By.xpath("//div[@id='main_navbar']//li[4]//span")).getText());
		Thread.sleep(1000);
		
		System.out.println("STEP 9: Print fourth option");
		System.out.println(driver.findElement(By.xpath("//div[@id='main_navbar']//li[5]//span")).getText());
		Thread.sleep(1000);
		
		System.out.println("STEP 10: Print fifth option");
		System.out.println(driver.findElement(By.xpath("//div[@id='main_navbar']//li[6]//span")).getText());
		Thread.sleep(1000);
		
		System.out.println("STEP 11:Print sixth option");
		System.out.println(driver.findElement(By.xpath("//div[@id='main_navbar']//li[7]//span")).getText());
		Thread.sleep(1000);
		
		System.out.println("STEP :Switch to parent frame");
		driver.switchTo().parentFrame();
		System.out.println("Test Passed");
	}
	
	/*@AfterMethod
	public void tearDoun() {
		driver.close();
	}*/
}
