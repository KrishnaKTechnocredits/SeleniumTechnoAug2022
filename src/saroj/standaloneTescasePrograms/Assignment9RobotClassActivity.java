package saroj.standaloneTescasePrograms;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saroj.utils.PropertyFilesReader;

public class Assignment9RobotClassActivity {

	WebDriver driver;
	PropertyFilesReader prop = new PropertyFilesReader("src/saroj/propertiesFiles/orangeHRMLDetails.properties");

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step - Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		System.out.println("Step - Launch Orange HRM Browser");
		driver.get("https://skumari-trials77.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void OrangeHrmLogin() throws InterruptedException, AWTException {
		System.out.println("Step - Enter User name");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(prop.getValue("Username"));
		System.out.println("Step - Enter Password");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(prop.getValue("Password"));
		System.out.println("Step - Press Submit button");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login failed");
		}

		System.out.println("Step - Click on Employee Management tab");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@id='left_menu_item_30']"))))
				.click();

		System.out.println("Step - Click on my info tab");
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='top_level_menu_item_menu_item_40']"))));
		driver.findElement(By.xpath("//div[@id='top_level_menu_item_menu_item_40']")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		System.out.println("Step - scroll down to the page");
		WebElement element = driver.findElement(By.xpath("//a[text()='Add']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("Step - Click on Add button under attachment");
		element.click();

		System.out.println("Step - Click on Browse button");
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//input[@id='filename']"))).build().perform();

		System.out.println("Step - browse any file");
		StringSelection ss = new StringSelection("C:\\Users\\dprat\\Downloads\\Java-Notes (3).txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(3000);
		Robot robot = new Robot();

		System.out.println("Press control V key");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		System.out.println("Release key");
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Press Enter key");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("Step - Click on save button");

		driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();

		System.out.println("Scroll to Add button");
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("//span[@class='break-word'][1]"));
		String str1 = ele.getText();
		String str2 = "Java-Notes(3).txt";
		Assert.assertEquals(str1, str2);
		System.out.println("Correct file uploaded");

		System.out.println("Step - Your name should be displayed under Added by column name");
		String actualName = driver.findElement(By.xpath("//td[@name='listField.name'][6]")).getText();
		String expectedName = driver.findElement(By.xpath("//a[@class='name']")).getText();
		Assert.assertEquals(actualName, expectedName);
		System.out.println("Name Matched");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
