package saroj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssignment7Script1 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		System.out.println("Navigate to Droppable window");
	}

	@Test
	public void draggable() {
		System.out.println("Step - Drag 'Drag me to my target' element to 'Drop here'");
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(sourceElement, targetElement).build().perform();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

}
