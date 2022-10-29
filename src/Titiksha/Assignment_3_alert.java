//Open chrome browser
//Open automationbykrishna webpage
//go to basicelemnet button
//press on alert button 
//validate alert message



package Titiksha;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3_alert {
	public static void main(String[] args) throws Exception {
		System.out.println("Testcase1:Open chrome browser");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		System.out.println("Testcase2:Open automationbykrishna webpage");
		
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		System.out.println("Testcase3:Open automationbykrishna webpage");
		
	
		driver.findElement(By.id("javascriptAlert")).click();
		Thread.sleep(1000);
		System.out.println("Testcase5:Press on alert button");
		
		System.out.println("Testcase6:Validate alert message");
		Alert alert=driver.switchTo().alert();
		String expectedText="You must be TechnoCredits student!!";
		String actualText=alert.getText();
		if(expectedText.equals(actualText)) {
			System.out.println("Test case pass");}
			else {
				System.out.println("Test case fail");}
		
		driver.close();
			
				
		}
}
		
		
	