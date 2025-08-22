package practise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninzaCRM.ObjectRepository.AddProductPage;
import ninzaCRM.ObjectRepository.ContactPage;
import ninzaCRM.ObjectRepository.CreateContactsPage;
import ninzaCRM.ObjectRepository.DashboardPage;
import ninzaCRM.ObjectRepository.LoginPage;
import ninzaCRM.ObjectRepository.ProductPage;
import ninzaCRM.genericMethodsPractise.FileUtility;
import ninzaCRM.genericMethodsPractise.WebDriverUtility;

public class TC_E2E_01 {
	
	 public static void main(String[] args) throws IOException, InterruptedException {
	        WebDriverManager.edgedriver().setup();

	        FileUtility fileu = new FileUtility();
	        WebDriverUtility webUty = new WebDriverUtility();
	        
	        String BROWSER=fileu.readDataFromPropertyFile("browser");
	        String URL = fileu.readDataFromPropertyFile("url");
	        String USERNAME =fileu.readDataFromPropertyFile("username");
	        String PASSWORD=fileu.readDataFromPropertyFile("password");
	        
	        WebDriver driver = null;
	        
	        if(BROWSER.equals("chrome")) {
	            driver = new ChromeDriver();
	        }else if(BROWSER.equals("firefox")) {
	            driver = new FirefoxDriver();
	        }else if (BROWSER.equals("edge")) {
	            driver = new EdgeDriver();
	        }else {
	            driver = new ChromeDriver();
	        }
	    
	        webUty.maximizeWindow(driver);
	        webUty.implicitlyWait(driver);
	        driver.get(URL);
	        
	        LoginPage lp = new LoginPage(driver);
	        lp.loginToApp(USERNAME, PASSWORD);

	 
	        DashboardPage dp = new DashboardPage(driver);
	        dp.clickOnContacts();
	        	        
	        ContactPage cp = new ContactPage(driver);
	        cp.clickCreateContact();
	        
	        
	        CreateContactsPage ccp = new CreateContactsPage(driver);
	        ccp.createContact(driver, fileu.readDataFromExcel("Sheet1", 4, 2), fileu.readDataFromExcel("Sheet1", 4, 3), fileu.readDataFromExcel("Sheet1", 4, 3), fileu.readDataFromExcel("Sheet1", 4, 4), fileu.readDataFromExcel("Sheet1", 4, 5), fileu.readDataFromExcel("Sheet1", 4, 6));
	        
	        Thread.sleep(6000);
	        
	        dp.clickOnProducts();
	        ProductPage pp=new ProductPage(driver);
	        pp.getAddProductBtn().click();
	        
	        
	        AddProductPage addProduct=new AddProductPage(driver);
	        addProduct.AddProduct(fileu.readDataFromExcel("Sheet1", 4, 7),fileu.readDataFromExcel("Sheet1", 4, 8),fileu.readDataFromExcel("Sheet1", 4, 9),
	        		fileu.readDataFromExcel("Sheet1", 4, 10),fileu.readDataFromExcel("Sheet1", 4, 11));
	        

////	        webUty.toWindow(driver);
////	        driver.findElement(By.id("search-input")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 6));
////	        Thread.sleep(2000);
////	        driver.findElement(By.xpath("//button[.='Select']")).click();
////	        driver.switchTo().window(currId);
////	        driver.findElement(By.xpath("//button[.='Create Contact']")).click();
////	        
//	        driver.findElement(By.xpath("//a[.='Products']")).click();
//	        WebElement productVerify = driver.findElement(By.xpath("//span[.='Add Product']"));
//	        driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
//	        if(productVerify.isDisplayed()) {
//	            System.out.println("status---> PASS");
//	            productVerify.click();
//	        }
//	        driver.findElement(By.name("quantity")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 7));
//	        driver.findElement(By.name("productName")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 8));//col.getCell(8).toString()
//	        WebElement pricePerUnEle = driver.findElement(By.name("price"));
//	        pricePerUnEle.clear();
//	        pricePerUnEle.sendKeys(fileu.readDataFromExcel("Sheet1", 4, 9));
//	        WebElement prodCategEle = driver.findElement(By.name("productCategory"));
//	        Select catgSel = new Select(prodCategEle);
//	        catgSel.selectByValue(fileu.readDataFromExcel("Sheet1", 4, 10));
//	        Select venderSel = new Select(driver.findElement(By.name("vendorId")));
//	        venderSel.selectByVisibleText(fileu.readDataFromExcel("Sheet1", 4, 11));
//	        driver.findElement(By.xpath("//button[.='Add']")).click();
//	        try {
//	        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
//	        }catch(Exception e) {Thread.sleep(5000);}
//	        driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
//	        driver.findElement(By.xpath("//span[.='Create Order']")).click();
//	        driver.findElement(By.name("dueDate")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 12));
//	        driver.findElement(By.name("subject")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 13));
//	        driver.findElement(By.xpath("//div[@style='display: flex; align-items: center;']/child::button[@class='action-button']")).click();
//
//	       // webUty.toWindow(driver);
//	        driver.findElement(By.id("search-input")).sendKeys("Sumit Ghosh");
//	        driver.findElement(By.xpath("//button[.='Select']")).click();
//	        //driver.switchTo().window(currId);
//	        driver.findElement(By.name("address")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 14));
//	        driver.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 14));
//	        driver.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 15));
//	        driver.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 15));
//	        driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 16));
//	        driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 16));
//	        driver.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 17));
//	        driver.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 17));
//	        driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 18));
//	        driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 18));
//	        driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 19));
//	        driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 19));        
//	        driver.findElement(By.xpath("//div[@style='margin-top: 20px;']/child::button")).click();    
//
//	        //webUty.toWindow(driver);
//	        WebElement searchEle = driver.findElement(By.id("search-criteria"));
//
//	        //webUty.handleDropDown(searchEle, "productName");
//	        driver.findElement(By.id("search-input")).sendKeys(fileu.readDataFromExcel("Sheet1", 4, 8));
//	        driver.findElement(By.xpath("//button[.='Select']")).click();
//	       // driver.switchTo().window(currId);
//	        driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
//	        try {
//	            driver.findElement(By.xpath("//button[@aria-label='close']")).click();
//	            }catch(Exception e) {Thread.sleep(6000);}
//	        driver.findElement(By.className("user-icon")).click();
//	        driver.findElement(By.xpath("//div[.='Logout ']")).click();
	    }

}
