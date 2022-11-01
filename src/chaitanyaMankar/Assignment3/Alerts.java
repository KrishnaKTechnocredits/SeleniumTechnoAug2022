/*Assignment - 3 : 28th Oct'2022
Verifiy Alert functionality on automationbykrishna application.*/

package chaitanyaMankar.Assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts 
{
	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("javascriptAlert")).click();
		
		String expectedText = "You must be TechnoCredits student!!";
		
		Alert alert = driver.switchTo().alert();
		
		String actualText = alert.getText();
		
		if(expectedText.equals(actualText))
			System.out.println("Alert-Pass");
		else
			System.out.println("Alert-Fail");
		
		alert.accept();
		Thread.sleep(1000);
		//-------------------------------------------------
		driver.findElement(By.id("javascriptConfirmBox")).click();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		expectedText = "You pressed OK!";
		
		actualText = driver.findElement(By.id("pgraphdemo")).getText();
		
		if(expectedText.equals(actualText))
			System.out.println("Javascript Confirmation Ok-Pass");
		else
			System.out.println("Javascript Confirmation Ok-Fail");
		
		//-----------------------------------------------------------------------
		driver.findElement(By.id("javascriptConfirmBox")).click();
		
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		expectedText = "You pressed Cancel!";
		
		actualText = driver.findElement(By.id("pgraphdemo")).getText();
		
		if(expectedText.equals(actualText))
			System.out.println("Javascript Confirmation Cancel-Pass");
		else
			System.out.println("Javascript Confirmation Cancel-Fail");
		//-----------------------------------------------------------------------
		
		driver.findElement(By.id("javascriptPromp")).click();
		
		Alert alert3 = driver.switchTo().alert();
		
		String name = "Chaitanya";
		alert3.sendKeys(name);
		alert.accept();
		actualText = driver.findElement(By.id("pgraphdemo")).getText(); 
		
		if(actualText.contains(name))
			System.out.println("Javascript Promt-Pass");
		else
			System.out.println("Javascript Promt-Fail");
		
		driver.close();
		
	}

}
