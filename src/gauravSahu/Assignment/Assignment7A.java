/*Script 2: Double click on element

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on Basic Element tab
4. Scroll till element visible
5. Perform double click on element
6. Validate that you double click on element

---------------------------------------------------------------
*/

package gauravSahu.Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7A {

	WebDriver driver;

	@BeforeMethod
	void launchUrl() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\AUG 2022 CLASS\\Selenium2022\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser & URL Launched");

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	@Test
	void doubleclick() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("Step 2 : Click on Basic Element tab");

		WebElement element1 = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element1);
		System.out.println("Step 3 : Scroll into the element");

		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.doubleClick(element1).build().perform();
		System.out.println("Step 4 : Double clicking on element");

		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		if (alertText.equals("You successfully double clicked it")) {
			System.out.println("Step 5 : Alert message & double clicking validated");
		}
		
		
		Thread.sleep(2000);
		alert.accept();

	}

	@AfterMethod
	void close() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test passed");
		driver.close();
		

	}

}
