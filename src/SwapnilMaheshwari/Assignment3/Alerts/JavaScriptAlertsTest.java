package SwapnilMaheshwari.Assignment3.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertsTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='row']//button[@id='javascriptAlert']")).click();
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("Actual Text for Alert :" + actualText);
		System.out.println("Step -Verify that Alert text must matched with expected text");
		alert.accept();
		if (expectedText.equals(actualText))
			System.out.println("Alert Test case Pass");
		else
			System.out.println("Alert Test case Fail");

		System.out.println("----------------------------------------------------------------------------");

		System.out.println("Step- Verify JavaScript Confirmation pop up");
		driver.findElement(By.xpath("//div[@class='row']//button[@id='javascriptConfirmBox']")).click();
		Alert javaAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		String javAlertActualText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String javaAlertText = javaAlert.getText();
		System.out.println(javaAlertText);

		if (javAlertActualText.equals(javaAlertText))
			System.out.println("JavaScrip Confirmation test case pass");
		else
			System.out.println("JavaScrip Confirmation test case fail");

		String expectedTextForOk = "You pressed OK!";
		javaAlert.accept();
		String elementText = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println("Button text that we clicked :" + elementText);

		if (expectedTextForOk.equals(elementText))
			System.out.println("You pressed Java Script Confirmation - Ok button - Test Case Pass");
		else
			System.out.println("You pressed Java Script Confirmation - Cancel button - Test Case Fail");
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("Step- Verify that JavaScript Prompt button functionality");
		driver.findElement(By.xpath("//div[@class='row']//button[@id='javascriptPromp']")).click();
		Alert propmtAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		String name = "Swapnil";
		propmtAlert.sendKeys(name);
		String promtExpectedText = "Hello" + name + "!" + "How are you today?";
		propmtAlert.accept();
		String jPromtText = driver.findElement(By.xpath("//div[@class='row']//p[@id='pgraphdemo']")).getText();
		System.out.println("Actual Text for Java Prompt:" + jPromtText);
		if (promtExpectedText.contains("Swapnil"))
			System.out.println("You Pressed Ok button of Java Script Promt - Pass");
		else
			System.out.println("You pressed Cancel button of Java Script Promt - Fail");

	}

}
