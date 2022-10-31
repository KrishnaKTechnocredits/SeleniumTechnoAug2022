package technocredits.enabledOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;

public class Enabled {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start("file:///D:/TechnoCredits/Projects/AUG22/SeleniumTechnoAug2022/src/technocredits/htmlForms/Display_And_Enabled.html");
	}

	@Test
	public void enabled() throws InterruptedException {
		Thread.sleep(2000);
		WebElement editableElement = driver.findElement(By.xpath("//button[@onclick='disable()']"));
	
		editableElement.click();
		
		Thread.sleep(2000);
		if(driver.findElement(By.id("myText")).isEnabled()) {
			driver.findElement(By.id("myText")).sendKeys("harsh");
		}else {
			System.out.println("STEP: Sendkeys not performed due to disable text area");
		}
		Thread.sleep(2000);
		
	
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowser();
	}
}
