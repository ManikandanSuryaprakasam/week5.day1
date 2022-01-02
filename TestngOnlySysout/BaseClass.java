package TestngOnlySysout;

import java.time.Duration;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	@Test
	public void preCondition() 
	{
		
		System.out.println("Precondition method");
				
	}
	
	@Test
	public void postCondition() 
	{
		System.out.println("Postcondition method");
	}

}
