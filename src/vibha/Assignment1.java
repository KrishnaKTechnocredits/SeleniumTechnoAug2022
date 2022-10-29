package vibha;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public  void processData() {
		System.out.println("Step 1 --> Launch crome browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("//D:/java/project/java%20student%20project/SeleniumTechnoAug2022/src/vibha/pages/DemoPage.html");
		
		System.out.println("step 2 --> Verify application is loaded");
		verifyTitle(driver,"Vibha's Demo Page");
		
		System.out.println(" Step 3 --> Enter First Name");
		driver.findElement(By.id("FirstName")).sendKeys("Vibha");
		
		System.out.println("Enter Last Name");
		driver.findElement(By.id("LastName")).sendKeys("Sawner");
		
		System.out.println("Select Gender");
		driver.findElement(By.id("female")).click();
		
		System.out.println("Select Hobbies");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h2")).click();
		
		System.out.println("Select Branch");
		WebElement e=driver.findElement(By.id("BID"));
		Select branchselect=new Select(e);
		branchselect.selectByVisibleText("CS");
		
		System.out.println("Step 4 --> Verify Redirect to another url by clicking click hereb link");
		driver.findElement(By.id("clickId")).click();
		
		System.out.println("Verify to Redirected correct URL");
		verifyTitle(driver,"Google");
		
		System.out.println("Step 5 --> Navigate privious url");
		driver.navigate().back();
		
		System.out.println("Verify html page is loaded");
		 verifyTitle(driver,"Vibha's Demo Page");
	}

	 void verifyTitle(WebDriver driver,String expectedTitle){
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		System.out.println("Title --> "+actualTitle);
	}
	
	public static void main(String[] args) {
		Assignment1 assignment1 =new Assignment1();
		assignment1.processData();
	}
}
