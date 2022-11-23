/*Script 3: Mouse hover

1. Launch chrome browser
2. Hit url(https://www.flipkart.com/)in browser.
3. Click on cross button on login
4. Mouse hover on Fashion Icon
5. Validate that menu is displayed
6. print each section's subsection count
	Men's Top Wear - 11
	Men's Buttom Wear - 11
	Like wise for others
	https://jqueryui.com/
*/package asthaSrivastava.assignment7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import asthaSrivastava.PredefinedActions;

public class MouseHover {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws Exception{
		System.out.println("STEP : Hit url(https://www.flipkart.com/)in browser.");
		driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void mouseHoverOperations() throws InterruptedException{
		driver.findElement(By.xpath("//div//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("STEP : Click on cross button on login");
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		
		System.out.println("STEP : Mouse hover on Fashion Icon");
		actions.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();
		
		System.out.println("VERIFY - Validate that menu is displayed");
		int totalCount= driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		if(totalCount>0) {
			System.out.println("Menu Displayed");
		}else {
			System.out.println("Menu not Displayed");
		}
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']"));
		for(WebElement element : listOfOptions) {
			List<WebElement> subsection = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
			System.out.println(" " + element.getText() + "--> " + subsection.size());
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}


