//Assignment - 4 : 29th Oct'2022
	//Go to Automationbykrishna.com
	//Go to Basic Element and perform below step on multi select dropdown
	//how many options are there ?
	//is that drodown is multi select.
	//select all even numbers
	//print first selected number.
	//how many options are selected ?
	//deselect first selected number.
	//now deselect all selected option and select all non-selected options.
	//print all selected option's text.

	package Titiksha;

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;


	public class Assignmnet_4_Dropdown {
		@Test
		public void assignment4Dropdown() throws InterruptedException{
			
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Testcase-1:Call chrome driver");
			
			driver.get("http://automationbykrishna.com/#");
			System.out.println("Testcase-2:Call automationbykrishna webpage");
			
			
			driver.findElement(By.id("basicelements")).click();
			Thread.sleep(2000);
			System.out.println("Testcase-3:Press basic elelment button ");
			Thread.sleep(1000);
			
			WebElement dropDownList=driver.findElement(By.xpath("//div[@class='panel-body']//div[3]//select[2]"));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true)", dropDownList);
			System.out.println("Testcase-4:Scroll Down ");
			
			System.out.println("Testcase-5:How many options are there");
			Select allOption=new Select(dropDownList);
			List<WebElement> listOfElemnet=allOption.getOptions();
			for(WebElement e:listOfElemnet) {
				System.out.println(e.getText());}
			
			
			if(allOption.isMultiple()) {
				System.out.println("Test case-6:Multiple option selelction allowed");}
			else {
				System.out.println("Test case-6:Multiple option selelction not allowed");}
			
			System.out.println("Testcase-7:All even numbers are selected");
			for(WebElement e:listOfElemnet) {
			int num=Integer.parseInt(e.getText());
			if(num%2==0) {
				allOption.selectByVisibleText(e.getText());
				}
			}
			
			System.out.println("Testcase-8:Select first option from dropdown from even list");	
			String output=allOption.getFirstSelectedOption().getText();
			System.out.println(output);
			
			System.out.println("Test case-9:Selected options are");
			List<WebElement> selectedOptions=allOption.getOptions();
			for(WebElement h:selectedOptions) {
			if(h.isSelected()) {
				System.out.println(h.getText());}}
			
			System.out.println("Test case-10:Deselected first options");
			allOption.deselectByVisibleText(allOption.getFirstSelectedOption().getText());
			
			System.out.println("Test case-11:now deselect all selected option and select all non-selected options.");
			for(WebElement g:listOfElemnet) {
				if(g.isSelected()) {
					allOption.deselectByVisibleText(g.getText());}
				else {
					allOption.selectByVisibleText(g.getText());}
			}
				
			
			System.out.println("Test case-12:Selected options are");
			Thread.sleep(2000);
			listOfElemnet=allOption.getAllSelectedOptions();
			for(WebElement e:listOfElemnet) {
				System.out.println(e.getText());}
			
			driver.close();
			}
			
	}