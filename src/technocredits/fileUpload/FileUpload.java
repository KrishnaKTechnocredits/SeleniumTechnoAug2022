package technocredits.fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;

public class FileUpload {
WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP - Navigate to Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
	}
	
	@Test
	public void fileUpload() throws InterruptedException, AWTException {
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//input[@id='exampleInputFile']"))).build().perform();
		Thread.sleep(3000);
		
		StringSelection ss = new StringSelection("C:\\Users\\harsh\\OneDrive\\Desktop\\New folder\\SeleniumTechnoAug2022\\src\\technocredits\\htmlForms\\BlankLinkPractice.html");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		File file = new File("C:\\Users\\harsh\\OneDrive\\Desktop\\Saved Notepads\\DB");
		File f[] = file.listFiles();
		
		String s = f[0].getAbsolutePath();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
}
