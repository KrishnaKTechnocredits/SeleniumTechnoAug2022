/*
 * Assignment No 1 : 
Test Cases: 
1.Launch chrome browser
2.Hit url(html page created)in browser.
3.Verify application is loaded successfully.
4.Enter First Name
5.Enter Last Name
6.Select gender radio button (at a time only one radio button should be selected)
7.Select Hobbies checkbox (user can select multiple checkboxes)
8.Select value from branch dropdown.
9.Click on Click here link should redirect to url configured (eg. https://www.google.com).
10.Navigate back to the previous url.
11.Verify html page is loaded again.
 */
package SwatiM.seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import SwatiM.base.PredefinedActions;

public class Assignment1 {

	static void verifyTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();

		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass");
		else
				System.out.println("Fail");
	}

	public static void main(String[] args) {
		
		WebDriver driver =PredefinedActions.start("D:\\AutomationTesting\\AUG22\\SeleniumTechnoAug2022\\src\\SwatiM\\pages\\FirstScript.html");

		System.out.println("VERIFY - application is loaded successfully.");
		verifyTitle(driver, "First HTML Script");

		System.out.println("STEP - Enter Firstname");
		driver.findElement(By.id("firstname")).sendKeys("Swati");

		System.out.println("STEP - Enter Lastname");
		driver.findElement(By.id("lastname")).sendKeys("Mohite");

		System.out.println("STEP - Select Gender");
		driver.findElement(By.id("female")).click();

		System.out.println("STEP - Select Hobbies");
		driver.findElement(By.id("h4")).click();
		driver.findElement(By.id("h6")).click();

		
		System.out.println("STEP - Select Branch");
		WebElement e = driver.findElement(By.id("bId")); //Option 1 to select text from dropdown
		Select oselect = new Select(e);
		oselect.selectByVisibleText("Information Technology"); //Option 2 to select text from dropdown
		//oselect.selectByValue("2"); //Option 3 to select text from dropdown
		//oselect.selectByIndex(1); //Option 4 to select text from dropdown 

		System.out.println("STEP - Click on link");
		driver.findElement(By.id("clickId")).click();
		System.out.println("VERIFY - Google is loaded");
		verifyTitle(driver, "Google");

		System.out.println("STEP - Navigate back to previous url : First HTML Script");
		driver.navigate().back();
		System.out.println("VERIFY - application is loaded successfully");
		verifyTitle(driver, "First HTML Script");

        System.out.println("Cleanup - Close Browser");
	    PredefinedActions.closeBrowser();
	 //   System.out.println("Testing stash ");
	}
	

}
