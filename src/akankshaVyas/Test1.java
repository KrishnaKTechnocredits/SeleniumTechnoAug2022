/*
 *  Test Case2B: To Handle Alert & Validate that "You successfully clicked on it" message is getting display in the alert.
 *  1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on basic element tab
4. Enter Email address
5. Enter password
6. Click on the submit button
7. Validate that "You successfully clicked on it" message is displayed
8. Accept the alert
 */

package akankshaVyas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	
	void testCase2A() throws InterruptedException{
		System.out.println("STEP 1 - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("STEP 2 - Hit url");
		driver.findElement(By.id("basicelements")).click();
		String fName="Akanksha";
		String lName="Vyas";
		String companyName="DXC";
		Thread.sleep(2000);
		System.out.println("STEP 3 - Enter required filed fname,lastname and company name");
		driver.findElement(By.id("UserFirstName")).sendKeys(fName);
		driver.findElement(By.id("UserLastName")).sendKeys(lName);
		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
		System.out.println("STEP 4-Click on the submit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		System.out.println("STEP 5-Validate message");
		Alert alert = driver.switchTo().alert();
		String expectedAlertMsg=fName+" and "+lName+" and "+companyName;
		String actualAlertMsg=alert.getText();
		if(expectedAlertMsg.equals(actualAlertMsg))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.dismiss();// if single alert msg then accept and dismiss both work same
		driver.quit();
	}
	
	void testCase2B() throws InterruptedException{
		System.out.println("STEP 1 - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize(); // Maximize window
		System.out.println("STEP 2 - Hit url");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP 3-Enter Email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("akanksha@gmail.com");
		System.out.println("STEP 4-Enter password");
		driver.findElement(By.id("pwd")).sendKeys("123456");
		System.out.println("STEP 5-Click on the submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();	
		Alert alert = driver.switchTo().alert(); //Switch to alert popup
		Thread.sleep(2000); //wait time
		System.out.println("STEP 6-Validate message");
		String expectedAlertMsg="You successfully clicked on it";
		String actualAlertMsg=alert.getText(); 
		if(expectedAlertMsg.equals(actualAlertMsg))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.accept();// Accepting alert msg
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test1 test1=new Test1();
		test1.testCase2A();
		System.out.println("==============Test case 2B===================");
		test1.testCase2B();
	}
}
