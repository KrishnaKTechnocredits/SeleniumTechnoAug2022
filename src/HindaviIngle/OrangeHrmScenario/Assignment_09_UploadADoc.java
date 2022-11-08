/*
 * 
Script 2: Upload doc and validate it's uploaded

1. launch your orange HRM site
2. Login with valid credentials
3. Click on Employee Management tab from left side
4. Click on my info tab
4. scroll down to the page
5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
6. Click on save button
7. vaidate the same file uploaded & type of file is aslo correct
8. Your name should be displayed under Added by colum name
 */
package HindaviIngle.OrangeHrmScenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class Assignment_09_UploadADoc {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	void beforeMethod() throws IOException {
		File file = new File(
				"D:\\TechnoCredit\\workspace\\Selenium_Oct22\\SeleniumTechnoAug2022\\src\\HindaviIngle\\PropertyFile\\OrangeHrmDetails");
		FileInputStream fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);
		System.out.println("--->" + prop.getProperty("url"));
		 driver = PredefinedActions.start(prop.getProperty("url"));
	
}
	@Test
	void uploadFileFunctionality() throws AWTException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		System.out.println("Step2 : fill login details from property file");
		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("txtPassword")).sendKeys(prop.getProperty("password"));
		
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		wait.until(ExpectedConditions.visibilityOf(element)).click();
		
		System.out.println("Step3 : Click on My info Link");
		WebElement ele=driver.findElement(By.xpath("//a[normalize-space()='My Info']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.visibilityOf(ele)).click();
		
		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		System.out.println("**STEP4 :Scroll down to dropdown**");
		
//		WebElement numberElement=driver.findElement(By.xpath("//div[@class='form-div'][2]"));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='form-div'][2]"))));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement numberElement=driver.findElement(By.xpath("//div[@class='form-div'][2]"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", numberElement);
		
		System.out.println("**STEP5 :Click on ADD button**");

		driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")).click();
		
		System.out.println("Step6: Browse any file (also you need to save the type of file txt, pdf, doccx etc)");
		
		Actions action=new Actions(driver);
		action.click(driver.findElement(By.xpath("//div[@class='file-path-wrapper form-control']"))).build().perform();
		
		StringSelection selectFile=new StringSelection("C:\\Users\\Bhushan\\Desktop\\test.txt");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectFile, null);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		System.out.println("Step8: Click on save button");
		
		//driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
		
		//action.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();
		action.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();
		System.out.println("Step9: File saved successfully.");
		
		
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", numberElement);
	
		
		System.out.println("Step9: Vaidate the same file uploaded & type of file is also correct");
		String actualFile = driver.findElement(By.xpath("//td[@name='listField.name'][1]")).getText();
		String expectedFile = "test.txt";
		Assert.assertEquals(actualFile, expectedFile);
		System.out.println("  Same file is uploaded");
		
		
		System.out.println("Step - Your name should be displayed under Added by column name");
		String actualName = driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
		String expectedName = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(actualName, expectedName);
		System.out.println("Name Matched");
		
		
		System.out.println("Step - Your name should be displayed under Added by column name");
		String actualN = driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
		String expectedN = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(actualN, expectedN);
		System.out.println("Name Matched");

	}
	
	void cleanUp() {
		driver.close();
	}
	
}