package technocredits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://harshaug2022-trials76.orangehrmlive.com");

		driver.findElement(By.id("txtUsername")).sendKeys("admin");

		driver.findElement(By.id("txtPassword")).sendKeys("MPCs0K@ce1");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(10000);

		driver.findElement(By.cssSelector("input#menuQuickSearch_menuQuickSearch")).sendKeys("Ma");
	
		driver.findElement(By.cssSelector("ul#menuQuickSearchResultList li:nth-child(88)"));
	
	
	
	}

}
