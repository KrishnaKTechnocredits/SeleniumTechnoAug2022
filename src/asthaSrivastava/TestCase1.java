/*Assignment No 1 : 
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
11.Verify html page is loaded again.*/
package asthaSrivastava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase1 {

	public static void main(String[] args) {
		System.out.println("STEP 1 - Launch Chrome Browser");
		WebDriver driver = PredefinedActions.start("file:///E:/Java2022/Assignments/Selenium/FirstHtmlPage.html");

		System.out.println("VERIFY - Application Loaded Successfully");
		String expectedTitle = "Registration Form";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		System.out.println("STEP 2 - Enter First Name and Last Name");
		WebElement element = driver.findElement(By.id("firstname"));
		element.sendKeys("Astha");

		driver.findElement(By.id("lasttname")).sendKeys("Srivastava");

		System.out.println("STEP 3 - Select Gender");
		driver.findElement(By.id("female")).click();

		System.out.println("STEP 4 - Select Hobbies");
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h3")).click();

		System.out.println("STEP 5 - Select Branch Dropdown");
		WebElement element2 = driver.findElement(By.id("bId"));
		Select branchSelect = new Select(element2);
		branchSelect.selectByVisibleText("Electronics(Honours)");
		// branchSelect.selectByValue("1");
		// branchSelect.selectByIndex("2");

		System.out.println("STEP 6 - Click here ");
		driver.get("https://www.google.com");
		System.out.println("VERIFY - Google URL is loaded");

		System.out.println("STEP 7 - Navigate to previous URL");
		driver.navigate().back();

		System.out.println("VERIFY - HTML page got loaded");
		String expectedUrl = "file:///E:/Java2022/Assignments/Selenium/FirstHtmlPage.html";
		String actualUrl = driver.getCurrentUrl();
		if (expectedUrl.equals(actualUrl))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		//driver.close();
	}
}
