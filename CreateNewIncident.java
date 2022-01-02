package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



@Test
public class CreateNewIncident {
	
	public void createnewincident() {
	
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
	
	driver.switchTo().frame("gsft_main");
	String Parentwindow = driver.getWindowHandle();	
	driver.findElement(By.xpath("//button[text()='New']")).click();
	String text = driver.findElement(By.name("incident.number")).getAttribute("value");
	System.out.println(text);
	driver.findElement(By.name("lookup.incident.caller_id")).click();
	
	//String Parentwindow = driver.getWindowHandle();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> handles = new ArrayList<String>(windowHandles);
	driver.switchTo().window(handles.get(1));
	
	driver.findElement(By.linkText("Abel Tuter")).click();
	
	driver.switchTo().window(Parentwindow);
	driver.switchTo().frame("gsft_main");	
	driver.findElement(By.id("incident.short_description")).sendKeys("Test Notes");
	driver.findElement(By.id("sysverb_insert_bottom")).click();
	
	
	driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys(text);
	driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys(Keys.ENTER);
	String text2 = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[1]")).getText();
	
	if(text.contains(text2))
	
	{
		System.out.println("Incident Created");}
	else
		{System.out.println("Incident not Created");}
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


















	


