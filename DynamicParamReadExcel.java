package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicParamReadExcel  {

	public static void main(String[] args) throws IOException {
	
		
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/DataproviderSheet1.xlsx");
		
		XSSFSheet ws = wb.getSheetAt(0);
		
		int rowCount = ws.getLastRowNum();
		
		XSSFRow header = ws.getRow(0);
		int columnCount = header.getLastCellNum();
		
				
		
		for (int i = 1;i <= rowCount;i++)
		{
			for (int j = 0; j < columnCount; j++) {
				
				XSSFRow row = ws.getRow(i);
				XSSFCell cell = row.getCell(j);
				String cellvalue = cell.getStringCellValue();
				System.out.println(cellvalue);
				
				
			}
		}
		

	}

}
