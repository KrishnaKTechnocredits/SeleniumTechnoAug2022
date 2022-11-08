package shubhamGupta.test;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import shubhamGupta.base.PredefinedActions;

public class Assignment10_OrangeHrmOps {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowserDoLogin() {
		System.out.println("Step 1: Launch Chrome Browser and open URL");
		driver = PredefinedActions.start("https://shubgupta-trials77.orangehrmlive.com/");

		System.out.println("Step2: Enter Credentials for Login");
		PredefinedActions.loginToOrangeHRM();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Employee Management";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Expected Title is: " + ExpectedTitle);
		System.out.println("Actual Title is: " + ActualTitle);
		System.out.println("Login Successful");

	}

	@Test
	public void verifyDetailsOnAbout() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		System.out.println("Step3: Verify User Profile is displayed");
		WebElement userProfile = driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"));
		System.out.println("User Profile is displaying: " + userProfile.isDisplayed());

		System.out.println("Step4: Mouse Hover on Profile and Click on setting icon on profile");
		Actions act = new Actions(driver);
		act.moveToElement(userProfile).build().perform();
		driver.findElement(
				By.xpath("//a[@class='password-action profile-context-menu-handler']//i[@class='material-icons']"))
				.click();

		System.out.println("Step5: Verify user menu total 2 options displayed");

		List<WebElement> menu = driver.findElements(By.xpath(
				"//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-item']/a"));
		System.out.println("Total options present under menu are: " + menu.size());
		System.out.println("These are: ");
		for (WebElement option : menu) {
			System.out.println(option.getText());
		}

		System.out.println("Step6: Click on About");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();

		System.out.println("Clicked on about link");
		String about = driver.findElement(By.xpath("//div[@class='customized-modal-header']/h4")).getText();
		if (about.equals("About")) {
			System.out.println("About popup is opened");
		}
		System.out.println("Step7: Verify Employee is more than 0");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='companyInfo']")));

		String employees = driver
				.findElement(By.xpath("//div[@id='companyInfo']//div//p[contains(text(),'Employees:')]")).getText();
		String[] empArr = employees.split(" ");
		int employeeCount = Integer.parseInt(empArr[1]);
		boolean flag = false;
		if (employeeCount > 0) {
			flag = true;
		}
		Assert.assertEquals(flag, true);
		System.out.println("Employee count is more then 0. Actual count is: " + employeeCount);

		System.out.println("Step8: Verify the company details  fields are getting displayed on information alert");

		List<WebElement> details = driver.findElements(By.xpath("//div[@id='companyInfo']//div//p"));
		LinkedHashMap<String, String> companyDetails = new LinkedHashMap<String, String>();
		for (WebElement ele : details) {
			String data = ele.getText();
			String[] maps = data.split(":");
			companyDetails.put(maps[0], maps[1]);
		}
		String[] actualDetails = { "Company Name", "Version", "Employees", "Users", "Renewal on" };
		Set<String> keys = companyDetails.keySet();
		LinkedList<String> keyList = new LinkedList<String>();
		System.out.println("Following  company details are present on company details popup: ");
		for (String key : keys) {
			keyList.add(key);
			System.out.println(key);
		}

		for (int i = 0; i < keyList.size(); i++) {
			Assert.assertEquals(keyList.get(i), actualDetails[i]);
		}

		System.out.println("Step9: Click on OK button on popup");
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
		System.out.println("Test case passed");
	}

	@Test
	public void verifyCTCIsNonZero() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		System.out.println("Step3: User click on Employee Management tab");
		driver.findElement(By.xpath("(//a[@data-tooltip='Employee Management'])[1]")).click();

		System.out.println("Step4: Navigate to myInfo tab");
		driver.findElement(By.xpath("//a[@href='#/pim/my_info']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));

		System.out.println("Step5: Verify user Personal info displayed");
		boolean flag = driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed();
		if (flag) {
			System.out.println("Personal details are displaying");
		} else {
			System.out.println("Personal details are not displaying");
		}
		System.out.println("Step6:Click on Salary");
		driver.findElement(By.xpath("//a[@href='#/pim/employees/13/salary']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='payGrade']")));
		String ctc = driver.findElement(By.xpath("//div[@translate='Cost to the Company']/following-sibling::div"))
				.getText();
		String updatedCtc = "";
		for (int i = 0; i < ctc.length(); i++) {
			char ch = ctc.charAt(i);
			if (Character.isDigit(ch)) {
				updatedCtc = updatedCtc + ch;
			}

		}
		int ctcNum = (Integer.parseInt(updatedCtc)) / 100;
		System.out.println("Employee's CTC is: " + ctcNum);
		boolean flag1 = false;
		if (ctcNum > 0) {
			flag1 = true;
		}
		Assert.assertEquals(flag1, true);
		System.out.println("Test Case passed");
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowsers();
		System.out.println("Browser is closed");
	}
}
