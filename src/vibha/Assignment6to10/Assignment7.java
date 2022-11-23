package vibha.Assignment6to10;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7 {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.out.println("Step1:Launch browser and hit url");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		driver=new ChromeDriver();
		//driver.get("https://jqueryui.com/droppable/");
		
	}
	
	@Test
	void verifyDragAndDropElementFeature() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		WebElement element=driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		
	//	PredefinedActions.scrollViewToElement(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));

		System.out.println("Step2: Drag \"Drag me to my target\" element to \"Drop here\"");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));
		Thread.sleep(2000);

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(1000);

		System.out.println("Step3: Validate that you move draggable element to target location");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'droppable']")).getText(), "Dropped!");

		System.out.println("Element dropped successfully");
	}

	@Test
	void verifyDoubleClickOnElementFeature() throws InterruptedException {
		driver.get("http://automationbykrishna.com/");
		System.out.println("Step2: Click on Basic Element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(4000);
		System.out.println("Step3: Scroll till element visible");
		WebElement element1=driver.findElement(By.xpath("//a[contains(text(),'Double-click on me')]"));
		
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element1);
		//PredefinedActions.scrollViewToElement(driver.findElement(By.xpath("//a[@ondblclick = 'doubleClick()']")));
		Thread.sleep(4000);

		System.out.println("Step4: Perform double click on element");
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(By.xpath("//a[@ondblclick = 'doubleClick()']"))).build().perform();

		System.out.println("Step5: Validate that you double click on element");
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		System.out.println("STEP6: Accept the alert");
		alert.accept();
	}

	@Test
	void verifyMouseHoverFeature() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		//driver = PredefinedActions.start("https://www.flipkart.com/");
		Thread.sleep(4000);

		System.out.println("Step2: Click on cross button on login");
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();

		System.out.println("Step3: Mouse hover on Fashion Icon");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]"))).build().perform();

		System.out.println("Step4: Validate that menu is displayed");
		int totalCount = driver.findElements(By.xpath("//a[@class='_6WOcW9']")).size();
		if (totalCount > 0) {
			System.out.println("Menu is displayed");
		} else {
			System.out.println("Menu is not displayed");
		}
		Thread.sleep(5000);

		System.out.println("Step5: Print each section's subsection count");
		List<WebElement> sections = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		for (WebElement section : sections) {
			List<WebElement> subSection = driver.findElements(By.xpath("//div[@class = '_3XS_gI']/a"));
			System.out.println("  " + section.getText() + " --> " + subSection.size());
		}
		Thread.sleep(5000);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	
}
