
/*Assignment - 4 : 29th Oct'2022
Go to Automationbykrishna.com
Go to Basic Element and perform below step on multi select dropdown
how many options are there ?
is that drodown is multi select.
select all even numbers
print first selected number.
how many options are selected ?
deselect first selected number.
now deselect all selected option and select all non-selected options.
print all selected option's text.

output : 1235*/

package nilamP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {
	public static void main(String[] args) {
		System.out.println("STP 1- Browser Launched");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 2 - Hit URl");
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP 3 - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,200)");
		 */

		System.out.println("STEP 4 :Locate a dropdown");
		WebElement numberElement = driver.findElement(By.xpath("//div[@class='panel-body']/form/div[3]//select[1]"));

		System.out.println("STEP 5 :Scroll down to dropdown");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", numberElement);
		Select s = new Select(numberElement);

		System.out.println("STEP 6 :find dropdown is multiselect or not");
		System.out.println("Multiselect : " + s.isMultiple());

		System.out.println("STEP 7 :how many options are there ?");
		List<WebElement> listOfElement = s.getOptions();
		System.out.println("Total number are :" + listOfElement.size());

		System.out.println("STEP 8 :Select all even numbers");
		WebElement multiSelectElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		Select s1 = new Select(multiSelectElement);
		System.out.println("is that drodown is multi select--> :" + s1.isMultiple());
		for (WebElement e : listOfElement) {
			int num = Integer.parseInt(e.getText());
			if (num % 2 == 0) {
				s1.selectByVisibleText(e.getText());
				System.out.println(e.getText());
			}
		}

		System.out.println("STEP 9: print first selected number");
		String selectedElement = s1.getFirstSelectedOption().getText();
		System.out.println("First selected element :" + selectedElement);

		System.out.println("STEP 10 : how many options are selected");
		List<WebElement> listOfSelected = s1.getAllSelectedOptions();
		System.out.println("Number of selected elements are " + listOfSelected.size());

		System.out.println("STEP 11 : deselect first selected number.");
		WebElement firstOption = s1.getFirstSelectedOption();
		s1.deselectByVisibleText(firstOption.getText());

		System.out.println("STEP 12: Deselect all selected option and select all non-selected options");
		List<WebElement> totalElement = s1.getOptions();
		for (WebElement e : totalElement) {
			if (e.isSelected()) {
				s1.deselectByVisibleText(e.getText());

			} else {
				s1.selectByVisibleText(e.getText());

			}
		}

		System.out.println("STEP 13 : print all selected option's text");
		List<WebElement> outputList = s1.getAllSelectedOptions();
		for (WebElement e : outputList) {
			System.out.print(e.getText());
		}

	}
}
