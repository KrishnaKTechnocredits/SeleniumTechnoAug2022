/*Assignment No 8 : 2nd Nov 2022

Script 1: Create Login script & complete first Test case from below excel file
https://docs.google.com/spreadsheets/d/1fXspjL_tJyOJLp29CGtYmd3yby1DlNd9TNp0yTiNqxY/edit#gid=1513189356

1. launch your orange HRM site
2. Login with valid credentials
3. Click on my info tab & update the require details & click on Save button
4. Validate Successfully Updated message on page
5. Refresh the page & validate the updated name

Task: convert your Thread.sleep() to implict wait
*/

package sanket.orangeHRM_scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sanket.base.PredefinedActions;
import sanket.utils.ProprtiesFileReaderUtil;

public class Assignment8loginOrangeHRMTestScript1 {

   WebDriver driver;
   ProprtiesFileReaderUtil prop = new ProprtiesFileReaderUtil("src/sanket/orangeHRM_scripts/orangehrm.properties");

   @BeforeMethod
   public void preTestSetup() throws Exception {

      System.out.println("STEP 1 - Launch Chrome Browser and OrangeHRM URL.");
      driver = PredefinedActions.start(prop.getValue("loginUrl"));
      driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")), TimeUnit.SECONDS);
      System.out.println("STEP 2 - Nevigate to Oranage URL.");
   }

   @Test
   public void loginInOrangeHrm() {

      driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
      System.out.println("STEP 3 - UserName is entered.");

      driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
      System.out.println("STEP 4 - Password is entered.");

      driver.findElement(By.xpath("//button[@type='submit']")).click();

      String actualTitle = driver.getTitle();
      String expectedTitle = "Employee Management";

      Assert.assertEquals(expectedTitle, actualTitle);
      System.out.println("STEP 5 - Login successfully in Orange HRM.");

      driver.findElement(By.xpath("//a[@ui-sref='pim.my_info']")).click();
      System.out.println("STEP 6 - Click on my info tab.");
      driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("myInfoPageLoad")), TimeUnit.SECONDS);

      // Fill first name
      WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
      firstName.clear();
      firstName.sendKeys(prop.getValue("firstName"));

      // Fill middle name
      WebElement middleName = driver.findElement(By.xpath("//input[@id='middleName']"));
      middleName.clear();
      middleName.sendKeys(prop.getValue("middleName"));

      // Fill last name
      WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
      lastName.clear();
      lastName.sendKeys(prop.getValue("lastName"));

      // Fill employee ID
      WebElement employeeID = driver.findElement(By.xpath("//input[@id='employeeId']"));
      employeeID.clear();
      employeeID.sendKeys(prop.getValue("employeeID"));

      // Fill other id
      WebElement otherId = driver.findElement(By.xpath("//input[@id='otherId']"));
      otherId.clear();
      otherId.sendKeys(prop.getValue("otherID"));

      // Fill Date of Birth
      WebElement employeeBirthday = driver.findElement(By.xpath("//input[@id='emp_birthday']"));
      employeeBirthday.clear();
      employeeBirthday.sendKeys(prop.getValue("dateOfBirth"));

      // Select Marrital Status
      //		WebElement selectMarritalStatus = driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']"));
      //		Select selectMarritalStatusDropDown = new Select(selectMarritalStatus);
      //		selectMarritalStatusDropDown.selectByValue("Single");

      driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//input")).click();
      driver.findElement(By.xpath("//div[@id='emp_marital_status_inputfileddiv']//ul/li/span[text()='Single']")).click();

      // Select Gender
      //		WebElement selectGender = driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']"));
      //		Select selectGenderDropDown = new Select(selectGender);
      //		selectGenderDropDown.selectByValue("Male");

      driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//input")).click();
      driver.findElement(By.xpath("//div[@id='emp_gender_inputfileddiv']//ul/li/span[text()='Male']")).click();

      // Select Nationality
      //		WebElement selectNationality = driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']"));
      //		Select selectNationalityDropDown = new Select(selectNationality);
      //		selectNationalityDropDown.selectByValue("Indian");

      driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//input")).click();
      driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//ul/li/span[text()='Indian']")).click();

      // Fill Driver License
      WebElement driverLicense = driver.findElement(By.xpath("//input[@id='licenseNo']"));
      driverLicense.clear();
      driverLicense.sendKeys(prop.getValue("driversLicense"));

      // Fill License Expiry Date
      WebElement liceneseExpiry = driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']"));
      liceneseExpiry.clear();
      liceneseExpiry.sendKeys(prop.getValue("licenseExpiry"));

      // Select eeoRace
      //		WebElement selectEeoRace = driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']"));
      //		Select selectEeoRaceDropDown = new Select(selectEeoRace);
      //		selectEeoRaceDropDown.selectByValue("Asian");

      driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//input")).click();
      driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//ul/li/span[text()='Asian']")).click();
      System.out.println("STEP 7 - Update the require details");

      driver.findElement(By.xpath("//div[@class='form-group schema-form-submit right']/button[@type='submit']"))
         .click();
      System.out.println("STEP 8 - Click on Save button");

      String actualValidationMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
      String expectedValidationMessage = "Successfully Updated";
      Assert.assertEquals(expectedValidationMessage, actualValidationMessage);
      System.out.println("STEP 9 - Validated Successfully Updated message on page.");

      driver.navigate().refresh();
      System.out.println("STEP 10 - Refresh the Page.");

      String actualClientName = driver.findElement(By.xpath("//a[@href='/client/#/pim/my_info']")).getText();
      String expectedClientName = "Steve Barnette";
      Assert.assertEquals(expectedClientName, actualClientName);
      System.out.println("STEP 11 -  Validated the updated name successfully.");
   }

   @AfterTest
   public void closeBrowser() {
      driver.quit();
   }
}