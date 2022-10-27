

package AMohini.Assignment1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AMohini.CommonActions.*;

public class HTMLFormAssignment1 {
	
	
	
		
		public static void main(String[] args) {
			
			System.out.println("STEP - Launch Chrome browser & load URL");
			WebDriver driver= PredefinedActions.start("file:///C:/Users/mohin/JAVACourse/SeleniumTechnoAug2022/src/AMohini/HTML/MyFirst.html");
			driver.findElement(By.id("firstname")).sendKeys("Mohini");
			driver.findElement(By.id("lastnamename")).sendKeys("Agarwal");
			
			driver.findElement(By.id("female")).click();
			
			driver.findElement(By.id("h3")).click();
			driver.findElement(By.id("h4")).click();
			
			WebElement e =driver.findElement(By.id("bId"));
			Select select1 = new Select(e); 
			
			select1.selectByVisibleText("IT");
			
			
			

}
		
}
