package base;

import java.io.IOException;

import org.testng.*;

import utilities.ScreenshotUtil;

public class TestListener extends ScreenshotUtil implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" test case started");
    	
    	System.setProperty("org.uncommons.reportng.title", "This is a sample changed title for ReportNG config");
    	
    	Reporter.log("Method name is - "+result.getName()); // generate the report every test case if associated with listener
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase passed is : "+ result.getName());
    	
    	Reporter.log("Status of Execution is: "+result.getStatus());		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			getScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	System.setProperty("org.uncommons.reportng.escape-output", "false"); // for latest reportng plugins - it requires to have this settings in order to have links in the report
    	Reporter.log(System.getProperty("user.dir")+"\\screenshot\\screenshot_"+ screenshotfilename +".png'>Test Results</a>"); // how to generate report with link in TestNG
        	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
