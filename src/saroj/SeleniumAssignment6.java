package saroj;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssignment6 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		System.out.println("Step - Launch the Browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();
		System.out.println("Step - Hit the URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Step - Click on iFrame tab");
		driver.findElement(By.id("iframes")).click();
		Thread.sleep(7000);
	}

	@Test
	public void frame1Activity() throws InterruptedException {
		System.out.println("Step - Switch to 1st iframe");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
		Thread.sleep(2000);
		String element = driver.findElement(By.xpath("//h1[text()=\"Selenium automates browsers. That's it!\"] "))
				.getText();
		System.out.println("Iframe--->" + element);

		System.out.println("Step - click on top right button");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		Thread.sleep(2000);

		System.out.println("Step - print the options");
		List<WebElement> element1 = driver.findElements(By.xpath("//div[@id ='main_navbar']//li/a"));
		for (WebElement eleOptions : element1) {
			System.out.println(eleOptions.getText());
		}
		Thread.sleep(2000);
		System.out.println("Step - Switch back to main window");
		driver.switchTo().parentFrame();
		String element2 = driver.findElement(By.xpath("//footer[@class=\"sticky-footer\"]")).getText();
		System.out.println("Footer text is: " + element2);
	}

	@Test
	public void frame3Activity() throws InterruptedException {
		System.out.println("Step - Switch to the 3rd frame ");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		System.out.println("Step - Click on Project Tab");
		driver.findElement(By.xpath("//font[text()='Projects']")).click();
		Thread.sleep(2000);
		System.out.println("Step -Print submenu");
		List<WebElement> projectElement = driver.findElements(By.xpath("//div[@class='menu']"));
		List<WebElement> projectElement1 = driver.findElements(By.xpath("//li[@class=\"menuheader\"]/ul"));
		projectElement1.retainAll(projectElement);
		for (WebElement e : projectElement) {
			System.out.println(e.getText());
		}
		Thread.sleep(2000);
		System.out.println("Step - Switch back to main window");
		driver.switchTo().parentFrame();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
}
