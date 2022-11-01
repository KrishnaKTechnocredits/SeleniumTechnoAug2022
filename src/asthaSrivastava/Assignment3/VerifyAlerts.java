/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.
*/
package asthaSrivastava.Assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAlerts {

	public static void verifyAlertMessage(String expectedMessage, Alert alert) {
		String actualMessage = alert.getText();
		if (expectedMessage.equals(actualMessage)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Launch Chrome Browser");

		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP - Navigate to https://automationbykrishna.com");

		driver.findElement(By.id("basicelements")).click();
		System.out.println("STEP - Click on Basic Element Tab");

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");

		System.out.println("--------------------------");
		driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();
		System.out.println("STEP - Click on Alert button");

		Alert alert = driver.switchTo().alert();
		System.out.println("STEP - Switch to Alert");

		verifyAlertMessage("You must be TechnoCredits student!!", alert);
		alert.accept();

		System.out.println("--------------------------");
		System.out.println("STEP - Click on Javascript Confirmation");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		driver.switchTo().alert();

		System.out.println("STEP - Switch to Alert");
		verifyAlertMessage("Are you are doing your homework regularly, Press Okay else Cancel!!", alert);
		alert.accept();

		String actualMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("VERIFY - Message displayed : " + actualMsg);

		String expectedMsg = "You pressed OK!";
		if (expectedMsg.equals(actualMsg)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("---------------------------------");

		System.out.println("STEP - Click on Javascript Prompt");
		driver.findElement(By.id("javascriptPromp")).click();
		String name = "Astha";

		Alert alert2 = driver.switchTo().alert();
		System.out.println("STEP - Switch to Alert");
		alert2.sendKeys(name);

		alert2.accept();
		System.out.println("STEP - Accept Alert");

		String aMessage = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println("Message displayed : " + aMessage);

		String exMessage = "Hello " + name + "! How are you today?";

		if (exMessage.contains(name)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		driver.close();
	}

}
