package UTILITIES;

import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

 
public class ActionListener implements ITestListener{

	ExtentReports extentReporter;
	ExtentSparkReporter sparkreporter;
	ExtentTest test;
	String report;
	
	@Override
	public void onStart(ITestContext context) {
		
		 System.out.println(" started");
		 String timeStamp=new SimpleDateFormat("dd-MM-yyyy hh.mm.ss").format(new Date());
		   report="ReportName"+timeStamp+".html";
		 String path=System.getProperty("user.dir")+"//test-output"+report;
		   extentReporter=new ExtentReports();
		   sparkreporter=new ExtentSparkReporter(path);
		 extentReporter.attachReporter(sparkreporter);
		 
	}
	@Override
	public void onTestStart(ITestResult result) {
		 
		System.out.println("test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("test success");
	    test=extentReporter.createTest(result.getName());
	    test.log(Status.PASS,result.getName());
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("test fail");
	    test=extentReporter.createTest(result.getName());
	    test.log(Status.FAIL,result.getName());
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("test skipped");
	    test=extentReporter.createTest(result.getName());
	    test.log(Status.SKIP,result.getName());
		 
	}

	 

	 

	 

	@Override
	public void onFinish(ITestContext context) {
		extentReporter.flush();
		System.out.println("test finished");
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"//test-output"+report).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	

}
