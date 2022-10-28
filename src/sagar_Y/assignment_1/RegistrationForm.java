package sagar_Y.assignment_1;

import javax.swing.plaf.ColorUIResource;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm {
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("-------------------------------------------Assignment: 1 --------------------------------");
		System.out.println("Create a local HTML form and Write a script to verify all details filled are validated----");
		System.out.println("------------------------------------------------------------------------------------------\n");
		String existingURL = "file:///E:/Sagar%20Yadav/eclipse/Selenium_SagarYadav/resources/TestClass.html";
		
		WebDriver driver  = Predefined.getTitle("E:\\Sagar Yadav\\eclipse\\Selenium_SagarYadav\\resources\\TestClass.html");
		
		System.out.println("STEP 2- Enter Students First Name as: Sagar\n");
		driver.findElement(By.id("fName")).sendKeys("Sagar");
		
		System.out.println("STEP 3- Enter Students Last Name as: Yadav\n");
		driver.findElement(By.id("lName")).sendKeys("Yadav");
		
		System.out.println("STEP 4- Enter Students Mobile No. as 8806388788\n");
		driver.findElement(By.id("mobile")).sendKeys("8806388788");
		
		System.out.println("STEP 5- Select Students Gender as: Male\n");
		driver.findElement(By.id("male")).click();
		
		System.out.println("STEP 6- Select Students Hobbies are: 1,2,3,5\n");
		driver.findElement(By.id("h1")).click();
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h3")).click();
		driver.findElement(By.id("h5")).click();
		
		System.out.println("STEP 7- Select Requested Course as : Automation Testing\n");
		WebElement element = driver.findElement(By.id("courseId"));
		Select courseSelect = new Select(element);
		courseSelect.selectByIndex(1);
		
		System.out.println("STEP 8- Select Course Timings as: Morning\n");
		element = driver.findElement(By.id("batchTime"));
		Select courseSelect1 = new Select(element);
		courseSelect1.selectByValue("morning");
		
		Thread.sleep(2000);
		
		System.out.println("STEP 9- Click on link\n");
		driver.navigate().to("E:\\Sagar Yadav\\eclipse\\Selenium_SagarYadav\\resources\\Registration Successfull.html");
		
		System.out.println("VERIFY - Registration successfull page opens:");
		
		String expectedURL = "Registration";
		String actualURL = driver.getTitle();
		
		if(expectedURL.equals(actualURL))
			System.out.println("Success\n");
		else
			System.out.println("Failed\n");		
		
		Thread.sleep(3000);
		
		System.out.println("STEP 9- Get back to registration page\n");		
		driver.navigate().back();
		
		String finalURL = driver.getCurrentUrl();
		
		System.out.println("VERIFY- If reverted to correct URL or not :\n");	
		
		if(finalURL.equals(existingURL)) {
			System.out.println("Test Passed");
		}else
			System.out.println("Test Failed");
		
		driver.quit();
		
	}
}
