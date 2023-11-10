package SCREENSHOT;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	
	public static void main(String args[]) throws IOException
	{
		ExtentReports extentReport=new ExtentReports();
		String timestamp=new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date());
	    String reportName="TestReport-"+timestamp+".html";
	    extentReport=new ExtentReports();
	    ExtentSparkReporter sparkreports=new ExtentSparkReporter(System.getProperty("user.dir")+"//test-output//"+reportName);
 		extentReport.attachReporter(sparkreports);
		//create first test
 		ExtentTest test1=extentReport.createTest("First Test");
 		test1.pass("this is passed");
 		
 		ExtentTest test2=extentReport.createTest("Second Test");
 		test2.log(Status.FAIL,"this is failed");
 		
 		ExtentTest test3=extentReport.createTest("Second Test");
 		test3.log(Status.SKIP,"this is skipped");
 		
 		extentReport.createTest("Fourth Test").log(Status.PASS,"<b>passed</b>")
 		//.log(Status.FAIL,"failed")
 		.log(Status.PASS,"<i>passed</i>")
 		.log(Status.SKIP,"<b>skipped</b>")
 		.pass("passed");
 		
 		String xmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
 				+ "- <note>\r\n"
 				+ "  <to>Tove</to>\r\n"
 				+ "  <from>Jani</from>\r\n"
 				+ "  <heading>Reminder</heading>\r\n"
 				+ "  <body>Don't forget me this weekend!</body>\r\n"
 				+ "</note>";
 		
 		extentReport.createTest("Fifth Test")
 		.log(Status.INFO,MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
 		
 		String jsonData="{\"employees\":[  \r\n"
 				+ "    {\"name\":\"Shyam\", \"email\":\"shyamjaiswal@gmail.com\"},  \r\n"
 				+ "    {\"name\":\"Bob\", \"email\":\"bob32@gmail.com\"},  \r\n"
 				+ "    {\"name\":\"Jai\", \"email\":\"jai87@gmail.com\"}  \r\n"
 				+ "]} ";
 		extentReport.createTest("Sixth Test")
 		.log(Status.INFO,MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));
 		
 		/*
 		 * loglevels 
 		 * fail
 		 * skip
 		 * warn        final test status taken from log levels
 		 * pass
 		 * info
 		 */
  		
 		/*
 		 * collections data 
 		 */
 		
 		List<String> data1=new ArrayList<String>();
 		
 		data1.add("rajesh");
 		data1.add("akila");
 		data1.add("nishavu");
 		
 		Map<Integer,String> mdata=new HashMap<Integer,String>();
 		
 		mdata.put(100,"raj");
 		mdata.put(200,"aki");
 		
 		extentReport.createTest("List collection data Test ordered list")
 		.log(Status.INFO,MarkupHelper.createOrderedList(data1));
 		
 		extentReport.createTest("List collection data Test unordered list")
 		.log(Status.INFO,MarkupHelper.createUnorderedList(data1));
 		
 		extentReport.createTest("List collection data Test ordered list")
 		.log(Status.INFO,MarkupHelper.createOrderedList(mdata));
 		
 		extentReport.createTest("List collection data Test unordered list")
 		.log(Status.INFO,MarkupHelper.createUnorderedList(mdata));
 		
 		/*
 		 *    displaying log messages in colors
 		 */
 		
 		extentReport.createTest("Extent color Test ")
 		.log(Status.INFO,MarkupHelper.createLabel("this is info",ExtentColor.LIME));
 		
 		// Exception add into extent test
 		
 		try
 		{
 			int a=5/0;
 		}
 		catch(Exception e)
 		{
 			extentReport.createTest("Exception Test")
 			.log(Status.PASS, e);
 		}
 		
 		/*
 		 * customized exceptions are displayed in extent report
 		 */
 		
 		Throwable t=new RuntimeException("runtime exception");
 		extentReport.createTest("Customized exception  Test")
			.log(Status.PASS, t);
 		
 		/*
 		 * attach the screen shot to extent report
 		 */
 		String path=screenShotPath();
 		extentReport.createTest("Attache the screenshot to extent report")
 		.log(Status.INFO,"add screen shot")
 		.addScreenCaptureFromPath(path);
 		
 		String path1=screenShotPath();
 		extentReport.createTest("Attache the screenshot to extent report")
 		.log(Status.INFO,"add screen shot")
 		.addScreenCaptureFromPath(path1,"<b>screen shot attached</b>");
 		
 		/*
 		 *  add multiple screen shots
 		 */
 		
  		String path3=screenShotPath1();
 		extentReport.createTest("Attache the screenshot to extent report")
 		.log(Status.INFO,"add screen shot")
 		.addScreenCaptureFromPath(path1,"<b>screen shot attached</b>")
 		.addScreenCaptureFromBase64String(path3);
 		
 		/*
 		 *  attach escreen shot at log level
 		 */
 		
 		extentReport.createTest("screenshot attach at log level")
 		.log(Status.PASS,"google image")
 		.log(Status.FAIL,MediaEntityBuilder.createScreenCaptureFromBase64String(path3).build());
  		
 		/*
 		 * add extra attributes to extent test
 		 */
 		
 		extentReport.createTest("Add information Test")
 		.assignAuthor("Rajesh")
 		.assignCategory("Smoke test")
 		.assignDevice("chrome 99")
 		.pass("passed");
 		
 		extentReport.createTest("Add information Test")
 		.assignAuthor("Akila")
 		.assignCategory("sanity test")
 		.assignDevice("Edge 99")
 		.pass("failed");
 		
 		/*
 		 * multiple authors also added into single test
 		 *  addautor("raj");
 		 *  add("aki");
 		 *  *  addauthor("raj","aki");
 		 *  
 		 *  
 		 */
 		
 		/*
 		 *   add some configuration to extent report
 		 */
 	/*	ExtentSparkReporterConfig g=sparkreports.config();
      g.setDocumentTitle("CONFIGURATION TEST");
      sparkreports.config().setTheme(Theme.DARK);
      g.setReportName("configuration report");
      sparkreports.config().setTimeStampFormat("dd-MM-yyyy hh-mm-ss");
      g.setCss(".badge-primary{background-color: #24d5d8;}");
      g.setJs("document.getElementsByClassName('logo')[0].style.display='none';");*/
      
       /*
        *   set configuration by json file 
        */
      
      sparkreports.loadJSONConfig(new File("D:\\JAVA PROJECTS\\Rajesh\\report\\report.json"));
		extentReport.flush();
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"//test-output//"+reportName).toURI());
	}
	
	public static String screenShotPath() throws IOException
	{
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("http://www.google.com");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		File f1=new File("D:\\JAVA PROJECTS\\Rajesh\\screenshot\\1.jpg");
		FileUtils.copyFile(f,f1);
		driver.close();
		return f1.getAbsolutePath();
		
		
	}
	
	public static String screenShotPath1() throws IOException
	{
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("http://www.google.com");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String f=ts.getScreenshotAs(OutputType.BASE64);
		return f;
		 
		
		
	}

}
