
/*
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
 */
package HindaviIngle.Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import HindaviIngle.base.PredefinedActions;

public class DropdownMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("http://www.Automationbykrishna.com");

		System.out.println("**STEP2 :Click on basic element**");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("**STEP3 :Locate a dropdown**");
		WebElement numberElement = driver.findElement(By.xpath("//div[@class='panel-body']/form/div[3]//select[1]"));

		System.out.println("**STEP4 :Scroll down to dropdown**");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", numberElement);

		Select s = new Select(numberElement);

		System.out.println("**STEP5 :Select single element**");
		// s.selectByVisibleText("3");

		System.out.println("**STEP6 :find dropdown is multiselect or not**");
		System.out.println("Multiselect : " + s.isMultiple());

		System.out.println("**STEP7 :how many options are there ?**");
		List<WebElement> listOfElement = s.getOptions();
		System.out.println("Total number are :" + listOfElement.size());

		System.out.println("**STEP8 :Select all even numbers**");
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
		System.out.println("**STEP 9: print first selected number**");
		String selectedElement = s1.getFirstSelectedOption().getText();
		System.out.println("First selected element :" + selectedElement);

		System.out.println("how many options are selected --->");
		List<WebElement> listOfSelected = s1.getAllSelectedOptions();
		System.out.println("Number of selected elements are " + listOfSelected.size());

		System.out.println("**STEP 10 : deselect first selected number.**");
		WebElement firstOption = s1.getFirstSelectedOption();
		s1.deselectByVisibleText(firstOption.getText());
		Thread.sleep(2000);

		listOfSelected = s1.getAllSelectedOptions();
		System.out.println("Modified Size : -->" + listOfSelected.size());

		System.out.println("**STEP 11: Deselect all selected option and select all non-selected options**");
		List<WebElement> totalElement = s1.getOptions();
		for (WebElement e : totalElement) {
			if (e.isSelected()) {
				s1.deselectByVisibleText(e.getText());

				// s1.deselectAll();
				Thread.sleep(2000);
			} else {
				s1.selectByVisibleText(e.getText());
				Thread.sleep(2000);
			}

		}

		System.out.println("STEP 9: print all selected option's text");
		List<WebElement> outputList = s1.getAllSelectedOptions();
		for (WebElement e : outputList) {
			System.out.println(e.getText());
		}
		driver.close();
	}

}
