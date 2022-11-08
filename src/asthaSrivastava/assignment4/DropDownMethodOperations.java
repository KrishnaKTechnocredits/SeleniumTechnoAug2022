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
package asthaSrivastava.assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import asthaSrivastava.PredefinedActionsLaunchUrl;

public class DropDownMethodOperations {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActionsLaunchUrl.start();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP : Go to Basic Element and perform below step on multi select dropdown");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement numElement = driver.findElement(By.xpath("//div[@class ='panel-body']//div[3]//select[2]"));
		PredefinedActionsLaunchUrl.scrollToElement(numElement);
		System.out.println("STEP : Scroll to MultiSelect Drop Down Option");

		Select multiSelectDropDown = new Select(numElement);

		List<WebElement> listOfElements = multiSelectDropDown.getOptions();
		System.out.println("STEP : Total available options is : " + listOfElements.size());

		System.out.println("VERIFY - Is that drodown is multi select?");
		if (multiSelectDropDown.isMultiple()) {
			System.out.println("Drop Down is Multi Select");
		} else {
			System.out.println("Drop Down is not Multi Select");
		}

		System.out.println("STEP : Select all even numbers.");
		for (WebElement e : listOfElements) {
			int num = Integer.parseInt(e.getText());
			if (num % 2 == 0) {
				multiSelectDropDown.selectByVisibleText(e.getText());
			}
		}
		System.out.println("STEP : Print first selected number.");
		/*
		 * for(WebElement e : listOfElements) { if(e.isSelected()) {
		 * System.out.println(e.getText()); break; } }
		 */
		WebElement output = multiSelectDropDown.getFirstSelectedOption();
		System.out.println("First selected number --> " + output.getText());

		System.out.println("STEP : How many options are selected ?");
		List<WebElement> listOfCurrentSelectedOptions = multiSelectDropDown.getAllSelectedOptions();
		System.out.println(listOfCurrentSelectedOptions.size());

		System.out.println("STEP : Deselect first selected number from selected options.");
		multiSelectDropDown.deselectByVisibleText(output.getText());

		for (WebElement e : listOfCurrentSelectedOptions) {
			System.out.println(e.getText());
		}

		List<String> allSelectedElementText = new ArrayList<String>();
		for (WebElement e : listOfCurrentSelectedOptions) {
			allSelectedElementText.add(e.getText());
		}
		System.out.println("STEP : Now deselect all selected option and select all non-selected options.");

		for (WebElement e : listOfElements) {
			if (e.isSelected()) {
				multiSelectDropDown.deselectByVisibleText(e.getText());
			} else {
				multiSelectDropDown.selectByVisibleText(e.getText());
			}
		}
		System.out.println("Step11: Print all selected option's text");
		System.out.println("All select options are --> ");
		listOfCurrentSelectedOptions = multiSelectDropDown.getAllSelectedOptions();
		for (WebElement element : listOfCurrentSelectedOptions) {
			System.out.println(element.getText());
		}
		
		PredefinedActionsLaunchUrl.closeAllBrowser();
	}
}