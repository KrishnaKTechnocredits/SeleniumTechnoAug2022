package sanket.framedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.*;

public class Assignment6FrameDemoScript1 {
	WebDriver driver;

	@BeforeMethod
	public void preTestSetup() throws Exception {

		System.out.println("STEP 1 - Launch Browser and hit URL.");
		driver = PredefinedActions.start();

		System.out.println("STEP 2 - Nevigate to iFrame window.");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		System.out.println("STEP 3 - Click on iFrame tab");

		Thread.sleep(3000);
	}

	@Test
	public void printFrameOptions() throws Exception {

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
		System.out.println("STEP 4 - Switch to Frame");

		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		Thread.sleep(2000);
		System.out.println("STEP 5 - Click on nevigation bar on top right button.");

		System.out.println("STEP 6 - Print all frame options.");
		List<WebElement> listOfFrameOptions = driver.findElements(By.xpath("//div[@id='main_navbar']"));
		for (WebElement allFrameOptions : listOfFrameOptions) {
			System.out.println("\n");
			System.out.println("Frame oprion list : ");
			System.out.println(allFrameOptions.getText());
		}

		System.out.println("\n");
		System.out.println("STEP 7 - Switch to main window");
		driver.switchTo().parentFrame();
		System.out.println("Switch to main window successfully.");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
