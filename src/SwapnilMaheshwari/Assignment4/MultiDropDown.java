/*
 Assignment - 4 : 29th Oct'2022
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

output : 1235
 */

package SwapnilMaheshwari.Assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step - Go to Basic Element and perform below step on multi select dropdown");
		WebDriver driver = PreDefinedFunction.browswerOpen();
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("Verify - how many options are there");
		WebElement element = driver.findElement(By.xpath("//div[@class='panel-body']//select[2]"));
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView()", element);
		Select multiDD = new Select(element);
		List<WebElement> listOfElements = multiDD.getOptions();
		for (WebElement e : listOfElements) {
			System.out.println(e.getText());
		}
		boolean b = multiDD.isMultiple();
		if (b == true)
			System.out.println("Dropdown is multiselect");
		else
			System.out.println("Not a multi select");

		for (WebElement e : listOfElements) {
			int num = Integer.parseInt(e.getText());
			if (num % 2 == 0) {
				//multiDD.selectByVisibleText(e.getText());
				 e.click();
				System.out.println("Selected value of even number is" + e.getText());
			}
		}
		// print first selected value
		WebElement firstSelected = multiDD.getFirstSelectedOption();
		System.out.println("First Selected vslur from the dropdown is:" + firstSelected.getText());

		// print all selected value
		List<WebElement> allSelected = multiDD.getAllSelectedOptions();
		System.out.println("All selected options are " + allSelected.size());

		// deselect first selected option
		multiDD.deselectByIndex(1);
		System.out.println("First Element got deselected");

		// deselect all selected options and select all non selected options

		List<WebElement> allSelectedItems = multiDD.getAllSelectedOptions();
		for (WebElement e : listOfElements) {
			
			if (allSelectedItems.contains(e))
				multiDD.deselectByVisibleText(e.getText());
			else
				multiDD.selectByVisibleText(e.getText());

		}
		List<WebElement> FinalSelectedItems = multiDD.getAllSelectedOptions();

		for (WebElement FinalList : FinalSelectedItems) {
			System.out.print(FinalList.getText());
		}
	}

}
