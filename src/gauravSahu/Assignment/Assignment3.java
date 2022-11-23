/*Assignment - 3 : 28th Oct'2022
Verify Alert functionality on automationbykrishna application.*/

package gauravSahu.Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws Exception {

		String expectedAlertmsg1 = "You must be TechnoCredits student!!";
		String expectedAlertmsg2 = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String expectedALertmsg3 = "You pressed OK!";
		String expectedAlertmsg4 = "Hello Gaurav Sahu! How are you today?";

		System.setProperty("webdriver.chrome.driver",
				"E:\\\\AUG 2022 CLASS\\\\Selenium2022\\\\SeleniumTechnoAug2022\\\\drivers\\\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//div[@class='panel-body']/button[1]"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element1);

		element1.click();
		System.out.println("Step-2 : Alert message click ");

		Alert alert = driver.switchTo().alert();
		String actualAlertmsg = alert.getText();
		if (actualAlertmsg.equals(expectedAlertmsg1)) {
			System.out.println("Step 3: Alert message verified");
		} else {
			System.out.println("Alert message mismatched");
		}

		Thread.sleep(2000);
		alert.accept();
		System.out.println("Step 4: Alert message accepted ");

		Thread.sleep(2000);
		System.out.println("Step 5 : 2nd Alert message click");
		WebElement element2 = driver.findElement(By.xpath("//div[@class='panel-body']/button[2]"));
		element2.click();

		Alert alert2 = driver.switchTo().alert();
		String actualAlertmsg2 = alert2.getText();
		if (expectedAlertmsg2.equals(actualAlertmsg2)) {
			System.out.println("Step 6 : Alert message verified");
		} else {
			System.out.println("Alert message mismatched");
		}

		alert2.accept();
		
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("//div[@class='col-lg-12']//section/p"));
		String actualAlertmsg3 = element3.getText();
		if(actualAlertmsg3.equals(expectedALertmsg3)) {
			System.out.println("Step 7 :Alert message verified ");
		}else {
			System.out.println("Alert message mismatched");
		}
		
		Thread.sleep(2000);
		WebElement element4 = driver.findElement(By.xpath("//div[@class='panel-body']/button[3]"));
		element4.click();
		
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert3.sendKeys("Gaurav Sahu");
		
		Thread.sleep(2000);
		alert3.accept();
		
		Thread.sleep(2000);
		String actualmsg5  =  driver.findElement(By.xpath("//div[@class='col-lg-12']/section/p")).getText();
		if(actualmsg5.equals(expectedAlertmsg4)) {
			System.out.println("Step 8 : Alert message verified"); 
		}else {
			System.out.println("Alert message mismatched");
		}
		
		
	}

}
