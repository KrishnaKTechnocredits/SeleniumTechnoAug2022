package nilamP.orangeHRM;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import nilamP.predefinedFunctions.OpenBrowser;

public class TestCase1 {
	WebDriver driver;
	PropertiesReadFile Prop = new PropertiesReadFile("src/nilamP/orangeHRM/personalInfo.properties");

	@Test
	public void LogintoWebsite() throws Exception {
		driver = OpenBrowser.start("https://neelamp-trials77.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("1. launch orange HRM site");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Prop.getValue("username"));
		System.out.println("Enter Username");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Prop.getValue("passwd"));
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		System.out.println("Click submit button");
		Thread.sleep(5000);

		if (driver.getTitle().equals("Employee Management")) {
			System.out.println("Pass - Login successfull");
		} else {
			System.out.println("Fail - Unsuccessfull login");
		}
	}

	@Test
	public void PersonalDetails() throws Exception {
		driver.findElement(By.xpath("//div[@id='top_level_menu_item_menu_item_40']")).click();
		System.out.println("Click My Info tab");
		// Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(Prop.getValue("name"));
		System.out.println("STEP - Entered First Name");
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Prop.getValue("lname"));
		System.out.println("STEP - Entered Last Name");
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).clear();
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(Prop.getValue("dob"));
		System.out.println("STEP - Entered DOB");
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//input")).click();
		System.out.println("STEP - Nationality selected");
		driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']")).clear();
		System.out.println("STEP - license expiry date cleared");
		driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[6]']//button")).click();
		System.out.println("STEP - click on save button");
		String message = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		if (message.equals("Successfully Updated"))
			System.out.println("Pass - message is displayed");
		else
			System.out.println("message not displayed");

		System.out.println("STEP - Refresh the page");
		driver.navigate().refresh();

		String actualUpdatedName = driver.findElement(By.xpath("//a[@href='/client/#/pim/my_info']")).getText();
		String expectedUpdatedName = Prop.getValue("name") + " " + Prop.getValue("lname");
		if (actualUpdatedName.equals(expectedUpdatedName)) {
			System.out.println("Pass - page refreshed  and data updated");
		} else
			System.out.println("fail - Data not updated");

	}
}

