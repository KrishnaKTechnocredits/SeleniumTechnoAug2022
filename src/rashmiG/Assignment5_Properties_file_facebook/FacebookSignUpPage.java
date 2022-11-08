/*Assignment - 5 : 30th OCt'2022

Scenario: fill the facebook's signup page using properties file (create separate class to read properties file)

1. Navigate to https://www.facebook.com/
2. Click on "Create New Account"
3. Fill the details using Properties file (text area, drop down, radio buttons)


Facebook - log in or sign up
https://www.facebook.com*/

package rashmiG.Assignment5_Properties_file_facebook;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rashmiG.Base.PredefinedActions;
import rashmiG.utils.PropertiesFileReader;

public class FacebookSignUpPage {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit url");
		driver = PredefinedActions.start("https://www.facebook.com/");
	}

	@Test
	public void doSignUp() throws InterruptedException {
		System.out.println("STEP - click on create account button");
		driver.findElement(By.xpath("//form/div[5]/a")).click();
		Thread.sleep(2000);

//	File file = new File(".//src/rashmiG/Assignment5_Properties_file_facebook/signUp.properties");
//	FileInputStream input = new FileInputStream(file);	
//	System.out.println(file.exists());//check if file is located in specified path or not
//	Properties loginDetails = new Properties();
//	loginDetails.load(input);//load the file

		PropertiesFileReader prop = new PropertiesFileReader(".//src/rashmiG/Assignment5_Properties_file_facebook/signUp.properties");

		System.out.println("Step - Enter fname");
		driver.findElement(By.xpath("//div[@id='reg_form_box']/div[1]/div[1]/div[1]/div/input"))
				.sendKeys(prop.getValue("fname"));
		// System.out.println(loginDetails.getProperty("fname"));
		System.out.println("STEP - Enter last name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getValue("sName"));
		System.out.println("STEP - enter mobie no");
		driver.findElement(By.xpath("//input[@name='reg_email__']"))
				.sendKeys(prop.getValue("mobile_no"));
		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']"))
				.sendKeys(prop.getValue("passwrd"));

		System.out.println("Enter birthDay");
		WebElement birthDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select birthDayDD = new Select(birthDay);
		birthDayDD.selectByVisibleText(prop.getValue("Bdate"));

		System.out.println("Enter birthMonth");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select birthMonthDD = new Select(birthMonth);
		birthMonthDD.selectByVisibleText(prop.getValue("Month"));

		System.out.println("Enter birthYear");
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select birthYearDD = new Select(birthYear);
		birthYearDD.selectByVisibleText(prop.getValue("Year"));

	
		System.out.println("STEP - select gender");
		WebElement element = driver.findElement(By.xpath("//div[7]/span/span[1]"));
		String gender = element.getText();
		if (gender.equals(prop.getValue("Gender"))) {
			element.click();
		}
		Thread.sleep(2000);
		/*System.out.println("STEP - select gender");
		List<WebElement> listOfElements =driver.findElements(By.xpath("//span[@data-name='gender_wrapper']//span"));
		for(WebElement e : listOfElements) {
			if(e.getText().equalsIgnoreCase(prop.getValue("Gender")))
				e.click();
			Thread.sleep(2000);
		}*/
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}