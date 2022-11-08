package Chirag;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {

	public static void main (String[] args) throws InterruptedException {
		System.out.println("STep:-1 launch browser and click url");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver=new ChromeDriver();
		 driver.get("http://automationbykrishna.com/");
		
		System.out.println("STep:-2 Click on basic element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		Thread.sleep(3000);
		
		System.out.println(" Get alert button basic form");
		WebElement element=driver.findElement(By.id("javascriptAlert"));
		
		System.out.println("Step:-3 Scroll till alert button basic form");
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Step:-3 Scroll till alert button basic form");
		
		System.out.println("STep:-4 Clicking on alert Button to generating simple Alert");
		driver.findElement(By.id("javascriptAlert")).click();
		
		System.out.println("Step:-5 Verify alert message");
		Alert alert=driver.switchTo().alert();
		
		Thread.sleep(2000);
		
	    String actualAlert=alert.getText();
		String expectedAlert="You must be TechnoCredits student!!";
		if(expectedAlert.equals(actualAlert)){
			System.out.println("Test cases for basic alert:- pass");
		}else{
			System.out.println("Test cases for basic alert:- fail");
		}
		alert.accept();
		System.out.println("alert is accepted");
		System.out.println("......");
		
		
		System.out.println("STep:-6 Click on basic element tab");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert2=driver.switchTo().alert();
		alert2.accept();
		
		String actualMessage1=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedMessage1=("You pressed OK!");
		if(expectedMessage1.equals(actualMessage1)){
			System.out.println("Test cases for  javascript Confirmation alert:- pass");
		}else{ 
			System.out.println("Test cases for javascript Confirmation alert:- fail");
		}
		System.out.println("alert is accepted");
		
		System.out.println("-----");
		System.out.println("Step:-7 Click on javaScriptPromp button ");
		driver.findElement(By.id("javascriptPromp")).click();
		Alert alert3=driver.switchTo().alert();
		System.out.println("Click on javaScriptPromp");
		alert3.sendKeys("Chirag");
		alert3.accept();
		String expectedMessage2=("Hello Chirag! How are you today?");
		String actualMessage2=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(expectedMessage2.equals(actualMessage2)){
			System.out.println("Test cases for javascript prompt alert:- pass");
		}else{
			System.out.println("Test cases for javascript prompt alert:- fail");
		}
		
	}
	
}
