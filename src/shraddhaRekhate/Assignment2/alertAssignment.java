package shraddhaRekhate.Assignment2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shraddhaRekhate.PredifinedActions;

public class alertAssignment {
	
	static void verifyTitle(WebDriver  driver,String expectedTitle) {
        String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Step1 and 2:Launch chrome browser and hit the url http://automationbykrishna.com/ in chrome browser");
		WebDriver driver=PredifinedActions.start("http://automationbykrishna.com");
		
		String emailValue="abc@gmail.com";
		String passwordValue="abc123";
		
		System.out.println("Step 3:Click on basic elemnts tab");
		driver.findElement(By.id("basicelements")).click();
		
		Thread.sleep(3000);
		
		System.out.println("Enter email adress");
		driver.findElement(By.name("emailId")).sendKeys(emailValue);
		
		System.out.println("Enter password");
		driver.findElement(By.id("pwd")).sendKeys(passwordValue);
		
		System.out.println("Click on submit button");
		driver.findElement(By.id("submitb2")).click();
		
		System.out.println("VAlidate that you successfully clicked on it");
		Alert alert=driver.switchTo().alert();
		String expectedText="You successfully clicked on it";
		String actualText=alert.getText();
		if(expectedText.equals(actualText)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
		//added wait
		Thread.sleep(3000);
		
		System.out.println("Accept the alert");
		alert.accept();
	}
     
}


