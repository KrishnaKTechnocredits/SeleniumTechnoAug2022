package rashmiG.Assignment1_htmlpageautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void verifyTitle(String expectedTitle, WebDriver driver) {
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("pass -  loaded successfully");
		} else {
			System.out.println("fail -  not loaded");
		}
	}

	public static void main(String[] args) {
		System.out.println("STEP - Launch chrome browser ");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP - Hit url in browser.");
		driver.get("file:///D:/Technocredits/Projects/AUG22/Form.html");

		System.out.println("VERIFY - application is loaded successfully");
		String expectedTitle = "Technocredits";
		verifyTitle(expectedTitle, driver);

		System.out.println("STEP - Enter First Name");
		driver.findElement(By.id("id1")).sendKeys("Rashmi");

		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.id("id2")).sendKeys("Ganachari");

		System.out.println("STEP - Select gender radio button");
		driver.findElement(By.id("r2")).click();

		System.out.println("STEP - Select Hobbies checkbox");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h5")).click();
		driver.findElement(By.id("h6")).click();

		System.out.println("STEP - Select value from branch dropdown");
		WebElement element = driver.findElement(By.id("bId"));
		Select sel = new Select(element);
		sel.selectByIndex(1);

		System.out.println("STEP - Click on Click here link");
		driver.findElement(By.id("clickId")).click();

		System.out.println("VERIFY - click here link should redirect to url configured ");
		expectedTitle = "Google";
		verifyTitle(expectedTitle, driver);

		System.out.println("STEP - Navigate back to the previous url");
		driver.navigate().back();

		System.out.println("VERIFY -  html page is loaded again");
		expectedTitle = "Technocredits";
		verifyTitle(expectedTitle, driver);
	}
}