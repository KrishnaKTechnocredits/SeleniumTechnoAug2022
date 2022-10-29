//Testcase1-Call chrome drive
//TC-2:call automationbykrishna webpage
//TC-3:press button basic elelment
//Tc-4: press javavscript prompt button
//Tc-5: add name in alert window
//Tc-6: accept alert
//Tc-7:validate message
//Tc-8:Reclick javaprompt button
//Tc-9: recall alert window
//Tc-10:this time give value then cancel it
//Tc-11:validate message

package Titiksha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3_C {
	public static void main(String[] args) throws Exception{
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("Testcase-1:Call chrome driver");
	
	driver.get("http://automationbykrishna.com/#");
	System.out.println("Testcase-2:Call automationbykrishna webpage");
	
	driver.findElement(By.id("basicelements")).click();
	Thread.sleep(2000);
	System.out.println("Testcase-3:Press basic elelment button ");
	
	driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
	System.out.println("Testcase-4:Press javavscript prompt button");
	
	Alert alert=driver.switchTo().alert();
	
	String name="titiksha";
	alert.sendKeys(name);
	System.out.println("Testcase-5: Add name in alert window");
	
	Thread.sleep(2000);
	alert.accept();
	System.out.println("Testcase-6:Accept alert");
	
	String message=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
	System.out.println("Testcase-7:Validate message");
		if(message.contains(name)) {
			System.out.println("pass");}
		else {	
			System.out.println("Fail");}
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("Testcase-8: Reclick javaprompt button");
		
		Alert alt=driver.switchTo().alert();
		System.out.println("Testcase-9:Recall alert window");
		
		alt.dismiss();
		Thread.sleep(1000);
		System.out.println("Testcase-11:Validate message");
		
		System.out.println("Testcase-10:This time give value then cancel it");
		String expectedText="User cancelled the prompt.";
		String actualText=driver.findElement(By.id("pgraphdemo")).getText();
		if(expectedText.equals(actualText)) {
			System.out.println("pass");}
		else {
			System.out.println("Fail");}
		
		driver.close();
		driver.quit();
		}
	
	}
	
