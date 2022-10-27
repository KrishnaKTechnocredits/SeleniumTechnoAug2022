/**********Assignment No 1 : 
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
************/
package AMohini.Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AMohini.CommonActions.*;

public class HTMLFormAssignment1 {

	public static void main(String[] args) {

		System.out.println("STEP - Launch Chrome browser & load URL");
		WebDriver driver = PredefinedActions
				.start("file:///C:/Users/mohin/JAVACourse/SeleniumTechnoAug2022/src/AMohini/HTML/MyFirst.html");
		driver.findElement(By.id("firstname")).sendKeys("Mohini");
		driver.findElement(By.id("lastnamename")).sendKeys("Agarwal");

		driver.findElement(By.id("female")).click();

		driver.findElement(By.id("h3")).click();
		driver.findElement(By.id("h4")).click();

		WebElement e = driver.findElement(By.id("bId"));
		Select select1 = new Select(e);

		select1.selectByVisibleText("IT");

	}

}
