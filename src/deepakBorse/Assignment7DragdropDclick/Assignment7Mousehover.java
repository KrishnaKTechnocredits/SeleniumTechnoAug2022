/*Assignment No 7 : 1st Nov 2022
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
package deepakBorse.Assignment7DragdropDclick;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deepakBorse.PredefinedActions;

public class Assignment7Mousehover {
	WebDriver driver;

	@BeforeMethod
	public void initprocess() {
		driver = PredefinedActions.start("https://www.flipkart.com/");
	}

	@Test
	public void mousehover() throws InterruptedException {
		// Alert confirmBox = (Alert) driver.switchTo().alert();

		driver.findElement(
				By.xpath("//div[@class='_2Sn47c']/div[@class='_2hriZF _2rbIyg']/div[@class='_2QfC02']/button")).click();
		/*
		 * List<WebElement>
		 * login=driver.findElements(By.xpath("//html/body/div[2]/div/div/button"));
		 * if(login.size()>0) {
		 * 
		 * login.get(0).click(); }
		 */
		// System.out.println(login);
		// ((Alert) confirmBox).dismiss();
		System.out.println("Mouse hover on the Fashion icon from top");
		WebElement ele = driver.findElement(By.xpath("//div[@class='xtXmba'][text()='Fashion']"));
		Actions act = new Actions(driver);

		act.moveToElement(ele).perform();
		List<WebElement> listofashion = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		// System.out.println(listofashion.size());

		for (WebElement leftoption : listofashion) {
			act.moveToElement(leftoption).build().perform();
			List<WebElement> suboptions = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
			// System.out.println(suboptions.size());
			System.out.println(leftoption.getText() + "->" + suboptions.size());
			suboptions.clear();
		}
		Thread.sleep(5000);
	}

	@AfterMethod
	public void endprocess() {
		PredefinedActions.closeAllBrowser();
	}

}
