/*
 * 

Script 3: Mouse hover

1. Launch chrome browser
2. Hit url(https://www.flipkart.com/)in browser.
3. Click on cross button on login
4. Mouse hover on Fashion Icon
5. Validate that menu is displayed
6. print each section's subsection count
	Men's Top Wear - 11
	Men's Bottom Wear - 11
	Like wise for others
 */

package akankshaVyas;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;

public class Assignment7_MouseHover {

WebDriver driver;
	
	@BeforeMethod
	void start() {
		driver=PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	void testCaseMouseHover() {
		
	
		System.out.println("Step :Click on cross button on loginclick ");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		
		System.out.println("Mouse hover on Fashion Icon");
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();
		
	
		System.out.println(" Validate that menu is displayed");
		int listOfOptions=driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
			
		if(listOfOptions>0) {
			System.out.println("STEP: Mouse hover working");
			System.out.println("Print all available options : "+ listOfOptions);
			
		}else {
		System.out.println("STEP: Mouse hover not performed");
	}
		System.out.println("Get List of Options under Fashion");
		List<WebElement> listOfFashionOptions = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		System.out.println("Display count for suboptios for every Fashion Option");
		for(WebElement e : listOfFashionOptions) {
			actions.moveToElement(e).build().perform();
			List<WebElement> listOfSubOptions = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
			System.out.println(e.getText() + "->" + listOfSubOptions.size());
			listOfSubOptions.clear();
		}
}
}