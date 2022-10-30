package technocredits.windownHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;

public class WindownHandle {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start("https://www.amazon.in/");

		System.out.println("STEP - Navigate to Amazon");
	}

	@Test
	public void clickOnFirstProduct() throws Exception {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobile");
		System.out.println("STEP: Enter mobile in search bar");

		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		System.out.println("STEP: Click on search button");

		Thread.sleep(5000);

		WebElement element = driver.findElement(
				By.xpath("(//a[@target=\"_blank\"]//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		String expectedTitle = element.getText();

		String mainWindowID = driver.getWindowHandle();

		element.click();
		
		Set<String> multipleWindow = driver.getWindowHandles();

		System.out.println("Main WIndow: " + mainWindowID);
		System.out.println("Multi: " + multipleWindow);
		
		Iterator<String> itr = multipleWindow.iterator();
		while(itr.hasNext()) {
			String currectWin = itr.next();
			if(!currectWin.equals(mainWindowID)) {
				driver.switchTo().window(currectWin);
//				driver.close();
			}
		}
		System.out.println("STEP: Click on first search result");
		
//		driver.switchTo().window(mainWindowID);
//		System.out.println("STEP: switch to main window");
		
		Thread.sleep(5000);
		WebElement productTitleElement = driver.findElement(By.xpath("//span[@id='productTitle']"));
	
		String productTitle = productTitleElement.getText();
		
		Assert.assertEquals(expectedTitle, productTitle, "Exception: Title mis-match");

	}

}
