/*Assignment No 7 : 1st Nov 2022
Script 3: Mouse hover

1. Launch chrome browser
2. Hit url(https://www.flipkart.com/)in browser.
3. Click on cross button on login
4. Mouse hover on Fashion Icon
5. Validate that menu is displayed
6. print each section's subsection count
	Men's Top Wear - 11
	Men's Buttom Wear - 11
	Like wise for others*/

package pujaSah;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pujaSah.Base.PredefinedActions;

public class MouseHoverExample {

	WebDriver driver;
	
	@BeforeMethod
	public void startUp() throws InterruptedException {
		System.out.println("STEP 1: Launch browser and hit url.");
		driver = PredefinedActions.start("https://www.flipkart.com/");	

		System.out.println("STEP 2: Click on cross button on login");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}
	
	@Test
	public void mouseHoverTest() {
		WebElement FashonElement = driver.findElement(By.xpath("//img[@alt='Fashion']"));
		Actions actions = new Actions(driver);
		
		System.out.println("STEP3 - Hover Mouse on Fashion Icon");
		actions.moveToElement(FashonElement).build().perform();
		
		List<WebElement> menuOptions = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		if (menuOptions.size() > 0) {
			System.out.println("VERIFY - Menu is displayed");
		} else {
			System.out.println("VERIFY - Menu is not displayed");
		}
		
		System.out.println("STEP 4: Print number of sections under each menu");
		for (WebElement options : menuOptions) {
			actions.moveToElement(options).build().perform();
			List<WebElement> listOfMoreOptions = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
			System.out.println(options.getText() + " - " + listOfMoreOptions.size());
		}
	}
	/*
	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}*/
}
