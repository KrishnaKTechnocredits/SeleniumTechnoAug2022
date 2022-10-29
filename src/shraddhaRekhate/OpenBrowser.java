package shraddhaRekhate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class OpenBrowser {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_106.exe");
		
		WebDriver driver= new ChromeDriver();//launch browser
		driver.get("https://www.google.com/");//enter url in browser
		driver.manage().window().maximize();//maximize browser
		
		String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		driver.close();//browser close
		}
}
