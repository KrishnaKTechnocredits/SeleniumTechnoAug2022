/*
Assignment No 7 : 1st Nov 2022
Script 3: Mouse hover

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

package deepakPatil.assignment7ActionsClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import deepakPatil.base.StartupActions;

public class MouseHover {
	WebDriver driver;
	
	@BeforeTest
	void startUp() {
		driver= StartupActions.launch("https://www.flipkart.com/");
	}
	
	@Test
	void mouseHover() {
		//Click on cross button on login
		System.out.println("--Click on cross button on login--");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		//Mouse hover on Fashion Icon
		System.out.println("--Mouse hover on Fashion Icon--");
		Actions act = new Actions(driver);
		WebElement e= driver.findElement(By.xpath("//div[@class='eFQ30H'][4]//div[@class='_1psGvi SLyWEo']//div[@class='xtXmba']"));
		act.moveToElement(e).build().perform();
		
		//Validate that menu is displayed
		System.out.println("--Validate that menu is displayed--");
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9']"));
		if(elements.size()>0)
			System.out.println("All elements displayed. Test passed");
		else
			System.out.println("Elements not displayed. Test failed");
		
		//print each section's subsection count
		System.out.println("--print each section's subsection count--");
		WebElement e2=driver.findElement(By.xpath("//a[@class='_6WOcW9 _2-k99T']"));
		act.moveToElement(e2).build().perform();
		System.out.println("SubMenu of: "+e2.getText());
	    List<WebElement> subMenuList =driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
	    
	    for(WebElement e1:subMenuList) {
	    	System.out.println(e1.getText());
	    }
	}
	
	@AfterTest
	void wrapUp() {
		driver.close();
	}
}
