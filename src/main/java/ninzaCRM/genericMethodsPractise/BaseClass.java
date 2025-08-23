package ninzaCRM.genericMethodsPractise;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;



/**
 * This Class consists of basic Configuartion annatoations
 * @author Marabathula Gopi Var
 */
public class BaseClass {
	
	public FileUtility fileu = new FileUtility();
    public WebDriverUtility webUty = new WebDriverUtility();
    
    public WebDriver driver = null;
    
    public static WebDriver sdriver=null;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("DB Connection Open Successful");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcCongig() throws IOException
	{

	        
	     String BROWSER=fileu.readDataFromPropertyFile("browser");
	     String URL = fileu.readDataFromPropertyFile("url");
	     
	        
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
	        
	        sdriver=driver;
	        System.out.println("---------------BROWSER OPENED------------");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		 String USERNAME =fileu.readDataFromPropertyFile("username");
	     String PASSWORD=fileu.readDataFromPropertyFile("password");
	     
	     
	     System.out.println("-----------lOGIN INTO APP----------------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		Thread.sleep(5000);
		
		 System.out.println("-----------lOGOUT INTO APP----------------");
	}
	
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acCongig()
	{
		driver.quit();
		System.out.println("---------------BROWSER CLOSED---------");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("DB Connection Closed Successful");
	}

}
