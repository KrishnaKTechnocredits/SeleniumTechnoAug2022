/*Assignment - 4 : 29th Oct'2022
Go to Automationbykrishna.com
Go to Basic Element and perform below step on multi select dropdown
how many options are there ?
is that dropdown is multi select.
select all even numbers
print first selected number.
how many options are selected ?
deselect first selected number.
now deselect all selected option and select all non-selected options.
print all selected option's text.

output : 1235*/
package Shruti.Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void main(String[]args)throws InterruptedException {
		System.out.println("STEP: Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		System.out.println("STEP: Click on Basic Elements Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		// code to scroll down on webpage
		Thread.sleep(2000);
		System.out.println("STEP: Scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		//code to get all options from multiselect dropdown
		System.out.println("STEP: Verify how many options are there in multiselect dropdown");
		WebElement numberElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		Select numberOfOptions = new Select(numberElement);
		List<WebElement> listOfAllNumbers = numberOfOptions.getOptions();
		for(WebElement e : listOfAllNumbers)
		System.out.println(e.getText());
		
		//code to check if dropdown is multiselect dropdown
		Thread.sleep(2000);
		System.out.println("STEP: Verify is that dropdown multi select");
		if(numberOfOptions.isMultiple()) 
			System.out.println("Yes, it is multiselect dropdown");
		else 
			System.out.println("No, it is not multiselect dropdown");
		
		//code to select all even numbers from multiselect dropdown
		Thread.sleep(2000);
		System.out.println("STEP: Select all even numbers from multiselect");
		for(WebElement e : listOfAllNumbers) {
			String values = e.getText();
			int numbers = Integer.parseInt(values);
			if(numbers % 2 == 0) {
				numberOfOptions.selectByVisibleText(values);
				Thread.sleep(2000);
				System.out.println(e.getText());
			}
		}
		
		//code to print 1st selected number from multiselect dropdown
		System.out.println("STEP: Print 1st selected option");
		System.out.println(numberOfOptions.getFirstSelectedOption().getText());
		
		//code to print how many options are selected
		System.out.println("STEP: Print all selected options");
		List<WebElement> listOfSelectedNumbers = numberOfOptions.getOptions();
		for(WebElement e : listOfSelectedNumbers)
		System.out.println(e.getText());
		
		//code to deselect first selected number
		System.out.println("STEP: Deselect first selected option");
		numberOfOptions.deselectByVisibleText(numberOfOptions.getFirstSelectedOption().getText());
		
		//code to deselect all selected options and select all non-selected options
		System.out.println("STEP: Deselect all selected options and select all non-selected options");
		for(WebElement e : listOfAllNumbers) {
			if(e.isSelected()) 
				numberOfOptions.deselectByVisibleText(e.getText());
			else
				numberOfOptions.selectByVisibleText(e.getText());
			}
		
		//code to print all selected options
		System.out.println("STEP: Print all selected options");
		listOfSelectedNumbers = numberOfOptions.getAllSelectedOptions();
		for (WebElement e : listOfSelectedNumbers) {
			System.out.print(e.getText());
		}
		driver.close();
	}
}