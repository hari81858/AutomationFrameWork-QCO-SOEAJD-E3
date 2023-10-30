package genericutilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementationClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testScritName = result.getMethod().getMethodName();
		System.out.println(testScritName+"===== Test Exeution stared ===== ");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testScritName = result.getMethod().getMethodName();
		System.out.println(testScritName+"===== pass ===== ");
		
			}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testScritName = result.getMethod().getMethodName();
		System.out.println(testScritName+"===== failed ===== ");
		
		// for exception 
		System.out.println(result.getThrowable());
		
		//Take screenshot
		
		String screenshotName=testScritName+new JavaUtility().getSystemDate();
		WebDriverUtilities w=new WebDriverUtilities();
		
		try {
			w.captureScreenShot(BaseClass.sdriver,screenshotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testScritName = result.getMethod().getMethodName();
		System.out.println(testScritName+"===== Skipped ===== ");
			}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("===== sute exeution stared ===== ");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("===== suite exeution finished ===== ");
			}
	
	

}
