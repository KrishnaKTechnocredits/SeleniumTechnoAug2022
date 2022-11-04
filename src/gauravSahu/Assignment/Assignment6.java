package gauravSahu.Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment6 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\AUG 2022 CLASS\\Selenium2022\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("iframes")).click();

		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//iframe[@name='site1']"));
		driver.switchTo().frame(e);
		System.out.println("Step 2 : Click on iFrame tab ");

		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']"));
		element1.click();

		Thread.sleep(2000);
		System.out.println("Step 3 :print the options");
		System.out.println(driver
				.findElement(By.xpath("//div[@class='navbar-collapse justify-content-end collapse show']//li[2]/a"))
				.getText());
		System.out.println(driver
				.findElement(By.xpath("//div[@class='navbar-collapse justify-content-end collapse show']//li[3]/a"))
				.getText());
		System.out.println(driver
				.findElement(By.xpath("//div[@class='navbar-collapse justify-content-end collapse show']//li[4]/a"))
				.getText());
		System.out.println(driver
				.findElement(By.xpath("//div[@class='navbar-collapse justify-content-end collapse show']//li[5]/a"))
				.getText());
		System.out.println(driver
				.findElement(By.xpath("//div[@class='navbar-collapse justify-content-end collapse show']//li[6]/a"))
				.getText());
		System.out.println(driver
				.findElement(By.xpath("//div[@class='navbar-collapse justify-content-end collapse show']//li[7]/a"))
				.getText());

		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		System.out.println("Step 4 : Switched to mainWindow");

	}

}
