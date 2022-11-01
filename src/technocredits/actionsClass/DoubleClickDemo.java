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

public class DoubleClickDemo {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start();

		System.out.println("STEP - Navigate to Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);
	}

	@Test
	public void doubleClick() {

		WebElement ele = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		System.out.println("STEP: Scroll till element");
		
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.id("")));
		driver.findElement(By.id("")).click();
		
		System.out.println("STEP: Double click on element");

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println("STEP: Alert accepted");
	}
}
