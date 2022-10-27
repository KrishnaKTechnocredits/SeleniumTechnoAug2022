package nehanig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		
		System.out.println("STEP-1: Launch chrome browser");
		System.out.println("Nehani's First WebSite is Launched");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		System.out.println("STEP-2: Hit url");
		driver.get("file:///C:/Twinkle/SeleniumAug22/Resources/FirstScript.html");
		String expectedTitle="Nehani's First WebSite";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Pass");}
			else {
				System.out.println("fail");
			}
		
		System.out.println("Application is loaded successfully");
		
		
		System.out.println("STEP-3: Enter First Name");
		driver.findElement(By.id("firstName")).sendKeys("Nehani");
		
		System.out.println("STEP-4: Enter Last Name");
		driver.findElement(By.id("lastName")).sendKeys("Gupta");
		
		System.out.println("Step-5: Select Gender Radio Button(one should be Selected)");
		driver.findElement(By.id("Female")).click();
		
		System.out.println("Step-6: Select Hobbies checkbox(multiple can be Selected)");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h5")).click();
		
		System.out.println("Step-7: Select value from Branch dropdown");
		WebElement e = driver.findElement(By.id("bId"));
		Select branchSelect = new Select(e);
		branchSelect.selectByValue("6");
		System.out.println("Branch selected successfully");
		
		System.out.println("Step-8: Click on given URL");
		driver.findElement(By.id("clickId")).click();
		System.out.println("VERIFY - Google is loaded");
		
		System.out.println("Step-9: Navigated Back to Form");
		driver.navigate().back();
		System.out.println("VERIFY - Nehani's First WebSite is loaded");
		
		System.out.println("Html page loaded sucessfully");
		
		
		
	}

}