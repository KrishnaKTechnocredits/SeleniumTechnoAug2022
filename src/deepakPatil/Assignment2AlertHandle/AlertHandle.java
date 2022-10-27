/*Assignment No 2 : 27th Oct 2022

Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert
 */

package deepakPatil.Assignment2AlertHandle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("testemail@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("Password");
		
		//used xpath to find element
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		
		//switch to alert to handle alert. driver.switchTo().alert() returns object captured in Alert interface
		Alert alert= driver.switchTo().alert();
		
		//getText method captures text from popup
		String alertMsg=alert.getText();
		String expectedMsg="You successfully clicked on it";
		System.out.println("Alert popup message is: "+expectedMsg);
		alert.accept();
		if(alertMsg.equals(expectedMsg))
			System.out.println("Test is passed");
		else
			System.out.println("Test is failed");
		
		driver.quit();
			
	}
}
