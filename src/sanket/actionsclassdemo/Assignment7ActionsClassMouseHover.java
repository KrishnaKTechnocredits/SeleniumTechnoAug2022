/*Assignment No 7 : 1st Nov 2022
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

package sanket.actionsclassdemo;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.PredefinedActions;

public class Assignment7ActionsClassMouseHover {

	WebDriver driver;

	@BeforeMethod
	public void preTestSetup() throws Exception {

		System.out.println("STEP 1 - Launch Chrome Browser and hit URL.");

		driver = PredefinedActions.start("https://www.flipkart.com/");
		
		System.out.println("STEP 2 - Navigate to Flipkart.");

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("STEP 3 - Click on cross button on Flipkart login");

	}

	@Test
	public void doubleClickOperations() throws Exception {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();
		
		System.out.println("STEP 4 - Mouse hover on Fashion Icon");

		int totalVisibleOptions = driver.findElements(By.xpath("//a[@class='_6WOcW9 _2-k99T']")).size();
		if (totalVisibleOptions > 0) {
			System.out.println("Pass - Mouse hover is working.");
			System.out.println("\n");
			
			System.out.println("STEP 5 - Printing subcategory count of Fashion options");
			System.out.println("Fashion Subsections");
			List<WebElement> fashionCategories = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
			for (WebElement fashionCategory : fashionCategories) {
				List<WebElement> fashionSubCategories = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
				System.out.println(fashionCategory.getText() + " - " + fashionSubCategories.size());
				Thread.sleep(3000);
			}
		} else {
			System.out.println("Fail - Mouse hover is not working.");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
