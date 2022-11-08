package shubhamGupta.test;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import shubhamGupta.base.PredefinedActions;

public class Assignment9_uploadFiles {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowserDoLogin() {
		System.out.println("Step 1: Launch Chrome Browser and open URL");
		driver = PredefinedActions.start("https://shubgupta-trials77.orangehrmlive.com/");

		System.out.println("Step2: Enter Credentials for Login");
		PredefinedActions.loginToOrangeHRM();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Employee Management";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Expected Title is: " + ExpectedTitle);
		System.out.println("Actual Title is: " + ActualTitle);
		System.out.println("Login Successful");

	}

	@Test
	public void uploadFileAndVerifyIt() throws AWTException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		//clicking on Employee Management tab
		System.out.println("Step3: Click on Employee Management tab from left side");
		driver.findElement(By.xpath("(//a[@data-tooltip='Employee Management'] )[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@class='sortable row-employee-id']")));

		//Clicking on My Info tab
		System.out.println("Step4: Click on my info tab");
		driver.findElement(By.xpath("//div[@id='top_level_menu_item_menu_item_40']//a[@href='#/pim/my_info']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='firstName']")));
		;
		WebElement attachment = driver.findElement(By.xpath("//span[text()='Attachments']"));

		// Scrolling till attachment tabs
		System.out.println("Step5: scroll down to the page");
		PredefinedActions.scrollTillElement(attachment);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")));
		
		// Clicking on Add button
		System.out.println("Step6: Click on add button under attachment, browse any file and upload it");
		WebElement add = driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", add);

		// Attachment Modal
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@data-field='filename']")));

		// click on Browse Button
		WebElement browser = driver.findElement(By.xpath("//input[@id='filename']"));
		Actions act = new Actions(driver);
		act.click(browser).build().perform();

		// upload file
		PredefinedActions.uploadFile("C:\\personal\\Selenium recordings\\test.xlsx");
		System.out.println("file uploaded");

		// send data in description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("test file uploaded");

		// Click on save button
		System.out.println("Step7: Click on save button.");
		driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));

		// Capturing save message and doing assert
		
		String confirmationMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		String expectedMessage = "Successfully Saved";
		Assert.assertEquals(confirmationMessage, expectedMessage);

		// Checking if correct file is uploaded or not
		System.out.println("Step8: validate the same file uploaded & type of file is aslo correct");
		String uploadedFileName = driver.findElement(By.xpath("(//span[@class='break-word'])[1]")).getText();
		String fileName = "test.xlsx";
		Assert.assertEquals(fileName, uploadedFileName);
		System.out.println("Uploaded file is correct");

		// Checking if file is uploaded correct format
		String uploadedFileformant = driver.findElement(By.xpath("(//td[@type='listField.type'])[4]")).getText();
		String fileformat = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		Assert.assertEquals(uploadedFileformant, fileformat);

		System.out.println("File type is correct");

		// Checking uploader name
		System.out.println("Step9: Verify your name should be displayed under Added by colum name");
		String uploaderName = driver.findElement(By.xpath("(//td[@type='listField.type'])[6]")).getText();
		String username = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(username, uploaderName);
		System.out.println("Uploader name is correct and is: " + uploaderName);
		System.out.println("Test case passed");

	}

	@AfterMethod

	public void closeBrowser() {
		PredefinedActions.closeAllBrowsers();
		System.out.println("Browser is closed");

	}
}
