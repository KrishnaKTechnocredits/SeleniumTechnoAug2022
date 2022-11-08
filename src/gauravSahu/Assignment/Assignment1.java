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
package gauravSahu.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\AUG 2022 CLASS\\Selenium2022\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");
		
		driver.get("file:///E:/AUG%202022%20CLASS/Html%20resources/Assignment_01_Gaurav.html");
		driver.manage().window().maximize();
		
		System.out.println("Step-2 : Enter Open Html Page in browser");
		
		String currentUrl = driver.getCurrentUrl();
		String mainpageUrl = "file:///E:/AUG%202022%20CLASS/Html%20resources/Assignment_01_Gaurav.html";
		if(mainpageUrl.equals(currentUrl)) {
			System.out.println("Step-3 : Verify Application is loaded successfully");
		}
		
		WebElement element = driver.findElement(By.id("firstname"));
		element.sendKeys("Gaurav");
		 
		element.clear();
		
		driver.findElement(By.id("firstname")).sendKeys("Gaurav");
		System.out.println("Step-4 : Enter First Name Entered");
		
		driver.findElement(By.id("lastname")).sendKeys("Sahu");
		System.out.println("Step-5 : Enter Last Name Entered");
		
		driver.findElement(By.id("male")).click();
		System.out.println("Step-6 : Enter  Radio button Selected");
		
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h4")).click();
		System.out.println("Step-7 : Enter 2 Hobbies checkbox Selected");
		
		WebElement element2 = driver.findElement(By.id("bId"));
		Select oselect = new Select(element2);
		oselect.selectByVisibleText("EE");
		System.out.println("Step-8 : Enter Branch Selected from DropDown");
		//oselect.selectByValue("4");
		oselect.selectByIndex(5);
		
		driver.findElement(By.id("clickID")).click();
		System.out.println("Step-9 : Enter Hyperlink redirected");
		
		driver.navigate().back();
		System.out.println("Step-10 : Verify Navigated Back to previous Page ");
		
		if(driver.getCurrentUrl().equals(currentUrl)) {
			System.out.println("Step-11 : Verify  html page is loaded again ");
		}
		
		driver.close();
	}

}
