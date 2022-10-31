/*
Assignment No 1 : 
			Test Cases: 
				1.Launch chrome browser
				2.Hit url(html page created)in browser.
				3.Verify application is loaded successfully.
				4.Enter First Name
				5.Enter Last Name
				6.Select gender radio button (at a time only one radio button should be selected)
				7.Select Hobbies checkbox (user can select multiple checkboxes)
				8.Select value from branch dropdown.
				9.Click on Click here link should redirect to url configured (eg. https://www.google.com).
				10.Navigate back to the previous url.
				11.Verify html page is loaded again.
*/

package Sunil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class Assignment_1 {
	
	public static void main(String[] args) {
		
		System.out.println("TC1:- Launch Chrome Browser");
		System.out.println("TC2:- Hit URL (HTML Page Created)In Browser");
		System.out.println("TC3:- Verify Application Is Loaded Successfully");
		WebDriver driver = PredefinedActions.start("file:///D:/TechnoCredits/Projects/Aug22/eclipse/SeleniumTechnoAug2022/src/Sunil/FirstPage.html");  
		//System.setProperty("webdriver.chrome.driver", "file:///D:/TechnoCredits/Projects/Aug22/eclipse/SeleniumTechnoAug2022/src/Sunil/FirstPage.html");  

		System.out.println("TC4:- Enter First Name");
		System.out.println("TC5:- Enter Last Name");
		driver.findElement(By.id("firstname")).sendKeys("Sunil");
		driver.findElement(By.id("lastname")).sendKeys("Holambe");
		
		System.out.println("TC6:- Select Gender");
		driver.findElement(By.id("Male")).click();
		
		System.out.println("TC7:- Select Hobbies");
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h6")).click();
		
		System.out.println("TC8:- Select Value From Branch Dropdown.");
		WebElement e = driver.findElement(By.id("bId"));
		Select branchSelect = new Select (e);
		//branchSelect.selectByVisibleText("IT");
		//branchSelect.selectByValue("2");
		branchSelect.selectByIndex(2);	
		
		System.out.println("TC9:- Click On Click Here Link Should Redirect To URL Configured (eg. https://www.google.com)");
		driver.findElement(By.partialLinkText("click here")).click();
		
		System.out.println("TC10:- Navigate Back Bo The Previous URL");
		driver.navigate().back();
		
		System.out.println("TC11:- Verify - HTML Page Is Loaded Sucessfully");
		System.setProperty("webdriver.chrome.driver", "file:///D:/TechnoCredits/Projects/Aug22/eclipse/SeleniumTechnoAug2022/src/Sunil/FirstPage.html");  
	}
}
