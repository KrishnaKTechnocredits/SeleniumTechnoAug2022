/*Assignment No 9 : 3rd Nov 2022

Script 1: File upload scenario on orangeHRM
https://docs.google.com/spreadsheets/d/1fXspjL_tJyOJLp29CGtYmd3yby1DlNd9TNp0yTiNqxY/edit#gid=1513189356
*/

package pujaSah.OrangeHRMLogin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pujaSah.Base.PredefinedActions;
import pujaSah.utils.PropertiesFileReader;

public class FileUpload {

	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader("src/pujaSah/OrangeHRMLogin/OrangeHRMLoginDetails.properties");

	@BeforeMethod
	public void startUp() throws InterruptedException {
		driver=PredefinedActions.start(prop.getValue("applicationURL"));
		System.out.println("STEP 1: Launch browser and hit Orange HRM URL");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")),TimeUnit.SECONDS);
	}
	
	@Test
	public void OrangeHRMLogin() throws InterruptedException, AWTException{
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
		System.out.println("STEP 2: Enter username");
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
		System.out.println("STEP 3: Enter password");
		
		System.out.println("STEP 4: Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		String title = driver.getTitle();
		if(title.equals("Employee Management")){
			System.out.println("Successfully logged in");
		}
		else{
			System.out.println("Log in failed");
		}
		
		driver.findElement(By.xpath("//top-level-menu-item[@automation-id='menu_pim_viewMyDetails']//a[@ng-if='!!sref && !menuTooltip']")).click();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("myInfoPageWait")), TimeUnit.SECONDS);
		System.out.println("STEP 5: Click on My info tab");
		Thread.sleep(10000);

		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"))); 		
		System.out.println("STEP 6: Scroll upto add button");
		
		StringSelection ss = new StringSelection("C:\\Users\\91768\\OneDrive\\Desktop\\myFile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		System.out.println("STEP 7: Copy filepath");
		
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"))).build().perform();
		Thread.sleep(10000);
		System.out.println("STEP 8: Click on add button");
		
		act.click(driver.findElement(By.xpath("//input[@id='filename']"))).build().perform();
		System.out.println("STEP 9: Click on Browse");
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		System.out.println("STEP 10: Press keys ctrl and v");

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		System.out.println("STEP 11: Release keys ctrl and v");

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("STEP 12: Press Enter key");
		
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("STEP 13: Release Enter key");
		Thread.sleep(10000);

		act.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();
		System.out.println("STEP 14: Click on save button");
	}
	
	/*@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}*/
}

