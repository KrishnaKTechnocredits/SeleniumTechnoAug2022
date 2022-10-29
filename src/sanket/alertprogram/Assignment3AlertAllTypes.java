/*Assignment - 3 : 28th Oct'2022
Verify Alert functionality on automationbykrishna application.
*/

package sanket.alertprogram;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3AlertAllTypes {

	public static void main(String[] args) throws Exception {

		System.out.println("STEP 1 - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");

		System.out.println("STEP 2 - Hit url (http://automationbykrishna.com/)in browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(3000);

		System.out.println("STEP 3- Verify Application is loaded successfully.");
		String expectedTitle = "Login Signup Demo";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle))
			System.out.println("Pass - Page Login Signup Demo loaded Suceessfully.");
		else
			System.out.println("Fail - Page not loaded.");

		System.out.println("STEP 4- Click on basic element tab.");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		System.out.println("\n");
		System.out.println("***Simple Alert Execution***");

		driver.findElement(By.id("javascriptAlert")).click();
		System.out.println("STEP 5- Click on Alert.");

		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);

		String expectedMessage = "You must be TechnoCredits student!!";
		System.out.println("STEP 6- Getting Alert message.");

		String actualMessage = alert1.getText();

		if (expectedMessage.equals(actualMessage))
			System.out.println("Paas - Alert Message Verified - You must be TechnoCredits student!!.");
		else
			System.out.println("Failed to get message");

		driver.switchTo().alert().accept();

		System.out.println("\n");
		System.out.println("***JavaScript Confirm Box Alert Execution - accept***");

		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("STEP 7- Click on JavaScript Confirmation");

		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(2000);

		String expectedMessage1 = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		System.out.println("STEP 8- Getting Alert message.");

		String actualMessage1 = alert2.getText();

		if (expectedMessage1.equals(actualMessage1))
			System.out.println(
					"Paas - Alert Message Verified - Are you are doing your homework regularly, Press Okay else Cancel!!");
		else
			System.out.println("Failed to get message");

		driver.switchTo().alert().accept();

		WebElement e = driver.findElement(By.id("pgraphdemo"));

		String expectedMessage2 = "You pressed OK!";
		String actualMessage2 = e.getText();

		if (expectedMessage2.equals(actualMessage2))
			System.out.println("Paas - Alert Message Verified - You pressed OK!");
		else
			System.out.println("Failed to get message");
		System.out.println("STEP 9- Getting Alert message.");

		System.out.println("\n");
		System.out.println("***JavaScript Confirm Box Alert Execution - dismiss***");

		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("STEP 10- Click on JavaScript Confirmation");

		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(2000);

		String expectedMessage3 = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		String actualMessage3 = alert3.getText();

		if (expectedMessage3.equals(actualMessage3))
			System.out.println(
					"Paas - Alert Message Verified - Are you are doing your homework regularly, Press Okay else Cancel!!");
		else
			System.out.println("Failed to get message");

		driver.switchTo().alert().dismiss();

		WebElement e2 = driver.findElement(By.id("pgraphdemo"));

		String expectedMessage4 = "You pressed Cancel!";
		String actualMessage4 = e2.getText();

		if (expectedMessage4.equals(actualMessage4))
			System.out.println("Paas - Alert Message Verified - You pressed Cancel!");
		else
			System.out.println("Failed to get message");

		System.out.println("\n");
		System.out.println("***JavaScript Prompt Box Alert Execution***");

		driver.findElement(By.id("javascriptPromp")).click();
		System.out.println("STEP 11- Click on JavaScript Prompt Box");

		Alert alert4 = driver.switchTo().alert();
		Thread.sleep(2000);

		String name = "Steve";
		alert4.sendKeys(name);
		
		System.out.println("STEP 12- Entered the name");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		

		WebElement e3 = driver.findElement(By.id("pgraphdemo"));
		String actualMessage5 = e3.getText();

		if (actualMessage5.contains(name))
			System.out.println("Pass - Text verfied.");
		else
			System.out.println("Fail - Wrong text.");
		
		driver.quit();
	}
}
