package shraddhaRekhate.Assignmnent1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import shraddhaRekhate.PredifinedActions;
public class Assignment1 {
	static void verifyTitle(WebDriver  driver,String expectedTitle) {
        String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}
	public static void main(String[] args) {
		System.out.println("STEP 1 and 2 Launch chrome browser and hit html url");
		WebDriver driver=PredifinedActions.start("C:\\Users\\Dell\\Desktop\\S\\New folder\\SeleniumTechnoAug2022\\src\\shraddhaRekhate\\Assignmnent1\\FirstPage.html");
		System.out.println("STEP 3 Verify application is loaded successfully");
		Assignment1.verifyTitle(driver,"Technocredits");
		
		System.out.println("STEP 4 Enter First Name");
		driver.findElement(By.id("firstName")).sendKeys("Shraddha");
		
		System.out.println("STEP 5 Enter Last Name");
		driver.findElement(By.id("lastName")).sendKeys("Rekhate");
		
		System.out.println("STEP 6 Select gender radio button at a time only one radio button should be selected");
		driver.findElement(By.id("female")).click();
		
		System.out.println("STEP 8 Select Hobbies checkbox (user can select multiple checkboxes)");
		driver.findElement(By.id("h2")).click();
		driver.findElement(By.id("h6")).click();
		
		System.out.println("STEP 9 Select value from branch dropdown.");
		WebElement element = driver.findElement(By.id("bid"));
		Select selectBranch=new Select(element);
		selectBranch.selectByVisibleText("EDT");
		
		System.out.println("STEP 10 Click on Click here link should redirect to url configured (eg. https://www.google.com)");
		driver.findElement(By.id("clickhere")).click();
		
		System.out.println("Navigate back to the previous url.");
	    driver.navigate().back();
	    
	    System.out.println("Verify html page is loaded again.");
	    Assignment1.verifyTitle(driver,"Technocredits");
		}
}
