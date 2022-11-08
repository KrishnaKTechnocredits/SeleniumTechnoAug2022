package SwapnilMaheshwari.PropertyFile.Assignment5;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SwapnilMaheshwari.utils.PropertyFileReader;

public class FacebookLogin {
	WebDriver driver;

	@BeforeMethod
	public void BrowserOpen() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\SeleniumTechnoAug2022\\drivers\\chromedriver_106.exe");
		System.out.println("Step -Launch chrome browser");
		driver = new ChromeDriver();
		System.out.println("Step- Launch the URL");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test
	public void login() throws InterruptedException {
		System.out.println("Click on Create Account button");
		driver.findElement(By.xpath("//div[@class='_6ltg'][2]")).click();
		Thread.sleep(3000);
		
		PropertyFileReader Prop = new PropertyFileReader("src/SwapnilMaheshwari/propertiesFile/facebookLoginCredential.properties");
		
		System.out.println("Step- Enter First Name ");
		driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"))
				.sendKeys(Prop.getValue("FirstName"));
		Thread.sleep(2000);
		System.out.println("Step- Enter Last Name ");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Prop.getValue("LastName"));
		System.out.println("Step- Enter the Email id");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(Prop.getValue("EmailID"));
		Thread.sleep(3000);
		System.out.println("Step- Enter the Re Enter Email id");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(Prop.getValue("ReEnterEmailId"));
		System.out.println("Step- Enter the Password");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(Prop.getValue("Password"));
		
		System.out.println("Step-Select birth date");
		WebElement birthDate = driver.findElement(By.xpath("//select[@id='day']"));
		Select selectBirthDate = new Select(birthDate);
		selectBirthDate.selectByValue(Prop.getValue("dateOfBirth"));
		
		System.out.println("Step-Select birth month");
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText(Prop.getValue("month"));
		
		System.out.println("Step-Select birth year");
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText(Prop.getValue("year"));
		
		System.out.println("Select Gender");
		//driver.findElement(By.xpath("//input[@value='2']")).click();
		WebElement element=driver.findElement(By.xpath("//div[7]/span/span[2]"));
		Thread.sleep(3000);
		String actualText=element.getText();
		System.out.println("Actual Text:"+actualText);
		if(actualText.equals(Prop.getValue("gender"))) {
			element.click();
			Thread.sleep(2000);
		}
		System.out.println("Script completed");
	}
}
