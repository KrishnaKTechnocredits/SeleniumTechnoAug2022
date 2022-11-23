/*
 * Script 3: Mouse hover

1. Launch chrome browser
2. Hit url(https://www.flipkart.com/)in browser.
3. Click on cross button on login
4. Mouse hover on Fashion Icon
5. Validate that menu is displayed
6. print each section's subsection count
	Men's Top Wear - 11
	Men's Buttom Wear - 11
	Like wise for others
 */
package HindaviIngle.DragDropDoubleClickMouseHover;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class Assignment_07_MouseHover {
	WebDriver driver;
@BeforeMethod
	void beforeMethod() {
		System.out.println("Step 2: Navigate to flipkart url ");
		driver=PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	@Test
	void mouseHoverFunctionality() {
		System.out.println("Step 3: Click on X button");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		System.out.println("Step 4: Mouse Over on Fashion");

		WebElement element=driver.findElement(By.xpath("//img[@alt='Fashion']"));
		
		Actions action= new Actions(driver);
		action.moveToElement(element).build().perform();
		
		System.out.println("Step5 - Validate that menu over is working");
		
		int menuCount=driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		
		System.out.println("Menu count-->"+menuCount);
		if(menuCount>0) {
			System.out.println("Menu's are displaying");
		}
		else {
			System.out.println("Menu hover not working");
		}
		
		System.out.println("Step 6 - Display each section's subsection count");
			
		List<WebElement> elementCount = driver.findElements(By.xpath("//a[@class='_6WOcW9']"));
		WebElement ele = driver.findElement(By.xpath("//a[@class='_6WOcW9 _2-k99T']"));
		System.out.println(ele.getText());
		action.moveToElement(ele);
		System.out.println(driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']")).size());
		for (WebElement e : elementCount) {
			System.out.println(e.getText());
			action.moveToElement(e).build().perform();
			List<WebElement> subElementSize = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
			System.out.println(subElementSize.size());
		}	
	}
	
	@AfterMethod
	void cleanUp() {
	driver.close();
	}

}
