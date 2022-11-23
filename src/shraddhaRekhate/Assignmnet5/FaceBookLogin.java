package shraddhaRekhate.Assignmnet5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shraddhaRekhate.PredifinedActions;
import shraddhaRekhate.propertyFIleReading.PropertiesFileReader;

public class FaceBookLogin {
	
	WebDriver driver;
	PropertiesFileReader p=new PropertiesFileReader("src/shraddhaRekhate/Assignmnet5/facebooklogin.properties");
	  
	@BeforeMethod
	public void launchBrowser(){
		System.out.println("Navigate to url https://www.facebook.com/");
		driver=PredifinedActions.start("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void faceBookInfo() {
		
		System.out.println(" Click on Ceate new account");
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[@role='button']")).click();
		System.out.println(" Enter fname");
		WebElement e=driver.findElement(By.xpath("//input[@name='firstname'][@placeholder='First name']"));
		e.sendKeys(p.getValue("FirstName"));
		System.out.println("Enter lname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(p.getValue("Surname"));
		System.out.println("Enter mob no");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(p.getValue("Mobile"));
		System.out.println("Enter pwd");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(p.getValue("password"));
		
		System.out.println("Select date month and year");
		WebElement droDownDate=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select date=new Select(droDownDate);
		date.selectByVisibleText("1");
		WebElement droDownMon=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select mon=new Select(droDownMon);
		mon.selectByVisibleText("Nov");
		WebElement droDownYear=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select year=new Select(droDownYear);
		year.selectByVisibleText("1998");
		System.out.println("ENter Gender");
		driver.findElement(By.xpath("//input[@type='radio'][@name='sex']")).click();
		System.out.println("Click on Sign Up button");
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	}
}
