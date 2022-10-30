package shubhamGupta.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import shubhamGupta.base.PredefinedActions;
import shubhamGupta.utils.PropertyFileReader;

public class Assignment5_PropertiesFilePractice {

	Select dropdown;

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step 1: Launch Chrome Browser and open URL");
		driver = PredefinedActions.start("https://www.facebook.com/");
	}

	@Test
	public void fillFacebookSignupForm() throws InterruptedException {
		System.out.println("Step2: Click on Create new account button.");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);
		PropertyFileReader prop = new PropertyFileReader("src\\shubhamGupta\\Files\\login.properties");

		System.out.println("Step3: Enter first name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(prop.getValue("firstName"));

		System.out.println("Step4: Enter surname name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getValue("lastName"));

		System.out.println("Step5: Enter email Id");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(prop.getValue("emailId"));

		System.out.println("Step6: Re enter email Id");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(prop.getValue("emailId"));

		System.out.println("Step7: Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(prop.getValue("password"));

		System.out.println("Step8: Select date");

		WebElement date = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		dropdown = new Select(date);
		dropdown.selectByVisibleText(prop.getValue("date"));

		System.out.println("Step9: Select Month");
		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		dropdown = new Select(month);
		dropdown.selectByVisibleText(prop.getValue("month"));

		System.out.println("Step10: Select Year");
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		dropdown = new Select(year);
		dropdown.selectByVisibleText(prop.getValue("year"));

		System.out.println("Step11: Select Gender");
		driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//span/label[text()=\"Male\"]")).click();
	}
	
	@AfterTest
	public void closeBrowser() {
		PredefinedActions.closeAllBrowsers();
	}
}
