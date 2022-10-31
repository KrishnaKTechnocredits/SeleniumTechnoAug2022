
/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.*/
package nilamP.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws Exception {

		System.out.println("STP 1- Browser Launched");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 2 - Hit URl");
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP 3 - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		System.out.println("STEP: Click on Alert Button");

		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		String expectedText = "You must be TechnoCredits student!!";
		System.out.println("STEP: Switch to Alert");
		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);
		System.out.println("STEP: Get actual text on alert popup");
		String actualText = alert.getText();

		System.out.println("STEP: Verify actual text to be as per expected text");
		if (actualText.equals(expectedText)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		System.out.println("STEP: Click OK on Alert popup");
		alert.accept();
	}
}
