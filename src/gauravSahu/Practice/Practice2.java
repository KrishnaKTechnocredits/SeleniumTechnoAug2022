/*Script 2

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the 3rd frame & click on Projects tab
5. print the 
	Projects
	Apache Ant Libraries
	Apache Ivy
	Apache IvyDE
	Apache EasyAnt
5. Switch back to main window*/
package gauravSahu.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice2 {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\AUG 2022 CLASS\\Selenium2022\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Step-2 : Hit url(http://automationbykrishna.com/)in browser");
		
		Thread.sleep(2000);
		driver.findElement(By.id("iframes")).click();
		System.out.println("Click on iFrame tab");
		
		Thread.sleep(5000);
		driver.switchTo().frame(2);
	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@summary='non selected tab']//a")).click();
		System.out.println("Step 3  : Switch to the 3rd frame & click on Projects tab");
		
		Thread.sleep(1000);
		
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@class='menucontainer']//ul/li[@class='menuheader']"));
		for(WebElement o : listOfOptions) {
			System.out.println(o.getText());
			Thread.sleep(1000);
		}
				
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		System.out.println("Step 4 : Switched to mainWindow");
		
	}

}
