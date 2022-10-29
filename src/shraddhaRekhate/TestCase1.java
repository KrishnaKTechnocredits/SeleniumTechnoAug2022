package shraddhaRekhate;
import org.openqa.selenium.WebDriver;
public class TestCase1 {
	static void verifyTitle(WebDriver  driver,String expectedTitle) {
        String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}
	public static void main(String[] args) {
		//launch chrome browser
		 System.out.println("STEP:Launch chrome browser url");
		 WebDriver driver=PredifinedActions.start();
		 
		 System.out.println("Verify application is loaded");
		 verifyTitle(driver,"Login Signup Demo");
		 
		 System.out.println("Navgate to:automationpractice.com");
		 driver.navigate().to("http://automationpractice.com/index.php");
			
		 System.out.println("Verify correct application is loaded");
		 verifyTitle(driver,"My Store");
		 
		 System.out.println("STEP: navigate back to previous url");
		 driver.navigate().back();
		 
		 System.out.println("STEP: navigate forward");
		 driver.navigate().forward();
		 
		 System.out.println("Close browser");
		 driver.close();
	}

}
