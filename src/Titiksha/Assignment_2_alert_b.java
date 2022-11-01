//Testcase1:open chrome browser
//tc2:maximize chrome browser screen
//tc3:open autiomation bykrishna webpage
//tc4:click on basic information
//tc5:give id 
//tc6:give password
//tc7:click checkbox click me out
//tc8:submit
//tc9:verify reject msg
//tc10: accept the ok button

package Titiksha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2_alert_b {
	public static void main(String[] args) throws Exception {
		
		System.out.println("Testcase1:open chrome browser");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver=new ChromeDriver();
	
		System.out.println("Testcase2:Maximize chrome browser screen");
		driver.manage().window().maximize();
	
		System.out.println("Testcase3:Open autiomation by krishna webpage");
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(2000);
	
		System.out.println("Testcase4:Click on basic information");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
	
		System.out.println("Testcase5:Give user id ");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("Titikshagoel12@gmail.com");
	
		System.out.println("Testcase6:Give password ");
		driver.findElement(By.id("pwd")).sendKeys("Titikshagoel12@gmail.com");
	
		System.out.println("Testcase7:Click checkbox click me out ");
		driver.findElement(By.id("pwd")).sendKeys("Titikshagoel12@gmail.com");
		Thread.sleep(2000);
	
		System.out.println("Testcase8:Click submit ");
		driver.findElement(By.id("submitb2")).click();
		Thread.sleep(2000);
	
		System.out.println("Testcase9:Verify reject message ");
		Alert alert=driver.switchTo().alert();
		String expectedText="You successfully clicked on it";
		String actualText=alert.getText();
			if(expectedText.equals(actualText)) {
				System.out.println("Test case pass");}
			else {
				System.out.println("Test case fail");}
			
			System.out.println("Testcase10:Accept alert ");
			alert.accept();
		
		driver.close();
	}
	
}
	
	
	
	
	














