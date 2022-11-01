/*
Assignment No 1 : 23rd Oct 2022
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

package deepakPatil.assignment1FirstCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import deepakPatil.base.StartupActions;

public class LoginToOwnHTMLPage {
	
	static void verifyPageLoadedCorrectly(String PageTitle, String expectedTitle) {
		if(PageTitle.equals(expectedTitle))
			System.out.println("->Page correctly loaded");
		else
			System.out.println("->Correct page not loaded");
	}
	
	public static void main(String[] args) {
		
		WebDriver driver = StartupActions.launch("file:///C:/Users/DELL/Desktop/Sample%20Form.html");
		
		System.out.println("3.Verify application is loaded successfully.");
		String expectedTitle="TechnoCredits Sample HTML Page";
		String pageTitle=driver.getTitle();
		verifyPageLoadedCorrectly(pageTitle, expectedTitle);
		
		System.out.println("4.Enter First Name");
		driver.findElement(By.id("firstname")).sendKeys("Deepak");
		
		System.out.println("5.Enter Last Name");
		driver.findElement(By.id("lastname")).sendKeys("Patil");
		
		System.out.println("6.Select gender radio button");
		driver.findElement(By.id("Male")).click();
		
		System.out.println("7.Select Hobbies checkbox");
		driver.findElement(By.id("h4")).click();
		driver.findElement(By.id("h5")).click();
		
		System.out.println("8.Select value from branch dropdown.");
		WebElement e= driver.findElement(By.id("bID"));
		Select s = new Select(e);
		s.selectByIndex(3);
		s.selectByValue("3");
		s.selectByVisibleText("CS");
		
		System.out.println("9.Click on Click here link should redirect to url configured (eg. https://www.google.com).");
		driver.findElement(By.id("clickID")).click();
		expectedTitle="Google";
		pageTitle=driver.getTitle();
		verifyPageLoadedCorrectly(pageTitle, expectedTitle);
		
		System.out.println("10.Navigate back to the previous url.");
		driver.navigate().back();
		
		System.out.println("11.Verify html page is loaded again.");
		pageTitle=driver.getTitle();
		expectedTitle="TechnoCredits Sample HTML Page";
		verifyPageLoadedCorrectly(pageTitle, expectedTitle);
		
		driver.quit();
		
		System.out.println("\n***Test Succesfully Completed****");
	}

}
