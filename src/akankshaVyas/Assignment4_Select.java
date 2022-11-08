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

package akankshaVyas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import akankshaVyas.base.PredefinedActions;

public class Assignment4_Select {

	@Test
	void testCase4() throws InterruptedException {

		System.out.println("STEP 1 - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP 2 - Hit url");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Step2: Click on basicElements");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Step3: selected dropdown");
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		// code to print all option of dropdown and size
		Select sel = new Select(element);
		List<WebElement> ls = sel.getOptions();
		System.out.println("Count of avaialble option is : " + ls.size());
		System.out.println("STEP: Verify how many options are there in multiselect dropdown");
		for (WebElement e : ls)
			System.out.println(e.getText());

		// code to find dropdown is multiselect?
		System.out.println("STEP: Verify is that dropdown multi select");
		if (sel.isMultiple()) {
			System.out.println("is multiple select dropdown");
		} else {
			System.out.println("not multiple select dropdown");
		}

		// code to select all even numbers from multiselect dropdown
		Thread.sleep(2000);
		System.out.println("STEP: Select all even numbers from multiselect");
		for (WebElement webElement : ls) {
			String values = webElement.getText();
			int num = Integer.parseInt(values);
			if (num % 2 == 0) {
				sel.selectByVisibleText(values);
				Thread.sleep(2000);
				System.out.println((webElement.getText()));
			}
		}

		// //code to print 1st selected number from multiselect dropdown
		System.out.println("STEP: Print 1st selected option");
		Thread.sleep(2000);
		System.out.println(sel.getFirstSelectedOption().getText());

		// code to print how many options are selected
		System.out.println("STEP: Print all selected options");
		Thread.sleep(2000);
		List<WebElement> listOfOptions = sel.getAllSelectedOptions();
		for (WebElement e : listOfOptions)
			System.out.println(e.getText());

		// code to deselect first selected number
		System.out.println("STEP: Deselect first selected option");
		Thread.sleep(2000);
		// listOfOptions=sel.getAllSelectedOptions();
		sel.deselectByVisibleText(sel.getFirstSelectedOption().getText());

		//// code to deselect all selected options and select all non-selected options
		System.out.println("STEP: Deselect all selected options and select all non-selected options");
		Thread.sleep(2000);
		for (WebElement e : ls) {
			if (e.isSelected())
				sel.deselectByVisibleText(e.getText());
			else
				sel.selectByVisibleText(e.getText());
		}

		//// code to print all selected options
		System.out.println("STEP: Print all selected options");
		Thread.sleep(2000);
		listOfOptions = sel.getAllSelectedOptions();
		for (WebElement e : listOfOptions)
			System.out.println(e.getText());
	}

	public void closeingBrowser() {
		PredefinedActions.closeBrowser();
	}
	
}
