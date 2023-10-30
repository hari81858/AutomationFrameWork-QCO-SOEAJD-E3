package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws IOException {
		
		//Read the data into java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		
		//Create workbook factory
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//Get sheet from workbook
		Sheet sh = wb.getSheet("Contacts");
		//Get row from  sheet
		Row rw = sh.getRow(1);
		//Get cell from row
		Cell ce = rw.getCell(2);
		
		String data = ce.getStringCellValue();
		System.out.println(data);
		
		
	}
	
	
	
	
		
}
