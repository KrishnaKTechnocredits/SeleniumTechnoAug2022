package technocredits.webtabledemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import technocredits.PredefinedActions;

public class Example1 {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start();
		
		System.out.println("STEP - Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyNumOfRowsInTable() throws InterruptedException {
		
		System.out.println("STEP - get total rows from Employee Details table");
		List<WebElement> listOfRows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		
		System.out.println("VERIFY - Table row count");
		int expectedRowCount = 4;
		int actualRowCount = listOfRows.size();
		
		Assert.assertEquals(actualRowCount, expectedRowCount);
	}

	@Test
	public void verifyNumOfColumnInTable() throws InterruptedException {
	
		System.out.println("STEP - get total colunm from Employee Details table");
		List<WebElement> listOfCol= driver.findElements(By.xpath("//table[@id='table1']//thead/tr/th"));
		
		System.out.println("VERIFY - Table row count");
		int expectedRowCount = 4;
		int actualColCount = listOfCol.size();
		
		Assert.assertEquals(actualColCount, expectedRowCount);
		System.out.println("End");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Clean up - Close browser");
		PredefinedActions.closeBrowser();
	}
}
