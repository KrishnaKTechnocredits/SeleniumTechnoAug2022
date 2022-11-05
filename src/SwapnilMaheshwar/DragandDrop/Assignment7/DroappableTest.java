package SwapnilMaheshwar.DragandDrop.Assignment7;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DroappableTest {
	WebDriver driver;

	@BeforeTest
	public void browserStart() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Drop() {
		Actions actions = new Actions(driver);
		WebElement sourec = driver.findElement(By.xpath("//div[@id='draggable']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.dragAndDrop(sourec, destination).build().perform();
	}

}
