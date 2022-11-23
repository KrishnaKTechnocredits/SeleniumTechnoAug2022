package saroj;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saroj.utils.PropertyFilesReader;

public class SeleniumAssignment10Script3 {

	WebDriver driver;
	PropertyFilesReader prop = new PropertyFilesReader("src/saroj/propertiesFiles/orangeHRMLDetails.properties");

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step - Launch oranage HRM URL");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get("https://skumari-trials77.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void login() {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Step - Verify User profile is displayed");
		if (driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']")).isDisplayed()) {
			System.out.println("Profile displayed");
		} else {
			System.out.println("Profile not displayed");
		}
		System.out.println("Step - Mouse Hover on Profile");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']"))).build().perform();

		System.out.println("Step - Click on setting icon on profile");
		driver.findElement(By.xpath("//i[@class='material-icons'][1]")).click();

		System.out.println("Step - Verify user menu total 2 options displayed");
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='sub-menu-container']"));
		int count = ele.size();
		if (count == 2) {
			System.out.println("Total 2 options displayed");
		} else {
			System.out.println("Options are not displaying");
		}
		System.out.println("Step - Click on About");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();

		System.out.println("Step - Verify Employee is more than 0");
		String emp = driver.findElement(By.xpath("//p[@style=\"padding-left: 5px\"][contains(text(),'Employees:')]"))
				.getText();
		String[] employee = emp.split(" ");
		int empcount = Integer.parseInt(employee[1]);
		if (empcount > 0) {
			System.out.println("Employee is more than 0");
		} else {
			System.out.println("Employee is not more than 0");
		}
		System.out.println("Step - Verify the company details  fields are getting displayed on information alert ");
		List<WebElement> empDetails = driver.findElements(By.xpath("//div[@class='col s12']"));
		System.out.println("Employee Details are: ");
		for (WebElement e : empDetails) {
			System.out.println(e.getText());
		}
		System.out.println("Step - Click on OK button on popup");
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
	}

	@AfterMethod
	public void closeWindows() {
		driver.close();
	}
}
