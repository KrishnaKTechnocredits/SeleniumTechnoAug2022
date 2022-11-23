//Assignment:8

//Script 1: Login to application & update the personal information

//1. launch your orange HRM site
//2. Login with valid credentials
//3. Click on my info tab & Update the require details & click on Save button
//4. Validate Successfully Updated message on page
//5. Refresh the page & validate the updated name

package Titiksha_selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login_Page {
	
	WebDriver driver;
	PropertyFileReader prop;
	@BeforeMethod
	void setup(){
	prop=new PropertyFileReader("src/Titiksha_selenium/organgeHRM.properties");
	System.out.println("open organge site");
	driver=PredefinedActions.start(prop.getvalue("Application_url"));
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	void orangeHRMLogin() throws InterruptedException {
	//2. Login with valid credentials
	System.out.println("Login with valid credentials");
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getvalue("Username"));
	System.out.println("Testcase 1 : Userid send");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getvalue("Password"));
	System.out.println("Testcase 2 : Password send");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println("Testcase 3 : Click button pressed");
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 //3.a press Employee management button
	
	driver.findElement(By.xpath("//li[@id='left_menu_item_30']")).click();
	System.out.println("Testcase 4 : Click on Employee management");
	
	//3.b Click on my info tab
	driver.findElement(By.xpath("//div[@class='top-level-menu-item-container']//a[@class='top-level-menu-item' and @href='#/pim/my_info']")).click();
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	
	
	//4. Update the require details
	System.out.println("Firstname updated");
	driver.findElement(By.xpath("//input[@id='firstName']")).clear();
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(prop.getvalue("FirstName"));
	
	System.out.println("Lastname updated");
	driver.findElement(By.xpath("//input[@id='lastName']")).clear();
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(prop.getvalue("LastName"));
	
	System.out.println("Dateofbirth updated");
	driver.findElement(By.xpath("//input[@id='emp_birthday']")).clear();
	driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(prop.getvalue("Date_of_Birth"));
	Thread.sleep(2000);
	
	System.out.println("Maritalstatus updated");
	driver.findElement(By.id("emp_marital_status_inputfileddiv")).click();
	driver.findElement(By.xpath("//input[@class='select-dropdown' and @value='Single']")).click();
	
	//Press submit button
	Thread.sleep(1000);
	System.out.print("Submit button pressed");
	driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']/button[@type='submit']")).click();
	
	//Validate mesasge
	String actuallMessage=driver.findElement(By.xpath("//div[@class='toast toast-success']")).getText();
	String expectedMessage=prop.getvalue("message");
	Assert.assertEquals(expectedMessage,actuallMessage);
	System.out.println("Testcase 5 : Pass");
	
	//refreshing page
	driver.navigate().refresh();
	System.out.println("Testcase 6 : Page refreshed");}
	
	//@AfterMethod
	//public void tearDown() {
	//	PredefinedActions.closeBrowser();
	//System.out.println("Testcase 7 :Browser closed");
}


