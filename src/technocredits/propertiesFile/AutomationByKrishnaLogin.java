package technocredits.propertiesFile;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;
import technocredits.utils.PropertiesFileReader;

public class AutomationByKrishnaLogin {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start();

		System.out.println("STEP - Navigate to Demo Tables");
		Thread.sleep(2000);
	}

	@Test
	public void doLogin() throws InterruptedException {
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);

		PropertiesFileReader prop = new PropertiesFileReader("src/technocredits/propertiesFile/login.properties");

		driver.findElement(By.id("unameSignin")).sendKeys(prop.getValue("qa_userName"));
		driver.findElement(By.id("pwdSignin")).sendKeys(prop.getValue("qa_userPassword"));
	}

//	public static void main(String[] args) throws IOException {
//		File file = new File("src/technocredits/propertiesFile/login.properties");
//		FileInputStream input = new FileInputStream(file);
//		
//		Properties prop = new Properties();
//		prop.load(input);
//		
//		System.out.println(prop.getProperty("qa_userName"));
//		System.out.println(prop.getProperty("qa_userPassword"));
//	}

}
