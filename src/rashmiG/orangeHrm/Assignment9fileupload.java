package rashmiG.orangeHrm;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rashmiG.Base.PredefinedActions;
import rashmiG.utils.PropertiesFileReader;

public class Assignment9fileupload {

	PropertiesFileReader prop = new PropertiesFileReader("src/rashmiG/orangeHrm/orangeHrm.properties");
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.out.println("STEP - Launch orange HRM site");
		driver=PredefinedActions.start(prop.getValue("applicationUrl"));
		//implicit time
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")),TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(prop.getValue("userName"));
		System.out.println("STEP - Enter username");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(prop.getValue("password"));
		System.out.println("Enter password");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println("STEP-Click on login button");
		System.out.println("STEP - login done");
		
	}
	@Test
	public void fileUpload() throws InterruptedException, AWTException {
		driver.findElement(By.cssSelector("div#top-ribbon-menu>div:nth-child(2) div#top_level_menu_item_menu_item_40>a")).click();
		System.out.println("STEP - Click on my info tab");
		System.out.println("STEP - Scroll down to the page");
		WebElement addElement = driver.findElement(By.xpath("//span[text()='Attachments']"));
		Thread.sleep(3000);
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", addElement);
		
		System.out.println("STEP - Click on add button");
		driver.findElement(By.xpath("//div/a[@class='waves-effect waves-teal btn primary-btn']")).click();
		
		System.out.println("STEP - Click on browse button");
		Actions act = new Actions(driver);
		
		act.click(driver.findElement(By.xpath("//input[@id='filename']"))).build().perform();
		
		Thread.sleep(3000);
		
		//upload file
		
		StringSelection ss = new StringSelection("D:\\dummyfilesforfileuploadscenario\\Rashmi uploaded file.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("STEP - Click on save button");
		driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
		
		String ExpectedFileName="Rashmiuploadedfile.pdf";
		String actualFileName= driver.findElement(By.xpath("//table[@class='highlight bordered classic-table']//td[position()=2 ]//a")).getText();
		Assert.assertEquals(ExpectedFileName,actualFileName);
		System.out.println("Pass - file name is "+actualFileName);
		if(actualFileName.contains(".pdf")) {
			
			System.out.println("Pass - file type is correct");
		}
		
		Assert.assertEquals("application/pdf",driver.findElement(By.xpath("//table[@class='highlight bordered classic-table']//td[position()=5 ]//span")).getText());
		
		String actualAddedBy = driver.findElement(By.xpath("//table[@class='highlight bordered classic-table']//td[position()=7 ]//span")).getText();
		String expectedAddedBy="Rashmi Ganachari";
		Assert.assertEquals(actualAddedBy, expectedAddedBy);
		System.out.println("PASS - file is added by "+actualAddedBy);
	}
	
	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}