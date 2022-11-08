package nehanig;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Assignment7 {
	WebDriver driver;

	@Test
	void verifyMouseHoverFeature() throws InterruptedException {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		Thread.sleep(3000);

		System.out.println("Step: Click on cross button on login");
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();

		System.out.println("Step: Mouse hover on Fashion Icon");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();

		System.out.println("Step: Validate that menu is displayed");
		int total = driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		if (total > 0) {
			System.out.println("Menu is displayed");
		} else {
			System.out.println("Menu is not displayed");
		}
		Thread.sleep(1000);

		System.out.println("Step: Print each section's subsection count");
		List<WebElement> sections = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		for (WebElement section : sections) {
			List<WebElement> subSection = driver.findElements(By.xpath("//div[@class = '_3XS_gI']/a"));
			System.out.println("  " + section.getText() + " --> " + subSection.size());
		}
		Thread.sleep(3000);
	}

	@AfterMethod

	public void closeBrowser() {
		PredefinedActions.closeAllBrowser();
	}
}
