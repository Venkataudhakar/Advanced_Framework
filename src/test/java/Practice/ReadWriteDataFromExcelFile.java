package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteDataFromExcelFile
{
	public static void main(String[] args) throws Throwable, Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb	= WorkbookFactory.create(fis);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		System.out.println(LASTNAME);
		
		wb.getSheet("Contacts").createRow(5).createCell(0).setCellValue(LASTNAME);
		FileOutputStream fos1=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos1);		

/*		//Step1: Open the document in Java readable format
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		//Step2: Create Workbook
		Workbook wb1	= WorkbookFactory.create(fis1);

		//Step3: Navigate to required Sheet
		Sheet sh1 = wb1.getSheet("Contacts");

		//Step4: Navigate to required Row
		Row rw1 = sh1.getRow(1);

		//Step5: Navigate to required Cell
		Cell cl1 = sh.getCell(2);

		//Step6: Capture the value and print
		String value = cl.getStringCellValue();
		System.out.println(value);
*/
	}
}
