package SwapnilMaheshwari;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAssignment1 
{
	
static void verifyTitle (WebDriver driver1, String expTitle){
	String expectedTitle=expTitle;
	String actualTitle=driver1.getTitle();
	//System.out.println(actualTitle);
	//System.out.println(expectedTitle);
	if(expectedTitle.equals(actualTitle)) {
		System.out.println("Pass");
	}

}
	
	public static void main(String[] args) {
		WebDriver driver=PredefinedFunctions.browserOpen();
		System.out.println("Verify - Application is loaded successfully");
		verifyTitle(driver,"Swapnil's HTML Page");
		System.out.println("Step - Enter First Name and Last Name");
		driver.findElement(By.id("firstName")).sendKeys("Swapnil");
		driver.findElement(By.id("lastName")).sendKeys("Maheshwari");
		System.out.println("Step- Select gender");
		driver.findElement(By.id("male")).click();
		System.out.println("Step - Select hobbies");
		driver.findElement(By.id("check")).click();
		driver.findElement(By.id("check4")).click();
		System.out.println("Step- Select branch from dropdown");
		WebElement element=driver.findElement(By.id("bid"));
		Select obj=new Select(element);
		obj.selectByVisibleText("CS");
		System.out.println("Step - Click on click here link");
		driver.findElement(By.id("link")).click();
		System.out.println("Step -Navigate back to the previous url");
		driver.navigate().back();
		System.out.println("Verify - Html page is loaded sucessfully");
		verifyTitle(driver,"Swapnil's HTML Page");
		//driver.close();
		
	}
}
