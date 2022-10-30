package Nikesh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1OpenBrowser {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Selenium/SeleniumTechnoAug2022/drivers/FirstPage.html");
		driver.manage().window().maximize();
		String expectedTitel = ("\"file:///D:/Selenium/SeleniumTechnoAug2022/drivers/FirstPage.html\"");
		String actualTitel = driver.getTitle();
		
		if(expectedTitel.equals(actualTitel)) {
		System.out.println("URL Loaded Sucessfully");
		}
		else 
			System.out.println("Check the Server Connectivity");
	
		driver.findElement(By.id("firstname")).sendKeys("Nikesh");
		Thread.sleep(3000);
		driver.findElement(By.id("lastname")).sendKeys("Margaje");
		Thread.sleep(3000);
		driver.findElement(By.id("male")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("h1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("h5")).click();
		Thread.sleep(3000);
		WebElement e = driver.findElement(By.id("bid"));
		Thread.sleep(3000);
		Select oselect = new Select(e);
		oselect.selectByVisibleText("INSTRU");
		Thread.sleep(3000);
		driver.findElement(By.linkText("click here")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		
	}
	
}
