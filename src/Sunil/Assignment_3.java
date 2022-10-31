/* Verifiy Alert Functionality On automationbykrishna Application */
 
package Sunil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("STEP 1 :- Open Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		System.out.println("STEP 2 :- Hit URL");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("STEP 3 :- Clieck On Basic Element Tab");
		driver.findElement(By.id("basicelements")).click();
		
		Thread.sleep(2000);
		
		System.out.println("STEP 4 :- Clieck On Alert Button");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,200)");
		
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptPromp")).click();
		
		System.out.println("STEP 5 :- Switch To Alert");
		String name ="Sunil Balaji Holambe";
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		
		System.out.println("STEP 6 :- Accept The Alert");
		alert.accept();	
		
		String msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
				if(msg.contains(name)) {
					System.out.println("Pass");
				} else {
					System.out.println("Fail");				
				}
	}
}