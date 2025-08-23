package ninzaCRM.genericMethodsPractise;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener,ITestNGListener {
	
	ExtentReports report;
	ExtentTest test ;

//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return ITestListener.super.isEnabled();
//	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" Test Excution Started");
		
		//Intimate Extent Reports for test Start
		test = report.createTest(methodName);
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" Test Excution Passed");
		
		//log the status of @Test is Pass
		test.log(Status.PASS, methodName+" Test Excution Passed");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" Test Excution Falied");
		
		//log the status of @Test is Failed in Extent Report
		test.log(Status.FAIL, methodName+" Test Excution Failed");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the exception
		test.log(Status.WARNING, result.getThrowable());
		
		//capture the screenshot
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility Wutil=new WebDriverUtility();
		
		//Screenshot
		String screenshotName=methodName+jUtil.getSystemData();
		
		try {
			String path = Wutil.captureScreenShot(BaseClass.sdriver, screenshotName);
			//Attach ScrenShot to Report
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" Test Excution Skipped");
		
		//log the status of @Test is Skipped in Extent Report
		test.log(Status.SKIP, methodName+" Test Excution Skipped");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the exception
		test.log(Status.WARNING, result.getThrowable());
		
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Suite Excution Started");
		
		//Extent Report Configuration
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReports\\Extent-Report-"+new JavaUtility().getSystemData()+".html");
		esr.config().setDocumentTitle("Ninza CRM Automation Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web Automation Excution Report");
		
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URl", "Test Env");
		report.setSystemInfo("ReporterName", "Gopi");
		
		
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Excution Finished");
		
		//Report generation
		report.flush();
		ITestListener.super.onFinish(context);
	}
	
	

}
