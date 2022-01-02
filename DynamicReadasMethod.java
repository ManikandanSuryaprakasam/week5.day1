package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicReadasMethod extends BaseTest{
	
	  @Test(dataProvider="ReadExcel")
		public void runCreateLead(String Company,String firstName,String lastName) {

			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Company);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			driver.findElement(By.name("submitButton")).click();
			}
	  
	  
	  @DataProvider
	  public String[][] ReadExcel() throws IOException
	  {
		 
		  String filepath = "./data/DataproviderSheet1.xlsx";
		  String table[][] =  SendData(filepath);
		  return (table); 
	  
	  }
	  
	  
	   public String[][] SendData(String filepath) throws IOException
	  {
		  											
		  		XSSFWorkbook wb = new XSSFWorkbook(filepath);
				XSSFSheet ws = wb.getSheetAt(0);
				int rowCount = ws.getLastRowNum();
				XSSFRow header = ws.getRow(0);
				int columnCount = header.getLastCellNum();
				String table[][] = new String[rowCount][columnCount];
								
				for (int i = 1;i <= rowCount;i++)
				{
					for (int j = 0; j < columnCount; j++) {
						
						XSSFRow row = ws.getRow(i);
						XSSFCell cell = row.getCell(j);
						table[i-1][j] = cell.getStringCellValue();
						
					}
				}
				
				return (table);

		}  
		  
		  
}




