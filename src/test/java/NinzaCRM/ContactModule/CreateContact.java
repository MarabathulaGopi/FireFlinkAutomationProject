package NinzaCRM.ContactModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.ObjectRepository.ContactPage;
import ninzaCRM.ObjectRepository.CreateContactsPage;
import ninzaCRM.ObjectRepository.DashboardPage;

import ninzaCRM.genericMethodsPractise.BaseClass;


public class CreateContact extends BaseClass {
	
	@Test(groups = {"RegressionSuite"})
	public void CreateContactTest() throws EncryptedDocumentException, IOException {

   
		String Subject = fileu.readDataFromExcel("Sheet1", 4, 2);
		String DueDate = fileu.readDataFromExcel("Sheet1", 4, 3);
		String Contact = fileu.readDataFromExcel("Sheet1", 4, 4);
		String QuoteSearch = fileu.readDataFromExcel("Sheet1", 4, 5);
		String Quote = fileu.readDataFromExcel("Sheet1", 4, 6);
		
 
        DashboardPage dp = new DashboardPage(driver);
        dp.clickOnContacts();
        	        
        ContactPage cp = new ContactPage(driver);
        cp.clickCreateContact();
        
  
        CreateContactsPage ccp = new CreateContactsPage(driver);
        ccp.createContact(driver, Subject, DueDate, DueDate, Contact, QuoteSearch, Quote);
        System.out.println("-----CONTACT CREATAED----");
	}

}
