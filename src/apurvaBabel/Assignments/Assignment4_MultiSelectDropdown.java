/*Assignment - 4 :
Test Cases
1.Go to Automationbykrishna.com
2.Go to Basic Element and perform below step on multi select dropdown
3.how many options are there ?
4.is that dropdown is multi select.
5.select all even numbers
6.print first selected number.
7.how many options are selected ?
8.deselect first selected number.
9.now deselect all selected option and select all non-selected options.
10.print all selected option's text.

output : 1235
*/

package apurvaBabel.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import apurvaBabel.PredefinedActions;

public class Assignment4_MultiSelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step2: Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("Step3: Scroll till multi select dropdown is visible");
		WebElement multiSelectElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		PredefinedActions.scrollViewToElement(multiSelectElement);
		Thread.sleep(3000);

		System.out.println("Step4: Check how many options are there?");
		Select multiDropdown = new Select(multiSelectElement);
		List<WebElement> allOptions = multiDropdown.getOptions();
		System.out.println("Options available in dropdown --> " + allOptions.size());
		if (allOptions.size() == 5) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("Step5: Check if that dropdown is multi select?");
		if (multiDropdown.isMultiple()) {
			System.out.println("Dropdown is multi select");
		} else {
			System.out.println("Dropdown is not multi select");
		}

		System.out.println("Step6: Select all even numbers");
		for (WebElement element : allOptions) {
			int num = Integer.parseInt(element.getText());
			if (num % 2 == 0) {
				multiDropdown.selectByVisibleText(element.getText());
			}
		}

		System.out.println("Step7: Print first selected number");
		WebElement firstSelect = multiDropdown.getFirstSelectedOption();
		System.out.println("First selected number --> " + firstSelect.getText());

		System.out.println("Step8: Check how many options are selected ?");
		List<WebElement> allSelected = multiDropdown.getAllSelectedOptions();
		System.out.println("Selected options --> ");
		for (WebElement selected : allSelected) {
			System.out.println(selected.getText());
		}

		System.out.println("Step9: Deselect first selected number");
		multiDropdown.deselectByVisibleText(firstSelect.getText());

		System.out.println("Step10: Now deselect all selected option and select all non-selected options");
		for (WebElement element : allOptions) {
			if (element.isSelected()) {
				multiDropdown.deselectByVisibleText(element.getText());
			} else {
				multiDropdown.selectByVisibleText(element.getText());
			}
		}

		System.out.println("Step11: Print all selected option's text");
		System.out.println("All select options are --> ");
		allSelected = multiDropdown.getAllSelectedOptions();
		for (WebElement element : allSelected) {
			System.out.println(element.getText());
		}
		
		driver.close();
	}
}
