package Shruti; 
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
		public static void main(String[] args) {
		System.out.println(" Step -1 : Launch ChromeBrowser" );
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		String url = "file:///D:/Java%20Selenium%20Course/Selenium_Aug22/src/Resources/Shruti_first_htmlPage.html";
		System.out.println(" Step -2 : hit Url ");
		driver.get(url);
		
		System.out.println(" Step - 3 : Verify application is loaded sucessfully: ");
		String expectedTitle = "Shruti first html page";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
			System.out.println("pass: Application loaded SuccessFully");
		else 
			System.out.println(" Fail");
		
		System.out.println(" Step - 4: Enter First Name");
	    driver.findElement(By.id("fname")).sendKeys("Shruti");
	    System.out.println(" Step - 5: Enter Last name");
	    driver.findElement(By.id("lname")).sendKeys("Arora");
	    System.out.println(" Step - 6 : Select gender only one at a time ");
	    driver.findElement(By.id("female")).click();
	    System.out.println(" Step - 7 : Select hobbies checkBox only 2 you have to select");
	    driver.findElement(By.id("1")).click();
	    driver.findElement(By.id("5")).click();
	    System.out.println(" Step - 8 : Select value from branch dropdown");
	    WebElement e = driver.findElement(By.id("bId"));
	    Select branchSelect = new Select(e);
	    branchSelect.selectByVisibleText("CS");
	    System.out.println(" Step -9 : Click on Click here link should redirect to url configured (eg. https://www.google.com). ");
	    driver.findElement(By.id("clickId")).click();
	    System.out.println(" Step - 10 : Navigate back to the previous url " );
	    driver.navigate().back();
	    System.out.println(" Step - 11 : Verify html page is loaded again.");
	    if(actualTitle.equals(expectedTitle))
			System.out.println("pass: html page is loaded SuccessFully");
		else 
			System.out.println(" Fail");
		}
	}