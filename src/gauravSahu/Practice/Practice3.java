/*Script 1: Drag & Drop

1. Launch chrome browser
2. Hit url(https://jqueryui.com/droppable/)in browser.
3. Drag "Dram me to my target" element to "Drop here"
4. validate that you move draggable element to target location
*/

package gauravSahu.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gauravSahu.InitialActions;

public class Practice3 {
	
	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\\\AUG 2022 CLASS\\\\Selenium2022\\\\SeleniumTechnoAug2022\\\\drivers\\\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	}
	
	/*@Test
	void toFrame() throws Exception{
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		driver.switchTo().frame(element1);
		System.out.println("Step 2 : Switched to frame");	
	}
	
	@Test
	void action()throws Exception{
		Actions actions = new Actions(driver);
		WebElement drag1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		Thread.sleep(1000);
		WebElement drop1 = driver.findElement(By.xpath("//div[@id='droppable']"));
		Thread.sleep(1000);
		actions.dragAndDrop(drag1,drop1).build().perform();
		
	}*/
	
	@AfterMethod
	void close() throws Exception{
		Thread.sleep(2000);
		InitialActions.close();
	}

}
