package vibha.Assignment6to10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Assignment6_IFrame {

	public WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("Step1:Launch browser and hit url");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		
		driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step2: Click on IFrame Demo tab");
		driver.findElement(By.id("iframes")).click();

		Thread.sleep(3000);
	}

	@Test
	public void printOptionsFrom1stIFrame() throws InterruptedException {
		System.out.println("Step3: Switch to the first frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'site1']")));

		Thread.sleep(5000);
		System.out.println("Step4: Click on top right button");
		driver.findElement(By.xpath("//button[@class = 'navbar-toggler']")).click();

		System.out.println("Step5: print the options");
		List<WebElement> options = driver.findElements(By.xpath("//div[@id ='main_navbar']//li/a"));
		System.out.println("Options -->");
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		Thread.sleep(1000);

		System.out.println("Step6: Switch back to main window");
		driver.switchTo().parentFrame();
	}

	@Test
	public void printOptionsFrom3rdIFrame() throws InterruptedException {
		System.out.println("Step3: Switch to the third frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title ='site3']")));

		Thread.sleep(4000);
	
		System.out.println("Step4: Click on Projects tab");
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//table[@summary ='non selected tab']"))).build().perform();
		//driver.findElement(By.xpath("//table[@summary ='non selected tab']")).click();

		System.out.println("Step5: Print the projects");
		List<WebElement> projects = driver.findElements(By.xpath("//li[@class='menuheader']"));
		for (WebElement project : projects) {
			System.out.println("------" + project.getText());
		}
		Thread.sleep(4000);

		System.out.println("Step6: Switch back to main window");
		driver.switchTo().parentFrame();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	
	}
}
