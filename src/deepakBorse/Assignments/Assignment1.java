/*
Assignment No 1 : 
Test Cases: 
1.Launch Chrome browser
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

package deepakBorse.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import deepakBorse.base.PredefinedActions;

public class Assignment1 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = PredefinedActions.start("C:\\Users\\A717644\\OneDrive - Atos\\Desktop\\TechnoCredit\\SeleniumTechnoAug2022\\src\\deepakBorse\\pages\\FirstScript.html");
		System.out.println("Step 1-Verify - Application URL loaded");
		System.out.println("Step 2- Enter First Name");
		driver.findElement(By.id("firstname")).sendKeys("Deepak");

		System.out.println("Step 3- Enter Last Name");
		driver.findElement(By.id("lastname")).sendKeys("Borse");

		System.out.println("Step 4- Select Gender Radio button-male");
		driver.findElement(By.id("male")).click();

		System.out.println("Step 5- Select hobbies- Painting, Cooking and coding");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h3")).click();
		driver.findElement(By.id("h6")).click();

		System.out.println("Step 6- Select branch - CE");
		WebElement e = driver.findElement(By.id("bId"));
		Select sel = new Select(e);
		sel.selectByVisibleText("Computer Engineering");

		System.out.println("Step 7- Click on Click here URL");
		driver.findElement(By.id("clickId")).click();
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle))
			System.out.println("Step 8- Verify - Google Site loaded");

		driver.navigate().back();
		String expectedTitle1 = "First HTML Script";
		String actualTitle1 = driver.getTitle();
		if (expectedTitle1.equals(actualTitle1))
			System.out.println("Step 9- Verify - First HTML Script site reloaded");
		System.out.println("-End-");
		
		PredefinedActions.closeBrowser();
	}

}
