//Assignment 4 : Dropdown Methods

package komalShrivastava.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import komalShrivastava.base.PredefinedActions;

public class DropdownMethodPractice {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("STEP : Launch Browser and load URL");
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP : Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP : Identify the Dropdown");
		WebElement dd = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		Select select = new Select(dd);
		
		System.out.println("STEP : Get all the options");
		List<WebElement> options = select.getOptions();
		System.out.println("Options : " + options.size());

		WebElement dd2 = driver.findElement(By.xpath("//select[@class='form-control m-bot15']/following-sibling::select"));
		Select select2 = new Select(dd2);
		System.out.println("STEP : Verify if dropdown2 is multi-select");
		System.out.println("Dropdown Multi-select : " + select2.isMultiple());
		
		System.out.println("STEP : Select all even numbers in dropdown");
		List<WebElement> ddValues = select2.getOptions();
		for(WebElement value : ddValues) {
			int num = Integer.parseInt(value.getText());
			if(num%2==0)
				value.click();
		}
		List<WebElement> listOfSelectedOptions = select2.getAllSelectedOptions();
		System.out.println("STEP : Print first selected number");
		System.out.println("FirstSelected option is : " + select2.getFirstSelectedOption().getText());
		
		System.out.println("STEP : Get count of selected numbers");
		System.out.println("Count of Selected Numbers : " + listOfSelectedOptions.size());
		
		Thread.sleep(1500);
		System.out.println("STEP : Deselect First selected option");
		WebElement firstSelected = select2.getFirstSelectedOption();
		select2.getFirstSelectedOption().click();
		
		Thread.sleep(1500);
		System.out.println("STEP :Select the deselected option: ");
		firstSelected.click();
		
		System.out.println("STEP :Selected Options : ");
		for(WebElement e : listOfSelectedOptions) {
			System.out.println(e.getText() + " ");
		}
		System.out.println("STEP : Deselect all selected option and select all non-selected options");
		List<WebElement> allOptions = select2.getOptions();
		for(WebElement e : allOptions) {
			if(e.isSelected())
				e.click();
			else
				e.click();
		Thread.sleep(1500);	
		}

		System.out.println("STEP : Print all selected elements");
		System.out.println("Selected options : ");
		listOfSelectedOptions = select2.getAllSelectedOptions();
		for(WebElement e : listOfSelectedOptions) {
			System.out.println(e.getText() + " ");
		}
	}
}