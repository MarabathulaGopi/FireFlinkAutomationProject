package practise;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	public void readData()
	{
		String Browser=System.getProperty("browser");
		System.out.println(Browser);
		
		String Username=System.getProperty("username");
		System.out.println(Username);
		
		String Password=System.getProperty("password");
		System.out.println(Password);
		
	}

}
