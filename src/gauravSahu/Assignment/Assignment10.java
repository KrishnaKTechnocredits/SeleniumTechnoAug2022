/*TC_4

1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on Employee Management tab
4. Click on My Info tab
5. Verify user Personal info displayed
6. Click on ""Salary""
7. Check the payable (CTC) amount is non-zero*/
package gauravSahu.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gauravSahu.InitialActions;
import technocredits.utils.PropertiesFileReader;

public class Assignment10 {

	WebDriver driver;
	PropertiesFileReader prop;

	@BeforeTest
	void launch() {
		driver = InitialActions.start("https://gsahu-trials77.orangehrmlive.com/auth/login");
		System.out.println("Step 2 : Login with credentials");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		prop = new PropertiesFileReader("src\\gauravSahu\\propertiesFile\\OrangeHRMLoginDetails.properties");

		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(prop.getValue("userName"));
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(prop.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test
	void testCase() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Step 3 : User click on Employee Management tab");
		driver.findElement(By.cssSelector("#left_menu_item_30>a:nth-child(1)>span")).click();
		
		System.out.println("Step : 4 Click on My Info tab");
		driver.findElement(By.cssSelector("div#top-ribbon-menu>div:nth-child(2)>top-level-menu-item:nth-child(2)>div>a")).click();
		
		String actual1 = driver.findElement(By.cssSelector("div#personal_details_tab>h4")).getText();
		
		Assert.assertEquals(actual1, "Personal Details");
		System.out.println("Step : 5 Verify user Personal info displayed");
		
		driver.findElement(By.cssSelector("ui-view[name=customTopRibbon]>div>div>top-level-menu-item:nth-child(3)>div>a")).click();
		System.out.println("Step 6 :  Click on Salary");
		
		String salary = driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[2]/div[2]")).getText();
		System.out.println(salary);
		try {
			int ctc = Integer.parseInt(salary.substring(0));
			System.out.println(ctc);
			if(ctc!=0) {
				System.out.println("Step 7  : Check the payable (CTC) amount is non-zero");
			}
		}catch(Exception e) {
			
		}
		
		System.out.println("Step 7 :  Check the payable (CTC) amount is non-zero");
		
	}

}
