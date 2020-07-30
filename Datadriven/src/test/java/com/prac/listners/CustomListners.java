package com.prac.listners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.prac.testBase.TestBase;
import com.prac.utilities.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=rep.startTest(result.getName().toUpperCase());
		test.log(LogStatus.INFO,"Starting " + result.getName() );
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		test.log(LogStatus.PASS,result.getName().toUpperCase()+" has passed");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtils.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("not able to take screen shot");
		}
		Reporter.log("<a target= \"_blank\" href="+TestUtils.Name+" >screenshot</a>");
		test.log(LogStatus.FAIL,test.addScreenCapture(TestUtils.Name));
		test.log(LogStatus.FAIL,result.getName().toUpperCase()+"has Failed due to "+ result.getThrowable());
		rep.endTest(test);
		rep.flush();
		
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
