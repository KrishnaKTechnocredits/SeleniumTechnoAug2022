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
5. Switch back to main window*/

package pujaSah.WorkingOnFrames;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pujaSah.Base.PredefinedActions;

public class FramesTesting2 {
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
		
		System.out.println("STEP 3: Switch to third frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		Thread.sleep(2000);

		System.out.println("STEP 4: - Click on projects tab");
		driver.findElement(By.xpath("//a[@href='./projects/index.html']")).click();
		Thread.sleep(5000);

		System.out.println("STEP 5: - Scroll upto last menu option :Project Management");
		WebElement element = driver.findElement(By.xpath("//div[@class='content']/h3[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP 6: - print the options under Project tab");
		List<WebElement> listOfMenu = driver.findElements(By.xpath("//li[@class='menuheader']"));
		for (WebElement curMenu : listOfMenu) {
			System.out.println(curMenu.getText());
		}
		
		System.out.println("STEP 7: - Switch back to main Window");
		driver.switchTo().parentFrame();
		String expectedTest = "Automation By Krishna";
		String actualText = driver.findElement(By.xpath("//a[@href='http://automationbykrishna.com']")).getText();
		Assert.assertEquals(actualText, expectedTest);	
	}
	
	/*@AfterMethod
	public void tearDoun() {
		driver.close();
	}*/
}

