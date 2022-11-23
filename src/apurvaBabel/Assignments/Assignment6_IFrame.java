/*Assignment No 6 : 31st Oct 2022
Script 1 :
1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the first frame & click on top right button & print the options
	About
	Downloads
	Documentations
	Project
	Support
	Blog
5. Switch back to main window
---------------------------------------------------------------
Script 2 :
1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the 3rd frame & click on Projects tab
5. print the 
	Projects
	Apache Ant Libraries
	Apache Ivy
	Apache IvyDE
	Apache EasyAnt
5. Switch back to main window
*/

package apurvaBabel.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apurvaBabel.PredefinedActions;

public class Assignment6_IFrame {

	public WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = PredefinedActions.start();

		System.out.println("Step2: Click on IFrame Demo tab");
		driver.findElement(By.id("iframes")).click();

		Thread.sleep(3000);
	}

	@Test
	public void printOptionsFrom1stIFrame() throws InterruptedException {
		System.out.println("Step3: Switch to the first frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'site1']")));

		Thread.sleep(5000);
		System.out.println("Step4: Click on top right button");
		driver.findElement(By.xpath("//button[@class = 'navbar-toggler']")).click();

		System.out.println("Step5: print the options");
		List<WebElement> options = driver.findElements(By.xpath("//div[@id ='main_navbar']//li/a"));
		System.out.println("Options -->");
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		Thread.sleep(1000);

		System.out.println("Step6: Switch back to main window");
		driver.switchTo().parentFrame();
	}

	@Test
	public void printOptionsFrom3rdIFrame() throws InterruptedException {
		System.out.println("Step3: Switch to the third frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title ='site3']")));

		Thread.sleep(2000);
		System.out.println("Step4: Click on Projects tab");
		driver.findElement(By.xpath("//table[@summary ='non selected tab']")).click();

		System.out.println("Step5: Print the projects");
		List<WebElement> projects = driver.findElements(By.xpath("//li[@class='menuheader']"));
		for (WebElement project : projects) {
			System.out.println("------" + project.getText());
		}
		Thread.sleep(2000);

		System.out.println("Step6: Switch back to main window");
		driver.switchTo().parentFrame();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
