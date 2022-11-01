/*Script 3: Mouse hover
1. Launch chrome browser
2. Hit url(https://www.flipkart.com/)in browser.
3. Click on cross button on login
4. Mouse hover on Fashion Icon
5. Validate that menu is displayed
6. print each section's subsection count
	Men's Top Wear - 11
	Men's Buttom Wear - 11
	Like wise for others*/

package manjiri.assignment7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;

public class MouseHover {
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {	
		System.out.println("Launch Browser and Navigate to URL");
		driver = PredefinedActions.start("https://www.flipkart.com/");
		System.out.println("Close Login Popup if present");
		List<WebElement> ele = driver.findElements(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		if(ele.size() > 0) {
			ele.get(0).click();
		}
	}
	
	@Test
	public void mouseHoverOnElement() {
		System.out.println("Locate element Fashion");
		WebElement fashionElement = driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"));
		System.out.println("Move to Fashion Element");
		Actions actions = new Actions(driver);
		actions.moveToElement(fashionElement).build().perform();
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
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Close Browser");
		PredefinedActions.closeBrowser();
	}
}
