package nehanig;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment10TC4 {
	WebDriver driver;
	PropertiesFileReader property = new PropertiesFileReader("src\\nehanig\\OrangeHRM.properties");

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start("https://ngupta-trials77.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	}

	@Test
	void testCase4() throws InterruptedException, IOException {
		File file = new File("src\\nehanig\\OrangeHRM.properties");
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		Thread.sleep(3000);

		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");

			System.out.println("Step: Click on my info tab & Update the require details & click on Save button");
			driver.findElement(By.xpath("//a[@class='top-level-menu-item'][@ui-sref='pim.my_info']")).click();

			System.out.println("Step: Verify user Personal info displayed");
			WebDriverWait wait = new WebDriverWait(driver, 9000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));

			Thread.sleep(2000);

			if (driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed()) {
				System.out.println("Personal details are displaying");
			} else {
				System.out.println("Personal details are not displaying");
			}

			System.out.println("Step: Click on SALARY");
			Thread.sleep(2500);
			driver.findElement(By.xpath("(//a[@class='top-level-menu-item'])[2]")).click();

			System.out.println("tab salary clicked");
			System.out.println("Step: Check the payable (CTC) amount is non-zero");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='payGrade']")));
			String actualCTC = driver
					.findElement(By.xpath("//div[@translate='Cost to the Company']/following-sibling::div")).getText();
			System.out.println(actualCTC);
			Thread.sleep(2000);
			String expectedCTC = "$168,500.00";
			Assert.assertEquals(actualCTC, expectedCTC, "CTC value check");

			for (int index = 0; index < actualCTC.length(); index++) {
				char ch = actualCTC.charAt(index);
				if (Character.isDigit(ch)) {
					int num = Integer.parseInt("" + ch);
					if (num > 0) {
						System.out.println("Salary is non zero");
						break;
					}
				}
			}

		}

	}

	@AfterTest
	void closeChromeBrowser() {
		PredefinedActions.closeAllBrowser();
	}
}
