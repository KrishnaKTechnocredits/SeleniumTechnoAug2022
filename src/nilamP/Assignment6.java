
/*Assignment No 6 : 31st Oct 2022

Script 1

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
Script 2

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
5. Switch back to main window*/
package nilamP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import nilamP.predefinedFunctions.OpenBrowser;

public class Assignment6 {

	WebDriver driver;

	@BeforeMethod
	public void m() {

		driver = OpenBrowser.start("http://automationbykrishna.com/#");
		System.out.println("STEP 2 - Hit URl");
		// driver.manage().window().maximize();
		System.out.println("STEP 3 - Click on iframes  tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
	}

	@Test
	void Script1() throws Exception {
		// WebDriver driver1 = new ChromeDriver();
		System.out.println("STEP - Switch to the first frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));

		Thread.sleep(4000);

		System.out.println("STEP - click on top right button");

		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		System.out.println("STEP - Print the list of projects");
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@id='main_navbar']/ul/li/a"));
		for (WebElement e : listOfOptions) {
			if (e.getText() != "")
				System.out.println(e.getText());
		}
		System.out.println("STEP - Switch back to main window");
		driver.switchTo().parentFrame();

		System.out.println("Switched back to main window");
	}

	@Test
	void Script2() throws Exception {

		System.out.println("STEP - Switch to the first frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));

		Thread.sleep(4000);

		System.out.println("STEP - Click on projects tab");
		driver.findElement(By.xpath("//a[@href='./projects/index.html']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[@class='content']/h3[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP - print the list  projects");
		List<WebElement> listOfAllProjects = driver
				.findElements(By.xpath("//div[@class='menucontainer']//li[@class='menuheader']"));
		System.out.println("\n");
		for (WebElement e : listOfAllProjects) {
			System.out.println(e.getText());
		}
		System.out.println("STEP - Switch back to main window");
		driver.switchTo().defaultContent();

	}

	
}
