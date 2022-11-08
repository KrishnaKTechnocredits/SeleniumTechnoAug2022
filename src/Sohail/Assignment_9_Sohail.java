package Sohail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_9_Sohail {
	WebDriver driver;

	@BeforeTest
	void launchBrowser() {
		driver = PredefinedActions.openBrowser("http://smujawar-trials77.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void fileUpload() throws InterruptedException, AWTException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("nXYH3A4pg@");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.className("name")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")).click();
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.id("filename"))).build().perform();

		StringSelection ss = new StringSelection("G:\\Technocredits\\Test.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("1");
		driver.findElement(By.id("modal-save-button")).click();

		System.out.println("2");
		Thread.sleep(20000);
	}

	@AfterTest
	void closeBrowser() {

		PredefinedActions.closeBrowser();
	}
}
