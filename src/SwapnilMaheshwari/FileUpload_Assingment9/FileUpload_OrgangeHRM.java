package SwapnilMaheshwari.FileUpload_Assingment9;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SwapnilMaheshwari.PreDefineMethods.CommonMethods;

public class FileUpload_OrgangeHRM {
	WebDriver driver;

	@BeforeTest

	public void browserOpen() throws InterruptedException {
		System.out.println("Step-Launch the Orange HRM application");
		driver = CommonMethods.openBrowser("https://swapnilm-trials77.orangehrmlive.com/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void fileUPload() throws AWTException {

		System.out.println("Step- Login with valid user name and credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("PUyF6Va6@k");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Step - Click on my info tab");
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		System.out.println("Step-reach till the attachment section");
		WebElement element = driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView()", element);

		System.out.println("Step- click on Add button");
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"))).build()
				.perform();

		System.out.println("Browse the file");
		act.click(driver.findElement(By.xpath("//input[@id='filename']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		StringSelection ss = new StringSelection(
				"D:\\TechnoCredits\\SeleniumTechnoAug2022\\src\\SwapnilMaheshwari\\FileUpload_Assingment9\\learning ms excel.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		System.out.println("create robot class");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("Enter the value in description box");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Testing content");

		System.out.println("Click on Save button after selecting the file");
		act.click(driver.findElement(By.xpath("//button[@ng-if='vm.showSaveButton']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*
		 * String
		 * actualMessage=driver.findElement(By.xpath("//div[@class='toast-message']")).
		 * getText(); String expectedMessage="Successfully Updated";
		 * Assert.assertEquals(actualMessage, expectedMessage);
		 * System.out.println("File uploaded successfully");
		 */
		System.out.println("vaidate the same file uploaded");
		String actualFileName;
		actualFileName = driver.findElement(By.xpath("//a[@ng-if='url.url']")).getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedFileName = "learningmsexcel.pdf";
		Assert.assertEquals(actualFileName, expectedFileName);
		System.out.println("File name is correct");

		System.out.println("Validate the file format");
		String expecteFileFormat = "application/pdf";
		String actualFileFormat = driver.findElement(By.xpath("//span[text()='application/pdf']")).getText();
		Assert.assertEquals(actualFileFormat, expecteFileFormat);
		System.out.println("File format is correct");

		System.out.println("Validat the added by column must be display your name ");
		String expectedName = "Swapnil Maheshwari";
		String actualName = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(actualName, expectedName);
		System.out.println("Name matched");
	}
}
