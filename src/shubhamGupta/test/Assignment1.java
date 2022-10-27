package shubhamGupta.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import shubhamGupta.base.PredefinedActions;

/*Assignment No 1 : 23/10/2022
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
public class Assignment1 {
	public static void main(String[] args) {

		System.out.println("Step 1: Launch Chrome Browser and open URL");
		WebDriver driver = PredefinedActions.start("file:///C:/personal/Selenium%20Assignment/Assignment1.html");

		System.out.println("Step 2: Verify if page is loaded successfully or not");
		String actualTitle = driver.getTitle();
		if (actualTitle.equals("Technocredits")) {
			System.out.println("Page Loaded successfully");
		} else {
			System.out.println("Page not Loaded");
		}

		System.out.println("Step 3: Enter first name");
		driver.findElement(By.id("firstName")).sendKeys("Shubham");

		System.out.println("Step 4: Enter last name");
		driver.findElement(By.id("lastName")).sendKeys("Gupta");

		System.out.println("Step 5: Select Gender");
		driver.findElement(By.id("male")).click();

		System.out.println("Step 6: Select Hobbies");
		driver.findElement(By.id("h3")).click();
		driver.findElement(By.id("h6")).click();

		System.out.println("Step 7: Select Branch from dropdown");
		WebElement element = driver.findElement(By.id("bId"));
		Select branch = new Select(element);
		branch.selectByVisibleText("EC");

		System.out.println("Step 8: Click on hyperlink");
		driver.findElement(By.id("clickId")).click();

		System.out.println("Step 9: verify that user is navigate to url - https://www.google.com/");
		String ActualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.google.com/";
		if (ActualUrl.equals(expectedUrl)) {
			System.out.println("User is redirected to correct URL");

		} else {
			System.out.println("User is navigated to incorrect url which is : " + ActualUrl);
		}

		System.out.println("Step 10: Navigate back to previous URL");
		driver.navigate().back();

		System.out.println("Step 11: Verify HTML page is loaded again");
		if (actualTitle.equals("Technocredits")) {
			System.out.println("Page Loaded successfully again");
		} else {
			System.out.println("Page not Loaded");
		}

		driver.close();
		System.out.println("Test case executed successfully");
	}

}
