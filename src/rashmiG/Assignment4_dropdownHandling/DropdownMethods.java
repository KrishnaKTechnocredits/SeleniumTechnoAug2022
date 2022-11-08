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

package rashmiG.Assignment4_dropdownHandling;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import rashmiG.Base.PredefinedActions;

public class DropdownMethods {

	public static void main(String[] args) throws Exception {

		System.out.println("STEP - Launch browser and hit url");
		WebDriver driver = PredefinedActions.start();

		System.out.println("STEP - Click on basic elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		System.out.println("STEP - Actions on MultiSelect  DrowDown");
		WebElement multiSelectDD = driver
				.findElement(By.xpath("//form[@class='form-horizontal adminex-form']/div[3]//select[2]"));
		Select oSelect = new Select(multiSelectDD);

		System.out.println("STEP - Number of options present");
		List<WebElement> listOfNumbers = oSelect.getOptions();
		System.out.println("Numbers of options in dropdown : " + listOfNumbers.size());

		System.out.println("VERIFY - Dropdown is MultiSelect or not");
		if (oSelect.isMultiple())
			System.out.println("pass - dropdown is multiselect");
		else
			System.out.println("fail - drowpdown is not multiSelect");

		System.out.println("STEP - Select all even numbers");
		for (WebElement e : listOfNumbers) {
			if (Integer.parseInt(e.getText()) % 2 == 0) {
				oSelect.selectByVisibleText(e.getText());
			}
		}
		System.out.println("STEP - print first selected number");
		String firstSelectedOption = oSelect.getFirstSelectedOption().getText();
		System.out.println("First selected number is " + firstSelectedOption);

		System.out.println("STEP - How many options are selected?");
		listOfNumbers = oSelect.getAllSelectedOptions();
		System.out.println("Number of selected options :" + listOfNumbers.size());

		System.out.println("STEP - deselect first selected number");
		oSelect.deselectByVisibleText(firstSelectedOption);
		listOfNumbers = oSelect.getAllSelectedOptions();
		System.out.println("Number of selected options currently :" + listOfNumbers.size());

		System.out.println("STEP - now deselect all selected option and select all non-selected options");
		System.out.print("Selected options are ::");
		oSelect.deselectAll();
		List<WebElement> AllOptionsList = oSelect.getOptions();
		AllOptionsList.removeAll(listOfNumbers);
		for (WebElement e : AllOptionsList) {
			oSelect.selectByVisibleText(e.getText());
			System.out.print(e.getText());
		}
		PredefinedActions.closeBrowser();
	}
	
}
