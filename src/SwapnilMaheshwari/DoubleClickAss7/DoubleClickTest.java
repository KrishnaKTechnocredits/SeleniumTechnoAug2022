package SwapnilMaheshwari.DoubleClickAss7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickTest {

	WebDriver driver;

	@BeforeTest
	public void browserStart() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void doubleClick() throws InterruptedException {
		System.out.println("Step:Scroll down the element till it visible");
		WebElement element = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView()", element);
		Actions action = new Actions(driver);
		System.out.println("Step:Double click on the link using action class");
		action.doubleClick(element).build().perform();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		System.out.println("Step: Alert Accepted");
		Thread.sleep(3000);
		alert.accept();
		System.out.println(alertText);
	}

}
