package SwapnilMaheshwar.MouseHover.Assignment7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHoverTest {
	WebDriver driver;

	@BeforeTest
	public void browserOpen() {
		System.out.println("Step-Launch the browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		System.out.println("Step- flipkart home page should be open");
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.manage().window().maximize();

	}

	@Test
	public void mouseHover() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();
		int count = driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		System.out.println("Section Total Count :" + count);
		List<WebElement> elementName = driver.findElements(By.xpath("//a[@class='_6WOcW9']"));
		WebElement ele = driver.findElement(By.xpath("//a[@class='_6WOcW9 _2-k99T']"));
		System.out.print(ele.getText() + ":");
		action.moveToElement(ele);
		System.out.println(driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']")).size());
		for (WebElement e : elementName) {
			System.out.print(e.getText() + ":");
			action.moveToElement(e).build().perform();
			List<WebElement> subElementSize = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
			System.out.println(subElementSize.size());
		}

	}

}
