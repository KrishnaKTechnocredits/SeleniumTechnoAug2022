/*Assignment No 6 : 31st Oct 2022

Script 1

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the first frame & click on top right button & print the options
	About
	Downloads
	Documentations
	Project
	Support
	Blog
5. Switch back to main window
---------------------------------------------------------------
Script 2

1. Launch chrome browser
2. Hit url(http://automationbykrishna.com/)in browser.
3. Click on iFrame tab
4. Switch to the 3rd frame & click on Projects tab
5. print the 
	Projects
	Apache Ant Libraries
	Apache Ivy
	Apache IvyDE
	Apache EasyAnt
5. Switch back to main window*/

package rashmiG.Assignment6_iFrame_And_Switch_Window;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rashmiG.Base.PredefinedActions;

public class iFrameHandling {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.out.println("STEP - Launch and hit the url");
		driver = PredefinedActions.start();
		System.out.println("STEP - Click on iFrame tab");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void firstFrameHandle() throws InterruptedException {
		System.out.println("STEP - Switch to the first frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
		// driver.switchTo().frame("site1");
		// driver.switchTo().frame(0);
		Thread.sleep(4000);

		System.out.println("STEP - click on top right button");
		// button/span[@class='navbar-toggler-icon']
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		System.out.println("STEP - Print the list of projects");
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@id='main_navbar']/ul/li/a"));
		for (WebElement e : listOfOptions) {
			if (e.getText() != "")
				System.out.println(e.getText());
		}
		System.out.println("STEP - Switch back to main window");
		driver.switchTo().parentFrame();
		String expectedText = "2017 © TechnoCredits by Krishna-Maulik";
		String actualText = driver.findElement(By.xpath("//footer[@class='sticky-footer']")).getText();
		Assert.assertEquals(expectedText, actualText, "Couldn't  switch back to main window");
		System.out.println("Switched back to main window");
	}

	@Test
	public void secondFrameHandle() throws InterruptedException {
		System.out.println("STEP - Switch to the 3rd frame");
		driver.switchTo().frame(2);
		Thread.sleep(3000);

		System.out.println("STEP - Click on projects tab");
		driver.findElement(By.xpath("//a[@href='./projects/index.html']")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//div[@class='content']/h3[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP - print the list  projects");
		List<WebElement> listOfAllProjects = driver
				.findElements(By.xpath("//div[@class='menucontainer']//li[@class='menuheader']"));
		System.out.println("========================");
		for (WebElement e : listOfAllProjects) {
			System.out.println(e.getText());
		}
		System.out.println("STEP - Switch back to main window");
		driver.switchTo().defaultContent();
		String actualText = driver.findElement(By.xpath("//a[@href='http://automationbykrishna.com']")).getText();
		if ("Automation By Krishna".equals(actualText)) {
			System.out.println("Pass - Switched  to main window");
		} else {
			System.out.println("Fail - Unable to switch to main window");
		}

//		System.out.println("\n");
//		System.out.println("STEP - print the sub projects");
//		List<WebElement> listOfSubProjects = driver
//				.findElements(By.xpath("//div[@class='menucontainer']//li[@class='menuheader']//ul"));
//		System.out.println("SUB Projects");
//		for (WebElement e : listOfSubProjects) {
//			System.out.println(e.getText());
//		}
		// Thread.sleep(3000);

//		System.out.println("Size of allProjectlist " + listOfAllProjects.size());
//		System.out.println("Size of subProjectlist " + listOfSubProjects.size());

//		System.out.println("\n");
//		// boolean flag= listOfAllProjects.removeAll(listOfSubProjects);
//		List<String> list = new ArrayList<String>();
//		//	4System.out.println(flag);
//		for (WebElement e : listOfAllProjects) {
//			// System.out.println(e.getText());
//			list.add(e.getText());
//		}
//		Thread.sleep(3000);
//
//		List<String> list1 = new ArrayList<String>();
//
//		for (WebElement e : listOfSubProjects) {
//			list1.add(e.getText());

		// }
//		System.out.println("Size of allProjectStingList " + list1.size());
//		System.out.println("Size of subProjStringlist " + list.size());
//		boolean flag = list.removeAll(list1);
//		System.out.println("flag of remove all method " + flag);
//		System.out.println("allProjectStingList");
//		System.out.println(list);
//		System.out.println("\n");
//		System.out.println("subProjStringlist");
//		//System.out.println(list1);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}