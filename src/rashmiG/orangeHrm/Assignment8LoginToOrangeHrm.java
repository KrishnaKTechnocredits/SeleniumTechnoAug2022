package rashmiG.orangeHrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rashmiG.Base.PredefinedActions;
import rashmiG.utils.PropertiesFileReader;

public class Assignment8LoginToOrangeHrm {
	WebDriver driver;
	PropertiesFileReader prop = new PropertiesFileReader("src/rashmiG/orangeHrm/orangeHrm.properties");

	public WebElement clearElement(WebElement element) {
		element.clear();
		return element;

	}

	@BeforeMethod
	public void setUp() {
		System.out.println(" STEP - Launch orange HRM site");
		driver = PredefinedActions.start(prop.getValue("applicationUrl"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getValue("implicitWait")), TimeUnit.SECONDS);

		System.out.println("STEP - Enter username");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getValue("userName"));

		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getValue("password"));

		System.out.println("STEP - Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		if (driver.getTitle().equals("Employee Management")) {
			System.out.println("Pass - Login successfull");
		} else {
			System.out.println("Fail - Unsuccessfull login");
		}
	}

	@Test
	public void updateReqDetails() throws InterruptedException {
		driver.findElement(
				By.xpath("//div[@class='top-ribbon-menu-items consume-leftover-space']/top-level-menu-item[2]"))
				.click();
		System.out.println("STEP - click on my info tab");

		clearElement(driver.findElement(By.id("firstName"))).sendKeys(prop.getValue("fName"));
		System.out.println("STEP - first name entered");

		// clearElement(driver.findElement(By.id("lastName"))).sendKeys(prop.getValue("lName"));
		// System.out.println("STEP - last name entered");

		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.id("lastName"))).sendKeys(prop.getValue("lName")).build().perform();
		System.out.println("STEP - last name entered");

		act.click(driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//input"))).build().perform();
		driver.findElement(By.xpath("//div[@id='eeo_race_ent_inputfileddiv']//ul/li[6]")).click();
		System.out.println("STEP - race selected");

		clearElement(driver.findElement(By.xpath("//input[@id='emp_birthday']"))).sendKeys(prop.getValue("DOB"));
		System.out.println("STEP - date of birth entered");

		driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//input")).click();
		WebElement e = driver.findElement(By.xpath("//div[@id='nation_code_inputfileddiv']//ul//li[83]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
		System.out.println("STEP - Scroll till element and nationality selected");

		driver.findElement(By.xpath("//input[@id='emp_dri_lice_exp_date']")).clear();
		System.out.println("STEP - license expiry date cleared");

		driver.findElement(By.xpath("//materializecss-decorator[@form='schemaForm.form[6]']//button")).click();
		System.out.println("STEP - click on save button");
		String message = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		if (message.equals("Successfully Updated"))
			System.out.println("Pass - message is displayed");
		else
			System.out.println("message not displayed");

		System.out.println("STEP - Refresh the page");
		driver.navigate().refresh();

		String actualUpdatedName = driver.findElement(By.xpath("//a[@href='/client/#/pim/my_info']")).getText();
		String expectedUpdatedName = prop.getValue("fName") + " " + prop.getValue("lName");
		if (actualUpdatedName.equals(expectedUpdatedName)) {
			System.out.println("Pass - page refreshed  and data updated");
		} else
			System.out.println("fail - Data not updated");
	}

	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}