//Assignment - 5 : 30th OCt'2022

package komalShrivastava.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import komalShrivastava.base.PredefinedActions;
import komalShrivastava.utility.PropertyFileReader;

public class FacebookSignupPage {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("https://www.facebook.com");
		
		System.out.println("STEP : Click on Create New Account button");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
	
		PropertyFileReader prop = new PropertyFileReader();
		System.out.println("STEP : Enter value in FirstName field");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(prop.getPropertyValue("firstname"));
		
		System.out.println("STEP : Enter value in Surname field");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getPropertyValue("surname"));
		
		
		System.out.println("STEP : Enter value in Email field");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(prop.getPropertyValue("email"));
		
		System.out.println("STEP : Enter value in Password field");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(prop.getPropertyValue("password"));
		
		System.out.println("STEP : Select Date Of Birth");
		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select daySelect = new Select(day);
		daySelect.selectByVisibleText(prop.getPropertyValue("date"));
		
		System.out.println("STEP : Select Month Of Birth");
		WebElement month = driver.findElement(By.name("birthday_month"));
		Select monthSelect = new Select(month);
		monthSelect.selectByVisibleText(prop.getPropertyValue("month"));
		
		System.out.println("STEP : Select Year Of Birth");
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select yearSelect = new Select(year);
		yearSelect.selectByVisibleText(prop.getPropertyValue("year"));
		
		System.out.println("STEP : Select Gender");
		String gender = prop.getPropertyValue("gender");
		if(gender.equals("female"))
			driver.findElement(By.xpath("//input[@type='radio'][@value='1']")).click();
		else if(gender.equals("male"))
			driver.findElement(By.xpath("//input[@type='radio'][@value='2']")).click();
		else
			driver.findElement(By.xpath("//input[@type='radio'][@value='3']")).click();
	}
}