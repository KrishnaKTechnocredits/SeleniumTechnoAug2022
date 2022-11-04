/*Assignment No 8 : 2nd Nov 2022

Script 1: Create Login script & complete first Test case from below excel file
https://docs.google.com/spreadsheets/d/1fXspjL_tJyOJLp29CGtYmd3yby1DlNd9TNp0yTiNqxY/edit#gid=1513189356

Task: convert your Thread.sleep() to implict wait
"1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & Update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name" */

package gauravSahu.Assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gauravSahu.InitialActions;
import technocredits.utils.PropertiesFileReader;

public class Assignment8A {

	WebDriver driver;

	@BeforeMethod
	void launchUrl() throws IOException {
		driver = InitialActions.start("https://gsahu-trials77.orangehrmlive.com/auth/login");
		System.out.println("Step 2 : Login with credentials");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PropertiesFileReader prop = new PropertiesFileReader("src\\gauravSahu\\propertiesFile\\OrangeHRMLoginDetails.properties");
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("userName"));
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//2nd Method to read properties file
		
		/*File file = new File("src\\\\gauravSahu\\\\propertiesFile\\\\OrangeHRMLoginDetails.properties");
		FileInputStream input = new FileInputStream(file);
		Properties prop2 = new Properties();
		prop2.load(input);
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop2.getProperty("userName"));
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop2.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		*/
	}

	@Test
	void clickMyInfo() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String pageTitle = driver.getTitle();
		String expectedTitle = "Employee Management";
		Assert.assertEquals(pageTitle, expectedTitle);
		System.out.println("Redirected to correct page");

		driver.findElement(By.xpath("//div[@class='top-ribbon-menu-items consume-leftover-space']/top-level-menu-item[2]//a")).click();
		
		PropertiesFileReader propInfo = new PropertiesFileReader("src\\gauravSahu\\propertiesFile\\OrangeHRMInfoDetails.properties");
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.clear();
		firstName.sendKeys(propInfo.getValue("firstName"));
		
		WebElement middleName = driver.findElement(By.xpath("//input[@id='middleName']"));
		middleName.clear();
		middleName.sendKeys(propInfo.getValue("middleName"));
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys(propInfo.getValue("lastName"));
		
		WebElement employeeId = driver.findElement(By.xpath("//input[@id='employeeId']"));
		employeeId.clear();
		employeeId.sendKeys(propInfo.getValue("employeeId"));
		
		driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id=\"emp_marital_status_inputfileddiv\"]//li[2]/span")).click();
		
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv'] //li[3]/span")).click();
		
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv'] //li/span[text()='Indian']")).click();
		
		driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']")).clear();
		driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']")).sendKeys(propInfo.getValue("licenseExpiry"));
		
		driver.findElement(By.xpath("//input[@id='employeeId']")).clear();
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(propInfo.getValue("employeeId"));
	
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).clear();
		driver.findElement(By.xpath("//input[@id='emp_birthday']")).sendKeys(propInfo.getValue("dob"));
		
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']")).click();
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//li/span[text()='Asian']")).click();
		System.out.println("Step 3 : Required Details updated");
		
		driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']/button")).click();
		
		String expectedmsg = "Successfully Updated";
		String actualmsg = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualmsg, expectedmsg, "::" +  actualmsg);
		System.out.println("Step 4 :  Successfully Updated message on page");
		
		driver.navigate().refresh();
		
		WebElement actualname = driver.findElement(By.xpath("//a[@class='name']"));
		String actualname1 = actualname.getText();
		String expectedname1 = propInfo.getValue("firstName") + " " + propInfo.getValue("lastName");
		Assert.assertEquals(actualname1, expectedname1, "::"  + actualname1);
		System.out.println("Step : 5: Refresh the page & validate the updated name");
	}
	
	@AfterMethod
	void close() throws InterruptedException {
		Thread.sleep(5000);
		InitialActions.close();
	}
	
	

}
