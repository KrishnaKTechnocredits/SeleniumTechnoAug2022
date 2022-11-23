package saroj;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssignment7Script3 {

	WebDriver driver;

	@BeforeMethod
	public void browserLaunch() {
		driver = PredefinedActions.start("https://www.flipkart.com/");
		System.out.println("STEP - Click on cross button on Login");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void mousehoverActivity() {
		WebElement element = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions act = new Actions(driver);
		System.out.println("Step - Mouse hover on Fashion Icon");
		act.moveToElement(element).build().perform();
		System.out.println("Step - Validate that menu is displayed");
		int subMenuSize = driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		if (subMenuSize > 0) {
			System.out.println("menu is displayed");
		} else {
			System.out.println("menu not displayed");
		}
		System.out.println("Step - print each section's subsection count");
		List<WebElement> elementSize = driver.findElements(By.xpath("//a[@class='_6WOcW9']"));
		WebElement ele = driver.findElement(By.xpath("//a[@class='_6WOcW9 _2-k99T']"));
		System.out.println(ele.getText());
		act.moveToElement(ele);
		System.out.println(driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']")).size());
		for (WebElement e : elementSize) {
			System.out.println(e.getText());
			act.moveToElement(e).build().perform();
			List<WebElement> subElementSize = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
			System.out.println(subElementSize.size());
		}
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
}
