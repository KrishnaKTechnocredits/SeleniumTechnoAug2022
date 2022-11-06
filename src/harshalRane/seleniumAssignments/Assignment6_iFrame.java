package harshalRane.seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import harshalRane.base.PredefinedActions;

public class Assignment6_iFrame {
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(5000);
		System.out.println("STEP 2: Click on iFrame tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		
		Thread.sleep(3000);
	}
	
	@Test
	public void printOptionsFromFirstIFrame() throws InterruptedException {
		System.out.println("STEP 3: Switch to First Frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'site1']")));
		
		Thread.sleep(5000);
		System.out.println("STEP 4: Click on top right button");
		driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
		
		Thread.sleep(5000);
		
		System.out.println("STEP 5: Print the options ");
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='main_navbar']/ul//li/a"));
		for(WebElement e : options) {
			System.out.println(e.getText());
		}
		
		Thread.sleep(2000);
		System.out.println("STEP 6: Switch back to main window");
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
	}
	
	@Test
	public void printOptionsFromThirdFrame() throws InterruptedException {
		// code to scroll down on webpage
		Thread.sleep(5000);
		System.out.println("STEP: Scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(3000);
		System.out.println("STEP 1: Switch to Third Frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		
		Thread.sleep(2000);
		System.out.println("STEP 2: Click on Project Tab");
		driver.findElement(By.xpath("//tBody/tr/td[2]/font/b")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP 3: Print the options");
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='menuheader']"));
		for(WebElement e : options) {
			System.out.println(e.getText());
		}
		
		Thread.sleep(2000);
		System.out.println("STEP 4: Switch back to main window");
		driver.switchTo().parentFrame();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
