package Nikesh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2Nikesh {

	public static void main(String[] args) throws Exception  {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().window().maximize();
		String expectedTitel = ("http://automationbykrishna.com/index.html#");
		String actualTitel = driver.getTitle();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("Nikesh.margaje@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("pwd")).sendKeys("Nikesh");
		Thread.sleep(1000);
		driver.findElement(By.id("submitb2")).click();
		Thread.sleep(3000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
	}
}
