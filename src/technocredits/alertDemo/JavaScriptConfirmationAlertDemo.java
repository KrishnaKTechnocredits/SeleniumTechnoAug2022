package technocredits.alertDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptConfirmationAlertDemo {

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

		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("STEP: Click on alert button");

		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		System.out.println("STEP: Switch to Alert");
		System.out.println("STEP: " + msg);

		alert.accept();
		System.out.println("STEP: Accept the Alert");

		String actualMsg = driver.findElement(By.xpath("//p[@id='pgraphdem']")).getText();
		System.out.println("STEP: Getting Text of Element");
		System.out.println("STEP: " + actualMsg);

		String expecteMsg = "You pressed OK!";

		if (actualMsg.equals(expecteMsg)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}

}
