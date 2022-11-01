package Sohail;

import java.io.*;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_5 {
	@Test
	void launchBroweser() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class=\"_6ltg\"][2]/a")).click();
		File file = new File("G:\\Technocredits\\Git\\SeleniumTechnoAug2022\\src\\Sohail\\facebook.properties");
		FileInputStream fileinput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileinput);
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.name("lastname")).sendKeys(prop.getProperty("surname"));
		driver.findElement(By.name("reg_email__")).sendKeys(prop.getProperty("mobileNumber"));
		driver.findElement(By.name("reg_passwd__")).sendKeys("password");
		Select select = new Select(driver.findElement(By.name("birthday_day")));
		select.selectByValue(prop.getProperty("day"));
		Select selectMonth = new Select(driver.findElement(By.name("birthday_month")));
		selectMonth.selectByVisibleText(prop.getProperty("month"));
		Select selectYear = new Select(driver.findElement(By.name("birthday_year")));
		selectYear.selectByVisibleText(prop.getProperty("year"));
		driver.findElement(By.xpath("//span[@class=\"_5k_2 _5dba\"][2]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
