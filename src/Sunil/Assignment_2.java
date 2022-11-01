/* Test Case: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.
 
		1. Launch chrome browser
		2. Hit url(http://automationbykrishna.com/)in browser.
		3. Click on basic element tab
		4. Enter Email address
		5. Enter password
		6. Click on the submit button
		7. Validate that "You successfully clicked on it" message is displayed
		8. Accept the alert
 */

package Sunil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("TC1:- Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("TC2:- Hit URL");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("TC3:- Enter Email Address");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("holambe.sunil26@gmail.com");
		//driver.findElement(By.name("emailId")).sendKeys("holambe.sunil26@gmail.com");
		//driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("holambe.sunil26@gmail.com");
		
		System.out.println("TC4:- Enter Password");
		driver.findElement(By.id("pwd")).sendKeys("Sunil@1992");
		
		System.out.println("TC5:- Click On The Submit Button");
		driver.findElement(By.id("submitb2")).click();
		Thread.sleep(5000);
		String expectedMsg = "You Successfully Clicked On It";
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		
		System.out.println("TC6:- Validate Message");
		if (expectedMsg.equals(actualMsg)) {
			System.out.println("Actual And Expected Alert Message Is Not Matching");
		} else {
			System.out.println("Actual And Expected Alert Message Is Matching");
		}
		alert.accept();
		driver.close();
	}
}