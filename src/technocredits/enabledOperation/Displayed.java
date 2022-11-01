package technocredits.enabledOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;

public class Displayed {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start("file:///D:/TechnoCredits/Projects/AUG22/SeleniumTechnoAug2022/src/technocredits/htmlForms/Display_And_Enabled.html");
	}

	@Test
	public void enabled() throws InterruptedException {
		Thread.sleep(2000);
		WebElement editableElement = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
	
//		editableElement.click();
		
		Thread.sleep(2000);
		if(driver.findElement(By.id("myDIV")).isDisplayed()) {
			System.out.println(driver.findElement(By.id("myDIV")).getText());
		}else {
			System.out.println("STEP: Element is not visible on screen");
		}
		Thread.sleep(2000);
	}

	@AfterMethod
	public void closeBrowser() {
		PredefinedActions.closeAllBrowser();
	}
}
