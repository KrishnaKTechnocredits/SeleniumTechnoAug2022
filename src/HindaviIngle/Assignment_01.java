package HindaviIngle;


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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Step 1: Launch Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/TechnoCredit/selenuim/FirstProgram.html#section1");
		driver.manage().window().maximize();
		System.out.println("Step 2: Validate page loaded successfully or not");
		String expectedTitle = "Welcome to the page!";
		String ActualTitle = driver.getTitle();
		if (expectedTitle.equals(ActualTitle)) {
			System.out.println("Page Title is mactching");
		} else {
			System.out.println("failed");
		}
		System.out.println("Step 3: Enter Details");

		driver.findElement(By.id("fname")).sendKeys("Hindavi");
		driver.findElement(By.id("lname")).sendKeys("Ingle");
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("h3")).click();
		driver.findElement(By.id("h1")).click();
		Select s1=new Select(driver.findElement(By.id("bid")));
		s1.selectByVisibleText("IT");
		System.out.println("Step 4: Click on link");
		driver.findElement(By.id("clicklink")).click();
		System.out.println("Step 5: Navigate back");
		driver.navigate().back();
		System.out.println("Step 6: Validate navigated successfully to prev page");
		 expectedTitle = "Welcome to the page!";
		 ActualTitle = driver.getTitle();
		if (expectedTitle.equals(ActualTitle)) {
			System.out.println("Page Title is mactching");
		} else {
			System.out.println("failed");
		}
		driver.close();

	}
	
	

}
