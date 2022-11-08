package saroj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssignment7Script2 {

	WebDriver driver;

	@BeforeMethod
	public void browserLaunch() {
		driver = PredefinedActions.start();
		System.out.println("STEP - Click on Basic Element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void doubleClickActivity() {
		System.out.println("Step - Scroll till element visible");
		WebElement element = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP: Perform double click on element");
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();

		System.out.println("STEP: Validate that you double click on element");
		Alert alert = driver.switchTo().alert();
		String expectedmsg = "You successfully double clicked it";
		String actualmsg = alert.getText();
		if (expectedmsg.equals(actualmsg)) {
			System.out.println("You have double clicked");
			System.out.println(alert.getText());
		}
		alert.accept();
		System.out.println("STEP: Alert accepted");
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
}
