/**
 * 
 */
package utilities;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basePage.BasePage;

/**
 * @author Admin
 *
 */
public class Report {

	static ExtentSparkReporter reporter;
	static	ExtentReports extent;
	static	ExtentTest test;
	
	public static void extentReport() throws IOException
	{
		String timestamp=  new SimpleDateFormat("dd.MM.yyyy.hh.MM.ss").format(new Date());
		String path= System.getProperty("user.dir")+"\\Reports\\Test_Report_"+timestamp+".html";
		
		 reporter = new  ExtentSparkReporter(path);
		reporter.loadXMLConfig("extent-config.xml");
		reporter.config().setReportName("TestReport");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("AutomationTestReport");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "ShaikJS");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OperatingSystem", "Windows10");
	}
	
	
	public static void flushReports()
	{
		extent.flush();
	}
}
