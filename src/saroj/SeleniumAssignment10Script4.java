package saroj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saroj.utils.PropertyFilesReader;

public class SeleniumAssignment10Script4 {

	WebDriver driver;
	PropertyFilesReader prop = new PropertyFilesReader("src/saroj/propertiesFiles/orangeHRMLDetails.properties");

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step - Launch oranage HRM URL");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get("https://skumari-trials77.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void login() throws InterruptedException {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Step - Click on Employee Management tab from left side");
		driver.findElement(By.xpath("//li[@id='left_menu_item_30']")).click();

		System.out.println("Step - Click on my info tab");
		driver.findElement(By.xpath("//div[@id='top_level_menu_item_menu_item_40']")).click();

		System.out.println("Step - Verify user Personal info displayed");
		if (driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed()) {
			System.out.println("Personal info displayed");
		} else {
			System.out.println("Personal info not displayed");
		}
		System.out.println("Step - Click on Salary");
		driver.findElement(By.xpath("//a[text()='Salary ']")).click();

		System.out.println("Step - Check the payable (CTC) amount is non-zero");
		Thread.sleep(5000);
		WebElement elesalary = driver
				.findElement(By.xpath("(//div[@class='summary-card-column summary-card-right'])[1]"));
		String amt = elesalary.getText();
		System.out.println(amt);
		String ctcamt = "";
		for (int index = 0; index < amt.length(); index++) {
			char ch = amt.charAt(index);
			if (Character.isDigit(ch)) {
				ctcamt = ctcamt + ch;
			}
		}
		int ctcamtNum = Integer.parseInt(ctcamt);
		if (ctcamtNum != 0) {
			System.out.println("  Employee's CTC amount is non zero: " + ctcamtNum);
		} else {
			System.out.println("  Employee's CTC amount is zero");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
