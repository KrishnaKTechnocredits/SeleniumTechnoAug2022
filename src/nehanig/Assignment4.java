package nehanig;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Assignment4 {

	public static void main(String[] args) throws InterruptedException{
		System.out.println("Launch Crome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_106.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 1:Hit URL");
		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP 2: Click on basic Element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		WebElement selectElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[1]"));
		
		System.out.println("STEP 3: Scroll upto Selects");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",selectElement);
		
		Select dropdown = new Select(selectElement);
		System.out.println("VERIFY: How many options are there?");
		List<WebElement> totalOptions = dropdown.getOptions();
		System.out.println("Number of options: " + totalOptions.size());
		if(totalOptions.size() == 5){
			System.out.println("PASS");
		}

		WebElement multiSelectElement = driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
		Select multiSelectDropdown = new Select(multiSelectElement);

		System.out.println("VERIFY: Dropdown is MultiSelect?");
		if(multiSelectDropdown.isMultiple()){
			System.out.println("Drop down is multiselect");
			System.out.println("PASS");
		}else{
			System.out.println("Drop down is single select");
			System.out.println("FAIL");
		}
		System.out.println("STEP 4: Select all even number options from dropdown menu");
		if(multiSelectDropdown.isMultiple()){
			for(WebElement e : totalOptions){
				if(Integer.parseInt(e.getText())%2 == 0){
					multiSelectDropdown.selectByVisibleText(e.getText());
				}
			}
		}else{
			System.out.println("Not a multiselect dropdown");
		}

		System.out.println("STEP 5: Print first selected option");
		WebElement firstOption = multiSelectDropdown.getFirstSelectedOption();
		System.out.println("First selected option is: " +  firstOption.getText());

		System.out.println("STEP 6: Print how many options are selected");
		List<WebElement> allSelectedOptions = multiSelectDropdown.getAllSelectedOptions();
		System.out.println("Total number of selected options is: " +  allSelectedOptions.size());

		System.out.println("STEP 7: Deselect first selected option");
		multiSelectDropdown.deselectByVisibleText(firstOption.getText());	

		System.out.println("STEP 8: Deselect all selected options and select all non selected options");
		List<WebElement> allOptions= multiSelectDropdown.getOptions();
		for(WebElement e : allOptions){
			if(e.isSelected()){
				multiSelectDropdown.deselectByVisibleText(e.getText());
			}
			else{
				multiSelectDropdown.selectByVisibleText(e.getText());
			}
		}

		System.out.println("STEP 9: print all selected option's text");
		List<WebElement> outputList= multiSelectDropdown.getAllSelectedOptions();
		for(WebElement e : outputList){
			System.out.println(e.getText());
		}	
	}
}