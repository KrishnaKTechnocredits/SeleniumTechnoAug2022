package Sohail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_7 {
	WebDriver driver;

	@BeforeTest
	void login() {
		driver = PredefinedActions.openBrowser("https://jqueryui.com/droppable/");
	}

	@Test
	public void Ass() throws InterruptedException {
		// Script 1: Drag & Drop
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

	}

	@Test
	public void Script2() {
		// Script 2: Double click on element
		WebDriver driver2 = new ChromeDriver();
		driver2.get("http://automationbykrishna.com");
		driver2.manage().window().maximize();
		driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver2.findElement(By.xpath("//a[@id='basicelements']")).click();
		WebElement ele = driver2.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		JavascriptExecutor js = (JavascriptExecutor) driver2;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		Actions actions2 = new Actions(driver2);
		actions2.doubleClick(ele).build().perform();
		String alertTex = driver2.switchTo().alert().getText();
		String Expected = "You successfully double clicked it";
		if (Expected.equals(alertTex)) {
			System.out.println("Clicked on Alert");

			driver2.switchTo().alert().accept();
		} else {
			System.out.println("Did not clicked on alert");
		}

	}

	@Test
	public void Script3() {
		// Script 3: Mouse hover
		WebDriver driver3 = new ChromeDriver();
		driver3.get("https://www.flipkart.com/");
		driver3.manage().window().maximize();
		driver3.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver3.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Actions actions3 = new Actions(driver3);
		actions3.moveToElement(driver3.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();
		driver3.findElement(By.xpath(""));

	}

	@AfterTest
	public void close() {
		PredefinedActions.closeAllBrowser();
	}

}
