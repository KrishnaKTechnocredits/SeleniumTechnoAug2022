package shraddhaRekhate.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shraddhaRekhate.PredifinedActions;
import shraddhaRekhate.propertyFIleReading.PropertiesFileReader;

public class OrangeHrm {
  WebDriver driver;
  PropertiesFileReader prop=new PropertiesFileReader("src/shraddhaRekhate/orangehrm/orangehrm.properties");
  
  @BeforeMethod
  public void setup() {
	  System.out.println("LAunch browser and hit url");
	  driver=PredifinedActions.start(prop.getValue("applicationURL"));
	  driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")), TimeUnit.SECONDS);
	  System.out.println("Navigate to orange hrm");
  }
  
  @Test
  public void doLoginOnOrangeHRM() {
	  
	  System.out.println("Enter userName");
	  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
	  System.out.println("Enter password");
	  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
	  System.out.println("Click on login button");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  String expectedTitle="Employee Management";
	  String actualTitle=driver.getTitle();
	  if(expectedTitle.equals(actualTitle)) {
		  System.out.println("pass");
	  }else {
		  System.out.println("fail");
	  }
	  
	  System.out.println("Cick on My Info tab");
	  WebElement e=driver.findElement(By.xpath("//a[@class='top-level-menu-item'][@ui-sref='pim.my_info']"));
	  e.click();
	  
//	  System.out.println("Find personal details tab");
//	  driver.findElement(By.xpath("//a[@class='top-level-menu-item active'][@ui-sref='pim.employees.profile.personal_details']"));

	  System.out.println("Enter fName and lName");
	  WebElement fNameElement=driver.findElement(By.xpath("//input[@id='firstName']"));
	  fNameElement.clear();
	  driver.findElement(By.xpath("//input[@id='firstName'][@type='text']")).sendKeys("Shraddha");
	  driver.findElement(By.xpath("//input[@id='lastName']")).clear();
	  driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Rekhate");
	  
	  System.out.println("Enter Emp ID");
	  driver.findElement(By.xpath("//input[@id='employeeId'][@type='text']")).sendKeys("5432");
	  
	  System.out.println("Click on save button");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  System.out.println("VAlidate successfully updated msg");
	  String actual=driver.findElement(By.xpath("//div[@class='toast toast-success']")).getText();
	  String expected="Successfully Updated";
	  Assert.assertEquals(actual, expected);
	  
	  System.out.println("Refresh page and validate the updated name");
	  driver.navigate().refresh();
	  
	  System.out.println("VAlidate updated name");
	  String expectedName="Shraddha Rekhate";
	  String actualName=driver.findElement(By.xpath("//a[text()='Shraddha Rekhate']")).getText();
	  Assert.assertEquals(actualName, expectedName);
	  }
}
