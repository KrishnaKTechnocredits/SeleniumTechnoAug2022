package pujaSah.AlertTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws Exception{
		
		System.out.println("STEP1: Launch chrome browser and hit url:");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		
		String firstName = "Puja";
		String secondName = "Sah";
		String companyName = "Technocredits";
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP2: Enter First name:");
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		
		System.out.println("STEP3: Enter Second name:");
		driver.findElement(By.id("UserLastName")).sendKeys(secondName);
		
		System.out.println("STEP4: Enter Company Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
		
		System.out.println("STEP5: Click submit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Alert alert = driver.switchTo().alert();

		System.out.println("VERIFY: correct alert message is generated");
		String expectedAlertMessage = firstName +" and " + secondName+" and " +companyName;
		String actualAlertMessage = alert.getText();
		System.out.println("Expected alert message:" + expectedAlertMessage);
		System.out.println("Actual alert message:" + actualAlertMessage);
		
		if(expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");	
		}
		alert.dismiss();
	}
}
