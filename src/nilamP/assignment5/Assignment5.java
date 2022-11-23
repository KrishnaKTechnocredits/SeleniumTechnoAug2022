
/*Assignment - 5 : 30th OCt'2022

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)*/

package nilamP.assignment5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment5 {
	@Test
	void m1() throws Exception {
		System.out.println("STP 1- Browser Launched");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 2 - Hit URl");
		driver.get("https://www.facebook.com/");
		System.out.println("STEP 3 -  Click on Create New Account");
		driver.findElement(By.xpath("//div[@class='_6ltg'][2]")).click();
		Thread.sleep(5000);

		PropertiesReadFile Prop = new PropertiesReadFile("C:\\Users\\lenovo\\Desktop\\Selenium\\Selenium_Automations\\SeleniumTechnoAug2022\\src\\nilamP\\assignment5\\facebook.properties");
		// *[@name='firstname'] //input[@name='firstname']
		// //div[@id='fullname_field']/div/div/div/input
		// //div[@id='fullname_field']/div/div[1]/div/input
		// div[@class='clearfix _58mh']/div/div/input
		System.out.println("Step3: Enter first name");
		driver.findElement(By.xpath("//div[@id='fullname_field']/div/div/div/input"))
				.sendKeys(Prop.getValue("firstname"));

		System.out.println("STEP: Enter last name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Prop.getValue("lastname"));

		System.out.println("STEP: Enter email");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(Prop.getValue("email"));

		System.out.println("STEP: Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(Prop.getValue("newpasswd"));

		System.out.println("STEP: Select Birth Day");
		WebElement birthDay = driver.findElement(By.xpath("//select[@id='day']"));
		Select selectBirthDay = new Select(birthDay);
		selectBirthDay.selectByVisibleText(Prop.getValue("day"));

		System.out.println("STEP: Select Birth Month");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectBirthMonth = new Select(birthMonth);
		selectBirthMonth.selectByVisibleText(Prop.getValue("month"));

		System.out.println("STEP: Select Birth Year");
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectBirthYear = new Select(birthYear);
		selectBirthYear.selectByVisibleText(Prop.getValue("year"));

		System.out.println("STEP: Select Gender");
		WebElement element = driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
		String gender = element.getText();
		if (gender.equals(Prop.getValue("gender"))) {
			element.click();
			Thread.sleep(2000);
		}

		driver.close();

	}
}
