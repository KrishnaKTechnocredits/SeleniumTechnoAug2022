package SwapnilMaheshwari.Assignment2_Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("Verify -Application is loaded sucessfully");
		String firstName = "Swapnil";
		String lastName = "Maheshwari";
		String companyName = "InfoBeans";

		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);

		String expectedAlertMessage = firstName + " and " + lastName + " and " + companyName;
		String actualAlertText = alert.getText();
		System.out.println("Actual Text : " + actualAlertText);
		if (expectedAlertMessage.equals(actualAlertText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		alert.accept();

		System.out.println(" BASIC FORMS Details");
		System.out.println("Verify -Form details submitted sucessfully");
		String emailId = "swapnilmaheshari5@gmail.com";
		String password = "testing123";
		String expectedFormText = "You successfully clicked on it";
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailId);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		String basicActualText = alert1.getText();
		System.out.println("Actual Text:"+basicActualText);
		if (expectedFormText.equals(basicActualText)) {
			System.out.println("Test pass");
		} else
			System.out.println("Test fail");
		alert.accept();
	}

}
