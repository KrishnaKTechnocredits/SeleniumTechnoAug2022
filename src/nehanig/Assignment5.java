package nehanig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class Assignment5 {

	@Test
	void launchBroweser() throws IOException, InterruptedException {
		WebDriver driver = PredefinedActions.start("https://www.facebook.com/");

		driver.findElement(By.xpath("//div[@class=\"_6ltg\"][2]/a")).click();
		File file = new File("src/nehanig/LoginFacebook.properties");
		System.out.println(file.exists());
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		Thread.sleep(3000);
		
		System.out.println("STEP - Fill details using properties file");
		System.out.println("STEP - Enter First Name");
		driver.findElement(By.name("firstname")).sendKeys(prop.getProperty("firstname"));
		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.name("lastname")).sendKeys(prop.getProperty("lastname"));
		System.out.println("STEP - Enter Email Address");
		driver.findElement(By.name("reg_email__")).sendKeys(prop.getProperty("email"));
		System.out.println("STEP - Enter Password");
		driver.findElement(By.name("reg_passwd__")).sendKeys("password");
		System.out.println("STEP - Enter Date Of Birth");
		Select select = new Select(driver.findElement(By.name("birthday_day")));
		select.selectByValue(prop.getProperty("birthday_day"));
		Select selectMonth = new Select(driver.findElement(By.name("birthday_month")));
		selectMonth.selectByVisibleText(prop.getProperty("birthday_month"));
		Select selectYear = new Select(driver.findElement(By.name("birthday_year")));
		selectYear.selectByVisibleText(prop.getProperty("birthday_year"));
		driver.findElement(By.xpath("//span[@class=\"_5k_2 _5dba\"][1]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}