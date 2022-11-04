package HindaviIngle.PropertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HindaviIngle.base.PredefinedActions;

public class FacebookSignUp {
	
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
	System.out.println("Step1: Navigate to  https://www.facebook.com");
	driver=PredefinedActions.start("https://www.facebook.com/");
	}
	@Test
	public void readDetailsfromPropertyFile() throws IOException, InterruptedException {
	
	System.out.println("Step2: Click on \"Create New Account\"");
	driver.findElement(By.xpath("//div[@id='globalContainer']//div/form/div[5]//a[@role='button']")).click();
	File file=new File("D:\\TechnoCredit\\workspace\\Selenium_Oct22\\SeleniumTechnoAug2022\\src\\HindaviIngle\\PropertyFile\\userdetails");
	FileInputStream fileInput=new FileInputStream(file);
	Properties prop=new Properties();
	prop.load(fileInput);
	Thread.sleep(3000);
	
	System.out.println("Step3: Fill the details using Properties file");
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getProperty("lastName"));
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(prop.getProperty("mobileNumber"));
	Select selectDay=new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
	selectDay.selectByValue(prop.getProperty("Day"));
	Select selectMonth=new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
	selectMonth.selectByVisibleText(prop.getProperty("Month"));
	Select selectYear=new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
	selectYear.selectByVisibleText(prop.getProperty("Year"));
	
	System.out.println("Step4: Click on radio button");
	driver.findElement(By.xpath("//span[@data-name='gender_wrapper']/span[1]/label[1]")).click();
	
	System.out.println("Step5: Click on submit button");
	driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	driver.close();
		
	}

}
