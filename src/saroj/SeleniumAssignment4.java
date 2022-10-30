package saroj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAssignment4 {

	static WebDriver driver;

	static void scrollElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step - Launch the browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");
		driver = new ChromeDriver();

		System.out.println("Step - Hit the URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("Step - Click on Basic Elements in menu bar");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("Step - Scroll to element");
		WebElement element = driver.findElement(By.xpath("//div[@class = 'panel-body']//div[3]//select[2]"));
		scrollElement(element);

		System.out.println("How many options are there?");
		Select dropdown = new Select(element);
		List<WebElement> multiSelect = dropdown.getOptions();
		System.out.println("There are " + multiSelect.size() + " options in Selects drop down");

		System.out.println("Verify - is that drodown is multi select?");
		if (dropdown.isMultiple())
			System.out.println("Yes, It is muliselect dropdown");
		else
			System.out.println("No, It is not multiselect dropdown");

		System.out.println("Step - select all even numbers");
		for (WebElement e : multiSelect) {
			int num = Integer.parseInt(e.getText());
			if (num % 2 == 0) {
				dropdown.selectByVisibleText(e.getText());
			}
		}

		System.out.println("Step - print first selected number");
		WebElement ele = dropdown.getFirstSelectedOption();
		System.out.println("First Selected number is: " + ele.getText());

		System.out.println("Step - how many options are selected ?");
		List<WebElement> selectedOptionsList = dropdown.getAllSelectedOptions();
		System.out.println("There are " + selectedOptionsList.size() + " options selected");

		System.out.println("Step - deselect first selected number");
		dropdown.deselectByVisibleText(dropdown.getFirstSelectedOption().getText());

		System.out.println("Step - deselect all selected option and select all non-selected options");
		for (WebElement e : multiSelect) {
			if (e.isSelected())
				dropdown.deselectByVisibleText(e.getText());
			else
				dropdown.selectByVisibleText(e.getText());
		}

		System.out.println("Step - print all selected option's text");
		selectedOptionsList = dropdown.getAllSelectedOptions();
		for (WebElement e : selectedOptionsList) {
			System.out.println(e.getText());
		}
		driver.close();
	}
}
