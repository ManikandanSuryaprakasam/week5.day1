package week5.day1.TestngIncidentApplication;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



@Test
public class UpdateExistingIncident {
	
	public void updateexistingincident() {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://dev76429.service-now.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.switchTo().frame("gsft_main");
	System.out.println(driver.getTitle());
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("Chiranjeevi@1234");
	driver.findElement(By.id("sysverb_login")).click();
	driver.findElement(By.id("filter")).sendKeys("incident");
	driver.findElement(By.xpath("//ul[contains(@aria-label,'Modules for Application: Incident')]/li[6]")).click();
	String Parentwindow = driver.getWindowHandle();	
	driver.switchTo().frame("gsft_main");	
	driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys("INC0010037");
	driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//tbody[@class='list2_body']//tr[1]/td[3]")).click();
	WebElement SelUrgency = driver.findElement(By.name("incident.urgency"));
	Select urgency = new Select(SelUrgency);
	urgency.selectByValue("1");
	
	
	WebElement SelState = driver.findElement(By.name("incident.state"));
	Select State = new Select(SelState);
	State.selectByVisibleText("In Progress");
	
	driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Test new notes");
	driver.findElement(By.id("sysverb_update_bottom")).click();
	
	driver.findElement(By.xpath("//tbody[@class='list2_body']//tr[1]/td[3]")).click();
	System.out.println("Pause");
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	WebElement SelUrgency2 = driver.findElement(By.name("incident.urgency"));
	Select urgency1 = new Select(SelUrgency2);
	WebElement urgencySelected = urgency1.getFirstSelectedOption();
	
	
	WebElement SelState2 = driver.findElement(By.name("incident.state"));
	Select State2 = new Select(SelState2);
	WebElement stateSelected = State2.getFirstSelectedOption();
	
	
if (urgencySelected.getText().equals("1 - High"))
     {
   	 System.out.println("Urgency is selected Verified Successfully!!!");
}
   
 if (stateSelected.getText().contains("In Progress"))
	       {
	    	 System.out.println("State is selected Verified Successfully!!!");
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


















	


