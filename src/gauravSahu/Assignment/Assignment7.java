/*Assignment No 7 : 1st Nov 2022

Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location

---------------------------------------------------------------
*/

package gauravSahu.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7 {
	WebDriver driver;
	@BeforeMethod
	void launchUrl() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "E:\\AUG 2022 CLASS\\Selenium2022\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
	driver = new ChromeDriver();
	System.out.println("Step-1 : Verify Chrome Browser Launched");
	
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	System.out.println("Step 2 : Switch to frame");
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	Thread.sleep(2000);
	}
	
	@Test
	void dragDropElement(){
		WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement element2 = driver.findElement(By.xpath("//div[@id='droppable']"));
		System.out.println("Step 3 : Drag & Dorp by creating object of action class");
		Actions act = new Actions(driver);
		act.dragAndDrop(element1, element2).build().perform();
	}
	
	@AfterMethod
	void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
