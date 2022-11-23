/*Assignment:9

Script 2: Upload doc and validate it's uploaded

1. launch your orange HRM site
2. Login with valid credentials
3. Click on Employee Management tab from left side
4. Click on my info tab
4. scroll down to the page
5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
6. Click on save button
7. vaidate the same file uploaded & type of file is aslo correct
8. Your name should be displayed under Added by colum name*/

package nilamP.orangeHRM;
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
import org.testng.annotations.Test;


import nilamP.predefinedFunctions.OpenBrowser;

public class TestCase2 {
	WebDriver driver;
	//PropertiesReadFile Prop = new PropertiesReadFile("src/basic/orangeHrm/personalinfo.properties");

	@Test
	public void LogintoWebsite() throws Exception {
		driver = OpenBrowser.start("https://neelamp-trials77.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("1. launch orange HRM site");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(("Admin"));
		System.out.println("Enter Username");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(("H0aC6sNdL@"));
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		System.out.println("Click submit button");
		Thread.sleep(5000);

		if (driver.getTitle().equals("Employee Management")) {
			System.out.println("Pass - Login successfull");
		} else {
			System.out.println("Fail - Unsuccessfull login");
		}
	}

	@Test
	public void UploadFile() throws Exception {
		driver.findElement(By.xpath("//a[@ui-sref='pim.my_info']")).click();
		System.out.println("STEP  - Click on my info tab.");

		Thread.sleep(10000);

		WebElement attachedmentElement = driver.findElement(By.xpath("//div[@ng-if='!attachmentsCtrl.isOxd']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", attachedmentElement);
		System.out.println("STEP  - Scroll down to the page attachement.");

		driver.findElement(By.xpath("//a[@ng-click='attachmentsCtrl.addAttachments()']")).click();
		System.out.println("STEP  - Click on add button under attachment.");

		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//span[@ng-if='!form.attachmentExists']/input[@id='filename']"))).build().perform();
		System.out.println("STEP  - Click on browse button on attachment dailog box.");
		Thread.sleep(3000);

		StringSelection ss = new StringSelection("C:\\Users\\lenovo\\Downloads\\fileuploadsample.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		System.out.println("STEP  - Copy file path.");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("STEP  - Copy file path ");

		action.click(driver.findElement(By.xpath("//button[@id='modal-save-button']"))).build().perform();
		System.out.println("STEP - Click on SAVE button on attachedment.");
		
	}

	
}

