package ninzaCRM.genericMethodsPractise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to
 * File Operations like property file,excel file
 * @author Gopi M
 */

public class FileUtility {
	
	
	/**
	 * This method is will read data from properties file and
	 * return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
	
	/**
	 * This method will read data from excel file and return
	 * the value to Caller
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFramework\\src\\test\\resources\\Copy_of_TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).toString();
	}
	
	/**
	 * This methods reads multiple data from excel
	 * @param sheetName
	 * @param rows
	 * @param columns
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMutlipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NinzaCRM.AutomationFramework\\src\\test\\resources\\Copy_of_TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rows=sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		Object[][] data =new Object[rows][columns];
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).toString();
				
			}
			System.out.println("Step1");
		}
		return data;
	}

}
