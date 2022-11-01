package vibha;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main (String[] args) throws InterruptedException {
	System.out.println("STep:-1 launch browser and click url");
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://automationbykrishna.com/");

	System.out.println("STep:-2 Click on basic element tab and perform below step on multi Select drop down");
	driver.findElement(By.id("basicelements")).click();
	Thread.sleep(2000);
	
	WebElement element=driver.findElement(By.xpath("//div[@class ='panel-body']//form/div[3]//select[1]"));
	System.out.println("Step:-3 Scroll down to dropdown");
	JavascriptExecutor je=(JavascriptExecutor)driver;
	je.executeScript("arguments[0].scrollIntoView(true)", element);
	
	System.out.println("Step:-4 how many option are there");
	WebElement multiselectelement=driver. findElement(By.xpath("//div[@class ='panel-body']//form/div[3]//select[2]"));
		Select select=new Select(multiselectelement);
		
		System.out.println("Step:-5 is thatdropdown  multi select or not ");
		System.out.println("MultipleSelect:- " +select.isMultiple());
	
	 
	 System.out.println("Step:-6 select all even number ");
	 
	List<WebElement> listOfitems= select.getOptions();
	for(WebElement e:listOfitems) {
		int num=Integer.parseInt(e.getText());
		if(num%2==0) {
			select.selectByVisibleText(e.getText());
		}
	}
	 System.out.println("Step:-7 Print first selecetd Number ");
	 String selectedElement= select.getFirstSelectedOption().getText();
	 System.out.println(selectedElement);
	 
	 System.out.println("Step:-8 Print first deselecetd Number ");
	 WebElement firstoption=select.getFirstSelectedOption();
	 select.deselectByVisibleText(firstoption.getText());
	 
	 Thread.sleep(2000);
	 
	 System.out.println("Step:-9 Print all selected options ");
	 listOfitems= select.getAllSelectedOptions();
	 System.out.println(" Remaining selected number "+listOfitems.size());
	 
	 System.out.println("Step:-10 Deselect all selected options and selected all deselected option ");
	List<WebElement> totalelementnumber=select.getOptions();
	for(WebElement e1:totalelementnumber) {
		if(e1.isSelected()) {
			select.deselectByVisibleText(e1.getText());
			Thread.sleep(2000);
		}else {
			select.selectByVisibleText(e1.getText());
			Thread.sleep(2000);
		}
	}
	System.out.println("Step:-11 Print all selected options ");
	List <WebElement> finalList=select.getAllSelectedOptions();
	for(WebElement e2:finalList) {
		System.out.println(e2.getText());
	}
	}
}