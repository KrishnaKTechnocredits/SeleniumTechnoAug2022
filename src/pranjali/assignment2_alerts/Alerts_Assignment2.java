package pranjali.assignment2_alerts;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_Assignment2 {
	
	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();  // to open the browser
		driver.manage().window().maximize(); //to mazimise the browser window
		driver.get("http://automationbykrishna.com/#"); //to open the webiste
		return driver;
	}
	
	public void alertDemo() throws InterruptedException {
		WebDriver driver = this.openBrowser();
		driver.findElement(By.id("basicelements")).click(); //click on Basic Elements
		Thread.sleep(3000);
		
		String firstName = "Pranjali";
		String lastName = "Vyavaharkar";
		String companyName = "LTI";
		
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName); //write value in 1st name
		driver.findElement(By.id("UserLastName")).sendKeys(lastName); //write value in last name
		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);//write value in company  name
		
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("Pranjali@gmail.com"); //write value in email id
		driver.findElement(By.id("pwd")).sendKeys("abcd");//write value in password
		driver.findElement(By.id("submitb2")).click();
		
		Alert alert = driver.switchTo().alert(); //to switch to Alert
		Thread.sleep(3000);
		
		//To verify Alert message matches with the expected message
		String expectedAlertMessage = "You successfully clicked on it";
		System.out.println("Expected Alert Message : " + expectedAlertMessage); //expected message 
		String actualAlertMessage = alert.getText();
		System.out.println("Actual Alert Message : " + actualAlertMessage); //actual message
		
		if(expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Test Pass");
		}
		else{
			System.out.println("Test Fail");
		}
		
		alert.dismiss();//to dismiss the Alert textbox
		
		driver.quit();//to close the browser
	}

	public static void main(String[] args) throws InterruptedException {
		Alerts_Assignment2 ex2 = new Alerts_Assignment2();
		ex2.alertDemo();
	}

}
