//Assignment No 7 : 1st Nov 2022

/*1. Launch chrome browser
2. Hit url(https://www.flipkart.com/)in browser.
3. Click on cross button on login
4. Mouse hover on Fashion Icon
5. Validate that menu is displayed
6. print each section's subsection count
	Men's Top Wear - 11
	Men's Buttom Wear - 11
	Like wise for others*/

package komalShrivastava.actionClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import komalShrivastava.base.PredefinedActions;

public class MouseHoverFlipkartPractice {
	
	WebDriver driver;
	@BeforeTest
	public void launchURL() throws InterruptedException {
		driver = PredefinedActions.start("https://www.flipkart.com/");
		Thread.sleep(2000);
	}
	
	@Test
	public void mouseHover() throws InterruptedException {
		
		Actions action = new Actions(driver);
		
		System.out.println("STEP : Click on cross icon");
		WebElement icon = driver.findElement(By.xpath("//div[@class='_2QfC02']/button"));
		action.click(icon).build().perform();
		Thread.sleep(2000);
		
		System.out.println("STEP : Mouse Hover on Fashion icon");
		WebElement fashionIcon = driver.findElement(By.xpath("//div[@class='_37M3Pb']//div[@class='eFQ30H'][4]//div[@class='_1mkliO']"));
		
		action.moveToElement(fashionIcon).build().perform();
		
		System.out.println("STEP : MouseHover on each option and get the count of Suboptions");
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		
		for(WebElement option : listOfOptions) {
			action.moveToElement(option).build().perform();
			List<WebElement> listOfSubOptions = driver.findElements(By.xpath("//div[@class='_3XS_gI']//a"));
			System.out.println(option.getText() + " --> " + listOfSubOptions.size());
		}
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("STEP : Clos the browser");
		driver.close();
	}
}