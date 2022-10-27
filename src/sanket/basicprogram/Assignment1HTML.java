package sanket.basicprogram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sanket.base.PredefinedActions;

public class Assignment1HTML {

	public static void main(String[] args) {

		System.out.println("STEP 1 - Launch chrome browser.");
		WebDriver driver = PredefinedActions
				.start("file:///D:/TechnoCredits/August2022/SeleniumTechnoAug2022/src/sanket/base/MyFirstSite.html");
		System.out.println("STEP 2 - Hit url(html page created)in browser.");

		System.out.println("STEP 3- Verify Application is loaded successfully.");
		String expectedTitle = "My First Site";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle))
			System.out.println("Pass - Page loaded Suceessfully.");
		else
			System.out.println("Fail - Page not loaded.");

		System.out.println("STEP 4 - Enter First Name.");
		WebElement element = driver.findElement(By.id("firstname"));
		element.sendKeys("Steve");

		System.out.println("STEP 5 - Enter Last Name.");
		WebElement element2 = driver.findElement(By.id("lastname"));
		element2.sendKeys("Barnett");

		System.out.println("STEP 6 - Select gender radio button (at a time only one radio button should be selected).");
		driver.findElement(By.id("male")).click();

		System.out.println("STEP 7 - Select Hobbies checkbox (user can select multiple checkboxes).");
		driver.findElement(By.id("h3")).click();
		driver.findElement(By.id("h6")).click();

		System.out.println("STEP 8 - Select value from branch dropdown.");
		WebElement e = driver.findElement(By.id("bId"));
		Select branchSelect = new Select(e);
		branchSelect.selectByVisibleText("ENTC");

		System.out.println(
				"STEP 9 - Click on Click here link should redirect to url configured (eg. https://www.google.com)");
		driver.findElement(By.id("clickId")).click();

		System.out.println("STEP 10 - Verify that desired site is opened");
		String expectedTitle2 = "Google";
		String actualTitle2 = driver.getTitle();

		if (expectedTitle2.equals(actualTitle2))
			System.out.println("Pass - Google loaded Suceessfully.");
		else
			System.out.println("Fail - Page not loaded.");

		System.out.println("STEP 11 - Navigate back to the previous url.");
		driver.navigate().back();

		System.out.println("STEP 12 - Verify html page is loaded again.");
		String expectedTitle3 = "My First Site";
		String actualTitle3 = driver.getTitle();

		if (expectedTitle3.equals(actualTitle3))
			System.out.println("Pass - Page loaded Suceessfully.");
		else
			System.out.println("Fail - Page not loaded.");
	}
}
