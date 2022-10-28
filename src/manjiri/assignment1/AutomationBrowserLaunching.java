package manjiri.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import manjiri.base.PredefinedActions;

public class AutomationBrowserLaunching {
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("file:///D:/TechnoCredits/Projects/SeleniumTechnoAug2022/src/manjiri/pages/FIrstProgram.html");
		driver.findElement(By.id("firstname")).sendKeys("Manjiri");
		driver.findElement(By.id("lastname")).sendKeys("Chourikar");
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h6")).click();
		
		Select branchSelect = new Select(driver.findElement(By.id("BId")));
//		branchSelect.selectByVisibleText("IT");
//		branchSelect.selectByValue("2");
		branchSelect.selectByIndex(2);
		
		driver.findElement(By.id("clickId")).click();
		driver.navigate().back();
	}
}
