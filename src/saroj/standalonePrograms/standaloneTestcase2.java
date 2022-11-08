package saroj.standalonePrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saroj.PredefinedActions;
import saroj.utils.PropertyFilesReader;

public class standaloneTestcase2 {

	WebDriver driver;
	PropertyFilesReader prop = new PropertyFilesReader(".//src/saroj/propertiesFiles/orangeHRMLDetails.properties");

	@BeforeMethod
	public void launchBrowser() {
		driver = PredefinedActions.start("https://skumari-trials77.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Step - Navigate to Orange HRM");
	}

	@Test
	public void loginAndGetEmpName() {
		System.out.println("Step - Enter User name");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(prop.getValue("Username"));
		System.out.println("Step - Enter Password");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(prop.getValue("Password"));
		System.out.println("Step - Press Submit button");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String title = driver.getTitle();
		if (title.equals("Employee Management")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login failed");
		}
		WebDriverWait wait = new WebDriverWait(driver, 60);
		System.out.println("Step - Click on Employee Management tab");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@id='left_menu_item_30']"))));
		driver.findElement(By.xpath("//li[@id='left_menu_item_30']")).click();
		System.out.println("Step - Print all the employee name whose sub unit is QA Team");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//th[text()='Name']"))));
		List<WebElement> qaElement = driver.findElements(By.xpath("//td[text()='QA Team']"));
		List<WebElement> nameEle = driver.findElements(By.xpath("//td[text()='QA Team']//preceding-sibling::td[@class='cursor-pointer'][1]"));
		int qaSize = qaElement.size();
		for (int index = 0; index < qaSize; index++) {
			WebElement e = nameEle.get(index);
			System.out.println(e.getText());
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
