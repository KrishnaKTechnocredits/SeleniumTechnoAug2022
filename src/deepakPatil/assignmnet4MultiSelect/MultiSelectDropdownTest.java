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

package deepakPatil.assignmnet4MultiSelect;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import deepakPatil.base.StartupActions;

public class MultiSelectDropdownTest {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("--Go to Automationbykrishna.com--");
		WebDriver driver = StartupActions.launch("http://automationbykrishna.com/");

		System.out.println("--Go to Basic Element and perform below step on multi select dropdown--");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", element);

		System.out.println("\n--how many options are there?--");
		Select multiSelect = new Select(element);
		List<WebElement> multiSelectOptions = multiSelect.getOptions();
		System.out.println("There are " + multiSelectOptions.size() + " options as below:");
		for (WebElement e : multiSelectOptions) {
			System.out.println(e.getText());
		}

		System.out.println("\n--is that drodown is multi select?--");
		if (multiSelect.isMultiple())
			System.out.println("Yes, It is muliselect dropdown");
		else
			System.out.println("No, It is not multiselect dropdown");

		System.out.println("\n--select all even numbers--");
		for (WebElement e : multiSelectOptions) {
			String ddText = e.getText();
			int ddNum = Integer.parseInt(e.getText());
			if (ddNum % 2 == 0)
				multiSelect.selectByVisibleText(ddText);
		}

		System.out.println("\n--print first selected number--");
		System.out.println(multiSelect.getFirstSelectedOption().getText());

		System.out.println("\n--how many options are selected ?--");
		List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
		System.out.println("There are " + selectedOptions.size() + " options selected as below:");
		for (WebElement e : selectedOptions) {
			System.out.println(e.getText());
		}

		System.out.println("\n--deselect first selected number--");
		multiSelect.deselectByVisibleText(multiSelect.getFirstSelectedOption().getText());

		System.out.println("\n--now deselect all selected option and select all non-selected options--");
		for (WebElement e : multiSelectOptions) {
			if (e.isSelected())
				multiSelect.deselectByVisibleText(e.getText());
			else
				multiSelect.selectByVisibleText(e.getText());
		}

		System.out.println("\n--print all selected option's text--");
		selectedOptions = multiSelect.getAllSelectedOptions();
		for (WebElement e : selectedOptions) {
			System.out.println(e.getText());
		}
		driver.close();
	}
}
