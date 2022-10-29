//Testcases:
//1-Open chrome browser
//2-Maximize chrome browser screen
//3-open automationkrishna webpage
//4-click basicinfo button
//5-add user name and lastname and company
//6-press submit.on submit button alert should come.
//7-on alert verify reject msg 
//8=then press accept alert

package Titiksha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2_Selenium  {
	public static void main(String[] args) throws Exception{
		System.out.println("Testcase1:Open chrome browser");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		WebDriver driver=new ChromeDriver();//parent child relation building
		Thread.sleep(2000);
		
		System.out.println("Testcase2:Maximize chrome browser screen");
		driver.manage().window().maximize();//driver represent chrome driver //manage method action performed // window reprsent chrome driver window//maximize method increasing window size
		Thread.sleep(2000);
		
		System.out.println("Testcase3:Open automationkrishna webpage");
		driver.get("http://automationbykrishna.com/#");//giving command to open automation krishna webpage in chrome driver
		//a) The get() method takes a string URL as a parameter and returns nothing.
		//b) This method opens the specified URL in the current browser window.
		Thread.sleep(2000);
		
		System.out.println("Testcase4:Click basicinfo button");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("Testcase5:add user name and lastname and company");
		String firstName="Titiksha";//giving dynamic value rather than hardcode
		String lastName="Goel";
		String company="TCS";
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);//other option was to give hardcode name//This command is used to uniquely identify a web element within the web page
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);//send key method helps to pass the value 
		driver.findElement(By.id("UserCompanyName")).sendKeys(company);
		
		System.out.println("Testcase6:Press submit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();//bitton doesnot ahve id type so we have given xpath //tagname[@attribute='attribute value']
	
		System.out.println("Testcase7:On alert verify reject msg");
		Alert alert=driver.switchTo().alert();//switch to method change driver focus from window to alert
		String expectedText=firstName+" "+"and"+" "+lastName+" "+"and"+" "+company;
		String actualText=alert.getText();
		if(expectedText.equals(actualText)) {
			System.out.println("Testcase pass");}
		else {
			System.out.println("Testcase Fail");}
		Thread.sleep(2000);
		
		System.out.println("Testcase8:Accept alert");
		alert.accept();
		
		driver.close();
	
	}	
}
