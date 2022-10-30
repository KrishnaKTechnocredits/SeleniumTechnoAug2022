package technocredits.dropdown;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownMethodTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000); // static wait
		WebElement numberElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[1]"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", numberElement);

		Select numberDD = new Select(numberElement);
		System.out.println("NumberDD : " + numberDD.isMultiple());

		numberDD.selectByVisibleText("3");

		List<WebElement> listOfNumberElements = numberDD.getOptions();
		for (WebElement e : listOfNumberElements) {
			if (e.isSelected())
				System.out.println(e.getText());
		}

		WebElement multiSelectElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		Select multiSelectDD = new Select(multiSelectElement);
		System.out.println("multiSelectDD :" + multiSelectDD.isMultiple());

		List<WebElement> listOfOptions = multiSelectDD.getOptions();

		for (WebElement e : listOfOptions) {
			int num = Integer.parseInt(e.getText());
			if (num % 2 == 0)
				multiSelectDD.selectByVisibleText(e.getText());
		}

		/*
		 * for (WebElement e : listOfOptions) { if (e.isSelected()) {
		 * System.out.println(e.getText()); } }
		 */
		System.out.println("---------");

		/*
		 * try { String output = multiSelectDD.getFirstSelectedOption().getText();
		 * System.out.println(output); } catch (NoSuchElementException ne) {
		 * System.out.println("No element is selected yet"); }
		 */

		List<WebElement> listOfSelectedOptions = multiSelectDD.getAllSelectedOptions();
		System.out.println("Size : " + listOfSelectedOptions.size());
		
		multiSelectDD.deselectByVisibleText("4");
		listOfSelectedOptions = multiSelectDD.getAllSelectedOptions();
		System.out.println("---Size : " + listOfSelectedOptions.size());
		
		for(WebElement e : listOfSelectedOptions) {
			System.out.println(e.getText());
		}
		
		multiSelectDD.deselectAll();
		listOfSelectedOptions = multiSelectDD.getAllSelectedOptions();
		System.out.println("++++Size : " + listOfSelectedOptions.size());
		
	}
}
