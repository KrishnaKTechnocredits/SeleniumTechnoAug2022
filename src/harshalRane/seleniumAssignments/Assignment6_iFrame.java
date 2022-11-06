package harshalRane.seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import harshalRane.base.PredefinedActions;

public class Assignment6_iFrame {
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("STEP 2: Click on iFrame tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		
		Thread.sleep(3000);
	}
	
	@Test
	public void printOptionsFromFirstIFrame() throws InterruptedException {
		System.out.println("STEP 3: Switch to First Frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'site1']")));
		
		Thread.sleep(2000);
		System.out.println("STEP 4: click on top right button");
		driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("STEP 5: Print the options ");
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='main_navbar']/ul//li/a"));
		for(WebElement e : options) {
			System.out.println(e.getText());
		}
		
		System.out.println("STEP 6: Switch back to main window");
		driver.switchTo().parentFrame();	
	}
}
