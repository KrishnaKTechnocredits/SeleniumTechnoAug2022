/*Go to Automationbykrishna.com
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

package manjiri.assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manjiri.base.PredefinedActions;


public class MultiSelectDropdown {
	
	WebDriver driver;

	@BeforeMethod
	public void setup(){
		System.out.println("STEP - Launch browser and hit URL");
		driver = PredefinedActions.start("http://automationbykrishna.com/");
	}

	@Test
	public void multiSelectDropdown() throws InterruptedException {
		System.out.println("Click on Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("Scroll to the element");
		WebElement ele = driver.findElement(By.xpath("//div[@class='col-lg-10']/select[2]"));
		PredefinedActions.scrollToElement(ele);
		Thread.sleep(2000);
		System.out.print("how many options are there ?: ");
		Select select = new Select(ele);
		List<WebElement> listOfOptions = select.getOptions();
		System.out.println(listOfOptions.size());
		System.out.println("is that drodown is multi select.");
		boolean isMulti = select.isMultiple();
		System.out.println(isMulti);
		System.out.println("select all even numbers");
		for(WebElement e : listOfOptions) {
			int num = Integer.parseInt(e.getText());
			if(num % 2 == 0) {
				select.selectByVisibleText(e.getText());
			}
		}
		System.out.print("print first selected number: ");
		String str = select.getFirstSelectedOption().getText();
		System.out.println(Integer.parseInt(str));
		System.out.print("how many options are selected ?: ");
		System.out.println(select.getAllSelectedOptions().size());
		System.out.println("deselect first selected number.");
		select.deselectByVisibleText(str);
		System.out.println("now deselect all selected option and select all non-selected options.");
		for(WebElement e : listOfOptions) {
			if(e.isSelected()) {
				select.deselectByVisibleText(e.getText());
			}
			else {
				select.selectByVisibleText(e.getText());
			}
		}
		System.out.println("print all selected option's text.");
		List<WebElement> listOfSelectedOptions = select.getAllSelectedOptions();
		for(WebElement e : listOfSelectedOptions) {
			System.out.println(e.getText());
		}
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
