package sagar_Y.assignment_2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("---------------Assignment: 2 ----------");
		System.out.println("This is to Test and Handle Alert Message");
		System.out.println("-----------------------------------------\n");
		System.out.println("STEP : Launch Chrome Browser\n");

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		
		String expectedTitle = "Login Signup Demo";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com/#");

		String actualTitle = driver.getTitle();

		System.out.println("\nVERIFY: If Correct URL loaded.");

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Yes\n");
		} else {
			System.out.println("No\n");
		}

		System.out.println("STEP : Click on Basic Elements\n");

		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		String firstName = "Sagar";
		String lastName = "Yadav";
		String company = "Wipro";

		System.out.println("STEP : Pass the values \n");

		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);

		driver.findElement(By.id("UserLastName")).sendKeys(lastName);

		driver.findElement(By.id("UserCompanyName")).sendKeys(company);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String expectedmessage = firstName + " and " + lastName + " and " + company;
		
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP: Switch to the Alert Message\n");

		Thread.sleep(3000);

		String actualMessage = alert.getText();
		alert.accept();
		System.out.println("STEP: Accept the Alert message.\n");

		System.out.println("VERIFY: If alert message appeared as we expected.");

		if (expectedmessage.equals(actualMessage))
			System.out.println("Test Case Pass !!!");
		else
			System.out.println("Test Case Fail !!!");

		Thread.sleep(3000);

		driver.close();

	}

}
