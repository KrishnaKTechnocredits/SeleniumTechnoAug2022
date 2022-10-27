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
11.Verify html page is loaded again.
*/

package akankshaVyas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1HTML {

	static String verifyingMethod(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			return "Pass";
		} else {
			return "Fail";
		}
	}

	void testCase() {
		System.out.println("STEP 1.Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP 2.Hit url(html page created)in browser.");
		driver.get("file:///C:/Users/asssssssssssssssssss/Desktop/videos-Java/project/FirstWebPageByAkanksha.html");
		driver.manage().window().maximize(); // window is maximize
		System.out.println("3.Verify application is loaded successfully.");
		System.out.println(verifyingMethod(driver, "Akanksha"));
		System.out.println("STEP 4.Step Enter First Name");
		WebElement element = driver.findElement(By.id("firstName"));
		element.sendKeys("Aaradhy");
		System.out.println("STEP 5.Enter Last Name");
		driver.findElement(By.id("lastName")).sendKeys("Ṁishra");
		System.out.println("STEP 6.Select gender radio button (at a time only one radio button should be selected)");
		driver.findElement(By.id("female")).click();
		System.out.println("STEP 7.Select Hobbies checkbox (user can select multiple checkboxes)");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h3")).click();
		System.out.println("STEP 8.Select value from branch dropdown.");
		WebElement e = driver.findElement(By.id("BId"));
		Select selectBranch = new Select(e);
		selectBranch.selectByVisibleText("CS");
		selectBranch.selectByValue("2");
		selectBranch.selectByIndex(1);
		System.out.println(
				" STEP 9.Click on Click here link should redirect to url configured (eg. https://www.google.com).");
		driver.findElement(By.id("URL")).click();
		System.out.println("STEP 10.Navigate back to the previous url");
		driver.navigate().back();
		System.out.println("11.Verify html page is loaded again.");
		System.out.println(verifyingMethod(driver, "Akanksha"));
		System.out.println("Close Window");
		driver.close();
	}

	public static void main(String[] args) {
		Assignment1HTML a = new Assignment1HTML();
		a.testCase();
	}
}
