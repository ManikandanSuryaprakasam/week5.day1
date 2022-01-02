package week5.day1.TestngIncidentApplication;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class AssigntheIncident {
	public static String incident;
	public void assigntheincident() {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://dev76429.service-now.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.switchTo().frame("gsft_main");
	System.out.println(driver.getTitle());
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("Chiranjeevi@1234");
	driver.findElement(By.id("sysverb_login")).click();
	driver.findElement(By.id("filter")).sendKeys("incident");
	driver.findElement(By.xpath("//ul[contains(@aria-label,'Modules for Application: Incident')]/li[6]")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	
	driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys("INC0010028");
	driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//tbody[@class='list2_body']//tr[1]/td[3]")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.name("lookup.incident.assignment_group")).click();
	driver.switchTo().defaultContent();
		incident = "hgfhgvf";
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> handles = new ArrayList<String>(windowHandles);
	driver.switchTo().window(handles.get(1));
      
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	driver.findElement(By.xpath("//tbody[@class='list2_body']//tr[1]/td[3]/a")).click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.switchTo().window(handles.get(0));
	driver.switchTo().frame("gsft_main");	
	System.out.println("Working");
	WebDriverWait wait = new WebDriverWait(driver,50);
	driver.findElement(By.xpath("(//span[text()='Work notes'])[3]/following::textarea")).sendKeys("Test new notes");
	driver.findElement(By.id("sysverb_update_bottom")).click();
	
	driver.findElement(By.xpath("//tbody[@class='list2_body']//tr[1]/td[3]")).click();
	System.out.println("Pause");
		
	
	String text = driver.findElement(By.name("sys_display.incident.assignment_group")).getText();
	if (text.contains("Application Development"))
     {
   	 System.out.println("Group is Assigned. Verified Successfully!!!");
}
   
	}
}


//Assignment- Service now Application
//================================
//1.Create new incident
//1. Launch ServiceNow application
//2. Login with valid credentials (refer the document to create the instance)
//3. Enter Incident in filter navigator and press enter"
//4. Click on Create new option and fill the manadatory fields
//5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)
//******************************************
//2.Update existing incident
//====================
//1. Launch ServiceNow application
//2. Login with valid credentials 
//3. Enter Incident in filter navigator and press enter "
//4. Search for the existing incident and click on the incident
//5. Update the incidents with Urgency as High and State as In Progress
//6. Verify the priority and state 
//************************************************
//3.Assign the incident
//=================
//1. Launch ServiceNow application
//2. Login with valid credentials 
//3.  Enter Incident in filter navigator and press enter
//4. click on open and Search for the existing incident and click on  the incident
//5. Assign the incident to  Software group
//6. Update the incident with Work Notes
//7. Verify the Assignment group and Assigned for the incident
//**************************************************
//4.Delete the incident
//==================
//1. Launch ServiceNow application
//2. Login with valid credentials 
//3. Enter Incident in filter navigator and press enter"
//4. Search for the existing incident and navigate into the incident
//5. Delete the incident
//6. Verify the deleted incident


















	


