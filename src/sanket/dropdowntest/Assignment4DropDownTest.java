/*Assignment - 4 : 29th Oct'2022
Go to Automationbykrishna.com
Go to Basic Element and perform below step on multi select dropdown
how many options are there ?
is that dropdown is multi-select.
select all even numbers
print first selected number.
how many options are selected ?
deselect first selected number.
now deselect all selected option and select all non-selected options.
print all selected option's text.

output : 1235
*/

package sanket.dropdowntest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4DropDownTest {

	public static void main(String[] args) throws Exception {

		System.out.println("STEP 1 - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver_106.exe");

		System.out.println("STEP 2 - Hit url (http://automationbykrishna.com/)in browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(3000);

		System.out.println("STEP 3- Verify Application is loaded successfully.");
		String expectedTitle = "Login Signup Demo";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle))
			System.out.println("Pass - Page Login Signup Demo loaded Suceessfully.");
		else
			System.out.println("Fail - Page not loaded.");

		System.out.println("STEP 4- Click on basic element tab.");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		WebElement elementDropDown = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		System.out.println("STEP 5 - Go to DropDown.");

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", elementDropDown);

		Select noOfDropDownElement = new Select(elementDropDown);
		System.out.println("STEP 6 - Select the DropDown.");

		noOfDropDownElement.selectByVisibleText("4");

		List<WebElement> listOfMultidDropDownElements = noOfDropDownElement.getOptions();
		System.out.println("STEP 7 - Get all DropDownElements");

		System.out.println("Total Number of options in : " + listOfMultidDropDownElements.size());

		System.out.println("STEP 8 - Is MultiDropDown?");

		if (noOfDropDownElement.isMultiple()) {
			System.out.println("Pass - DropDown is MultiSelect");
			System.out.println("STEP 9 - select all even numbers");
			for (WebElement selectEvenElement : listOfMultidDropDownElements) {
				if (Integer.parseInt(selectEvenElement.getText()) % 2 == 0) {
					noOfDropDownElement.selectByVisibleText(selectEvenElement.getText());
				}
			}
		} else {
			System.out.println("DropDown is not MultiSelect");
		}

		System.out.println("STEP 10 - Print first selected number.");
		WebElement firstOptionSelected = noOfDropDownElement.getFirstSelectedOption();
		System.out.println("First selected option is: " + firstOptionSelected.getText());

		System.out.println("STEP 11 - How many options are selected?");
		List<WebElement> allSelectedOptions = noOfDropDownElement.getAllSelectedOptions();
		System.out.println("Total number of selected options is: " + allSelectedOptions.size());

		System.out.println("STEP 12 - Deselect first selected number.");
		noOfDropDownElement.deselectByVisibleText(firstOptionSelected.getText());

		System.out.println("STEP 13 - Deselect all selected option and select all non-selected options");
		List<WebElement> allOptions = noOfDropDownElement.getOptions();
		for (WebElement allDropDownElement : allOptions) {
			if (allDropDownElement.isSelected())
				noOfDropDownElement.deselectByVisibleText(allDropDownElement.getText());
			else
				noOfDropDownElement.selectByVisibleText(allDropDownElement.getText());
		}

		System.out.println("STEP 14 - Print all selected option's text");
		List<WebElement> outputList = noOfDropDownElement.getAllSelectedOptions();
		for (WebElement e : outputList) {
			System.out.println(e.getText());
		}
		driver.quit();
	}
}
