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

package apurvaBabel.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1_html {

	static void verifyTitle(String expectedTitle , WebDriver driver) {
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Step1: Launch browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Step2: Hit url in browser");
		driver.get("//E:/Apurva/Automation%20Aug22/SeleniumTechnoAug2022/src/apurvaBabel/Pages/DemoPage.html");
		driver.manage().window().maximize();
		
		System.out.println("Verify : Application loaded successfully");
		verifyTitle("Apurva's Demo Webpage",driver);
		
		System.out.println("Step3: Enter details");
		driver.findElement(By.id("firstname")).sendKeys("Apurva");
		driver.findElement(By.id("lastname")).sendKeys("Babel");
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h6")).click();
		WebElement element = driver.findElement(By.id("bId"));
		Select select = new Select(element);
		select.selectByValue("1");
		
		System.out.println("Step4: Redirect to another url by clicking click here link");
		driver.findElement(By.id("clickId")).click();
		
		System.out.println("Verify : Redirected to correct url");
		verifyTitle("Google", driver);
		
		System.out.println("Step5: Navigate back to previous url");
		driver.navigate().back();
		
		System.out.println("Verify: Previous page loaded again");
		verifyTitle("Apurva's Demo Webpage",driver);
	}
}
