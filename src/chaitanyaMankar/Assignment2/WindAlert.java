package chaitanyaMankar.Assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindAlert 
{
	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com/");
		
		String firstName="Chaitanya";
		String lastName="Mankar";
		String company="Infosys";
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		driver.findElement(By.id("UserCompanyName")).sendKeys(company);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String expectedText = firstName + " and " + lastName + " and " + company;
		String actualText = alert.getText();

		System.out.println("Actual Text : "+actualText);
		if(actualText.equals(expectedText))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		alert.accept();
		Thread.sleep(3000);
		driver.close();
		
	}
}
