package technocredits.testngdemo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example {
	

	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("1**");
	}
	
	@Test
	void m1() {
		System.out.println("2");
		int x = 11;
		Assert.assertEquals(x, 10);
		System.out.println("Hi");
	}
	
	@Test
	void m2() {
		System.out.println("3");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("4");
	}
}
