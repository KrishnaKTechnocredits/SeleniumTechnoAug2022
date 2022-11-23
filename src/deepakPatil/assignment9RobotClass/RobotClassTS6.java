package deepakPatil.assignment9RobotClass;

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

import deepakPatil.base.StartupActions;
import deepakPatil.utils.PropertiesFileReader;

public class RobotClassTS6 {
	
	PropertiesFileReader fileRead = new PropertiesFileReader("D:\\Automation Class-TechnoCredit\\SeleniumTechnoAug2022\\src\\deepakPatil\\assignment9RobotClass\\OrangeHRMDetails.properties");
	WebDriver driver; 
	
	@BeforeMethod
	void startUp() {
		
		driver=StartupActions.launch(fileRead.getValue("URL"));
		driver.findElement(By.cssSelector("input[id=txtUsername]")).sendKeys(fileRead.getValue("Username"));
		driver.findElement(By.cssSelector("input[id=txtPassword]")).sendKeys(fileRead.getValue("Password"));
		driver.findElement(By.cssSelector("button[type=submit]")).click();
	}
	
	@Test
	void uploadFile() throws AWTException, InterruptedException {
		
		//Click on my info tab
		driver.manage().timeouts().implicitlyWait(Long.parseLong(fileRead.getValue("WaitTime")), TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#top-ribbon-menu>div:nth-child(2) top-level-menu-item:nth-child(2) a")).click();
		WebElement element = driver.findElement(By.cssSelector("a[class='waves-effect waves-teal btn primary-btn']"));
		
		//scroll down to the page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		
		//Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//button[@type='button'][text()='Browse']"))).build().perform();
		StringSelection ss = new StringSelection(fileRead.getValue("FilePath"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		//Click on save button
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[id=modal-save-button]")).click();
		
		//validate the same file uploaded & type of file is aslo correct
		WebElement fileElement = driver.findElement(By.cssSelector("a[class=break-word]"));
		js.executeScript("arguments[0].scrollIntoView(true)", fileElement);
		String actualFileName= fileElement.getText();
		String expectedFileName= fileRead.getValue("FileName");
		Assert.assertEquals(actualFileName, expectedFileName);
		
		//Your name should be displayed under Added by column name
		String addedByActualName=driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
		String addedByExpectdName= fileRead.getValue("addedByName");
		Assert.assertEquals(addedByActualName, addedByExpectdName);
		
	}
	
	@AfterMethod
	void wrapUp() {
		driver.close();
	}
}
