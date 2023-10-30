package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author anil mittanosala
 *
 */
public class ExcelFileUtility {
/**
 * This method will read the data from excel file and return the value to the caller
 * @param SheetName
 * @param RowNo
 * @param CellNo
 * @return
 * @throws Throwable
 */
	public String readDataFromExcel(String SheetName,int RowNo,int CellNo) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow( RowNo).getCell(CellNo).getStringCellValue();
		return value;
	}

	/**
	 * This method will read the multiple organization and industries
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
