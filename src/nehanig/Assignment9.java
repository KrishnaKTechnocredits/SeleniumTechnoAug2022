package nehanig;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment9 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.out.println("Step: Launch your OrangeHRM site");
		driver = PredefinedActions.start("https://ngupta-trials77.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

	@Test
	void testCaseUpload() throws InterruptedException, AWTException, IOException {

		File file = new File("src\\nehanig\\OrangeHRMCredentials");
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		Thread.sleep(3000);
		System.out.println("Step: Login your OrangeHRM site");
		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");

			System.out.println("Step: Click on my info tab");
			driver.findElement(By.xpath("//a[@class='top-level-menu-item'][@ui-sref='pim.my_info']")).click();

			System.out.println("Step: scroll down to the page");
			WebElement ele = driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"));
			PredefinedActions.scrollToElement(ele);

			System.out.println("Step: Click on add button under attachment, browse any file");
			driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")).click();

			Actions action = new Actions(driver);
			action.click(driver.findElement(By.id("filename"))).build().perform();

			StringSelection ss = new StringSelection("C:\\Users\\Hp\\Documents\\Colleen Hoover");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			action.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();

			Thread.sleep(3000);
			WebElement ele1 = driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"));
			PredefinedActions.scrollToElement(ele1);
			System.out.println("Step: Vaidate the same file uploaded & type of file is also correct");
			String actualFile = driver.findElement(By.xpath("//td[@name='listField.name'][1]")).getText();
			String expectedFile = "ColleenHoover.docx";
			Assert.assertEquals(actualFile, expectedFile);
			System.out.println("Same file is uploaded");

			String actualFileType = driver.findElement(By.xpath("//td[@name='listField.name'][4]")).getText();
			String expectedFileType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
			Assert.assertEquals(actualFileType, expectedFileType);
			System.out.println("File type is correct");

			System.out.println("Step: Your name should be displayed under column name");
			String actualName = driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
			String expectedName = driver.findElement(By.xpath("//a[@class='name']")).getText();
			Assert.assertEquals(actualName, expectedName);
			System.out.println("Name is displayed");

			String acttualFileName = driver
					.findElement(By.xpath("//span[@class='break-word'][text()='ColleenHoover.docx']")).getText();
			System.out.println(acttualFileName);

		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
