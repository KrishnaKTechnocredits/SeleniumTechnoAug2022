//Assignment:9

//Script 2: Upload doc and validate it's uploaded
//1. launch your orange HRM site
//2. Login with valid credentials
//3. Click on Employee Management tab from left side
//4. Click on my info tab
//4. scroll down to the page
//5. Click on add button under attachment, browse any file (also you need to save the type of file txt, pdf, doccx etc)
//6. Click on save button
//7. vaidate the same file uploaded & type of file is aslo correct
//8. Your name should be displayed under Added by colum name


package Titiksha_selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Assignment_9_Robotclass {
	
		WebDriver driver;
		PropertyFileReader prop;
		@BeforeMethod
		void setup() throws Exception{
		prop=new PropertyFileReader("src/Titiksha_selenium/Assignment_9_OrgangeHRM.properties");
		System.out.println("open organge site");
		driver=PredefinedActions.start(prop.getvalue("Application_url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);}
		
		@Test
		void TestSriptRun() throws InterruptedException, AWTException {
	//2. Login with valid credentials
		System.out.println("Login with valid credentials");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(prop.getvalue("Username"));
		System.out.println("Testcase 1 : Userid send");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getvalue("Password"));
		System.out.println("Testcase 2 : Password send");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Testcase 3 : Click button pressed");
		
	//3.a press Employee management button
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='left_menu_item_30']")).click();
		System.out.println("Testcase 4 : Click on Employee management");
		
	//3.b Click on my info tab	
		driver.findElement(By.xpath("//div[@class='top-level-menu-item-container']//a[@class='top-level-menu-item' and @href='#/pim/my_info']")).click();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
	//4. scroll down to the page
		WebElement attachedmentElement = driver.findElement(By.xpath("//div[@class='form-div' and @ng-if='personal.permissions.personal_attachment.read']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", attachedmentElement);
		System.out.println("Testcase 5 : Scroll down to the page attachement.");
		
	//click in add button given in page
		driver.findElement(By.xpath("//a[@class='waves-effect waves-teal btn primary-btn']")).click();
		System.out.println("Testcase 6 : Add button is pressed");
		
		
	//5. Click on add button under attachment, browse any file 
	//note:problem-normal selenium method doesnot work with window based popup window 
	//Note: to resolve this issue we have to use action class 
		Actions act=new Actions(driver);//Action class object creating
		act.click(driver.findElement(By.xpath("//input[@id='filename']"))).build().perform();//build() creates composite of action which are ready to perform action so far//perform() performs sequence of actions
		StringSelection file=new StringSelection("C:\\Users\\Asus\\OneDrive\\Desktop\\selenium techno credit repo\\Stash scenarios.txt");//StringSelection coverts string file into file which can be easily transferred into file upload window
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file,null);//toolkit is class which comes from java.awt package//getdefaulttoolkit is selelnium method//getSystemClipboard is method which refers to file or image//setcontent method takes parameters and copy the selected file
		System.out.println("Testcase 7 : File is successfully copied");
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);//VK_control=virtualkey control//On window based pop normal mouse hover methods doesn't work thats why robot class provide us facility to use virtual keyboard actions
		robot.keyPress(KeyEvent.VK_V);//setContent method copied the file //VK_V=control+V //it will paste the selelcted file path into clipboard 
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Testcase 8 : File is successfully uploaded");
		Thread.sleep(1000);
		
		act.click(driver.findElement(By.cssSelector("#modal-save-button"))).build().perform();
		System.out.println("Testcase 8.b : Save button is pressed");
		
	//7. Validate the same file uploaded & type of file is aslo correct
		String actualFileName=driver.findElement(By.xpath("//span[@class='break-word']")).getText();
		String expectedFileName=prop.getvalue("Expectedfilename");
		Assert.assertEquals(actualFileName,expectedFileName,"Testcase 9: Correct file is uploaded");
		if(actualFileName.contains(".txt")) {
			System.out.println("Testcase 10 : correct file type is uploaded");
		}
		
		
		
	//8. Your name should be displayed under Added by column name
		String actualAddedBy=driver.findElement(By.xpath("//tbody[@ng-if='!listData.staticBody']//tr[1]//td[@type='listField.type'][6]//ng-include//span")).getText();//in case of multiple file upload //xpath will not work because tr position is getting change //we have to use css path
		String expectedAddedBy=prop.getvalue("AddedBy");
		Assert.assertEquals(actualAddedBy,expectedAddedBy);
		System.out.println("Testcase 11: Titiksha has successfully uploaded file");
		Thread.sleep(1000);
		
		//@AfterMethod
		//void closeBrowser() {
		//PredefinedActions.closeCurrentBrowser();}
		
		}
}
		
		
