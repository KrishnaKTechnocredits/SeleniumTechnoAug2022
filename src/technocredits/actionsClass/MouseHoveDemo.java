package technocredits.actionsClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;

public class MouseHoveDemo {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start("https://www.flipkart.com/");

		System.out.println("STEP - Navigate to Flipkart");

		Thread.sleep(5000);
	}

	@Test
	public void mouseHover() {
	
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();
		
		int total = driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		if(total>0) {
			System.out.println("STEP: Mouse hover working");
		}else {
			System.out.println("STEP: Mouse hover not performed");
		}
	}
}
