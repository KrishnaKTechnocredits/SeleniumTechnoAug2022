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

package gauravSahu.Assignment;

import java.util.List;

import javax.swing.colorchooser.DefaultColorSelectionModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\\\AUG 2022 CLASS\\\\Selenium2022\\\\SeleniumTechnoAug2022\\\\drivers\\\\chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 : Verify Chrome Browser Launched");

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']/ul[1]/li[4]/a")).click();

		Thread.sleep(2000);
		WebElement element1 = driver
				.findElement(By.xpath("//div[@class='wrapper']/section/div[5]//section[2]//select[2]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element1);
		System.out.println("Step 2 : Scroll Down to dropdown ");

		Select dropDownMenu = new Select(element1);
		List<WebElement> listOfElements = dropDownMenu.getOptions();
		int count = 0;
		for (WebElement num : listOfElements) {
			System.out.println(num.getText());
			count++;
		}

		System.out.println("Step 3 : Total options in DropDown : " + count);

		boolean multiselect = dropDownMenu.isMultiple();
		System.out.println("Step 4 : It is multiselect options :" + multiselect);

		Thread.sleep(2000);
		for (WebElement num : listOfElements) {
			if (Integer.parseInt(num.getText()) % 2 == 0) {
				dropDownMenu.selectByVisibleText(num.getText());
				Thread.sleep(2000);
			}
		}

		System.out.println("Step 5 : Even options Selected");

		System.out.println("Step 6 : First Selected Number is  : " + dropDownMenu.getFirstSelectedOption().getText());

		int optionSelected = 0;
		for (WebElement options : listOfElements) {
			if (options.isSelected()) {
				optionSelected++;
			}
		}
		System.out.println("Step 7 : Selected options are : " + optionSelected);

		Thread.sleep(2000);
		WebElement deSelectoption = dropDownMenu.getFirstSelectedOption();
		dropDownMenu.deselectByVisibleText(deSelectoption.getText());
		System.out.println("Step 8 : First option DeSelected");

		int selectedOptions = 0;
		for (WebElement options : listOfElements) {
			if (options.isSelected()) {
				selectedOptions++;
			}
		}

		System.out.println("Step 9 : Selected Options : " + selectedOptions);

		Thread.sleep(2000);
		for (WebElement s : listOfElements) {
			if (s.isSelected()) {
				dropDownMenu.deselectByVisibleText(s.getText());
			} else {
				dropDownMenu.selectByVisibleText(s.getText());
			}
		}
		System.out.println("Step 10 : deselect all selected option and select all non-selected options.");

		System.out.println("Step 11 :  all selected option's text are");
		for (WebElement k : listOfElements) {
			if (k.isSelected()) {
				System.out.println(k.getText());
			}
		}

	}

}
