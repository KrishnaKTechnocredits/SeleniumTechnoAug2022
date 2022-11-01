package Sohail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Iframe_Assignment_6 {

	@Test
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		System.out.println("Switched");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button//span[@class='navbar-toggler-icon']")).click();
		String we = driver.findElement(By.xpath("//button//span[@class='navbar-toggler-icon']")).getText();
		System.out.println("Values are " + we);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@summary='non selected tab']//font")).click();
		System.out.println("Apache");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
