package practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ninzaCRM.genericMethodsPractise.FileUtility;

public class TestNGPractise {
	
	@Test(dataProvider = "demo" )
	public void create(String name,int id)
	{
		
		System.out.println(name+" "+id);
	}
	
	@Test(dependsOnMethods = "create")
	public void modify()
	{
		System.out.println("modify");
	}
	
	@Test()
	public void delete()
	{
		System.out.println("delete1");
	}
	
	@DataProvider
	public Object[][] demo() throws EncryptedDocumentException, IOException
	{
		FileUtility futil=new FileUtility();
		
		return  futil.readMutlipleDataFromExcel("Sheet2");
		
	}

	
	
}
