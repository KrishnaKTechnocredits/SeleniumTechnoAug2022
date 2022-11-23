/*Assignment No 9 : 3rd Nov 2022
Script 1: File upload scenario on orangeHRM

"1. launch your orange HRM site
2. Login with valid credentials
3. Click on Employee Management tab from left side
4. Click on my info tab
4. scroll down to the page
5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
6. Click on save button
7. vaidate the same file uploaded & type of file is aslo correct
8. Your name should be displayed under Added by colum name"*/

package komalShrivastava.robotClass;

import java.awt.AWTException;
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

import komalShrivastava.base.PredefinedActions;

public class FileUpload {
	
	WebDriver driver;

	@BeforeTest
	public void launchURL() {
		driver = PredefinedActions.start("https://kshrivastava-trials77.orangehrmlive.com/");
	}

	@Test
	public void loginTest() throws InterruptedException, AWTException{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Xl2ga9MMA@");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP : Validate Page title");
		String actualTitle = driver.findElement(By.xpath("//ul[@class='topbar-title']")).getText();
		Assert.assertEquals(actualTitle, "Employee Management");

		System.out.println("STEP : Click on My Info tab");
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']")).click();
		Thread.sleep(30000);
		System.out.println("STEP : Verify if My info tab is loaded");
		String actualTabTile= driver.findElement(By.id("personal_details_tab")).getText();
	//	Assert.assertEquals(actualTabTile,"Personal Details");
		
		WebElement button = driver.findElement(By.xpath("//div[@ng-if='!attachmentsCtrl.isOxd']//a[@ng-click='attachmentsCtrl.addAttachments()']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		
		button.click();
		
		System.out.println("STEP : Click on Browse button ");
		
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//button[@type='button'][@ng-if='fileInputVisible']"))).build().perform();
		
		Thread.sleep(5000);
		StringSelection ss = new StringSelection("C:\\Java-Selenium-Sessions\\Java-Selenium\\SeleniumSessions\\UserDetails.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		System.out.println("STEP : Verify if file is uploaded");
		String filename = driver.findElement(By.xpath("//input[@ng-if='!form.hideText']")).getText();
	//	Assert.assertEquals(filename, "UserDetails.txt");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
		Thread.sleep(3000);
		String actualFilename = driver.findElement(By.xpath("//div[@class='form-div'][2]//tbody/tr/td[2]")).getText();
		Assert.assertEquals(actualFilename, "UserDetails.txt");
	}

}
