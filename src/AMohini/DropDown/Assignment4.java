/********
 * Assignment - 4 : 29th Oct'2022
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
 * ********/

package AMohini.DropDown;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AMohini.CommonActions.*;
public class Assignment4 {

public static void main(String[] args) throws InterruptedException {
	
	//Initialize Chrome browser , get URL to open , maximize the window and wait for 2 sec Load page
	System.out.println("STEP - Launch Chrome browser & load URL");
	WebDriver driver=PredefinedActions.start("http://automationbykrishna.com/");
	
	//Click on Basic elements menu option using Xpath/findelement ad click methods of WebDriver class
	
	System.out.println("STEP: Click on Basic Elements Tab");
	driver.findElement(By.xpath("//a[@id='basicelements']")).click();
	
	// Scroll down on webpage using excuteScript method of JavascriptExecutor class
			JavascriptExecutor js = (JavascriptExecutor) driver; //type casted diver instance from WebDriver to JavascriptExecutor
			js.executeScript("window.scrollBy(0,200)");
	
	
			
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

