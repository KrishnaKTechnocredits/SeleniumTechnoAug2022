package rashmiG.Assignment2_Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import rashmiG.Base.PredefinedActions;

public class AlertDemo1 {
	public static void main(String[] args) throws InterruptedException {

		String firstName = "Rashmi";
		String lastName = "Ganachari";
		String companyName = "TechM";
		String expectedAlertMessage = firstName + " and " + lastName + " and " + companyName;

		System.out.println("STEP - launch the browser and hit url");
		WebDriver driver = PredefinedActions.start();

		System.out.println("STEP - Click on basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		System.out.println("STEP - Enter first name");
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);

		System.out.println("STEP - Enter last name");
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);

		System.out.println("STEP - Enter company name");
		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);

		System.out.println("STEP - Click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String actualAlertMessage = alert.getText();
		if (expectedAlertMessage.equals(actualAlertMessage))
			System.out.println("pass");
		else
			System.out.println("fail");

		alert.accept();
		// driver.close();//[1666899017.091][SEVERE]: Unable to receive message from
		// renderer

	}

}
