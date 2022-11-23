package rashmiG.orangeHrm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rashmiG.Base.PredefinedActions;
import rashmiG.utils.PropertiesFileReader;

public class Assignment10TC3AndTC4 {

	PropertiesFileReader prop = new PropertiesFileReader("src/rashmiG/orangeHrm/orangeHrm.properties");
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("STEP - Lanuch orange HRM site");
		driver = PredefinedActions.start(prop.getValue("applicationUrl"));
		System.out.println("STEP - Enter the userName");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));
		System.out.println("STEP - Enter the password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));
		System.out.println("STEP - Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")), TimeUnit.SECONDS);

	}

	@Test
	public void TC_3() throws InterruptedException {
		System.out.println("VERIFY - profile is displayed");
		WebElement profilePic = driver.findElement(By.cssSelector("div#sidebar-profile-picture img"));
		Assert.assertTrue(profilePic.isDisplayed(), "profile is not displayed");
		System.out.println("Pass");

		System.out.println("STEP - mouse hover on profile and click on settings icon");
		Actions act = new Actions(driver);
		act.moveToElement(profilePic)
				.click(driver.findElement(By.cssSelector("div#sidebar-profile-picture i.material-icons"))).build()
				.perform();

		System.out.println("VERIFY - Menu contains total 2 options ");
		List<WebElement> listOfOptionsInUserMenu = driver
				.findElements(By.cssSelector("div#sidebar-profile-picture div.sub-menu-container a"));
		int actualSizeOfList = listOfOptionsInUserMenu.size();
		Assert.assertEquals(actualSizeOfList, 2,
				"user menu contains " + actualSizeOfList + " options but expected size is 2");
		System.out.println("Pass");

		System.out.println("STEP - Click on about option");
		driver.findElement(By.xpath("//a[text()[normalize-space()='About']]")).click();
		Thread.sleep(2000);

		System.out.println("VERIFY -  company details  fields are getting displayed on information alert");
		List<WebElement> listOfCompanyDetails = driver.findElements(By.xpath("//div[@id='companyInfo']//div/p"));
		for (WebElement compDetail : listOfCompanyDetails) {
			System.out.println(compDetail.getText());
		}

		System.out.println("VERIFY - Employee is more than 0");
		String noOfEmployee = driver
				.findElement(By.xpath("//p[text()[normalize-space()='Employees: 97 (103 more allowed)']]")).getText();
		String[] empArr = noOfEmployee.split(" ");
		for (int index = 0; index < empArr.length; index++) {
			try {
				int num = Integer.parseInt(empArr[index]);
//				if (num > 0) {
//					System.out.println("Number of employess :" + num);
//					System.out.println("Pass");
//				}

				Assert.assertNotEquals(num, 0, "There are no employess");
				System.out.println("Number of employess :" + num);
				System.out.println("Pass");

			} catch (NumberFormatException e) {

			}
		}
		System.out.println("STEP - Click on OK button on popup");
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
		Thread.sleep(4000);
		WebElement widget = driver.findElement(By.xpath("//div[@class='widget-header']//span[text()='Quick Access']"));
		Assert.assertTrue(widget.isDisplayed(), "About popup is not closed");
		System.out.println("Pass");

	}

	@Test
	public void TC_4() throws InterruptedException {

		System.out.println("STEP-Click on employee management tab");
		driver.findElement(By.xpath("//div[@id='menu-content']//li[@id='left_menu_item_30']//span")).click();
		// Thread.sleep(4000);

		System.out.println("STEP - click on my info tab");
		driver.findElement(
				By.xpath("//div[@class='top-ribbon-menu-items consume-leftover-space']/top-level-menu-item[2]"))
				.click();
		Thread.sleep(3000);
		System.out.println("VERIFY -  user Personal info displayed");

		List<WebElement> listOfPersonalInfo = driver
				.findElements(By.xpath("//div[@id='personal_details_tab']/form//div/label"));
//		int expectedNumberOfFieldsDisplayed=12;
//		int actualNumbersOfFieldsDisplayed=listOfPersonalInfo.size();
		boolean isDisplayedFlag = false;
		for (WebElement data : listOfPersonalInfo) {
			isDisplayedFlag = true;
			if (!data.isDisplayed()) {
				isDisplayedFlag = false;

			}
		}
		if (isDisplayedFlag) {
			System.out.println("Pass - personal info is displayed");

			System.out.println("Number of fields displayed under personal info :" + listOfPersonalInfo.size());
		}
		System.out.println("STEP - Click on salary tab");
		driver.findElement(By.xpath("//a[text()='Salary ']")).click();

		System.out.println("VERIFY - Check the payable (CTC) amount is non-zero");
		// String expectedSal="$168,500.00";
		//can also add explicit wait
		if (driver.findElement(By.xpath("//div[@class='form-group col-4']//label[@for='payGrade']")).isDisplayed()) {
			String actualSal = driver.findElement(By.cssSelector(
					"#pim_salary_details>div:first-of-type>div:first-child>div:first-child>div[class='summary-card-column summary-card-right']"))
					.getText();
			Thread.sleep(2000);
			Assert.assertNotEquals("$0.00", actualSal, "payable amount is $0.00 but expected  is " + actualSal);
			System.out.println("Pass - Payable amount is : " + actualSal);
		}
	}

	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}