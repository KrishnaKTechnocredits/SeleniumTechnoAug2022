package akankshaVyas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3Alert {

	void testCaseSimpleAlert() throws InterruptedException {

		System.out.println("STEP 1.Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(2000);
		System.out.println("Step2: Click on basicElements");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Step3: Click on Alert");
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,200)");
		driver.findElement(By.id("javascriptAlert")).click();
		Alert al = driver.switchTo().alert();
		String actualMsg = al.getText();
		String expectedMsg = "You must be TechnoCredits student!!";
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");

		}
		al.accept();
		driver.close();
	}

	void testCaseConfirmationAlert() throws InterruptedException {
		System.out.println("STEP 1.Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(2000);
		System.out.println("Step2: Click on basicElements");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Step3: Click on Alert");
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,200)");

		driver.findElement(By.id("javascriptConfirmBox")).click();

		System.out.println("STEP4 -Switch to Alert and accept it");
		driver.switchTo().alert().accept();
		System.out.println("STEP5 -Verify text on Alert");

		String actualMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedMsg = "You pressed OK!";

		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");

		}
		driver.close();

	}

	void testCasePromptAlert() throws InterruptedException {
		System.out.println("STEP 1.Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(2000);
		System.out.println("Step2: Click on basicElements");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Step3: Click on Alert");
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,200)");

		driver.findElement(By.id("javascriptPromp")).click();
		System.out.println("STEP 4 -Switch to Alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP 5 -Send input to Alert and accept it");
		String input = "Akanksha";
		alert.sendKeys(input);
		alert.accept();
		System.out.println("STEP 6 -Print actual msg");
		String actualMsg = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(actualMsg);
		System.out.println("STEP 7 -Verify dynamic input given in text");
		if (actualMsg.contains(input)) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");

		}
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment3Alert assignment3Alert = new Assignment3Alert();
		assignment3Alert.testCaseSimpleAlert();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		assignment3Alert.testCaseConfirmationAlert();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		assignment3Alert.testCasePromptAlert();
	}

	
}
