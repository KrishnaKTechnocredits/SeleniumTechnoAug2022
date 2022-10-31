package saroj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saroj.utils.PropertyFilesReader;

public class SeleniumAssignment5 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("STEP - Navigate to Facebook");
	}

	@Test
	public void newAccount() throws InterruptedException {
		System.out.println("STEP - Click on Create New Account");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(3000);
		PropertyFilesReader prop = new PropertyFilesReader("src/saroj/propertiesFiles/userDetails.properties");
		driver.findElement(By.name("firstname")).sendKeys(prop.getValue("firstName"));
		driver.findElement(By.name("lastname")).sendKeys(prop.getValue("surName"));
		driver.findElement(By.name("reg_email__")).sendKeys(prop.getValue("mobileNumber"));
		driver.findElement(By.id("password_step_input")).sendKeys(prop.getValue("newPassword"));

		System.out.println("Step - Select day");
		WebElement dayElement = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayElement);
		daySelect.selectByVisibleText(prop.getValue("day"));

		System.out.println("Step - Select month");
		WebElement mnthElement1 = driver.findElement(By.id("month"));
		Select monthSelect = new Select(mnthElement1);
		monthSelect.selectByVisibleText(prop.getValue("month"));

		System.out.println("Step - Select year");
		WebElement yearElement = driver.findElement(By.id("year"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText(prop.getValue("year"));

		System.out.println("Step - Select Gender");
		WebElement genderRadiobtn = driver.findElement(By.xpath("//label[text()='Female']"));
		String genderbtn = genderRadiobtn.getText();
		if (genderbtn.equals(prop.getValue("gender"))) {
			genderRadiobtn.click();
		}

		driver.quit();
	}
}
