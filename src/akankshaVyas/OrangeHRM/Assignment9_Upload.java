/*
 * Script 2: Upload doc and validate it's uploaded

1. launch your orange HRM site
2. Login with valid credentials
3. Click on Employee Management tab from left side
4. Click on my info tab
4. scroll down to the page
5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
6. Click on save button
7. Validate the same file uploaded & type of file is also correct
8. Your name should be displayed under Added by column name

 */
package akankshaVyas.OrangeHRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;
import akankshaVyas.base.PropertiesFileReader;

public class Assignment9_Upload {

	WebDriver driver;

	@BeforeMethod
	void start() {

		System.out.println("Step 1. launch your orange HRM site");
		driver = PredefinedActions.start("https://avyas-trials77.orangehrmlive.com/client/#/dashboard");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

	@Test
	void testCaseUpload() throws InterruptedException, AWTException {

		PropertiesFileReader propertiesFileReader = new PropertiesFileReader(
				"src\\akankshaVyas\\PropertiesFiles\\OrangeHrmLoginCredentials.properties");

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		System.out.println("Step : 2. Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(propertiesFileReader.getValue("Username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(propertiesFileReader.getValue("Password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("3. Click on my info tab & Update the require details & click on Save button");
		driver.findElement(By.xpath("//a[@class='top-level-menu-item'][@ui-sref='pim.my_info']")).click();

		System.out.println("Step 4: scroll down to the page");
		WebElement ele = driver.findElement(By.cssSelector("a[class*='waves-effect waves-teal btn primary-btn']"));
		PredefinedActions.scrollToElement(ele); // add reach

		System.out.println(
				"5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)");
		driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")).click(); // add click

		Actions action = new Actions(driver);
		action.click(driver.findElement(By.id("filename"))).build().perform(); // click browse

		Thread.sleep(2000);
		StringSelection ss = new StringSelection(
				"C:\\Users\\asssssssssssssssssss\\Desktop\\videos-Java\\EclipseWorkspace\\SeleniumTechnoAug2022\\src\\akankshaVyas\\OrangeHRM\\2test_fileJavaUpload.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); // file path add

		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL); // control v =press for paste action
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V); // control v ==release action
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER); // Press enter and release for open
		Thread.sleep(2000);
		action.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform(); // click on
																											// save

		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.cssSelector("a[class*='waves-effect waves-teal btn primary-btn']"));
		PredefinedActions.scrollToElement(ele1); // add reach

		System.out.println("7. Validate the same file uploaded & type of file is also correct");
		System.out.println("Step9: Vaidate the same file uploaded & type of file is also correct");
		String actualFile = driver.findElement(By.xpath("//td[@name='listField.name'][1]")).getText();
		String expectedFile = "2test_fileJavaUpload.docx";
		Assert.assertEquals(actualFile, expectedFile);
		System.out.println("  Same file is uploaded");

		String actualFileType = driver.findElement(By.xpath("//td[@name='listField.name'][4]")).getText();
		String expectedFileType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		Assert.assertEquals(actualFileType, expectedFileType);
		System.out.println("  File type is correct");

		System.out.println("Step10: Your name should be displayed under Added by column name");
		String actualName = driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
		String expectedName = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(actualName, expectedName);
		System.out.println("  Name is displayed");

		String acttualFileName = driver
				.findElement(By.xpath("//span[@class='break-word'][text()='2test_fileJavaUpload.docx']")).getText();
		System.out.println(acttualFileName);

	}

	@AfterMethod
	void close() {
		PredefinedActions.closeAllBrowser();
	}

}
