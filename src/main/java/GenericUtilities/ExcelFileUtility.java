package GenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class will consists of Generic methods related Excel file
 * @author user
 *
 */
public class ExcelFileUtility
{
/**
 * This method will read the from excel sheet and return the value to Caller
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws Exception
 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
}
