package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadDataproviderReadExcel extends BaseTestParam {
	
	
    @Test(dataProvider="SendData")
	public  void runCreateLead(String Company,String firstName,String lastName) {

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.name("submitButton")).click();
		}



@DataProvider
public String [][] SendData(){
	
	String [][] data = new String [2][3];
	
	data[0][0] = "Testleaf";
	data[0][1] = "Manikandan";
	data[0][2] = "S";
	data[1][0] = "TestCompany";
	data[1][1] = "Ram";
	data[1][2] = "M";
	
	return data;
	
} 
}





