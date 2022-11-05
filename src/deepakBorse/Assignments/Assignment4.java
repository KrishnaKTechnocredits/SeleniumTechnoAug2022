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

output : 1235
 */
package deepakBorse.Assignments;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deepakBorse.base.PredefinedActions;

public class Assignment4 {
	WebDriver driver;

	@BeforeMethod
	public void initprocess() {
		System.out.println(" launch your orange HRM site");
		driver = PredefinedActions.start("http://Automationbykrishna.com");

	}

	@Test
	public void multidropdownselect() throws InterruptedException {
		System.out.println("Step - Click on basic element tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		// WebElement
		// element=driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		WebElement ele = (driver.findElement(By.xpath("//div[@class='col-lg-10']/select[2]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(3000);

		Select se = new Select(ele);
		List<WebElement> Option = se.getOptions();
		// List<WebElement> option = se.getOptions();
		System.out.println("Total options present in drop :" + Option.size() + " and options are as follows");

		for (WebElement i : Option) {
			System.out.println(i.getText());
		}

		if (se.isMultiple()) {
			System.out.println("Dropdown is multiselect");
		} else {
			System.out.println("Dropdown is not multiselect");
		}
		System.out.println("Select all Even Number from multisect dropdown");
		for (WebElement i : Option) {
			String dropvalue = i.getText();
			int intdrop = Integer.parseInt(i.getText());
			if (intdrop % 2 == 0) {
				// System.out.println(i.getText());
				se.selectByVisibleText(dropvalue);
			}
		}
		Thread.sleep(4000);
		System.out.println("Print First selected number : " + se.getFirstSelectedOption().getText());

		List<WebElement> selectedoption = se.getAllSelectedOptions();
		System.out.println("How many options are selected from multiselect dropdown?");
		for (WebElement we : selectedoption) {
			System.out.println(we.getText());
		}
		System.out.println("Deselect first selected number");
		se.deselectByVisibleText(se.getFirstSelectedOption().getText());

		System.out.println("Deselect all selected option and select all non-selected options");
		for (WebElement we : Option) {
			if (we.isSelected())
				se.deselectByVisibleText(we.getText());
			else
				se.selectByVisibleText(we.getText());
		}

		System.out.println("print all selected option's text are as follows");
		selectedoption = se.getAllSelectedOptions();
		for (WebElement we : selectedoption) {
			System.out.println(we.getText());
		}
	}

	@AfterMethod
	public void endprocess() {
		PredefinedActions.closeAllBrowser();
	}
}
