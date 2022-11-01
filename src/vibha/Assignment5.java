package vibha;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import vibha.utils.PropertiesFileReader;

public class Assignment5 {

	public WebDriver driver;

	@BeforeMethod
	public void processDta() {
		
		System.out.println("STep:-1 launch browser and click url");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");

	}

	@Test
	public void fillFacebookSignUpDetails() throws InterruptedException {

		System.out.println("Step2: Click on Create New Account");
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();
		Thread.sleep(5000);
         
		System.out.println("Step3: Fill the details using properties file");
		PropertiesFileReader propertyDetails = new PropertiesFileReader(
				"src/vibha/File/Facebook.properties");

		System.out.println("Step4: Enter First name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(propertyDetails.getValue("firstName"));

		System.out.println("Step5: Enter Surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(propertyDetails.getValue("lastName"));

		System.out.println("Step6: Enter Email address");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(propertyDetails.getValue("emailId"));
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"))
				.sendKeys(propertyDetails.getValue("emailId"));

		System.out.println("Step7: Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(propertyDetails.getValue("password"));

		System.out.println("Step8: Enter Date of birth");
		WebElement element = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select select = new Select(element);
		select.selectByVisibleText(propertyDetails.getValue("date"));

		element = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		select = new Select(element);
		select.selectByVisibleText(propertyDetails.getValue("month"));

		element = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		select = new Select(element);
		select.selectByVisibleText(propertyDetails.getValue("year"));

		System.out.println("Step9: Select Gender");
		List<WebElement> genderOptions = driver.findElements(By.xpath("//label[@class='_58mt']"));
		for (WebElement gender : genderOptions) {
			if (gender.getText().equalsIgnoreCase(propertyDetails.getValue("gender"))) {
				gender.click();
			}
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}

