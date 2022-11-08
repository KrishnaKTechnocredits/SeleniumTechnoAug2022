/*Assignment - 5 : 30th OCt'2022

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)*/

package gauravSahu.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment5 {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void m1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\\\AUG 2022 CLASS\\\\Selenium2022\\\\SeleniumTechnoAug2022\\\\drivers\\\\chromedriver_106.exe");
		driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	void createAccount() throws Exception,IllegalArgumentException{
		
		System.out.println("Step 2 : Click on Registration ");
		driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']//li[2]/a")).click();
		Thread.sleep(5000);
		
		Properties prop = new Properties();
		File file = new File("src\\gauravSahu\\propertiesFile\\propertyFile.properties");
		System.out.println(file.exists());
		
		FileInputStream input = new FileInputStream(file);
	
		
		Thread.sleep(5000);
		System.out.println("Step : 3 Enter First Name");
		driver.findElement(By.xpath("//div[@id='registration']//input[@id='fullName']")).
		sendKeys(prop.getProperty("firstName"));
		
			
		}
	}
	

