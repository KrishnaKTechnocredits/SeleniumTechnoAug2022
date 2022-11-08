/*
 Assignment No 6 : 31st Oct 2022

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
5. Switch back to main window
 */

package SwapnilMaheshwari.Assignment6.iFrameTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
	
	WebDriver driver;
	

		@BeforeMethod
		public void BrowserOpen() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"D:\\TechnoCredits\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
			System.out.println("Step -Launch chrome browser");
			driver = new ChromeDriver();
			System.out.println("Step- Launch the URL");
			driver.get("http://automationbykrishna.com/#");
			driver.manage().window().maximize();
			Thread.sleep(3000);
		System.out.println("STEP - Navigate to IFrame Window");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void iFrame1st() throws InterruptedException {
	System.out.println("Step - switch to first Iframe ");
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
	System.out.println("Step- click on right corner of site");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
	List <WebElement> element=driver.findElements(By.xpath("//div[@id ='main_navbar']//li/a"));
	for(WebElement e : element) {
		System.out.println("The Element is :"+e.getText());
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	System.out.println("Step - Switch to main window");
	driver.switchTo().parentFrame();
	System.out.println("Step - Validate that foorter text should be visiable");
	System.out.println(driver.findElement(By.xpath("//footer[@class='sticky-footer']")).getText());
	Thread.sleep(2000);
}
	@Test
	public void iFrame() throws InterruptedException {
		System.out.println("Step - switch to third Iframe ");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		System.out.println("Click on Projects tab in frame 3");
		driver.findElement(By.xpath("//a[@href='./projects/index.html']//font[text()='Projects']")).click();
		Thread.sleep(30000);
		List<WebElement> projects = driver.findElements(By.xpath("//div[@class='menucontainer']//li[@class='menuheader']"));
		System.out.println("Print the project name");
		for(WebElement project :projects) {
			System.out.println("Project title is :"+project.getText());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Script End");
	}

}
