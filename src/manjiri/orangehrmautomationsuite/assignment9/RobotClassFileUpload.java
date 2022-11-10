/*Script 2: Upload doc and validate it's uploaded

1. launch your orange HRM site
2. Login with valid credentials
3. Click on Employee Management tab from left side
4. Click on my info tab
4. scroll down to the page
5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
6. Click on save button
7. vaidate the same file uploaded & type of file is aslo correct
8. Your name should be displayed under Added by colum name*/

package manjiri.orangehrmautomationsuite.assignment9;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;
import manjiri.orangehrmautomationsuite.utils.PropertiesFileReader;

public class RobotClassFileUpload {
	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader(
			"src/manjiri/orangehrmautomationsuite/propertiesfile/orangeHRMLogin");

	@BeforeMethod
	public void setup() {
		System.out.println("Step: Launch the browser and hit URL");
		driver = PredefinedActions.start("https://mchourikar-trials77.orangehrmlive.com/");

		// Added implicit wait for 35 sec
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	@Test
	public void applicationLogin() throws InterruptedException, AWTException {
		System.out.println("Step: Enter Username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("username"));

		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));

		System.out.println("Step: Click on Login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Step: Click on MyInfo tab");
		driver.findElement(By.xpath("//div[@unique-name='uniqueName']/a[@data-automation-id='menu_pim_viewMyDetails']"))
				.click();
		
		System.out.println("Step: Scroll to Attachments");
		PredefinedActions.scrollToElement(driver.findElement(By.xpath("//span[text()='Attachments']")));

		System.out.println("Step: Click on Add button");
		driver.findElement(By.xpath("//div[@class='form-div']//a[text()='Add']")).click();
				
		System.out.println("Click on Browse button");
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("//div[@class='file-path-wrapper form-control']"))).build().perform();
		Thread.sleep(3000);
		
		System.out.println("Step: Upload file");
		StringSelection ss = new StringSelection("D:\\TechnoCredits\\sample\\orangeHRM.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Click on Save button after uploading attachment");
		actions.click(driver.findElement(By.xpath("//button[text()='Cancel']//following-sibling::button"))).build().perform();
		
		Thread.sleep(3000);
		
		String actualFilename = driver.findElement(By.xpath("//list[@listdata='attachmentsCtrl.listData']/table/tbody/tr/td[position()=2]//span")).getText();
		String expectedFileName = "orangeHRM.txt";
		if(expectedFileName.equals(actualFilename)) {
			System.out.println("Filename is correct!!!");
		}
		else {
			System.out.println("Incorrect filename!!!");
		}
		
		String actualFileextn = driver.findElement(By.xpath("//list[@listdata='attachmentsCtrl.listData']/table/tbody/tr/td[position()=5]//span")).getText();
		String expectedFileextn = "text/plain";
		if(expectedFileextn.equals(actualFileextn)) {
			System.out.println("File Extension is correct!!!");
		}
		else {
			System.out.println("Incorrect file extension!!!");
		}
		
		String actualUser = driver.findElement(By.xpath("//list[@listdata='attachmentsCtrl.listData']/table/tbody/tr/td[position()=7]//span")).getText();
		String expectedUser = "manjiri ch";
		if(expectedUser.equals(actualUser)) {
			System.out.println("User Details are correct!!!");
		}
		else {
			System.out.println("Incorrect user details!!!");
		}
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
