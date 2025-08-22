package ninzaCRM.genericMethodsPractise;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplemenation implements IRetryAnalyzer {
	int count=0;
	int retrycount=3; //manual analysis 

	@Override
	public boolean retry(ITestResult result) {
		
		
		while(count<retrycount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
