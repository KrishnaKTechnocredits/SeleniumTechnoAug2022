/*Assignment No 8 : 2nd Nov 2022

Script 1: Create Login script & complete first Test case from below excel file
https://docs.google.com/spreadsheets/d/1fXspjL_tJyOJLp29CGtYmd3yby1DlNd9TNp0yTiNqxY/edit#gid=1513189356

1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name

Task: convert your Thread.sleep() to implict wait
*/

package sanket.orangeHRM_scripts;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.PredefinedActions;
import sanket.utils.ProprtiesFileReaderUtil;

public class Assignment8UploadDocRobotOrangeHRMTestScript2 {

	WebDriver driver;
	ProprtiesFileReaderUtil prop = new ProprtiesFileReaderUtil("src/sanket/orangeHRM_scripts/orangehrm.properties");

	@BeforeMethod
	public void preTestSetup() throws Exception {

		System.out.println("STEP 1 - Launch Chrome Browser and OrangeHRM URL.");
		driver = PredefinedActions.start(prop.getValue("loginUrl"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")), TimeUnit.SECONDS);
		System.out.println("STEP 2 - Nevigate to Oranage URL.");
	}

	@Test
	public void fileUploadOnOrangeHrm() throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
		System.out.println("STEP 3 - UserName is entered.");

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
		System.out.println("STEP 4 - Password is entered.");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Employee Management";

		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("STEP 5 - Login successfully in Orange HRM.");

		driver.findElement(By.xpath("//a[@ui-sref='pim.my_info']")).click();
		System.out.println("STEP 6 - Click on my info tab.");

		Thread.sleep(10000);

		WebElement attachedmentElement = driver.findElement(By.xpath("//div[@ng-if='!attachmentsCtrl.isOxd']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", attachedmentElement);
		System.out.println("STEP 7 - Scroll down to the page attachement.");

		driver.findElement(By.xpath("//a[@ng-click='attachmentsCtrl.addAttachments()']")).click();
		System.out.println("STEP 8 - Click on add button under attachment.");

		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//span[@ng-if='!form.attachmentExists']/input[@id='filename']")))
				.build().perform();
		System.out.println("STEP 9 - Click on browse button on attachment dailog box.");
		Thread.sleep(3000);

		StringSelection ss = new StringSelection(
				"D:\\TechnoCredits\\August2022\\SeleniumTechnoAug2022\\src\\sanket\\orangeHRM_scripts\\SampleFileToUpload.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		System.out.println("STEP 10 - Copy file path.");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("STEP 11 - Copy file path on Windows UI.");

		action.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();
		System.out.println("STEP 12 - Click on SAVE button on attachedment.");

		String actualSaveFileName = driver.findElement(By.xpath("//a[@class='break-word']")).getText();
		String expectedSaveFileName = "SampleFileToUpload.pdf";

		Assert.assertEquals(expectedSaveFileName, actualSaveFileName);
		System.out.println("STEP 13 -  File Uploaded Successfully.");

	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("STEP 14 -  Browser close Successfully.");
		driver.quit();
	}
}