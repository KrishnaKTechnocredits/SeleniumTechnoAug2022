package Titiksha;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3_b_alert {
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
		
		System.out.println("Testcase4:Click on java confirmation");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert=driver.switchTo().alert();
		
		String expectedText="Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualText=alert.getText();
		if(expectedText.equals(actualText)) {
			System.out.println("Test case pass");}
		else {
				System.out.println("Test case fail");}
		
		alert.accept();
		
		String expectedText1="You pressed OK!";
		System.out.println(expectedText1);
		String actualText1=driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(actualText1);
		if(expectedText1.equals(actualText1)) {
			System.out.println("Test case pass");}
			else {
				System.out.println("Test case fail");}
	}
}