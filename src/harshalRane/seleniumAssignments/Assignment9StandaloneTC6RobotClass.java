package harshalRane.seleniumAssignments;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import harshalRane.base.PredefinedActions;
import harshalRane.utils.PropertiesFileReader;

public class Assignment9StandaloneTC6RobotClass {
	WebDriver driver;
	PropertiesFileReader property = new PropertiesFileReader(
			"src/harshalRane/propertiesFile/OrangeHRM.properties");

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start(property.getValue("url"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(property.getValue("implicitWait")), TimeUnit.SECONDS);
	}

	@Test
	public void uploadFile() throws AWTException, InterruptedException {
		System.out.println("Step2: Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(property.getValue("username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(property.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Step3: Click on Employee Management tab from left side");
		driver.findElement(By.xpath("//a[@id='menu_item_37'][1]")).click();

		System.out.println("Step4: Click on my info tab");
		driver.findElement(By.xpath("(//a[@class='top-level-menu-item'])[1]")).click();

		System.out.println("Step5: scroll down to the page");
		PredefinedActions.scrollToElement(driver.findElement(By.xpath("//div[@class='form-div'][2]")));

		System.out.println("Step6: Click on add button under attachment");
		driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")).click();

		System.out.println("Step7: Browse any file (also you need to save the type of file txt, pdf, doccx etc)");

		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//div[@class='file-path-wrapper form-control']"))).build().perform();
		StringSelection selectFile = new StringSelection("D:\\H\\Testing_Courses\\TechnoCredits_Java_Selenium\\Java Topics Technocredits.pdf");
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
		action.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();

		Thread.sleep(5000);
		System.out.println("Step9: Vaidate the same file uploaded & type of file is also correct");
		String actualFile = driver.findElement(By.xpath("//td[@name='listField.name'][1]")).getText();
		Thread.sleep(2000);
		String expectedFile = "JavaTopicsTechnocredits.pdf";
		Assert.assertEquals(actualFile, expectedFile);
		System.out.println("  Same file is uploaded");

		String actualFileType = driver.findElement(By.xpath("//td[@name='listField.name'][4]")).getText();
		String expectedFileType = "application/pdf";
		Assert.assertEquals(actualFileType, expectedFileType);
		System.out.println("  File type is correct");

		System.out.println("Step10: Your name should be displayed under Added by column name");
		String actualName = driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
		String expectedName = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(actualName, expectedName);
		System.out.println("  Name is displayed");
	}

//	@AfterMethod
//	public void closeBrowser() {
//		driver.close();
//	}
}
