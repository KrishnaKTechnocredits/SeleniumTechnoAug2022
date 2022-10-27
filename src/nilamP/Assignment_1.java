/*
Assignment No 1 : 
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

package nilamP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_1 {
	public static void main(String[] args) {

		Assignment_1 a = new Assignment_1();
		//WebDriver driver = a.start("https://www.google.com/");
		WebDriver driver =
		 a.start("C:\\Users\\lenovo\\Desktop\\Selenium\\Selenium_Automations\\SeleniumTechnoAug2022\\src\\nilamP\\form.html");

		// System.out.println(" Browser is Launched");
		System.out.println("Title : " + driver.getTitle());
		System.out.println("Url of the website :" + driver.getCurrentUrl());
		driver.manage().window().maximize();

		System.out.println("STEP - 2 - Validated Title ");
		a.validateTitle();
		System.out.println("STEP - 3 - Enter Details ");
		driver.findElement(By.id("firstname")).sendKeys("Nilam");
		driver.findElement(By.id("lastname")).sendKeys("Patel");
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h4")).click();
		WebElement e = driver.findElement(By.id("bid"));
		Select s = new Select(e);
		s.selectByIndex(2);
		System.out.println("STEP - 4 -Click Link ");
		driver.findElement(By.id("clickid")).click();
		System.out.println("STEP - 5 - Navigated Back to Form ");
		driver.navigate().back();

		System.out.println("STEP - 6 - Validated Title ");
		a.validateTitle();
	}

	void validateTitle() {
		String ActualTitle = "Assignment1 Nilam";
		String ExpectedTitle = "Assignment1 Nilam";
		if (ActualTitle.equals(ExpectedTitle)) {
			System.out.println("Title Matched " + "\n" + "Validation is Passed");
		} else
			System.out.println("Incorrect Title" + "\n" + "Validation is Failed ");
	}

	final static public WebDriver start(String url) {

		System.out.println("STEP- 1 - Launch Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		return driver;
	}
}
