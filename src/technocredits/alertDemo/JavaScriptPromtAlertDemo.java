package technocredits.alertDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPromtAlertDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP: Browser opens");
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP: Navigate to Automation By Krishna");

		driver.findElement(By.id("basicelements")).click();
		System.out.println("STEP: Click on Basic Element Tab");

		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,200)");
		
		Thread.sleep(2000);

		driver.findElement(By.id("javascriptPromp")).click();
		System.out.println("STEP: Click on alert button");
		
		String name = "Harsh";
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		System.out.println("STEP: Switch to Alert");

		alert.accept();
		System.out.println("STEP: Accept the Alert");

		String msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(msg.contains(name)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
	}

}
