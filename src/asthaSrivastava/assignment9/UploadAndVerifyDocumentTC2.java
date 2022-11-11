/*Assignment:9

Script 2: Upload doc and validate it's uploaded

1. launch your orange HRM site
2. Login with valid credentials
3. Click on Employee Management tab from left side
4. Click on my info tab
4. scroll down to the page
5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
6. Click on save button
7. vaidate the same file uploaded & type of file is aslo correct
8. Your name should be displayed under Added by colum name*/
package asthaSrivastava.assignment9;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import asthaSrivastava.PredefinedActions;
import asthaSrivastava.utils.PropertiesFileReader;

public class UploadAndVerifyDocumentTC2 {

	WebDriver driver;
	PropertiesFileReader properties = new PropertiesFileReader(
			"src/asthaSrivastava/assignment9/OrangeHRMLogin.properties");

	@BeforeMethod
	public void setUp() {
		System.out.println("STEP : Launch Orange HRM Site");
		driver = PredefinedActions.start("http://asrivastava-trials77.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getValue("waitTime")), TimeUnit.SECONDS);
	}

	@Test
	public void uploadDoc() throws InterruptedException, AWTException {
		System.out.println("STEP : Login with valid credentials");
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys(properties.getValue("userName"));
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(properties.getValue("userPassword"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualDisplayMsg = driver.findElement(By.xpath("//div[text()='Employee Management']")).getText();
		String expectedDisplayMsg = "Employee Management";
		System.out.println("VERIFY: Login done successfully");
		Assert.assertEquals(actualDisplayMsg, expectedDisplayMsg);

		System.out.println("STEP : Click on Employee Management tab from left side");
		driver.findElement(By.xpath("(//span[text()='Employee Management'])[1]")).click();

		System.out.println("STEP : Click on my info tab");
		driver.findElement(By.xpath("(//a[@class='top-level-menu-item'])[1]")).click();

		System.out.println("STEP : Scroll down to the page");
		PredefinedActions.scrollToElement(driver.findElement(By.xpath("//div[@class='form-div'][2]")));

		System.out.println("Step6: Click on add button under attachment");
		driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")).click();

		System.out.println("STEP : Browse any file (also you need to save the type of file txt, pdf, doccx etc)");
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("//div[@class='file-"
				+ "path-wrapper form-control']"))).build().perform();
		Thread.sleep(5000);
		StringSelection fileSelect = new StringSelection("E:\\Java2022\\Assignments\\robot\\SampleFile1.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileSelect, null);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		 
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		actions.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();
		String actualFileName = driver.findElement(By.xpath("//td[@name='listField.name'][1]")).getText();
		String expectedFileName = "SampleFile1.txt";
		System.out.println("VERIFY : Validate the same file uploaded & type of file is aslo correct");
		Assert.assertEquals(actualFileName, expectedFileName, "File name is correct "+actualFileName+" ");

		String actualName = driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
		String expectedName = driver.findElement(By.xpath("//a[@class='name']")).getText();
		System.out.println("VERIFY : Your name should be displayed under Added by colum name");
		Assert.assertEquals(actualName, expectedName, "Name is correct");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
