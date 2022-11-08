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

package pujaSah.DropDownMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pujaSah.Base.PredefinedActions;

class DropDownTest{

	public static void main(String[] args) throws InterruptedException{
		System.out.println("STEP 1: Launch chrome browser and hit url--------");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/index.html");
		
		System.out.println("STEP 2: Click on Basic Elements--------");
		driver.findElement(By.id("basicelements")).click();
		//driver.findElement(By.xpath("//a[@id='basicElements']")).click();
		Thread.sleep(2000);
		
		WebElement selectElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[1]"));
		
		System.out.println("STEP 3: Scroll upto Selects---------------------");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",selectElement);
		
		Select dropdown = new Select(selectElement);
		System.out.println("VERIFY: How many options are there-----------------------------");
		List<WebElement> totalOptions = dropdown.getOptions();
		System.out.println("Total number of options: " + totalOptions.size());
		if(totalOptions.size() == 5){
			System.out.println("PASS");
		}
		
		WebElement multiSelectElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		Select multiSelectDropdown = new Select(multiSelectElement);
		
		System.out.println("VERIFY: Dropdown is MultiSelect-----------------------------");
		if(multiSelectDropdown.isMultiple()){
			System.out.println("Drop down is multiselect");
			System.out.println("PASS");
		}else{
			System.out.println("Drop down is single select");
			System.out.println("FAIL");
		}
		
		System.out.println("STEP 4: Select all even number options from dropdown menu----------------------");
		if(multiSelectDropdown.isMultiple()){
			for(WebElement e : totalOptions){
				if(Integer.parseInt(e.getText())%2 == 0){
					multiSelectDropdown.selectByVisibleText(e.getText());
				}
			}
		}else{
			System.out.println("Not a multiselect dropdown");
		}
		
		System.out.println("STEP 5: Print first selected option------------------");
		WebElement firstOption = multiSelectDropdown.getFirstSelectedOption();
		System.out.println("First selected option is: " +  firstOption.getText());
		
		System.out.println("STEP 6: Print how many options are selected---------------");
		List<WebElement> allSelectedOptions = multiSelectDropdown.getAllSelectedOptions();
		System.out.println("Total number of selected options is: " +  allSelectedOptions.size());
		
		System.out.println("STEP 7: Deselect first selected option-------------------");
		multiSelectDropdown.deselectByVisibleText(firstOption.getText());	
		
		System.out.println("STEP 8: Deselect all selected options and select all non selected options-------------------");
		List<WebElement> allOptions= multiSelectDropdown.getOptions();
		for(WebElement e : allOptions){
			if(e.isSelected()){
				multiSelectDropdown.deselectByVisibleText(e.getText());
			}
			else{
				multiSelectDropdown.selectByVisibleText(e.getText());
			}
		}
		
		System.out.println("STEP 9: print all selected option's text---------------");
		List<WebElement> outputList= multiSelectDropdown.getAllSelectedOptions();
		for(WebElement e : outputList){
			System.out.println(e.getText());
		}	
	}		
}
		
		