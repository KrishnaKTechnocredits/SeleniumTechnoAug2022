package saroj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	
	static void verifyTitle(WebDriver driver, String expectedTitle) {
		System.out.println("Verify - application is loaded successfully");
		String actualTile = driver.getTitle();
		if(expectedTitle.equals(actualTile)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
	}

	public static void main(String[] args) {
		System.out.println("Step - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver",".//drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Step - Hit url");
		driver.get("file:///D:/Saroj/SeleniumTechnoAug2022/src/saroj/htmlFile/Assignment1.html");
		driver.manage().window().maximize();
		
		System.out.println("Step - Enter First Name: ");
		driver.findElement(By.id("firstname")).sendKeys("Saroj");
		System.out.println("Step - Enter Last Name: ");
		driver.findElement(By.id("lastname")).sendKeys("Kumari");
		System.out.println("Step - Select Gender: ");
		driver.findElement(By.id("female")).click();
		System.out.println("Step - Select Hobbies: ");
		driver.findElement(By.id("h3")).click();
		driver.findElement(By.id("h1")).click();
		
		System.out.println("Step - Select value from branch dropdown");
		WebElement e = driver.findElement(By.id("b1"));
		Select optselect = new Select(e);
		optselect.selectByVisibleText("CS");
		System.out.println("Step - Click on Click here link ");
		driver.findElement(By.id("clicklink")).click();
		System.out.println("Step - Navigate back to the previous url");
		driver.navigate().back();
		System.out.println("Verify - html page is loaded again");
		verifyTitle(driver, "Login Page");
		driver.close();
		
	}
}
