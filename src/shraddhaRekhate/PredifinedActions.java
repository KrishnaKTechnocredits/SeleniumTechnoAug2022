package shraddhaRekhate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class PredifinedActions {
	//overloaded methods without parameter
	 public final static WebDriver start() {
		    return start("http://automationbykrishna.com/");
	 }
	   //overloaded methods with parameter
	 public final static WebDriver start(String url) {
		    System.out.println("Step:Launch browser");
			System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver_106.exe");
			WebDriver driver= new ChromeDriver();//launch browser
			
			System.out.println("STEP:Hit URL");
			driver.get(url);//enter url in browser
			driver.manage().window().maximize();//maximize browser
			return driver;
	}
}
