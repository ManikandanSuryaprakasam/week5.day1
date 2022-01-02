package TestngOnlySysoutPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead  {
	
	
    @BeforeClass
	public  void a() {
		
    	
		System.out.println("Package 2 Method A");
    }
		
    @AfterClass
		public  void b() {
		
			System.out.println("Package 2 Method B");
			
}
		
   
	
}






