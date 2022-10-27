package harshalRane.seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	static void verifyTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass");
		else
				System.out.println("Fail");
	}
	
	public static void main(String[] args) {
		WebDriver driver = harshalRane.base.PredefinedActions.start("D:/H/Testing_Courses/TechnoCredits_Java_Selenium/Projects/AUG22/SeleniumTechnoAug2022/src/harshalRane/pages/Page1.html");
		
		System.out.println("VERIFY - Harshal Rane Website is loaded");
		verifyTitle(driver, "Harshal Rane Website");
		
		System.out.println("STEP: Enter Firstname");
		driver.findElement(By.id("firstname")).sendKeys("Harshal");
		
		System.out.println("STEP: Enter Lastname");
		driver.findElement(By.id("lastname")).sendKeys("Rane");
		
		System.out.println("STEP: Select Gender");
		driver.findElement(By.id("female")).click();
		
		System.out.println("STEP: Select Hobbies");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h6")).click();
		
		System.out.println("STEP: Select College Branch Firstname");
		driver.findElement(By.id("h7")).click();
		driver.findElement(By.id("h12")).click();
		
		System.out.println("STEP: Select Branch");
		WebElement e = driver.findElement(By.id("bId")); //Option 1 to select text from dropdown
		Select oselect = new Select(e);
		oselect.selectByVisibleText("Information Technology"); //Option 2 to select text from dropdown
		//oselect.selectByValue("2"); //Option 3 to select text from dropdown
		//oselect.selectByIndex(1); //Option 4 to select text from dropdown 
		
		System.out.println("STEP: Click on link");
		driver.findElement(By.id("clickId")).click();
		System.out.println("VERIFY - Google is loaded");
		verifyTitle(driver, "Google");
		
		System.out.println("STEP: Navigate back to previous url : Harshal Rane Website");
		driver.navigate().back();
		System.out.println("VERIFY - Harshal Rane Website is loaded");
		verifyTitle(driver, "Harshal Rane Website");
		
//		System.out.println("Cleanup - Close Browser");
//		PredefinedActions.closeBrowser();
	}
}
