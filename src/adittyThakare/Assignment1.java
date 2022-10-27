package adittyThakare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("C:\\Aditty\\Techno\\Login.html");
		System.out.println("Verify - Application URL loaded");
		System.out.println("Step - Enter First Name");
		driver.findElement(By.id("firstname")).sendKeys("Aditty");
		
		System.out.println("Step - Enter Last Name");
		driver.findElement(By.id("lastname")).sendKeys("Thakare");
		
		System.out.println("Step - Select Gender Radio button");
		driver.findElement(By.id("female")).click();
		
		System.out.println("Step - Select hobbies");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h5")).click();
		
		System.out.println("Step - Select branch");
		WebElement e = driver.findElement(By.id("branchId"));
		Select sel = new Select(e);
		sel.selectByVisibleText("IT");
		
		System.out.println("Step - Click on URL");
		driver.findElement(By.partialLinkText("Click Here")).click();
		String expectedTitle="Google";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle))
			System.out.println("Verify - Google Site loaded");
		
		driver.navigate().back();
		String expectedTitle1="Aditty";
		String actualTitle1 = driver.getTitle();
		if(expectedTitle1.equals(actualTitle1))
			System.out.println("Verify - Aditty site reloaded");
		
	}
}
