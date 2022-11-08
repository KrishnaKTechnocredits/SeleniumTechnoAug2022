package gauravSahu.Assignment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7B {
	
	WebDriver driver;
	
	@BeforeMethod
	void launchUrl() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\AUG 2022 CLASS\\Selenium2022\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser & URL Launched");

		driver.get("https://www.xoriant.com/");
		driver.manage().window().maximize();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	}
	@Test
	void mouseHover() throws InterruptedException {
		System.out.println("Step 2 : Locate the element ");
		WebElement element1 = driver.findElement(By.xpath("//span[@title='Digital Product Engineering']"));
		
		System.out.println("Step 3 : Hover to that element");
		Actions act = new Actions(driver);
		act.moveToElement(element1).build().perform();
		
		System.out.println("Step 4 : Get list of Elements");
		List<WebElement> listOfElement = new ArrayList<WebElement>();
		listOfElement = driver.findElements(By.xpath("//li[@id='main-menu-link-content6a57a95e-e6f2-42a7-8650-fbddd13aa1be']//li"));
		for (WebElement e : listOfElement) {
			System.out.println(e.getText());
			
		}
	}

}
