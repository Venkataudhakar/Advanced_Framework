package GenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EF
{
	public String readDataFromEF(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
}
