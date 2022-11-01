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

package SwatiM.seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import SwatiM.base.PredefinedActions;



public class Assignment4_Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Step 1 - Launch Chrome Browser and open URL");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		
		// Clicking on basic element tab and waiting for 2 sec to get loading complete
				System.out.println("Step 2 - Click on basic element tab");
				driver.findElement(By.xpath("//a[@id='basicelements']")).click();
				Thread.sleep(2000);
				
				// Scrolling till multiselect dropdown is visible
				System.out.println("Step 3 - Scroll till multi select dropdown");
				WebElement multiselect = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
				PredefinedActions.scrollTillElement(multiselect);

				// Printing all the available values in multiselect dropdown
				Select multiDropDown = new Select(multiselect);
				System.out.println("Step 4 - Checking total options available there: ");
		
				List<WebElement> multiOption = multiDropDown.getOptions();
				for (WebElement e : multiOption) {
					System.out.println("	" + e.getText());
				}
				
				// Checking if dropdown is multiselect or not
				System.out.println("Step 5 - Validating that if dropdown is multiselect or not: ");
				boolean flag = multiDropDown.isMultiple();
				if (flag) {
					System.out.println("	Dropdown is Multiselect");
				} else {
					System.out.println("	Dropdown is not Multiselect");
				}
				
				// Selecting all even numbers from dropdown
				System.out.println("Step 6 - Selecting all even Numbers");
				for (WebElement e : multiOption) {
					int num = Integer.parseInt(e.getText());
					if (num % 2 == 0) {
						multiDropDown.selectByVisibleText(e.getText());
						System.out.println("	Selected value : " + e.getText());
					}
				}

				// Printing 1st selected number
				System.out.println("Step 7 - Printing 1st selected number");
				WebElement firstSelected = multiDropDown.getFirstSelectedOption();
				System.out.println("	1st selected number is : " + firstSelected.getText());

				// checking and printing total number of selected values
				System.out.println("Step 8 - Checking how many numbers are selected");
				List<WebElement> allSelected = multiDropDown.getAllSelectedOptions();
				System.out.println("	Total selected numbers are :" + allSelected.size());

				// Deselecting 1st value
				System.out.println("Step 9 - Deselecting 1st element");
				multiDropDown.deselectByVisibleText(firstSelected.getText());
				System.out.println("	First selected element is now deselected");
				List<WebElement> allSelectedNew = multiDropDown.getAllSelectedOptions();

				// Deselecting all selected value and selecting all deselected value
				System.out.println("Step 10 - Deselecting all selected option and selecting deselected options");
				for (WebElement e : multiOption) {
					if (allSelectedNew.contains(e)) {
						multiDropDown.deselectByVisibleText(e.getText());
					} else {
						multiDropDown.selectByVisibleText(e.getText());
					}
				}
				System.out.println("	 Desired operation is successful");

				// storing values of all selected value in a list
				List<WebElement> finalSelectedValues = multiDropDown.getAllSelectedOptions();

				// printing all the selected value
				System.out.println("Step 11 - Printing all selected values");

				for (WebElement e : finalSelectedValues) {
					System.out.println("	" + e.getText());
				}

				// Closing the browser
				System.out.println("Step 12 - Closing the browser");
				PredefinedActions.closeAllBrowsers();
				System.out.println("Test Case passed!!");
				

	}

}
