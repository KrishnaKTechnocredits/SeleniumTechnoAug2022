package nehanig;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment6_2 {
	WebDriver driver;

	@BeforeMethod
	public void launchBrower() throws InterruptedException {
		System.out.println("Step : Launch Crome Browser and Hit URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/");

		System.out.println("Step : Switch to IFrame Demo");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(3000);
	}

	@Test
	public void getAllOptionsFrom2ndframe() throws InterruptedException {
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@title='site3']"));

		System.out.println("Step : Scroll");
		PredefinedActions.scrollToElement(frame3);

		System.out.println("Step : Switch to Third Frame");

		System.out.println("Step : Scroll till alert option is visible");
		PredefinedActions.scrollToElement(frame3);

		driver.switchTo().frame(frame3);
		System.out.println("Switching to frame successfull");
		Thread.sleep(5000);

		System.out.println("Step4 : Clicking on Project Button");
		driver.findElement(By.xpath("//table[@summary='tab bar']/tbody/tr//table[@summary='non selected tab']"))
				.click();
		System.out.println("Click on button is successful");
		Thread.sleep(2000);

		System.out.println("Step5 : Getting all options present in frame");

		List<WebElement> contents = driver
				.findElements(By.xpath("//div[@class='menucontainer']//ul/li[@class='menuheader']"));
		for (WebElement element : contents) {
			System.out.println("    " + element.getText());
			Thread.sleep(2000);
		}
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowser();
		System.out.println("Browser Closed");
	}

}
