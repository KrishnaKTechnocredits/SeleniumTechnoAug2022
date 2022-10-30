//Assignment 1: 26-Oct-2022

package komalShrivastava.testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import komalShrivastava.base.*;

public class TestCase1 {

	public static void main(String[] args) {
		System.out.println("STEP: Launch Chrome browser and load URL");
		WebDriver driver = PredefinedActions.start("file:///C:/Java-Selenium-Sessions/Info_Form.html");
		
		System.out.println("STEP - Verify Title");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Komal Application";
		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass - Title is correct");
		else
			System.out.println("Fail - Title is incorrect");
		
		System.out.println("STEP - Enter Firstname");
		driver.findElement(By.id("1")).sendKeys("Komal");
		
		System.out.println("STEP - Enter Lastname");
		driver.findElement(By.name("lastname")).sendKeys("Shrivastava");
		
		System.out.println("STEP - Select Gender");
		driver.findElement(By.id("4")).click();
		
		System.out.println("STEP - Select Skills");
		driver.findElement(By.id("5")).click();
		driver.findElement(By.id("7")).click();
		
		System.out.println("STEP - Select Hobbies");
		WebElement e = driver.findElement(By.id("8"));
		Select select = new Select(e);
		select.selectByVisibleText("Reading");
		
		System.out.println("STEP - Click on Link");
		driver.findElement(By.id("555")).click();
		driver.navigate().back();
		
		System.out.println("STEP - Verify the reloaded page");
		actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass - Title is correct");
		else
			System.out.println("Fail - Title is incorrect");
	}
}